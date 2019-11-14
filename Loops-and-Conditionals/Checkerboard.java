public class Checkerboard {
    public static void main (String[] args){
        int n = Integer.parseInt(args[0]);
        for (int i=0; i<n; i++) {
            if (i % 2 == 1) System.out.printf(" ");
            for (int j=0; j<2*n; j++) {
                if (j % 2 == 0) System.out.printf("*");
                else System.out.printf(" ");
            }
            System.out.printf("\n");
        }
    }
}