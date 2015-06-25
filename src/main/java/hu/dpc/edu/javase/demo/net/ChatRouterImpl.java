package hu.dpc.edu.javase.demo.net;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class ChatRouterImpl implements ChatRouter {

    private List<ChatClient> clients = new ArrayList<>();

    @Override
    public synchronized void broadcast(String message) {
        for (ChatClient client : clients) {
            client.send(message);
        }
    }

    @Override
    public synchronized void registerClient(ChatClient chatClient) {
        broadcast("Client logged in: " + chatClient.getName());
        clients.add(chatClient);
    }

    @Override
    public synchronized void unregisterClient(ChatClient chatClient) {
        clients.remove(chatClient);
        broadcast("Client logged out: " + chatClient.getName());
    }

}
