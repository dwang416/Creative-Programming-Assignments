public class Ordered {
    public static void main(String[] args) { 
        if (args.length != 3) {
            System.err.println("Number of arguments given is not 3");
            System.exit(1);
        }
        int x=0, y=0, z=0;
        try {
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
            z = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Arguments are not integers");
            System.exit(1);
        }
        boolean isOrdered = ((x > y && y > z) || (x < y && y < z)) ? true : false;
        System.out.println(isOrdered);
    }
}