package com.model;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> child;
    public boolean isEndOfWord;
    public String songTitle;

    public TrieNode() {
        this.child = new HashMap<>();
        this.isEndOfWord = false;
        this.songTitle = null;
    }
}
