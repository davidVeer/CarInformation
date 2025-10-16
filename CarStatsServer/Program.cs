using CarStatsServer.DatabaseManagement;
using CarStatsServer.Models;

namespace CarStatsServer
{
    public class Program
    {
        static void Main() {
            Console.WriteLine("Hello world!");
            Dictionary<int, FuelUp_Model> fuelUps;
            Dictionary<string, Car_Model> cars;
            Dictionary<int, Account_Model> accounts;
            accounts = Database_DataManagement.LoadAccounts();
            foreach (Account_Model account in accounts.Values) {
                Console.WriteLine(account.Name);
            }


            cars = Database_DataManagement.LoadCars();

            foreach (Car_Model car in cars.Values) {
                Console.WriteLine("Licenceplate: {0},\n - Owner: {1},\n - Model: {2},\n - Make: {3}",
                    car.LicencePlateNumber,
                    car.Owner.Name,
                    car.CarModel,
                    car.CarManufacturer);
            }


            foreach (Car_Model car in cars.Values) {
                car.ToString();
            }

            fuelUps = Database_DataManagement.LoadFuelUps();
            foreach (FuelUp_Model fuelUp in fuelUps.Values) {
                Console.WriteLine("FuelUpNumber: {0},\n - LinkedCar: {1},\n - OdometerReading: {2},\n - LitersFueled: {3},\n - RefuelCost: {4},\n - KilometersDriven: {5}",
                    fuelUp.FuelUpNumber,
                    fuelUp.LinkedCar.LicencePlateNumber,
                    fuelUp.OdometerReading,
                    fuelUp.LitersRefueled,
                    fuelUp.FuelUpCost,
                    fuelUp.KilometersDriven);
            }


        }

    }

}