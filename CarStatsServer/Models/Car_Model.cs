using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Models
{
    public class Car_Model
    {
        public string licencePlateNumber { get; }
        public string carModel { get; }
        public string carManufacturer { get; }
        public ushort buildYear { get; } 
        public Account_Model owner { get; }

        public List<FuelUp_Model> fuelUps { get; }


        public Car_Model()
        {
        }
        public Car_Model(string licencePlateNumber, string carModel, string carManufacturer, ushort buildYear, List<FuelUp_Model> fuelUps)
        {
            this.licencePlateNumber = licencePlateNumber;
            this.carModel = carModel;
            this.carManufacturer = carManufacturer;
            this.buildYear = buildYear;
            this.fuelUps = fuelUps;
        }


    }
}
