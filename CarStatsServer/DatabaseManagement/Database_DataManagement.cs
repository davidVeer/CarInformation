using CarStatsServer.Models;
using Dapper;
using System.Data.SQLite;

namespace CarStatsServer.DatabaseManagement
{
    class Database_DataManagement
    {

        public static Dictionary<int, FuelUp_Model> LoadFuelUps(string query = """
             SELECT FuelUps.*, Cars.LicencePlateNumber, Cars.CarModel, Cars.CarManufacturer, Cars.BuildYear 
             FROM FuelUps 
             INNER JOIN Cars 
             ON FuelUps.LinkedCar = Cars.LicencePlateNumber
            """) => LoadFuelUpsFromDatabase(query);

        public static Dictionary<string, Car_Model> LoadCars(string query = """
            SELECT * FROM Cars 
            INNER JOIN Accounts 
            ON Cars.Owner = Accounts.UserID
            """) => LoadCarsFromDatabase(query);


        public static Dictionary<int, Account_Model> LoadAccounts(string query = """
            SELECT * FROM Accounts
            """) => LoadAccountsFromDatabase(query);


        public static void SaveFuelUpToDatabase(FuelUp_Model newFuelUp) {
            string query = "insert into FuelUps " +
                "(FuelUpNumber, OdometerReading, FuelUpDate, LitersFueledUp, FuelUpPrice, DistanceDriven, FuelEfficiency, LiterPrice, CarbonEmissions, LinkedCar) " +
                "values (@FuelUpNumber, @OdometerReading, @FuelUpDate, @LitersFueledUp, @FuelUpPrice, @DistanceDriven, @FuelEfficiency, @LiterPrice, @CarbonEmissions)";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                Database_Connection.databaseConnection.Execute(query, newFuelUp);
            }
        }

        public static void SaveCarToDatabase(Car_Model newCar) {
            string query = "insert into Cars (licencePlateNumber, carModel, buildYear, owner)" +
                "values (@licencePlateNumber, @carModel, @buildYear, @owner)";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                Database_Connection.databaseConnection.Execute(query, newCar);
            }

        }
        public static void SaveAccountToDatabase(Account_Model newAccount) {
            string query = "insert into Cars (name) values (@name)";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                Database_Connection.databaseConnection.Execute(query, newAccount);
            }
        }

        private static Dictionary<int, Account_Model> LoadAccountsFromDatabase(string sql) {
            Dictionary<int, Account_Model> keyValuePairs = new();

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                IEnumerable<Account_Model> accounts = Database_Connection.databaseConnection.Query<Account_Model>(sql, new DynamicParameters());

                foreach (Account_Model account in accounts.ToList()) {
                    keyValuePairs.Add(account.UserId, account);
                }
            }

            return keyValuePairs;
        }

        private static Dictionary<string, Car_Model> LoadCarsFromDatabase(string sql) {
            Dictionary<string, Car_Model> keyValuePairs = new();

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                IEnumerable<Car_Model> cars = Database_Connection.databaseConnection.Query<Car_Model, Account_Model, Car_Model>(
                    sql,
                    (car, account) => { car.Owner = account; return car; }, splitOn: "Owner");

                foreach (Car_Model car in cars.ToList()) {
                    keyValuePairs.Add(car.LicencePlateNumber, car);
                }
            }

            return keyValuePairs;
        }

        private static Dictionary<int, FuelUp_Model> LoadFuelUpsFromDatabase(string sql) {
            Dictionary<int, FuelUp_Model> keyValuePairs = new();

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                IEnumerable<FuelUp_Model> fuelUps = Database_Connection.databaseConnection.Query<FuelUp_Model, Car_Model, FuelUp_Model>(
                    sql,
                    (fuelUp, linkedCar) => { fuelUp.LinkedCar = linkedCar; return fuelUp; }, splitOn: "LinkedCar");

                foreach (FuelUp_Model fuelup in fuelUps.ToList()) {
                    keyValuePairs.Add(fuelup.FuelUpNumber, fuelup);
                }
            }

            return keyValuePairs;
        }

    }
}
