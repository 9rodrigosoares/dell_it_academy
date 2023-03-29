package Dell_IT_Academy;

import Dell_IT_Academy.Entities.Freight;
import Dell_IT_Academy.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║     #   Simulador STIC   #      ║");
        System.out.println("║      Sistema de Transporte      ║");
        System.out.println("║     Interestadual de Cargas     ║");
        System.out.println("╚═════════════════════════════════╝");

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
                    for(Freight f : listTravels) {
                        System.out.println(f.loadout.cellphone.toString());
                    }
                    break;
            }}
        Utils.endProgram();
    }
}
