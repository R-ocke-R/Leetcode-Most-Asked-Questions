class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    TrieNode(){
        isEnd = false;
        children = new TrieNode[26];
    }
}

class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children[c-'a']== null){
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isEnd = true;
    }
    public String shortestRoot(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) {
                // word not present
                return word;
            }
            current = current.children[c-'a'];
            if(current.isEnd) {
                // reached the smallest prefix's end
                return word.substring(0, i+1);
            }
        }
        return word;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String wordArray[] = sentence.split(" ");

        Trie dictTrie = new Trie();
        for(String word : dictionary){
            dictTrie.insert(word);
        }

        for(int word = 0; word < wordArray.length; word++){
            wordArray[word] = dictTrie.shortestRoot(wordArray[word]);
        }
        return String.join(" ", wordArray);
    }
}