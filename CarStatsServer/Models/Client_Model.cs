using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Models
{
    public class Client_Model
    {
        public TcpClient tcpClient { get; }
        public NetworkStream clientNetworkStream { get; }

        public Client_Model(TcpClient tcpClient, NetworkStream clientNetworkStream)
        {
            this.tcpClient = tcpClient;
            this.clientNetworkStream = clientNetworkStream;
        }
    }
}
