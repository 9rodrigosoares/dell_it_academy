package Dell_IT_Academy.Entities;

public abstract class Item {

    private String name;
    private int quantity;
    private double weight;

    public Item() {}

    public Item(String name, int quantity, double weight) {
        this.name = name;
        this.quantity += quantity;
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalWeight(){
        return quantity * weight;
    }

    @Override
    public String toString() {
        return "Nome: "+name+"\nQuantidade: "+quantity+"\nPeso: "+weight;
    }
}
