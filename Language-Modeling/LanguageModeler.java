import java.util.HashMap;
import java.util.ArrayList;

class LanguageModeler {
    public HashMap<String, Markov> countFrequency(String s, int k) {
        if (s.length() < k) return new HashMap<String, Markov>();
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

            if (i < s.length() - k) {
                markov.add(s.charAt(i + k));
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String s = args[0];
        int k = Integer.parseInt(args[1]);

        LanguageModeler languageModeler = new LanguageModeler();
        HashMap<String, Markov> map = languageModeler.countFrequency(s, k);
        ArrayList<Markov> list = new ArrayList<>(map.values());

        System.out.println(list.size() + " distinct keys");
        for (Markov markov: list) {
            System.out.println(markov);
        }
    }
}