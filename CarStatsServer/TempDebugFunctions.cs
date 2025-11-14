using CarStatsServer.DatabaseManagement;
using CarStatsServer.DatabaseManagement.DatabaseObjectServices;
using CarStatsServer.Models;
using System.Collections.Generic;

namespace CarStatsServer
{
    public class TempDebugFunctions
    {
        public static void PrintFuelUpList() {
            Dictionary<ushort, FuelUp_Model> fuelUps;

            fuelUps = FuelUpDatabaseService.LoadDatabaseObjects();
            foreach (FuelUp_Model model in fuelUps.Values)
            {
                Console.WriteLine("FuelUpID = {0}: \n - Odometer = {1}\n - Liters = {2}\n - Price = {3}\n - Date = {4}",
                    model.ObjectKey,
                    model.OdometerReading,
                    model.LitersRefueled,
                    model.FuelUpCost,
                    model.FuelUpDate);
            }
        }

        public static void EnterNewFuelUp()
        {
            Console.WriteLine("Enter the FuelupNumber, odometerReading, Date, Liters fueled, and cost of fuel up:");
            FuelUpDatabaseService.SaveDatabaseObject(new FuelUp_Model()
            {
                ObjectKey = ushort.Parse(Console.ReadLine()),
                OdometerReading = ushort.Parse(Console.ReadLine()),
                FuelUpDate = Convert.ToDateTime(Console.ReadLine()),
                LitersRefueled = ushort.Parse(Console.ReadLine()),
                FuelUpCost = ushort.Parse(Console.ReadLine()),
            });
        }

        public static void DeleteFuelUp() {
            Console.WriteLine("Enter the FuelUpId you want to delete:");
            FuelUpDatabaseService.DeleteDatabaseObject(ushort.Parse(Console.ReadLine()));
        }
    }
}

