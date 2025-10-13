namespace CarStatsServer.Models
{
    public class Account_Model
    {
        public int UserId { get; set; }
        public string Name { get; set; }
        public List<Car_Model> ownedCars { get; set; }

        public Account_Model() {
        }

        public Account_Model(string accountName, List<Car_Model> ownedCars) {
            Name = accountName;
            this.ownedCars = ownedCars;
        }


    }
}
