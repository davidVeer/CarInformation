namespace CarStatsServer.Models
{
    public class FuelUpModel
    {
        public ushort fuelUpNumber { get; }
        public ushort kilometersDriven { get; }
        public uint odometerReading { get; }
        public DateTime fuelUpDate { get; }
        public float litersRefueled { get; }
        public float fuelUpCost { get; }
        public float fuelEfficiency { get; }
        public float literPrice { get; }
        public float carbonEmissions { get; }

        public FuelUpModel(ushort fuelUpNumber, ushort kilometersDriven, uint odometerReading, DateTime fuelUpDate, float litersRefueled, float fuelUpCost, float fuelEfficiency, float literPrice, float carbonEmissions)
        {
            this.fuelUpNumber = fuelUpNumber;
            this.kilometersDriven = kilometersDriven;
            this.odometerReading = odometerReading;
            this.fuelUpDate = fuelUpDate;
            this.litersRefueled = litersRefueled;
            this.fuelUpCost = fuelUpCost;
            this.fuelEfficiency = fuelEfficiency;
            this.literPrice = literPrice;
            this.carbonEmissions = carbonEmissions;
        }
    }
}
