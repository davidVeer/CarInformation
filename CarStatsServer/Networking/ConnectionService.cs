using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Networking
{
    public class ConnectionService
    {
        private TcpListener listener { get; }
        public ClientHandler clientHandler { get; }

        public void StartServer(int port) {
            throw new NotImplementedException();
        }

        private void AcceptClients() {
            throw new NotImplementedException();
        }
    }
}
