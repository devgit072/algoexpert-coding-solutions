package solutions.medium;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieImpl {

    static class TrieNode {
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }

        TrieNode(Map<Character, TrieNode> node) {
            children = node;
        }
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            int currentIndex = str.length() - 1;
            while (currentIndex >= 0) {
                char ch = str.charAt(currentIndex);
                String subStringAfterCurrentChar = str.substring(currentIndex + 1);
                TrieNode trieNode = null;
                if (subStringAfterCurrentChar.isEmpty()) {
                    trieNode = getTrieForEmptyStr();
                } else {
                    Map<Character, TrieNode> mapOfCurrentChar = new HashMap<>();
                    if (root.children.containsKey(ch)) {
                        Map<Character, TrieNode> m = root.children.get(ch).children;
                        for (Map.Entry<Character, TrieNode> entry : m.entrySet()) {
                            mapOfCurrentChar.put(entry.getKey(), entry.getValue());
                        }
                    }
                    char chOfSubString = subStringAfterCurrentChar.charAt(0);
                    TrieNode internalNode = root.children.get(chOfSubString);
                    mapOfCurrentChar.put(chOfSubString, internalNode);
                    trieNode = new TrieNode(mapOfCurrentChar);
                }
                root.children.put(ch, trieNode);
                currentIndex--;
            }
        }

        public TrieNode getTrieForEmptyStr() {
            Map<Character, TrieNode> map = new HashMap<>();
            map.put('*', null);
            return new TrieNode(map);
        }

        public boolean contains(String str) {
            int currentIndex = 0;
            TrieNode currentNode = root;
            while (currentIndex <= str.length() - 1) {
                char currentChar = str.charAt(currentIndex);
                if (!currentNode.children.containsKey(currentChar)) {
                    return false;
                }
                currentNode = currentNode.children.get(currentChar);
                currentIndex++;
            }
            return currentNode.children.containsKey('*');
        }
    }

    public static void main(String[] args) {
        SuffixTrie obj = new SuffixTrie("invisible");
        System.out.println(obj.contains("abc"));
    }
}
