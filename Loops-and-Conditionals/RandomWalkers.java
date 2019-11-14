public class RandomWalkers{
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        
        double r;
        int x, y;
        int sum = 0;

        for (int j=0; j<t; j++) {
            x = 0;
            y = 0;
            for (int i=0; i<n; i++) {
                r = Math.random();          // 0.0 ~ 1.0
                if (r < 0.25) y++ ;         // north
                else if (r < 0.5) x++ ;     // east
                else if (r < 0.75) y-- ;    // south
                else x-- ;                  // west
            }
            sum = sum + x * x + y * y;
            
        }
        double res = (float)sum / t;
        System.out.printf("mean squared distance = %f", res);
    }
}