using CarStatsServer.Models;
using Dapper;
using System.Data.SQLite;

namespace CarStatsServer.DatabaseManagement
{
    class Database_DataManagement
    {
        public static List<FuelUp_Model> LoadFuelUps() {
            string query = @"SELECT * FROM Fuelups";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                IEnumerable<FuelUp_Model> output = Database_Connection.databaseConnection.Query<FuelUp_Model>(query, new DynamicParameters());
                return output.ToList();
            }
        }

        public static List<Car_Model> LoadCars() {
            
            Dictionary<int, Account_Model> loadedAccounts = new();


            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                string query = """
                               SELECT * FROM Cars 
                               INNER JOIN Accounts 
                               ON Cars.Owner = Accounts.UserID
                               """;

                var cars = Database_Connection.databaseConnection.Query<Car_Model, Account_Model, Car_Model>(
                    query,
                    (car, account) => { car.Owner = account; return car; }, splitOn: "Owner");
                return cars.ToList();
            }
        }
        public static List<Account_Model> LoadAccounts() {
            string query = "select * from Accounts";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                var output = Database_Connection.databaseConnection.Query<Account_Model>(query, new DynamicParameters());
                return output.ToList();
            }
        }

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


    }
}
