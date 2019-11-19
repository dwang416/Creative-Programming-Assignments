import java.util.HashMap;
import java.util.ArrayList;

class FrequencyCounter {
    public ArrayList<Markov> countFrequency(String s, int k) {
        if (s.length() < k) return new ArrayList<Markov>();
        HashMap<String, Markov> map = new HashMap<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String pattern = s.substring(i, i+k);
            Markov markov;
            if (map.containsKey(pattern)) {
                markov = map.get(pattern);
                markov.add();
            } else {
                markov = new Markov(pattern);
                map.put(pattern, markov);
            }
        }

        ArrayList<Markov> res = new ArrayList<>(map.values());
        return res;
    }

    public static void main(String[] args) {
        String s = args[0];
        int k = Integer.parseInt(args[1]);

        FrequencyCounter frequencyCounter = new FrequencyCounter();
        ArrayList<Markov> list = frequencyCounter.countFrequency(s, k);

        System.out.println(list.size() + " distinct keys");
        for (Markov markov: list) {
            System.out.println(markov);
        }
    }
}