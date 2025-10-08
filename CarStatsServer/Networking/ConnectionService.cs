using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Networking
{
    public class ConnectionService
    {
        private TcpListener listener { get; }
        public ClientHandler clientHandler { get; }
    }
}
