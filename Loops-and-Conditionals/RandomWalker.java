public class RandomWalker{
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        int x = 0, y = 0;
        double r;
        for (int i=0; i<n; i++) {
            r = Math.random();          // 0.0 ~ 1.0
            if (r < 0.25) y++ ;         // north
            else if (r < 0.5) x++ ;     // east
            else if (r < 0.75) y-- ;    // south
            else x-- ;                  // west
            System.out.printf( "(%d, %d)\n", x, y);
        }
        System.out.printf("squared distance = %d", x * x + y * y);
    }
}