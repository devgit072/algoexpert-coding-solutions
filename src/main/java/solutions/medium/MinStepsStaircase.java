package solutions.medium;

public class MinStepsStaircase {
    public int staircaseTraversal(int height, int maxSteps) {
        int[] memo = new int[height+1];
        memo[0] = 0;
        for(int i = 1;i<=height;i++) {
            memo[i] = -1;
        }
        staircaseTraversalUtil(height, maxSteps, memo);
        return memo[height];
    }
    public int staircaseTraversalUtil(int height, int maxSteps, int[] memo) {
        if(height == 0) {
            return 1;
        }
        if(height < 0) {
            return 0;
        }

        if(memo[height] != -1) {
            return memo[height];
        }
        int steps = 0;
        for(int i=1;i<=maxSteps;i++) {
            steps += (staircaseTraversalUtil(height - i, maxSteps, memo));
        }
        memo[height] = steps;
        return memo[height];
    }

    public static void main(String[] args) {
        MinStepsStaircase o = new MinStepsStaircase();
        o.staircaseTraversal(4, 2);
    }
}
