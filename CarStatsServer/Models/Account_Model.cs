using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Models
{
    public class Account_Model
    {
        public string accountName { get; }
        public List<Car_Model> ownedCars { get; }

        public Account_Model(string accountName, List<Car_Model> ownedCars)
        {
            this.accountName = accountName;
            this.ownedCars = ownedCars;
        }
    }
}
