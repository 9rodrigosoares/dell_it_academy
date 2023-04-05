package Dell_IT_Academy.Entities;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    public List<SmallTruck> smallTrucks;
    public List<MediumTruck> mediumTrucks;
    public List<BigTruck> bigTrucks;

    public Fleet() {
        this.smallTrucks = new ArrayList<>();
        this.mediumTrucks = new ArrayList<>();
        this.bigTrucks = new ArrayList<>();
    }

    public void addSmallTruck() {
        this.smallTrucks.add(new SmallTruck());
    }
    public void addMediumTruck() {
        this.mediumTrucks.add(new MediumTruck());
    }
    public void addBigTruck() {
        this.bigTrucks.add(new BigTruck());
    }
}
