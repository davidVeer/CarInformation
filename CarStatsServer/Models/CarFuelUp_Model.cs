using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Models
{
    class CarFuelUp_Model
    {
        public CarFuelUp_Model()
        {
        }

        public int fuelupNumber { get; set; }
        public Car_Model car { get; set; }
        public FuelUp_Model fuelUp { get; set; }


    }
}
