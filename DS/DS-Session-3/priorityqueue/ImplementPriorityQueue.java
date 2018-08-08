package datastructure_3.priorityqueue;

public class ImplementPriorityQueue implements PriorityQueue {
    int[] priorityQueue;

    public ImplementPriorityQueue(int[] inputArray) {
        priorityQueue = inputArray;
    }

    @Override
    public void addProcess(int priority) {

    }

    @Override
    public int removeProcess() {
        int least = 0, leastIndex = 0;
        if (priorityQueue.length > 0) {
            least = priorityQueue[0];
            leastIndex = 0;
        }

        for (int i = 1; i < priorityQueue.length; i++) {
            if (priorityQueue[i] <= least && priorityQueue[i] != -1) {
                least = priorityQueue[i];
                leastIndex = i;
            }
        }
        
        priorityQueue[leastIndex] = -1;
        return leastIndex + 1;
    }

}
