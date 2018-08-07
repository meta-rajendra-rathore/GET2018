package datastructure_3.lowestruns;

public class LowestRuns {
    int maxBalls;
    int noOfBallers;
    int[] ballersQuota;

    public LowestRuns(int maxBalls, int[] quota) {
        this.maxBalls = maxBalls;
        ballersQuota = quota;
        noOfBallers = quota.length;
    }

    public int[] ballsDistribution() {
        int[] distribution = new int[noOfBallers];
        int sum = 0;
        for (int i = 0; i < noOfBallers - 1; i++) {
            if (sum < maxBalls) {
                for (int j = i + 1; j < noOfBallers - i; j++) { 
                    if (ballersQuota[i] > ballersQuota[j]) {
                        int tmp = ballersQuota[i];
                        ballersQuota[i] = ballersQuota[j];
                        ballersQuota[j] = tmp;
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
