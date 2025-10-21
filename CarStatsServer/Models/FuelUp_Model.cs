namespace CarStatsServer.Models
{
    public class FuelUp_Model
    {
        public ushort FuelUpId { get; init; }
        public ushort KilometersDriven { get; init; }
        public uint OdometerReading { get; init; }
        public DateTime FuelUpDate { get; init; }
        public float LitersRefueled { get; init; }
        public float FuelUpCost { get; init; }
        public float FuelEfficiency { get; init; }
        public float LiterPrice { get; init; }
        public float CarbonEmissions { get; init; }
        public Car_Model LinkedCar { get; set; }


        public FuelUp_Model() {
        }

        public FuelUp_Model(ushort fuelUpId, ushort kilometersDriven, uint odometerReading, DateTime fuelUpDate, float litersRefueled, float fuelUpCost, float fuelEfficiency, float literPrice, float carbonEmissions, Car_Model linkedCar) {
            FuelUpId = fuelUpId;
            KilometersDriven = kilometersDriven;
            OdometerReading = odometerReading;
            FuelUpDate = fuelUpDate;
            LitersRefueled = litersRefueled;
            FuelUpCost = fuelUpCost;
            FuelEfficiency = fuelEfficiency;
            LiterPrice = literPrice;
            CarbonEmissions = carbonEmissions;
            LinkedCar = linkedCar;
        }
    }
}
