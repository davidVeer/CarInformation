namespace CarStatsServer.Models
{
    public class CollectiveDataset
    {
        public CollectiveDataset(List<FuelUp_Model> fuelUps)
        {
            this.fuelUps = fuelUps;
        }

        public ushort[] FuelUpIdList { get => AddAllToList(fuelUps, fuelUp => fuelUp.ObjectKey); }
        public ushort[] KilometersDrivenList { get => AddAllToList(fuelUps, fuelUp => fuelUp.KilometersDriven); }
        public DateTime[] FuelUpDateList { get => AddAllToList(fuelUps, fuelUp => fuelUp.FuelUpDate); }
        public float[] LitersRefueledList { get => AddAllToList(fuelUps, fuelUp => fuelUp.LitersRefueled); }
        public float[] FuelUpCostList { get => AddAllToList(fuelUps, fuelUp => fuelUp.FuelUpCost); }
        public float[] FuelEfficiencyList { get => AddAllToList(fuelUps, fuelUp => fuelUp.FuelEfficiency); }
        public float[] LiterPriceList { get => AddAllToList(fuelUps, fuelUp => fuelUp.LiterPrice); }
        public float[] CarbonEmissionsList { get => AddAllToList(fuelUps, fuelUp => fuelUp.CarbonEmissions); }
        private List<FuelUp_Model> fuelUps { get; }

        private static T[] AddAllToList<T>(List<FuelUp_Model> fuelUpList, Func<FuelUp_Model, T> selector) => fuelUpList.Select(selector).ToArray();
    }
}
