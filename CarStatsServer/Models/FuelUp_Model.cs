namespace CarStatsServer.Models
{
    public class FuelUp_Model
    {
        public ushort FuelUpNumber { get; }
        public ushort KilometersDriven { get; }
        public uint OdometerReading { get; }
        public DateTime FuelUpDate { get; }
        public float LitersRefueled { get; }
        public float FuelUpCost { get; }
        public float FuelEfficiency { get; }
        public float LiterPrice { get; }
        public float CarbonEmissions { get; }
        public Car_Model LinkedCar { get; }


        public FuelUp_Model()
        {
        }

        public FuelUp_Model(ushort fuelUpNumber, ushort kilometersDriven, uint odometerReading, DateTime fuelUpDate, float litersRefueled, float fuelUpCost, float fuelEfficiency, float literPrice, float carbonEmissions, Car_Model linkedCar) {
            FuelUpNumber = fuelUpNumber;
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
