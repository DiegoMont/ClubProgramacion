class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(!trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(!trie.startsWith("z"));
        trie.insert("z");
        System.out.println(trie.search("z"));
    }

    private Trie[] letters;
    private boolean isWordLastLetter;

    public Trie() {
        this.letters = new Trie[26];
        this.isWordLastLetter = false;
    }

    public void insert(String word) {
        this.insert(word, 0);
    }

    private void insert(String word, int start) {
        if (start == word.length()) {
            this.isWordLastLetter = true;
            return;
        }
        char letter = word.charAt(start);
        int charIndex = letter - 97;
        if (this.letters[charIndex] == null)
            this.letters[charIndex] = new Trie();
        this.letters[charIndex].insert(word, start+1);
    }

    public boolean search(String word) {
        return this.search(word, 0);
    }

    private boolean search(String word, int i) {
        if (i == word.length())
            return this.isWordLastLetter;
        char letter = word.charAt(i);
        int charIndex = letter - 97;
        if (this.letters[charIndex] == null)
            return false;
        else
            return this.letters[charIndex].search(word, i+1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    public boolean startsWith(String prefix, int i) {
        if (i == prefix.length())
            return true;
        char letter = prefix.charAt(i);
        int charIndex = letter - 97;
        if (this.letters[charIndex] == null)
            return false;
        else
            return this.letters[charIndex].startsWith(prefix, i+1);
    }
}
