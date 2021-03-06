package com.syeedode.interviews.tenna.threadsynchronization;

import java.util.*;

import static com.syeedode.interviews.tenna.threadsynchronization.NumericThreadSynchronizationService.ThreadTrackingEnum.*;
import static com.syeedode.interviews.tenna.threadsynchronization.NumericThreadSynchronizationService.ThreadTrackingEnum.EVEN;

public class NumericThreadSynchronizationService {
    private static final int N_PRODUCERS = 100;

    public static void main(String [] args) {
        PriorityQueue<NumberDto> queue = new PriorityQueue<>(
                  N_PRODUCERS
                , Comparator.comparing(NumberDto::getId));

        for (int id = 1; id < (N_PRODUCERS + 1); id++) {
            NumberDto numberDto = new NumberDto(id);
            queue.add(numberDto);
        }

        for (int i = 1; i < 3; i++) {
            String name = "Thread " + i;
            new Thread(new NumericPrintingTask(queue, name)).start();
        }
    }


    static class NumericPrintingTask implements Runnable {
        private final Queue<NumberDto> queue;
        private final String threadName;
        private final ThreadTrackingEnum printerType;

        public NumericPrintingTask(Queue<NumberDto> queue, String threadName) {
            this.queue = queue;
            this.threadName = threadName;
            if("Thread 1".equalsIgnoreCase(threadName)) {
                printerType = ODD;
            } else {
                printerType = EVEN;
            }
        }

        public void run() {
//        try {
            while (true) {
                /**
                 * The most important thing is to marry the poll with the take.
                 * The blocking queue assured the correct order, but we want to
                 * assure the correct thread prints the right number
                 */
                synchronized (queue) {
                    if(isPrintableByThread()){
                        printNumber(queue.poll());
                    }
                }

            }
        }

        private boolean isPrintableByThread() {
            NumberDto peeked = queue.peek();
            return Objects.nonNull(peeked) && peeked.getPrinterType().equals(printerType);
        }

        private void printNumber(NumberDto took) {
            took.setThreadId(threadName);
            System.out.println(took);
        }

        @Override
        public String toString() {
            return "NumericPrintingTask: " + threadName + " " + printerType;
        }
    }

    static class NumberDto {
        private final String name;
        private final Integer id;
        private final ThreadTrackingEnum printerType;
        private String threadId;

        public NumberDto(Integer numberId) {
            if(Objects.isNull(numberId))
                throw new IllegalArgumentException();
            this.name = String.valueOf(numberId);
            this.id = numberId;
            if(id % 2 == 0) {
                printerType = EVEN;
            } else {
                printerType = ODD;
            }
        }

        @Override
        public String toString() {
            return threadId + ":" + " The number is '" + name + "'";
        }

        public synchronized void setThreadId(String threadId) {
            this.threadId = threadId;
        }

        public ThreadTrackingEnum getPrinterType() {
            return printerType;
        }

        public Integer getId() {
            return id;
        }
    }

    public enum ThreadTrackingEnum {
        EVEN,
        ODD;
    }
}
