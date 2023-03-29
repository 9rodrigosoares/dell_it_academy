package Dell_IT_Academy.Entities;

public abstract class Truck {

    private String name;
    private double kmPrice;
    private double loadWeight;

    public Truck() {}

    public Truck(String name, double kmPrice, double loadWeight) {
        this.name = name;
        this.kmPrice = kmPrice;
        this.loadWeight = loadWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKmPrice() {
        return kmPrice;
    }

    public void setKmPrice(double kmPrice) {
        this.kmPrice = kmPrice;
    }

    public double getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(double loadWeight) {
        this.loadWeight = loadWeight;
    }
}
