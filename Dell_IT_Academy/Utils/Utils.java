package Dell_IT_Academy.Utils;

import Dell_IT_Academy.Data.CsvReader;
import Dell_IT_Academy.Entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static Scanner sc = new Scanner(System.in);

    public static class Constants {

         public static final double kmSmallTruckCost = 4.87;
         public static final double kmMediumTruckCost = 11.92;
         public static final double kmBigTruckCost = 27.44;
         public static final String textSmallTruck = "pequeno";
         public static final String textMediumTruck = "medio";
         public static final String textBigTruck = "grande";
         public static final int maxLoadWeightSmallTruck = 1000;
         public static final int maxLoadWeightMediumTruck = 4000;
         public static final int maxLoadWeightBigTruck = 10000;
    }

    public static void exibeLogo() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║     #   Simulador STIC   #      ║");
        System.out.println("║      Sistema de Transporte      ║");
        System.out.println("║     Interestadual de Cargas     ║");
        System.out.println("╚═════════════════════════════════╝");
    }

    public static int callMenu() {

        System.out.println();
        System.out.println("Escolha uma opção: ");
        System.out.println();
        System.out.println("1 - Consulta trechos x modalidade");
        System.out.println("2 - Cadastrar transporte");
        System.out.println("3 - Ver transportes cadastrados");
        System.out.println("0 - Finalizar");
        return sc.nextInt();
    }

    public static boolean validateCity(String cityName) {
        if (!CsvReader.fillData().containsKey(cityName)) {
            System.out.println("A cidade digitada não existe");
            return false;
        }
        return true;
    }

    public static boolean validateRepeatCities(String finalCity, String initialCity) {
        if (finalCity.equals(initialCity)) {
            System.out.println("As cidades origem e destino não podem ser as mesmas.");
            return false;
        }
        return true;
    }

    public static double calculateCostByTruck(String modality, Route route) {
        double totalCost = 0;
        switch (modality) {
            case "pequeno" -> totalCost = route.getDistance() * Constants.kmSmallTruckCost;
            case "medio" -> totalCost = route.getDistance() * Constants.kmMediumTruckCost;
            case "grande" -> totalCost = route.getDistance() * Constants.kmBigTruckCost;
            default -> System.out.println("Modalidade de transporte inválida.\nErro ao cadastrar rota... Voltando ao menu");
        }
        return totalCost;
    }

    public static double calculateCostByFleet(Fleet fleet, Route route) {
        double totalFleetCost = 0;

        if (fleet.smallTrucks.size() > 0){
            for(SmallTruck s : fleet.smallTrucks) {
                totalFleetCost += calculateCostByTruck(s.getName(), route);
            }
        }
        if (fleet.mediumTrucks.size() > 0){
            for(MediumTruck m : fleet.mediumTrucks) {
                totalFleetCost += calculateCostByTruck(m.getName(), route);
            }
        }
        if (fleet.bigTrucks.size() > 0){
            for(BigTruck b : fleet.bigTrucks) {
                totalFleetCost += calculateCostByTruck(b.getName(), route);
            }
        }
        return totalFleetCost;
    }

//    public static double calculateCostByItem(String productName, Loadout loadout) {
//        double totalCost = loadout.travelTotalCost;
//        if (productName.equals("Celular")) {
//            totalCost / loadout.cellphone.getQuantity();
//        }
//    }

    public static Route createRoute() {

        sc.nextLine(); // absorve a quebra de linha do buffer
        System.out.print("Digite o nome da cidade de origem: ");
        String initialCity = sc.nextLine().toUpperCase();

        if (!validateCity(initialCity)){
            return null;
        }

        System.out.print("Digite o nome da cidade de destino: ");
        String finalCity = sc.nextLine().toUpperCase();

        if (!validateRepeatCities(finalCity, initialCity)) {
            return null;
        }

        if (!validateCity(finalCity)){
            return null;
        }

        return new Route(initialCity, finalCity, CsvReader.fillData().get(initialCity).get(finalCity));
    }

    public static void routeAndModalityConsult() {
        Route r = createRoute(); // Para reaproveitar as informações coletadas no método createRoute()

        if(r == null) {
            System.out.println("Erro ao cadastrar rota... Voltando ao menu");
            return;
        }

        System.out.print("Digite a modalidade de transporte (pequeno, medio ou grande): ");
        String modality = sc.nextLine().toLowerCase();

        double totalCost = calculateCostByTruck(modality, r);

        // Exibir o resultado da consulta
        System.out.println();
        System.out.printf("De %s para %s, utilizando um caminhão de %s porte, a distância é de %d km e o custo será de R$ %.2f.", r.getInitialCity(), r.getFinalCity(), modality, r.getDistance(), totalCost);
    }

    public static Loadout createLoadout() {
        Loadout loadout = new Loadout();

        int option;
        do {
            System.out.println("\nAdicione os itens a serem transportados:");
            System.out.println("1 - Celular           - 0.5kg");
            System.out.println("2 - Geladeira         - 60kg");
            System.out.println("3 - Freezer           - 100kg");
            System.out.println("4 - Cadeira           - 5kg");
            System.out.println("5 - Luminária         - 0.8kg");
            System.out.println("6 - Lavadora de roupa - 120kg");
            System.out.println("0 - Voltar");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Quantos celulares? ");
                    int qtdCellphones = sc.nextInt();
                    loadout.addCellphone(qtdCellphones);
                    System.out.printf("A quantidade cadastrada foi atualizada para %d.%n", qtdCellphones);
                    break;
                case 2:
                    System.out.print("Quantas geladeiras? ");
                    int qtdFridges = sc.nextInt();
                    loadout.addFridge(qtdFridges);
                    System.out.printf("Quantidade %d cadastrada.%n", qtdFridges);
                    break;
                case 3:
                    System.out.print("Quantos freezers? ");
                    int qtdFreezers = sc.nextInt();
                    loadout.addFreezer(qtdFreezers);
                    System.out.println("Quantidade cadastrada.");
                    break;
                case 4:
                    System.out.print("Quantas cadeiras? ");
                    int qtdChairs = sc.nextInt();
                    loadout.addChair(qtdChairs);
                    System.out.println("Quantidade cadastrada.");
                    break;
                case 5:
                    System.out.print("Quantas luminárias? ");
                    int qtdLightings = sc.nextInt();
                    loadout.addLighting(qtdLightings);
                    System.out.println("Quantidade cadastrada.");
                    break;
                case 6:
                    System.out.print("Quantas lavadoras de roupa? ");
                    int qtdWashingMachines = sc.nextInt();
                    loadout.addWashingMachine(qtdWashingMachines);
                    System.out.println("Quantidade cadastrada.");
                    break;
                case 0:
                    if (loadout.getTotalQuantity() == 0) {
                        System.out.println("Nenhuma carga foi adicionada.");
                    } else {
                        System.out.println("Carga cadastrada com sucesso!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);

        return loadout;
    }

//    public static List<Route> addExtraRoutes(String initialCity) {
//        List<Route> routes = new ArrayList<>();
//
//        char option = 'X';
//
//        System.out.print("Deseja adicionar uma parada? S/N  ");
//        option = sc.next().toUpperCase().charAt(0);
//        sc.nextLine(); // absorve a quebra de linha
//
//        if(option == 'N') {
//            break;
//        }
//
//        System.out.print("Digite o nome da cidade de parada: ");
//        String stopCity = sc.nextLine().toUpperCase();
//
//
//
//        if (!validateCity(stopCity)){
//            return null;
//        }
//
//        if (!validateRepeatCities(stopCity, initialCity)) {
//            return null;
//        }
//
//        return routes;
//    }

    public static Freight createFreight() {
        Route route = createRoute();
        Loadout loadout = createLoadout();
        Fleet fleet = createFleet(loadout.getTotalWeight(), route.distance);
        return new Freight(route, loadout, fleet);
    }


    public static Fleet createFleet(double totalWeight, double distance) {
        Fleet fleets = new Fleet();
        int qtdBigTruck = 0, qtdMedTruck = 0, qtdSmallTruck =0;
        double tempTotalWeight = totalWeight;

        if(totalWeight >= Constants.maxLoadWeightBigTruck) {
            qtdBigTruck = (int) (totalWeight / totalWeight);
            tempTotalWeight -= Constants.maxLoadWeightBigTruck * qtdBigTruck;
            for(int i =0; i < qtdBigTruck; i++) {
                fleets.addBigTruck();
            }
        } else if (tempTotalWeight >= Constants.maxLoadWeightMediumTruck) {
            qtdMedTruck = (int) (tempTotalWeight / totalWeight);
            tempTotalWeight -= Constants.maxLoadWeightMediumTruck * qtdMedTruck;
            for(int i =0; i < qtdMedTruck; i++) {
                fleets.addMediumTruck();
            }
        } else {
            qtdSmallTruck = (int) (tempTotalWeight / totalWeight);
            for(int i =0; i<qtdSmallTruck; i++) {
                fleets.addSmallTruck();
            }
        }
        return fleets;
    }

    public static void endProgram() {
        if (sc != null) {
            sc.close();
        }
        System.out.println();
        System.out.println("Fim!");
        System.exit(0);
    }
}
