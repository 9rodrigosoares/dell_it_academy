package Dell_IT_Academy.Entities;

import Dell_IT_Academy.Utils.Utils;

public class MediumTruck extends Truck {

    public MediumTruck() {
        super(Utils.Constants.textMediumTruck, Utils.Constants.kmMediumTruckCost, Utils.Constants.maxLoadWeightMediumTruck);
    }
}
