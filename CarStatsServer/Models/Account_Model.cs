using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Models
{
    public class Account_Model
    {
        public string AccountName { get; set; }
        public List<Car_Model> ownedCars { get; }

        public Account_Model()
        {
        }

        public Account_Model(string accountName, List<Car_Model> ownedCars)
        {
            AccountName = accountName;
            this.ownedCars = ownedCars;
        }


    }
}
