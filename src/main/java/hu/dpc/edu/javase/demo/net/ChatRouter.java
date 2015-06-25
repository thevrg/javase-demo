package hu.dpc.edu.javase.demo.net;

/**
 *
 * @author IQJB
 */
public interface ChatRouter {
    public void broadcast(String message);
    public void registerClient(ChatClient chatClient);
    public void unregisterClient(ChatClient chatClient);
}
