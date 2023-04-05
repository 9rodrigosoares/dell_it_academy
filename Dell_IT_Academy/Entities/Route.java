package Dell_IT_Academy.Entities;

import java.util.ArrayList;
import java.util.List;

public class Route {

    public String initialCity;
    public String finalCity;
    public int distance;

    public Route() {}

    public Route(String initialCity, String finalCity, int distance) {
        this.initialCity = initialCity;
        this.finalCity = finalCity;
        this.distance = distance;
    }

    public String getInitialCity() {
        return initialCity;
    }

    public String getFinalCity() {
        return finalCity;
    }

    public int getDistance() {
        return distance;
    }
}
