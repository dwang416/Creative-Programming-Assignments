import java.util.HashMap;

class TextGenerator {
    public static void main(String[] args) {
        String s = args[0];
        int k = Integer.parseInt(args[1]), m = Integer.parseInt(args[2]);

        TextGenerator textGenerator = new TextGenerator();
        String str = textGenerator.generate(s, k, m);
        System.out.println(str);
    }

    public String generate(String s, int k, int m) {
        LanguageModeler languageModeler = new LanguageModeler();
        HashMap<String, Markov> map = languageModeler.countFrequency(s, k);

        StringBuilder sb = new StringBuilder();
        // Start by printing the first K characters of the original text.
        sb.append(s.substring(0, k));
        int i = 0;

        while (i < m) {
            String pattern = sb.substring(i, i+k);
            Markov markov = map.get(pattern);
            sb.append(markov.random());
            i++;
        }

        return sb.toString();
    }
}