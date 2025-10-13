using System.Data.SQLite;
using System.Diagnostics.Contracts;
using CarStatsServer.DatabaseManagement;
using CarStatsServer.Models;

namespace CarStatsServer
{
    public class Program
    {
        static void Main() {
            Console.WriteLine("Hello world!");
            List<FuelUp_Model> fuelUps;
            List<Car_Model> cars;
            List<Account_Model> accounts;
            accounts = Database_DataManagement.LoadAccounts();
            foreach (Account_Model account in accounts)
            {
                Console.WriteLine(account.AccountName);
            }


            cars = Database_DataManagement.LoadCars();


            foreach (Car_Model car in cars)
            {
                car.ToString();
            }


        }

    }

}