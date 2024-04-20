package com.corejava.innerclass;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
    public static void main(String[] args) {
        List<Message> sortedMsgList = createSortedMessageList();

        int startIndex = 0;
        int totalItems = sortedMsgList.size();
        int maxBatchSize = 3;

        while (startIndex < totalItems) {
            int endIndex = Math.min(startIndex + maxBatchSize, totalItems);

            List<Message> subList = sortedMsgList.subList(startIndex, endIndex);

            processBatch(subList);
System.out.println("________________________________________________________________________");
            startIndex = endIndex;
        }
    }

    public static void processBatch(List<Message> batch) {
        for (Message message : batch) {
            System.out.println("Processing message: " + message);
            // Your implementation to process each message in the batch
        }
    }

    public static List<Message> createSortedMessageList() {
        List<Message> sortedMsgList = new ArrayList<>();

        // Add some example messages (Replace with your actual message creation logic)
        sortedMsgList.add(new Message("Message 1"));
        sortedMsgList.add(new Message("Message 2"));
        sortedMsgList.add(new Message("Message 3"));
        sortedMsgList.add(new Message("Message 4"));
        sortedMsgList.add(new Message("Message 5"));
        sortedMsgList.add(new Message("Message 6"));
        sortedMsgList.add(new Message("Message 7"));
        sortedMsgList.add(new Message("Message 8"));
        sortedMsgList.add(new Message("Message 9"));
        sortedMsgList.add(new Message("Message 10"));
        sortedMsgList.add(new Message("Message 11"));
        sortedMsgList.add(new Message("Message 12"));
        sortedMsgList.add(new Message("Message 13"));

        return sortedMsgList;
    }
}

class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
