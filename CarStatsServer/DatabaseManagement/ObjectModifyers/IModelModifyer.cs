using CarStatsServer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.DatabaseManagement.ObjectModifyers
{
    interface IModelModifyer<T_Key,T_Object> where T_Object : DatabaseObject<T_Key>
    {
        static abstract T_Object ConvertToDatabaseValues(T_Object ExportModel);
        static abstract T_Object ConvertToCodeValues(T_Object ImportModel);
    }
}
