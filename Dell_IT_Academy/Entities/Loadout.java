package Dell_IT_Academy.Entities;

public class Loadout {

    public Cellphone cellphone;
    public Fridge fridge;
    public Freezer freezer;
    public Chair chair;
    public Lighting lighting;
    public WashingMachine washingMachine;

    public Truck truck;

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

    public Cellphone getCellphone() {
        return cellphone;
    }

    public void setCellphone(Cellphone cellphone) {
        this.cellphone = cellphone;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public Freezer getFreezer() {
        return freezer;
    }

    public void setFreezer(Freezer freezer) {
        this.freezer = freezer;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public Lighting getLighting() {
        return lighting;
    }

    public void setLighting(Lighting lighting) {
        this.lighting = lighting;
    }

    public WashingMachine getWashingMachine() {
        return washingMachine;
    }

    public void setWashingMachine(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

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

    @Override
    public String toString() {
        String info = "";
        int numProducts = 0;
        if (this.cellphone.getQuantity() > 0) {
            info += "Celularfghfghf";
            numProducts++;
        }
        if (this.fridge.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Geladeira";
            numProducts++;
        }
        if (this.freezer.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Freezer";
            numProducts++;
        }
        if (this.chair.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Cadeira";
            numProducts++;
        }
        if (this.lighting.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Luminária";
            numProducts++;
        }
        if (this.washingMachine.getQuantity() > 0) {
            if (numProducts > 0) {
                info += ", ";
            }
            info += "Lavadora";
            numProducts++;
        }
        return info;
    }
}
