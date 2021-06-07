using Microsoft.Data.Sqlite;
using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NumberGen
{
    class Program
    {
        static void Main(string[] args)
        {
            GenNumbers();
        }
		
        public static void GenNumbers()
        {
            for (int i = 7000000; i < 7999999; i++) //change starting and ending value based on the type of number
            {
                Console.WriteLine("Number: +960 " + i); // show output
                StringBuilder sb = new StringBuilder();
                sb.AppendFormat("\n{0},{1}", "Name", i); //get it ready for csv format
                File.AppendAllText("Dhiraagu.csv", sb.ToString()); //add line to csv file
            }
            Console.WriteLine("DONE");
        }
    }
}
