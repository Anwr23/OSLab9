import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Process {
    String name;
    int priority;
    int burstTime;

    public Process(String name, int priority, int burstTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
    }
}

public class MLQScheduler {
    public static void main(String[] args) {
        Queue<Process> highPriorityQueue = new LinkedList<>();
        Queue<Process> mediumPriorityQueue = new LinkedList<>();
        Queue<Process> lowPriorityQueue = new LinkedList<>();

        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 2, 6));
        processes.add(new Process("P2", 1, 4));
        processes.add(new Process("P3", 3, 8));
        processes.add(new Process("P4", 2, 1));
        processes.add(new Process("P5", 1, 2));

        for (Process process : processes) {
            if (process.priority == 1) {
                highPriorityQueue.add(process);
            } else if (process.priority == 2) {
                mediumPriorityQueue.add(process);
            } else {
                lowPriorityQueue.add(process);
            }
        }

        System.out.println("MLQ Scheduling Order:");
        while (!highPriorityQueue.isEmpty() || !mediumPriorityQueue.isEmpty() || !lowPriorityQueue.isEmpty()) {
            if (!highPriorityQueue.isEmpty()) {
                executeProcess(highPriorityQueue);
            } else if (!mediumPriorityQueue.isEmpty()) {
                executeProcess(mediumPriorityQueue);
            } else {
                executeProcess(lowPriorityQueue);
            }
        }
    }

    private static void executeProcess(Queue<Process> queue) {
        Process currentProcess = queue.poll();
        System.out.println("Executing: " + currentProcess.name);
        currentProcess.burstTime -= 2;

        if (currentProcess.burstTime > 0) {
            queue.add(currentProcess);
        }
    }
}
