using System.Collections;
using System.Linq;
using System.Numerics;

namespace CarStatsServer.Calculators
{
    public class StatisticsCalculator
    {
        public static T FindLowest<T>(T[] dataSet) => dataSet.Min();
        public static T FindHighest<T>(T[] dataList) => dataList.Max();

        public static float CalculateMean(float[] floatDataSet) => floatDataSet.Average();
        public static int CalculateMean(ushort[] ushortDataSet) => (int)ushortDataSet.Average(ushortDataPoint => (int)ushortDataPoint);

        public static float CalculateTotal(float[] floatDataSet) => floatDataSet.Sum();
        public static int CalculateTotal(ushort[] ushortDataSet) => (int)ushortDataSet.Sum(ushortDataPoint => (int)ushortDataPoint);

        public static float FindMedian(float[] floatDataSet)
        {
            throw new NotImplementedException();
        }
        public static ushort FindMedian(ushort[] ushortDataSet)
        {
            throw new NotImplementedException();
        }

        public static float CalculateMode(float[] floatDataSet) 
        {
            throw new NotImplementedException();
        }
        public static ushort CalculateMode(ushort[] ushortDataSet)
        {
            throw new NotImplementedException();
        }

        public static float CalculateStandardDeviation(float[] floatDataSet)
        {
            throw new NotImplementedException();
        }
        public static ushort CalculateStandardDeviation(ushort[] ushortDataSet)
        {
            throw new NotImplementedException();
        }

        public static float CalculateIqr(float[] floatDataSet)
        {
            throw new NotImplementedException();
        }
        public static ushort CalculateIqr(ushort[] ushortDataSet)
        {
            throw new NotImplementedException();
        }

        public static Hashtable MakeFrequencyTable(float[] dataListFloats)
        {
            throw new NotImplementedException();
        }

    }
}
