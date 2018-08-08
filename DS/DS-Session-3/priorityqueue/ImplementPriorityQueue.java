/**
 * This class provide implementation for priority queue by returning highest priority process
 * @author Rajendra Singh Rathore
 *
 */

package datastructure_3.priorityqueue;

public class ImplementPriorityQueue implements PriorityQueue {
    int[] priorityQueue;
    int rear;

    public ImplementPriorityQueue(int maxSize) {
        rear = -1;
        priorityQueue = new int[maxSize];
    }

    @Override
    public void addProcess(int priority) {
        priorityQueue[++rear] = priority;
    }

    /**
     * this function returns the current highest priority process from the queue
     * @return process index with current highest priority
     */
    @Override
    public int removeProcess() {
        int highestPriority = 0, index = 0;

        for (int i = 0; i < priorityQueue.length; i++) {
            if (priorityQueue[i] > highestPriority && priorityQueue[i] != -1) {
                highestPriority = priorityQueue[i];
                index = i;
            }
        }
        
        /**
         * return -1 if queue is empty
         */
        if (highestPriority == 0) {
            return -1;
        }
        
        priorityQueue[index] = -1;
        return highestPriority;
    }

}
