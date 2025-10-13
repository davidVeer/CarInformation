namespace CarStatsServer.Models
{
    public class Car_Model
    {
        public string LicencePlateNumber { get; set; }
        public string CarModel { get; set; }
        public string CarManufacturer { get; set; }
        public ushort BuildYear { get; set; }
        public Account_Model Owner { get; set; }
        public List<FuelUp_Model> fuelUps { get; set; }


        public Car_Model() {
        }

        public Car_Model(string licencePlateNumber, string carModel, string carManufacturer, ushort buildYear, List<FuelUp_Model> fuelUps) {
            LicencePlateNumber = licencePlateNumber;
            CarModel = carModel;
            CarManufacturer = carManufacturer;
            BuildYear = buildYear;
            this.fuelUps = fuelUps;
        }
    }
}
