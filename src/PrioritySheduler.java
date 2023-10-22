import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Process implements Comparable<Process> {
    String name;
    int priority;
    int burstTime;

    public Process(String name, int priority, int burstTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
    }

    @Override
    public int compareTo(Process other) {
        return Integer.compare(this.priority, other.priority);
    }
}

public class PriorityScheduler {

    public static List<String> priorityScheduling(List<Process> processes) {
        int time = 0;
        List<Process> processQueue = new ArrayList<>();
        List<String> processOrder = new ArrayList<>();

        while (!processes.isEmpty() || !processQueue.isEmpty()) {
            for (Process process : processes) {
                if (process.priority <= time) {
                    processQueue.add(process);
                }
            }

            if (!processQueue.isEmpty()) {
                Collections.sort(processQueue, Collections.reverseOrder());

                Process highestPriorityProcess = processQueue.get(0);
                processQueue.remove(highestPriorityProcess);
                processOrder.add(highestPriorityProcess.name);
                time += highestPriorityProcess.burstTime;
            } else {
                time++;
            }
        }

        return processOrder;
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 2, 6));
        processes.add(new Process("P2", 1, 4));
        processes add(new Process("P3", 3, 8));
        processes.add(new Process("P4", 2, 1));

        List<String> executionOrder = priorityScheduling(processes);

        System.out.println("Порядок выполнения процессов:");
        for (String processName : executionOrder) {
            System.out.println(processName);
        }
    }
}
