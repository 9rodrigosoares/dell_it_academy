package Dell_IT_Academy.Entities;

public class Route {

    private String initialCity;
    private String finalCity;
    private int distance;

    public Route() {}

    public Route(String initialCity, String finalCity, int distance) {
        this.initialCity = initialCity;
        this.finalCity = finalCity;
        this.distance = distance;
    }

    public String getInitialCity() {
        return initialCity;
    }

    public void setInitialCity(String initialCity) {
        this.initialCity = initialCity;
    }

    public String getFinalCity() {
        return finalCity;
    }

    public void setFinalCity(String finalCity) {
        this.finalCity = finalCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
