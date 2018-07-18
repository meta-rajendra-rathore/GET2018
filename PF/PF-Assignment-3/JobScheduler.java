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
		
		System.out.println("\nCOMPLETION TIME :-");
		for(int i=0 ; i < noOfProcess ; i++) {		//computing completion time
			if(i==0) {
				completionTime[i] = arrivalTime[i] + burstTime[i];
			}
			else {
				if(arrivalTime[i] > completionTime[i-1]) {
				 	completionTime[i] = arrivalTime[i] + burstTime[i];
				}
				else {
				 	completionTime[i] = completionTime[i-1] + burstTime[i];
				}
			}
			System.out.println("The completion time for process " + (i+1) + " is " + completionTime[i]);
		}
		
		System.out.println("\nTURN AROUND TIME :-");		// computing turn around time
		for(int i=0 ; i < noOfProcess ; i++) {
			turnAroundTime[i] = completionTime[i] - arrivalTime[i];
			System.out.println("The turn around time for process " + (i+1) + " is " + turnAroundTime[i]);
		}
		
		System.out.println("\nWAITING TIME :-");			// computing waiting time
		for(int i=0 ; i < noOfProcess ; i++) {
			waitingTime[i] = turnAroundTime[i] - burstTime[i];
			System.out.println ("The waiting time for process " + (i+1) + " is " + waitingTime[i]);
			totalWaitingTime += waitingTime[i];
		}
		
		avgWaitingTime = totalWaitingTime / noOfProcess;
		System.out.println("\nThe average waiting time is " + avgWaitingTime); 
		
		
		int biggest = 0;
		int bigIndex = 0;
		for(int i = 0 ; i < noOfProcess ; i++){
			if(waitingTime[i] > biggest) {
				biggest = waitingTime[i];
				bigIndex = i;
			}
		}
		System.out.println("Maximum waiting time period is of process " + (bigIndex + 1) + " in queue and is equal to : " + biggest);
	}
}