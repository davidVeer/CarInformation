using CarStatsServer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Networking
{
    public class ClientHandler
    {
        public ProtocolState currentState { get; private set; }
        public readonly ConnectionService server;
        public readonly Client_Model currentActiveClient;

        public ClientHandler(ConnectionService server, Client_Model currentActiveClient)
        {
            this.server = server;
            this.currentActiveClient = currentActiveClient;
        }

        public void ReadIncomingMessages() {
            throw new NotImplementedException();
        }

        public void SwitchStates(ProtocolState newProtocolState) {
            currentState = newProtocolState;
        }
    }
}
