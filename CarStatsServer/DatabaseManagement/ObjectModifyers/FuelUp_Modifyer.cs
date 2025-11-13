using CarStatsServer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.DatabaseManagement.ObjectModifyers
{
    class FuelUp_Modifyer : IModelModifyer<ushort, FuelUp_Model>
    {
        public static FuelUp_Model ConvertToDatabaseValues(FuelUp_Model ExportModel)
        {
            return new()
            {
                ObjectKey = ExportModel.ObjectKey,
                KilometersDriven = ExportModel.KilometersDriven,
                OdometerReading = ExportModel.OdometerReading,
                FuelUpDate = ExportModel.FuelUpDate,

                LitersRefueled = ExportModel.LitersRefueled * 100,
                FuelUpCost = ExportModel.FuelUpCost * 100,
                FuelEfficiency = ExportModel.FuelEfficiency * 100,
                LiterPrice = ExportModel.LiterPrice * 100,
                CarbonEmissions = ExportModel.CarbonEmissions * 100
            };
        }

        public static FuelUp_Model ConvertToCodeValues(FuelUp_Model ImportModel)
        {
            return new()
            {
                ObjectKey = ImportModel.ObjectKey,
                KilometersDriven = ImportModel.KilometersDriven,
                OdometerReading = ImportModel.OdometerReading,
                FuelUpDate = ImportModel.FuelUpDate,

                LitersRefueled = ImportModel.LitersRefueled / 100.0f,
                FuelUpCost = ImportModel.FuelUpCost / 100.0f,
                FuelEfficiency = ImportModel.FuelEfficiency / 100.0f,
                LiterPrice = ImportModel.LiterPrice / 100.0f,
                CarbonEmissions = ImportModel.CarbonEmissions / 100.0f
            };
        }

    }
}
