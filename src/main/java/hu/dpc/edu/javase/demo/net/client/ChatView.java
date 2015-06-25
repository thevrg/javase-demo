package hu.dpc.edu.javase.demo.net.client;

import hu.dpc.edu.javase.demo.net.common.ChatMessage;

/**
 *
 * @author IQJB
 */
public interface ChatView {
    public void printReceivedMessage(ChatMessage message);
    public void clear();
}
