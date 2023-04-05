package Dell_IT_Academy.Entities;

import Dell_IT_Academy.Utils.Utils;

public class SmallTruck extends Truck {

    public SmallTruck() {
        super(Utils.Constants.textSmallTruck, Utils.Constants.kmSmallTruckCost, Utils.Constants.maxLoadWeightSmallTruck);
    }
}