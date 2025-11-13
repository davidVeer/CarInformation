using CarStatsServer.Models;

namespace CarStatsServer.DatabaseManagement.DatabaseObjectServices
{
    interface IDatabaseObjectService<T_Key, T_Object> where T_Object : DatabaseObject<T_Key>
    {
        static abstract void SaveDatabaseObject(T_Object ObjectToSave);
        static abstract T_Object LoadDatabaseObject();
        static abstract void UpdateDatabaseObject(T_Object UpdatedDatabaseObject, T_Key DatabaseObjectKey);
        static abstract void DeleteDatabaseObject(T_Key DatabaseObjectKey);
    }
}
