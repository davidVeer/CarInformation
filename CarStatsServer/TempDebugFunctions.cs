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
    }
}

