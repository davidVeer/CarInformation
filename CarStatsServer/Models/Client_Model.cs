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
        public Account_Model accountClient { get; private set; }

        public Client_Model(TcpClient tcpClient, NetworkStream clientNetworkStream, Account_Model accountClient)
        {
            this.tcpClient = tcpClient;
            this.clientNetworkStream = clientNetworkStream;
            this.accountClient = accountClient;
        }

        public Client_Model(TcpClient tcpClient, NetworkStream clientNetworkStream)
        {
            this.tcpClient = tcpClient;
            this.clientNetworkStream = clientNetworkStream;
        }

        public void SetClientAccount(Account_Model linkedAccount) {
            if (accountClient != null) return;

            accountClient = linkedAccount;
        }
    }
}
