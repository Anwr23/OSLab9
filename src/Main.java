import java.util.*;
import java.util.stream.Collectors;

// Process class to represent a process
class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int priority;

    public Process(String name, int arrivalTime, int burstTime, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class SchedulingAlgorithms {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 24, 3));
        processes.add(new Process("P2", 1, 3, 1));
        processes.add(new Process("P3", 2, 3, 3));
        processes.add(new Process("P4", 3, 5, 2));

        // Uncomment the scheduling algorithm you want to simulate
        // FCFS(processes);
        // SJN(processes);
        // PriorityScheduling(processes);
        // ShortestRemainingTime(processes);
        // MultipleLevelQueues(processes)
    }