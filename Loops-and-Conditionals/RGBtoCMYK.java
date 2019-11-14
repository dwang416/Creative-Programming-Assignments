public class RGBtoCMYK {
    public static void main(String[] args) { 
        if (args.length != 3) {
            System.err.println("Number of arguments given is not 3");
            System.exit(1);
        }
        int r=0, g=0, b=0;
        try {
            r = Integer.parseInt(args[0]);
            g = Integer.parseInt(args[1]);
            b = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Arguments are not integers");
            System.exit(1);
        }

        if (r == g && g == b && b == 0){
            System.out.println("cyan\t = 0");
            System.out.println("magenta\t = 0");
            System.out.println("yellow\t = 0");
            System.out.println("black\t = 1");
        } else{
            double red = r, green = g, blue = b;
            double white = Math.max(Math.max(red/255, green/255), blue/255);
            double cyan = (white - red / 255) / white;
            double magenta = (white - green / 255) / white;
            double yellow = (white - blue / 255) / white;
            double black = (1 - white);
            System.out.printf("cyan\t = %f\n", cyan);
            System.out.printf("magenta\t = %f\n", magenta);
            System.out.printf("yellow\t = %f\n", yellow);
            System.out.printf("black\t = %f\n", black);
        }

        
    }
}