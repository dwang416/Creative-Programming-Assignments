public class EditDistance {
    public static void main(String[] args) {
        String x = args[0];
        String y = args[1];

        EditDistance editDistance = new EditDistance();
        int[][] dp = editDistance.distance(x, y);

        System.out.println("Distance is: " + dp[0][0]);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j< dp[0].length; j++) {
                System.out.printf(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // output the entire dp array
    public int[][] distance(String x, String y) {
        int[][] dp = new int[x.length()+1][y.length()+1];

        for (int i = 0; i <= x.length(); i++) {
            dp[i][y.length()] = 2 * (x.length() - i);
        }

        for (int j = 0; j <= y.length(); j++) {
            dp[x.length()][j] = 2 * (y.length() - j);
        }

        for (int i = x.length()-1; i >=0; i--) {
            for (int j = y.length()-1; j >= 0; j--) {
                int gap = Math.min(dp[i+1][j], dp[i][j+1]) + 2;
                int xy = (x.charAt(i) == y.charAt(j)) ? 0 : 1;
                dp[i][j] = Math.min(xy + dp[i+1][j+1], gap);
            }
        }

        return dp;
    }
}