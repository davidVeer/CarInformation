using CarStatsServer.Calculators;

namespace CarStatsServer.Models
{
    public class FuelUp_Model : DatabaseObject<ushort>
    {
        public override ushort ObjectKey { get; init; }
        public ushort KilometersDriven { get; set; }
        public uint OdometerReading { get; init; }
        public DateTime FuelUpDate { get; init; }
        public float LitersRefueled { get; init; }
        public float FuelUpCost { get; init; }
        public float FuelEfficiency { get; set; }
        public float LiterPrice { get; set; }
        public float CarbonEmissions { get; set; }

        public FuelUp_Model() {
        }

    }
}
