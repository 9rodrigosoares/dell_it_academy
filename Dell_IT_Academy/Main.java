package Dell_IT_Academy;

import Dell_IT_Academy.Entities.Fleet;
import Dell_IT_Academy.Entities.Freight;
import Dell_IT_Academy.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Utils.exibeLogo();

        // Lista criada para armazenar os transportes que forem cadastrados
        List<Freight> listTravels = new ArrayList<>();

        int opcao = -1;
        while (opcao != 0) {
            opcao = Utils.callMenu();

            switch (opcao) {
                case 1:
                    Utils.routeAndModalityConsult();
                    break;
                case 2:
                    listTravels.add(Utils.createFreight());
                    break;
                case 3:
                    if (listTravels.size() == 0){
                        System.out.println("Não existem transportes cadastrados.");
                        break;
                    }
                    int i = 1;
                    for(Freight f : listTravels) {
                        System.out.println("Viagem #"+i);
                        System.out.printf("Rota: de %s a %s %n",f.route.initialCity,f.route.finalCity);
                        System.out.printf("Custo total: R$ %.2f%n",Utils.calculateCostByFleet(f.fleet, f.route));
                        System.out.printf("Número de veículos deslocados: %d%n",countTrucks(f.fleet));
                        System.out.println();
                        i++;
                    }
                    break;
            }}
        Utils.endProgram();
    }

    public static int countTrucks(Fleet fleet) {
        int countTrucks = 0;
        if (fleet.smallTrucks != null && fleet.smallTrucks.size() > 0) {
            countTrucks += fleet.smallTrucks.size();
            System.out.println("Caminhão de pequeno porte: "+fleet.smallTrucks.size());
        }
        if (fleet.mediumTrucks != null && fleet.mediumTrucks.size() > 0) {
            countTrucks += fleet.mediumTrucks.size();
            System.out.println("Caminhão de medio porte: "+fleet.mediumTrucks.size());
        }
        if (fleet.bigTrucks != null && fleet.bigTrucks.size() > 0) {
            countTrucks += fleet.bigTrucks.size();
            System.out.println("Caminhão de grande porte: "+fleet.bigTrucks.size());
        }
        return countTrucks;
    }

}
