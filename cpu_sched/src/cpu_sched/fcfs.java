/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpu_sched;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author maikaordonez
 */
public class fcfs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes (between 3 and 6): ");
        int n = scanner.nextInt();
        System.out.println();

        if (n >= 3 && n <= 6) {
            int[] processID = new int[n];
            int[] burstTime = new int[n];
            int[] arrivalTime = new int[n];

            // Input burst time and arrival time
            for (int i = 0; i < n; i++) {
                processID[i] = i + 1; // Initialize process IDs
                System.out.print("Enter burst time for [P" + (i + 1) + "]: ");
                burstTime[i] = scanner.nextInt();
                System.out.print("Enter arrival time for [P" + (i + 1) + "]: ");
                arrivalTime[i] = scanner.nextInt();
            }

            // Sort processes by arrival time, and by process ID in case of a tie
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arrivalTime[j] > arrivalTime[j + 1] || 
                        (arrivalTime[j] == arrivalTime[j + 1] && processID[j] > processID[j + 1])) {
                        // Swap arrivalTime
                        int temp = arrivalTime[j];
                        arrivalTime[j] = arrivalTime[j + 1];
                        arrivalTime[j + 1] = temp;

                        // Swap burstTime
                        temp = burstTime[j];
                        burstTime[j] = burstTime[j + 1];
                        burstTime[j + 1] = temp;

                        // Swap processID
                        temp = processID[j];
                        processID[j] = processID[j + 1];
                        processID[j + 1] = temp;
                    }
                }
            }

            // Calculate completion time, turn-around time, and waiting time
            int[] completionTime = new int[n];
            int[] waitingTime = new int[n];
            int[] turnAroundTime = new int[n];
            int currentTime = 0;

            for (int i = 0; i < n; i++) {
                if (arrivalTime[i] > currentTime) {
                    currentTime = arrivalTime[i]; // Handle idle time
                }
                currentTime += burstTime[i];
                completionTime[i] = currentTime;
                turnAroundTime[i] = completionTime[i] - arrivalTime[i];
                waitingTime[i] = turnAroundTime[i] - burstTime[i];
            }

            // Calculate averages
            double avgWaitingTime = 0;
            double avgTurnAroundTime = 0;
            int totalBurstTime = 0;

            for (int i = 0; i < n; i++) {
                avgWaitingTime += waitingTime[i];
                avgTurnAroundTime += turnAroundTime[i];
                totalBurstTime += burstTime[i];
            }
            double cpuUtilization = (double) totalBurstTime / completionTime[n - 1] * 100;

            // Display results
            System.out.println("\n- Gantt Chart -");
            System.out.print("0");
            for (int i = 0; i < n; i++) {
                System.out.print(" | P" + processID[i] + " | " + completionTime[i]);
            }
            System.out.println();

            System.out.println("\n- CPU UTILIZATION -");
            System.out.println("Total Burst Time / Total Completion Time * 100 = " + totalBurstTime + " / " + completionTime[n - 1] + " * 100 = " + String.format("%.2f", cpuUtilization) + "%");

            System.out.println("\n- TABLE -");
            System.out.println("Process ID | Arrival Time | Burst Time | Completion Time | Turn-Around Time | Waiting Time");
            for (int i = 0; i < n; i++) {
                System.out.println("P" + processID[i] + "         | " + arrivalTime[i] + "           | " + burstTime[i] + "         | " + completionTime[i] + "             | " + turnAroundTime[i] + "               | " + waitingTime[i]);
            }

            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("\nAverage waiting time: " + df.format(avgWaitingTime / n) + " ms");
            System.out.println("Average turn-around time: " + df.format(avgTurnAroundTime / n) + " ms");
        } else {
            System.out.println("Number of processes must be between 3 and 6.");
        }

        scanner.close();
    }
}
