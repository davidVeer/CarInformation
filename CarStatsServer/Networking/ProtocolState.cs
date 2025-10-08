using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarStatsServer.Networking
{
    public abstract class ProtocolState
    {
        protected ClientHandler clientHandler { get; set; }

        protected ProtocolState(ClientHandler clientHandler)
        {
            this.clientHandler = clientHandler;
        }

        public abstract void ProcessIncommingMessage(string incommingMessage);
    }
}
