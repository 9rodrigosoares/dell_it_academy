package Dell_IT_Academy.Entities;

import java.util.ArrayList;
import java.util.List;

public class Freight {

    public Route route;
    public Loadout loadout;
    public Fleet fleet;
    public Freight() {}

    public Freight(Route route, Loadout loadout, Fleet fleet) {
        this.route = route;
        this.loadout = loadout;
        this.fleet = fleet;
    }
}
