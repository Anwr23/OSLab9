import java.util.LinkedList;
import java.util.Queue;

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

public class FCFS_Scheduler {

    public static void main(String[] args) {
        Queue<Process> processQueue = new LinkedList<>();

        processQueue.add(new Process("Process1", 0, 6));
        processQueue.add(new Process("Process2", 1, 4));
        processQueue.add(new Process("Process3", 2, 8));
        processQueue.add(new Process("Process4", 3, 1));

        int currentTime = 0;

        System.out.println("Порядок выполнения:");

        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.poll();
            System.out.println(currentProcess.name + " выполняется с " + currentTime + " по " + (currentTime + currentProcess.burstTime));
            currentTime += currentProcess.burstTime;
        }
    }
}
