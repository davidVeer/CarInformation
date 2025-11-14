using CarStatsServer.Models;
using Dapper;
using System.Collections.Generic;
using System.Data.SQLite;

namespace CarStatsServer.DatabaseManagement.DatabaseObjectServices
{
    class FuelUpDatabaseService : IDatabaseObjectService<ushort, FuelUp_Model>
    {
        public static void SaveDatabaseObject(FuelUp_Model ObjectToSave)
        {
            string query = @"
            INSERT INTO FuelUps (FuelUpId, OdometerReading, FuelUpDate, LitersRefueled, FuelUpCost, DistanceTraveled, FuelEfficiency, LiterPrice, CarbonEmissions)
            VALUES (@ObjectKey, @OdometerReading, @FuelUpDate, @LitersRefueled, @FuelUpCost, @KilometersDriven, @FuelEfficiency, @LiterPrice, @CarbonEmissions)";

            try
            {
                using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
                {
                    Database_Connection.databaseConnection.Execute(query, ObjectToSave);
                    }
            }
            catch (SQLiteException ex) {
                Console.Write(ex.Message);
            }
        }

        public static Dictionary<ushort, FuelUp_Model> LoadDatabaseObjects()
        {
            string query = @"
            SELECT FuelUpId AS ObjectKey, OdometerReading, FuelUpDate, LitersRefueled, FuelUpCost, FuelEfficiency, LiterPRice, CarbonEmissions, DistanceTraveled
            FROM FuelUps";
            Dictionary<ushort, FuelUp_Model> keyValuePairs = new();

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
            {
                IEnumerable<FuelUp_Model> fuelUps = Database_Connection.databaseConnection.Query<FuelUp_Model>(query,new DynamicParameters());

                foreach (FuelUp_Model fuelup in fuelUps.ToList())
                {
                    keyValuePairs.Add(fuelup.ObjectKey, fuelup);
                }
            }

            return keyValuePairs;
        }
        
        public static void UpdateDatabaseObject(FuelUp_Model UpdatedDatabaseObject, ushort DatabaseObjectKey)
        {
            throw new NotImplementedException();
        }
        
        public static void DeleteDatabaseObject(ushort DatabaseObjectKey)
        {
            string query = @"DELETE FROM FuelUps
                             WHERE FuelUpId = @ObjectKey";

            using (Database_Connection.databaseConnection = new SQLiteConnection(Database_Connection.LoadConnectionString()))
            {
                Database_Connection.databaseConnection.Execute(query, new { ObjectKey = DatabaseObjectKey});
            }
        }

    }
}
