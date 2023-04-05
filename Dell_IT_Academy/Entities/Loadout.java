package Dell_IT_Academy.Entities;

public class Loadout {

    public Cellphone cellphone;
    public Fridge fridge;
    public Freezer freezer;
    public Chair chair;
    public Lighting lighting;
    public WashingMachine washingMachine;

    public double travelTotalCost;

    public Truck truck;

    public Truck getTruck() {
        return truck;
    }

    public Cellphone getCellphone() {
        return cellphone;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public Freezer getFreezer() {
        return freezer;
    }

    public Chair getChair() {
        return chair;
    }

    public Lighting getLighting() {
        return lighting;
    }

    public WashingMachine getWashingMachine() {
        return washingMachine;
    }

    public double getTravelTotalCost() {
        return travelTotalCost;
    }

    public void setTravelTotalCost(double travelTotalCost) {
        this.travelTotalCost = travelTotalCost;
    }

    public void addCellphone(int qtd) {
        this.cellphone = new Cellphone(qtd);
    }
    public void addFridge(int qtd) {
        this.fridge = new Fridge(qtd);
    }
    public void addFreezer(int qtd) {
        this.freezer = new Freezer(qtd);
    }
    public void addChair(int qtd) {
        this.chair = new Chair(qtd);
    }
    public void addLighting(int qtd) {
        this.lighting = new Lighting(qtd);
    }
    public void addWashingMachine(int qtd) {
        this.washingMachine = new WashingMachine(qtd);
    }
    public Loadout(){}
    public int getTotalQuantity() {
        int total = 0;
        if (this.cellphone != null) {
            total += cellphone.getQuantity();
        }
        if (this.fridge != null) {
            total += fridge.getQuantity();
        }
        if (this.freezer != null) {
            total += freezer.getQuantity();
        }
        if (this.chair != null) {
            total += chair.getQuantity();
        }
        if (this.lighting != null) {
            total += lighting.getQuantity();
        }
        if (this.washingMachine != null) {
            total += washingMachine.getQuantity();
        }
        return total;
    }
    public double getTotalWeight() {
        double totalWeight = 0.0;
        if (cellphone != null) totalWeight += cellphone.getTotalWeight();
        if (fridge != null) totalWeight += fridge.getTotalWeight();
        if (freezer != null) totalWeight += freezer.getTotalWeight();
        if (chair != null) totalWeight += chair.getTotalWeight();
        if (lighting != null) totalWeight += lighting.getTotalWeight();
        if (washingMachine != null) totalWeight += washingMachine.getTotalWeight();
        return totalWeight;
    }
    @Override
    public String toString() {
        String info = "";
        int numProducts = 0;
        if (this.cellphone != null && this.cellphone.getQuantity() > 0) {
            info += "Celular";
            numProducts++;
        }
        if (this.fridge != null && this.fridge.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Geladeira";
            numProducts++;
        }
        if (this.freezer != null && this.freezer.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Freezer";
            numProducts++;
        }
        if (this.chair != null && this.chair.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Cadeira";
            numProducts++;
        }
        if (this.lighting != null && this.lighting.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Luminária";
            numProducts++;
        }
        if (this.washingMachine != null && this.washingMachine.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Lavadora";
            numProducts++;
        }
        return info;
    }
}
