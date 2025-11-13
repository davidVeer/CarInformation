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
            throw new NotImplementedException();
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
