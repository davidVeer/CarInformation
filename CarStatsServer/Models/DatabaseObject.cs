using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Models
{
    public abstract class DatabaseObject<T>
    {
        public abstract T ObjectKey { get; init; }
    }
}
