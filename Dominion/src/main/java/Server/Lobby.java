package Server;

import protobuf.PacketProtos.Packet;

import java.util.*;

/*
 * Keeps track of players connected to the server
 */

public class Lobby {

    private final Server server;

    private final Map<UUID, ConnectionDetails> clients;
    private final int maxNumOfPlayers; //max number of clients that may be added

    public Lobby(Server server, int maxLobbySize){
        this.server = server;
        this.clients = Collections.synchronizedMap(new HashMap<UUID, ConnectionDetails>());
        this.maxNumOfPlayers = maxLobbySize;
    }

    public synchronized int getNumPlayersConnected(){
        return clients.size();
    }

    public int getMaxNumOfPlayers(){
        return maxNumOfPlayers;
    }

    public synchronized List<ConnectionDetails> getConnectionDetails() {
        List<ConnectionDetails> players = new ArrayList<>();

        for (ConnectionDetails connectionDetails : Collections.synchronizedCollection(clients.values())) {
            players.add(connectionDetails);
        }

        return players;
    }

    public synchronized Map<UUID, ConnectionDetails> getClients() { return clients; }

    public synchronized ConnectionDetails addClient(ConnectionDetails clientDetails) throws IllegalArgumentException {
        if(clients.size() >= maxNumOfPlayers) {
            throw new IllegalArgumentException("The server is full. Could not join.");
        }

        return clients.put(clientDetails.getPlayerId(), clientDetails);
    }

    public synchronized ConnectionDetails removeClient(UUID playerId) {
        synchronized(clients){
            UUID clientToRemove = clients.get(playerId).getPlayerId();

            if(playerId == clientToRemove)
                return clients.remove(playerId);
            else
                return null;
        }
    }

    public void queuePacketToProcess(Packet message){
        this.server.queuePacket(message);
    }

    public void killAll() {

    }
}