package com.trie;

import com.model.TrieNode;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String title) {
        TrieNode curr = root;
        String lowerTitle = title.toLowerCase();

        for (int i = 0; i < lowerTitle.length(); i++) {
            char c = lowerTitle.charAt(i);

            if (!curr.child.containsKey(c)) {
                curr.child.put(c, new TrieNode());
            }

            curr = curr.child.get(c);
        }

        curr.isEndOfWord = true;
        curr.songTitle = title;
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        String lowerPrefix = prefix.toLowerCase();

        for (int i = 0; i < lowerPrefix.length(); i++) {
            char c = lowerPrefix.charAt(i);

            if (!curr.child.containsKey(c)) {
                return null;
            }

            curr = curr.child.get(c);
        }

        return curr;
    }

    public TrieNode getRoot() {
        return root;
    }
}
