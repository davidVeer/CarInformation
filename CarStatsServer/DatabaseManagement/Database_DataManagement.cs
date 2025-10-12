using CarStatsServer.Models;
using Dapper;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.SQLite;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.DatabaseManagement
{
    class Database_DataManagement
    {
        public static List<FuelUp_Model> LoadFuelUpsFromSpecificCar(Car_Model carmodelFromFuelups) {
            string query = string.Format("select * from Fuelups where linkedCar = '{0}'", carmodelFromFuelups.licencePlateNumber);
            
            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString())) {
                IEnumerable<FuelUp_Model> output = Database_Connection.databaseConnection.Query<FuelUp_Model>(query, new DynamicParameters());
                return output.ToList();
            }
        }

        public static List<Car_Model> LoadCars()
        {
            string query = "select * from Cars";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
            {
                IEnumerable<Car_Model> output = Database_Connection.databaseConnection.Query<Car_Model>(query, new DynamicParameters());
                return output.ToList();
            }
        }
        public static List<Account_Model> LoadAccounts()
        {
            string query = "select * from Accounts";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
            {
                IEnumerable<Account_Model> output = Database_Connection.databaseConnection.Query<Account_Model>(query, new DynamicParameters());
                return output.ToList();
            }
        }

        public static void SaveFuelUpToDatabase(FuelUp_Model newFuelUp){
            string query = "insert into FuelUps " +
                "(fuelUpNumber, odometerReading, fuelUpDate,litersFueledUp, fuelUpPrice, distanceDriven, fuelEfficiency, literPrice, carbonEmissions, linkedCar) " +
                "values (@fuelUpNumber, @odometerReading, @fuelUpDate,@litersFueledUp, @fuelUpPrice, @distanceDriven, @fuelEfficiency, @literPrice, @carbonEmissions, @LinkedCar)";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
            {
                Database_Connection.databaseConnection.Execute(query, newFuelUp);
            }
        }

        public static void SaveCarToDatabase(Car_Model newCar)
        {
            string query = "insert into Cars (licencePlateNumber)";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
            {
               
            }

        }
        public static void SaveAccountToDatabase(Account_Model newAccount)
        {
            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
            {
                
            }
        }


    }
}
