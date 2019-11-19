run: java TextGenerator s k m
where s is the given string ("training data"), k is the length of pattern (k-order markov), m is the length of generated text.
The program will print the first k characters of s, then print m characters predicted sequentially by k-order markov model.

Example:
java TextGenerator agggcagcgggcg 2 5