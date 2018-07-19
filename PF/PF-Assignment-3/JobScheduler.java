/**
 * This class is used to schedule number of processes for execution time
 * @author Rajendra Singh Rathore
 *
 */
import java.util.Scanner;

public class JobScheduler {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of processes : ");	// Asking no of processes to schedule
		int noOfProcess = scan.nextInt();
		if(noOfProcess == 0) {
			System.out.println("There are no jobs to schedule."); 
			System.exit(0);									// terminate program because no processes to schedule
		}
		int arrivalTime[] = new int[noOfProcess];
		int burstTime[] = new int[noOfProcess];
		int completionTime[] = new int[noOfProcess];
		int turnAroundTime[] = new int[noOfProcess];
		int waitingTime[] = new int[noOfProcess];
		int totalWaitingTime = 0;
		int avgWaitingTime = 0;
		int maximumWaitingTime = 0;
		int maximumWaitingTimeIndex = 0;

		System.out.println("\nARRIVAL TIME");		// taking arrival time
		for(int i = 0 ; i < noOfProcess ; i++) {
			System.out.print("Enter arrival time of process " + (i+1) + " : ");
			arrivalTime[i] = scan.nextInt();
		}

		System.out.println("\nBURST TIME");			// taking burst time
		for(int i = 0 ; i < noOfProcess ; i++) {
			System.out.print("Enter burst time of process " + (i+1) + " : ");
			burstTime[i] = scan.nextInt();
		}
		
		for (int i = 0; i < noOfProcess; i++) {
			if ((arrivalTime[i] < 0) || (burstTime[i] < 0)) {
				System.out.println("Arrival Time or Burst Time can't be negative");
			}
		}
		
		for (int i = 0; i < noOfProcess; i++) {
			if ((i + 1) < noOfProcess) {
				if (arrivalTime[i] >= arrivalTime[i + 1]) {
					System.out.println("Arrival Time of Process " + (i + 1) + " is greater than or equal to " + (i + 2));
					System.exit(1);
				}
			}
		}
		
		for (int i = 0; i < noOfProcess; i++) {		
			if (i==0) {
				completionTime[i] = arrivalTime[i] + burstTime[i];
			} else {
				if (arrivalTime[i] > completionTime[i-1]) {
				 	completionTime[i] = arrivalTime[i] + burstTime[i];
				} else {
				 	completionTime[i] = completionTime[i-1] + burstTime[i];
				}
			}
			turnAroundTime[i] = completionTime[i] - arrivalTime[i];
			waitingTime[i] = turnAroundTime[i] - burstTime[i];
			totalWaitingTime += waitingTime[i];
		}
		
		System.out.println("Process No\tCompletion Time\tTurnAround Time\tWaiting Time");
		for (int i = 0; i < noOfProcess; i++) {
			System.out.println(i + 1 + "\t\t" +completionTime[i] + "\t\t\t" + turnAroundTime[i] + "\t\t" + waitingTime[i]);
			if(maximumWaitingTime < waitingTime[i]) {
				maximumWaitingTime = waitingTime[i];
			}
		}
		
		System.out.println("Maximum Waiting Time :- " + maximumWaitingTime);
		avgWaitingTime = totalWaitingTime / noOfProcess;
		System.out.println("The average waiting time is " + avgWaitingTime);
	}
}
