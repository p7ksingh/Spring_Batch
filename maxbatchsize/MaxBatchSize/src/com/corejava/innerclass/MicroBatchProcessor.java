package com.corejava.innerclass;

import java.util.ArrayList;
import java.util.List;

public class MicroBatchProcessor {
    private int maxBatchSize;

    public MicroBatchProcessor(int maxBatchSize) {
        this.maxBatchSize = maxBatchSize;
    }

    public void processMicroBatches(List<String> messages) {
        int numBatches = (int) Math.ceil((double) messages.size() / maxBatchSize);

        for (int batchIndex = 0; batchIndex < numBatches; batchIndex++) {
            int startIndex = batchIndex * maxBatchSize;
            int endIndex = Math.min(startIndex + maxBatchSize, messages.size());
            List<String> batch = messages.subList(startIndex, endIndex);

            // Process the current micro batch
            processBatch(batch);
        }
    }

    private void processBatch(List<String> batch) {
        // Your logic to process the micro batch goes here
        System.out.println("Processing batch: " + batch);
    }

    public static void main(String[] args) {
        int maxBatchSize = 3; // Maximum number of messages in a micro batch

        // Create some sample messages
        List<String> messages = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            messages.add("Message " + i);
        }

        // Create an instance of the MicroBatchProcessor
        MicroBatchProcessor processor = new MicroBatchProcessor(maxBatchSize);

        // Process the micro batches
        processor.processMicroBatches(messages);
    }
}
