import java.util.TreeMap;
import java.util.Random;

class Markov {

    private int counter = 1;

    // key: char immediately flow the patterm, value: its count
    private TreeMap<Character, Integer> counters = new TreeMap<>(); 
    private String pattern;

    public Markov (String pattern) {
        this.pattern = pattern;
    }

    public void add () {
        counter++;
    }

    public void add (char c) {
        counters.put(c, counters.getOrDefault(c, 0) + 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(counter + " " + pattern + ": ");
        for (char c: counters.keySet()) {
            sb.append(counters.get(c) + " " + c + " ");
        }
        return sb.toString();
    }

    public int getCounter() {
        return counter;
    }

    // generate a random character according to counters
    public char random() {
        int max = 0, min = 0;
        for (int count: counters.values()) max += count;
        Random r = new Random();
        int randval = r.nextInt(max - min + 1) + min;
        int curr = 0;
        char ch = counters.firstKey();
        for (char c: counters.keySet()) {
            ch = c;
            curr += counters.get(c);
            if (curr > randval) break;
        }

        return ch;
    } 
}