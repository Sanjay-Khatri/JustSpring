package com.spring.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.stream.DoubleStream;

@Slf4j
@RestController
public class AnotherController {

    @GetMapping("/")
    public String getAnother(){
        return "Its working...";
    }

    @GetMapping("/example")
    public String getExample(){
        return "this is just an example...";
    }

    private final Executor taskExecutor;

    public AnotherController(@Qualifier("taskExecutor") Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @GetMapping("/threading")
    public String processRequest() {

        Runnable task = () -> {
            long startTime = System.currentTimeMillis();
            Random random = new Random();

            while (System.currentTimeMillis() - startTime < 3000) {
                DoubleStream.generate(() -> random.nextDouble())
                        .limit(random.nextInt(100))
                        .map(n -> Math.cos(n))
                        .sum();
            }
            System.out.println("Done");
        };

//        taskExecutor.execute(task);
        processRecords(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));
        return "Request is being processed asynchronously!";
    }

    public void processRecords(List<String> records) {
        int chunkSize = 1; // Process 1000 records per task
        List<List<String>> chunks = partitionList(records, chunkSize);

        CountDownLatch latch = new CountDownLatch(chunks.size());

        for (List<String> chunk : chunks) {
            taskExecutor.execute(() -> {
                try {
                    handleChunk(chunk);
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await(); // Wait for all tasks to finish
            System.out.println("All chunks processed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void handleChunk(List<String> chunk) {
        while (true){
            log.info(Thread.currentThread().getName());
        }
    }

    private <T> List<List<T>> partitionList(List<T> list, int size) {
        List<List<T>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += size) {
            partitions.add(list.subList(i, Math.min(i + size, list.size())));
        }
        return partitions;
    }
}
