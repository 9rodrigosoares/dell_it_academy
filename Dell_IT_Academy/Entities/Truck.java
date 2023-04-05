package Dell_IT_Academy.Entities;

public abstract class Truck {

    private String name;
    private double kmPrice;
    private double loadWeight;

    public Truck(String name, double kmPrice, double loadWeight) {
        this.name = name;
        this.kmPrice = kmPrice;
        this.loadWeight = loadWeight;
    }

    public static Truck getTruck(String name) {

        return switch (name) {
            case "pequeno" -> new SmallTruck();
            case "medio" -> new MediumTruck();
            case "grande" -> new BigTruck();
            default -> null;
        };
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
