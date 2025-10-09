namespace CarStatsServer.Models
{
    public class CollectiveDataset
    {
        public CollectiveDataset(List<FuelUp_Model> fuelUps)
        {
            this.fuelUps = fuelUps;
        }

        public ushort[] fuelUpNumberList { get => AddAllToList(fuelUps, fuelUp => fuelUp.fuelUpNumber); }
        public ushort[] kilometersDrivenList { get => AddAllToList(fuelUps, fuelUp => fuelUp.kilometersDriven); }
        public DateTime[] fuelUpDateList { get => AddAllToList(fuelUps, fuelUp => fuelUp.fuelUpDate); }
        public float[] litersRefueledList { get => AddAllToList(fuelUps, fuelUp => fuelUp.litersRefueled); }
        public float[] fuelUpCostList { get => AddAllToList(fuelUps, fuelUp => fuelUp.fuelUpCost); }
        public float[] fuelEfficiencyList { get => AddAllToList(fuelUps, fuelUp => fuelUp.fuelEfficiency); }
        public float[] literPriceList { get => AddAllToList(fuelUps, fuelUp => fuelUp.literPrice); }
        public float[] carbonEmissionsList { get => AddAllToList(fuelUps, fuelUp => fuelUp.carbonEmissions); }
        private List<FuelUp_Model> fuelUps { get; }

        private static T[] AddAllToList<T>(List<FuelUp_Model> fuelUpList, Func<FuelUp_Model, T> selector) => fuelUpList.Select(selector).ToArray();
    }
}
