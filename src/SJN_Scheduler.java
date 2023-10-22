import java.util.ArrayList;
import java.util.List;

class Process {
    String name;
    int arrivalTime;
    int burstTime;

    public Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class SJN_Scheduler {

    public static List<String> sjnScheduling(List<Process> processes) {
        int time = 0;
        List<Process> processQueue = new ArrayList<>();
        List<String> processOrder = new ArrayList<>();

        while (!processes.isEmpty() || !processQueue.isEmpty()) {
            for (Process process : processes) {
                if (process.arrivalTime <= time) {
                    processQueue.add(process);
                }
            }

            Process shortestJob = null;
            int shortestBurstTime = Integer.MAX_VALUE;

            for (Process process : processQueue) {
                if (process.burstTime < shortestBurstTime) {
                    shortestBurstTime = process.burstTime;
                    shortestJob = process;
                }
            }

            if (shortestJob != null) {
                processQueue.remove(shortestJob);
                processOrder.add(shortestJob.name);
                time += shortestJob.burstTime;
            } else {
                time++;
            }
        }

        return processOrder;
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 6));
        processes.add(new Process("P2", 1, 4));
        processes.add(new Process("P3", 2, 8));
        processes.add(new Process("P4", 3, 1));

        List<String> executionOrder = sjnScheduling(processes);

        System.out.println("Порядок выполнения процессов:");
        for (String processName : executionOrder) {
            System.out.println(processName);
        }
    }
}
