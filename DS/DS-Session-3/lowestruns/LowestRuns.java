/**
 * This class solves the problems to provide functionality for keeping the score minimum
 * @author Rajendra Singh Rathore
 *
 */

package datastructure_3.lowestruns;

public class LowestRuns {
    int maxBalls;
    int noOfBallers;
    int[] ballersQuota;

    /**
     * constructor which accept total no of balls to be played by the batsman
     * and quota for each baller
     * @param maxBalls
     * @param quota
     */
    public LowestRuns(int maxBalls, int[] quota) {
        this.maxBalls = maxBalls;
        ballersQuota = quota;
        noOfBallers = quota.length;
    }

    /**
     * This function return the array containing the sequence of ballers
     * @return array of ballers' ball quota
     */
    public int[] ballsDistribution() {
        int[] distribution = new int[noOfBallers];
        int sum = 0;
        for (int i = 0; i < noOfBallers; i++) {
            
            /**
             * check if the already assigned ballers are enough for the max balls provided
             */
            if (sum < maxBalls) {
                if (i < noOfBallers - 1) {  // assign the least balls quota baller to the last position
                    distribution[i] = ballersQuota[0];
                }
                
                for (int j = 0; j < noOfBallers - i - 1; j++) { // bubble sort to get the highest no of balls available 
                    if (ballersQuota[j] > ballersQuota[j + 1]) {
                        int tmp = ballersQuota[j];
                        ballersQuota[j] = ballersQuota[j + 1];
                        ballersQuota[j + 1] = tmp;
                    }
                }
                distribution[i] = ballersQuota[noOfBallers - i - 1];
                sum += ballersQuota[noOfBallers - i - 1];
            } else {
                break;
            }
        }        
        return distribution;
    }
}
