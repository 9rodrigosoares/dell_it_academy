package Dell_IT_Academy.Utils;

import Dell_IT_Academy.Data.CsvReader;
import Dell_IT_Academy.Entities.Freight;
import Dell_IT_Academy.Entities.Loadout;
import Dell_IT_Academy.Entities.Route;
import Dell_IT_Academy.Entities.Truck;

import java.util.Scanner;

public class Utils {

    public static Scanner sc = new Scanner(System.in);

    public static class Constants {

         public final double kmSmallTruckCost = 4.87;
         public final double kmMediumTruckCost = 11.92;
         public final double kmBigTruckCost = 11.92;
         public final String textSmallTruck = "pequeno";
         public final String textMediumTruck = "medio";
         public final String textBigTruck = "grande";
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

    public static Route createRoute() {

        sc.nextLine(); // quebra buffer
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
        Route r = createRoute();

        if(r == null) {
            System.out.println("Erro ao cadastrar rota... Voltando ao menu");
            return;
        }
        System.out.print("Digite a modalidade de transporte (pequeno, medio ou grande): ");
        String modality = sc.nextLine().toLowerCase();

        double custo = 0;
        switch (modality) {
            case "pequeno" -> custo = r.getDistance() * 4.87;
            case "medio" -> custo = r.getDistance() * 11.92;
            case "grande" -> custo = r.getDistance() * 27.44;
            default -> System.out.println("Modalidade de transporte inválida.");
        }

        if (custo == 0) {
            return;
        }

        // Exibir o resultado da consulta
        System.out.println();
        System.out.printf("De %s para %s, utilizando um caminhão de %s porte, a distância é de %d km e o custo será de R$ %.2f.\n", r.getInitialCity(), r.getFinalCity(), modality, r.getDistance(), custo);
    }


    public static Loadout createLoadout() {
        Loadout loadout = new Loadout();

        int option;
        do {
            System.out.println("\nAdicione os itens a serem transportados:");
            System.out.println("1 - Celular");
            System.out.println("2 - Geladeira");
            System.out.println("3 - Freezer");
            System.out.println("4 - Cadeira");
            System.out.println("5 - Luminária");
            System.out.println("6 - Lavadora de roupa");
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


    public static Freight createFreight() {
        Route route = createRoute();
        Loadout loadout = createLoadout();
        return new Freight(route, loadout);
    }

    public static void endProgram() {
        if (sc != null) {
            sc.close();
        }
        System.out.println();
        System.out.println("Fim!");
    }



}
