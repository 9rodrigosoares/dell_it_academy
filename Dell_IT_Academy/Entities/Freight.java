package Dell_IT_Academy.Entities;

public class Freight {

    public Route route;
    public Loadout loadout;

    public Truck truck;

    public Freight() {}

    public Freight(Route route, Loadout loadout) {
        this.route = route;
        this.loadout = loadout;
    }

    @Override
    public String toString() {
        return "Transporte cadastrado: " +
                "\nRota: " + route +
                ", \nCarga: " + loadout;
    }
}
