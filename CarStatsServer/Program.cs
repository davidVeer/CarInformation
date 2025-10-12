using System.Data.SQLite;
using CarStatsServer.DatabaseManagement;
using CarStatsServer.Models;

namespace CarStatsServer
{
    public class Program
    {
        static void Main() {
            Console.WriteLine("Hello world!");

            Database_DataManagement.LoadAccounts();
        }

    }

}