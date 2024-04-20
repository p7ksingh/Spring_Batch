package com.corejava.innerclass;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExampleCode {

    public static void main(String[] args) {
        int startIndex = 0;
        int totalItems = sortedMsgList.size();
        int maxBatchSize = 10; // Replace with your desired value

        while (startIndex < totalItems) {
            int endIndex = Math.min(startIndex + maxBatchSize, totalItems);

            List<Message> subList = sortedMsgList.subList(startIndex, endIndex);

            Set<String> boIdList = subList.stream()
                    .map(msg -> msg.getBoId())
                    .collect(Collectors.toSet());

            Set<String> msgIdList = subList.stream()
                    .map(msg -> msg.getMessageId())
                    .collect(Collectors.toSet());

            List<StateHolder> stateHolderList = beginBatchTxProcess(subList);

            // Process the batch of messages and stateHolderList
            // ...

            startIndex = endIndex;
        }
    }

    private static List<StateHolder> beginBatchTxProcess(List<Message> subList) {
        // Implement your logic for processing the batch of messages here
        // Return the list of StateHolder objects
        // ...

        return null; // Placeholder, replace with the actual implementation
    }

    private static class Message {
        private String boId;
        private String messageId;

        public Message(String boId, String messageId) {
            this.boId = boId;
            this.messageId = messageId;
        }

        public String getBoId() {
            return boId;
        }

        public String getMessageId() {
            return messageId;
        }
    }

    private static class StateHolder {
        // Replace with your StateHolder class implementation
        // ...
    }

    private static List<Message> sortedMsgList;

    static {
        // Initialize sortedMsgList with your actual data
        sortedMsgList = List.of(
                new Message("boId1", "msgId1"),
                new Message("boId2", "msgId2"),
                new Message("boId3", "msgId3"),
                new Message("boId4", "msgId4"),
                new Message("boId5", "msgId5")
        );
    }
}
