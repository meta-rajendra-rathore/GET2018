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
		if (noOfProcess == 0) {
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

		for (int i = 0 ; i < noOfProcess ; i++) {	// taking arrival time and burst time
			
			System.out.print("\nEnter arrival time of process " + (i+1) + " : ");
			arrivalTime[i] = scan.nextInt();
			System.out.print("Enter burst time of process " + (i+1) + " : ");
			burstTime[i] = scan.nextInt();
			
			if ((arrivalTime[i] < 0) || (burstTime[i] < 0)) {
				System.out.println("Arrival Time or Burst Time can't be negative");
			}
			
			if ((i + 1) <= noOfProcess && i != 0) {
				if (arrivalTime[i] < arrivalTime[i - 1]) {
					System.out.println("Arrival Time of Process " + i + " is earlier than earlier process "");
					System.exit(1);
				}
			}
			
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
		
		System.out.println("\n\nProcess No\tCompletion Time\tTurnAround Time\tWaiting Time");
							   
		for (int i = 0; i < noOfProcess; i++) {
			System.out.println(i + 1 + "\t\t" +completionTime[i] + "\t\t\t" + turnAroundTime[i] + "\t\t" + waitingTime[i]);
			if (maximumWaitingTime < waitingTime[i]) {
				maximumWaitingTime = waitingTime[i];
			}
		}
		
		System.out.println("\n\nMaximum Waiting Time : " + maximumWaitingTime);
		avgWaitingTime = totalWaitingTime / noOfProcess;
		System.out.println("The average waiting time is " + avgWaitingTime);
	}
}
