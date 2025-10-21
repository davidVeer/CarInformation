using CarStatsServer.DatabaseManagement;
using CarStatsServer.Models;

namespace CarStatsServer
{
    public class TempDebugFunctions
    {
        public static void PrintFuelUpList() {
            Dictionary<int, FuelUp_Model> fuelUps;
            fuelUps = Database_DataManagement.LoadFuelUps();
            foreach (FuelUp_Model fuelUp in fuelUps.Values) {
                Console.WriteLine("FuelUpId: {0},\n - LinkedCar: {1},\n - OdometerReading: {2},\n - LitersFueled: {3},\n - RefuelCost: {4},\n - KilometersDriven: {5}",
                    fuelUp.FuelUpId,
                    fuelUp.LinkedCar.LicencePlateNumber,
                    fuelUp.OdometerReading,
                    fuelUp.LitersRefueled,
                    fuelUp.FuelUpCost,
                    fuelUp.KilometersDriven);
            }
        }

        public static void PrintAccountsList() {
            Dictionary<int, Account_Model> accounts;
            accounts = Database_DataManagement.LoadAccounts();
            foreach (Account_Model account in accounts.Values) {
                Console.WriteLine("Account ID: {0},\n - AccountName: {1}", account.UserId, account.Name);
            }

        }

        public static void PrintCarsList() {
            Dictionary<string, Car_Model> cars;
            cars = Database_DataManagement.LoadCars();


            foreach (Car_Model car in cars.Values) {
                Console.WriteLine("Licenceplate: {0},\n - Owner: {1},\n - Model: {2},\n - Make: {3}",
                    car.LicencePlateNumber,
                    car.Owner.Name,
                    car.CarModel,
                    car.CarManufacturer);
            }
        }

        public static void EnterNewAccount() {
            Console.WriteLine("Enter a Name for the new Account:");

            Database_DataManagement.SaveAccountToDatabase(new Account_Model() {
                Name = Console.ReadLine()
            });
        }

        public static void EnterNewCar() {
            Console.WriteLine("Enter the Licenceplatenumber, ownerID, Manufacturer, model, year");

            Database_DataManagement.SaveCarToDatabase(new Car_Model() {
                LicencePlateNumber = Console.ReadLine(),
                Owner = Database_DataManagement.LoadAccounts().GetValueOrDefault(int.Parse(Console.ReadLine())),
                CarManufacturer = Console.ReadLine(),
                CarModel = Console.ReadLine(),
                BuildYear = ushort.Parse(Console.ReadLine())
            });
        }

        public static void EnterNewFuelUp() {
            Console.WriteLine("Enter the FuelupNumber, LinkedCar's Licenceplate number, odometerReading, Liters fueled, and cost of fuel up:");
            Database_DataManagement.SaveFuelUpToDatabase(new FuelUp_Model() {
            });
        }


    }
}
