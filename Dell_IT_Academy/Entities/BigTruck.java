package Dell_IT_Academy.Entities;

import Dell_IT_Academy.Utils.Utils;

public class BigTruck extends Truck {

    public BigTruck() {
        super(Utils.Constants.textBigTruck, Utils.Constants.kmBigTruckCost, Utils.Constants.maxLoadWeightBigTruck);
    }
}
