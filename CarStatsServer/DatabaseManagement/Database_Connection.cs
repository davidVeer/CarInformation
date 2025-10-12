using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.DatabaseManagement
{
    public class Database_Connection
    {
        public static IDbConnection databaseConnection;

        public static string LoadConnectionString(string connectionStringId = "Default") =>
            ConfigurationManager.ConnectionStrings[connectionStringId].ConnectionString;
    }
}
