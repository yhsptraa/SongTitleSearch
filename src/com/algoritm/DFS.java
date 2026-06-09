package com.algoritm;

import com.model.TrieNode;
import java.util.ArrayList;
import java.util.List;

public class DFS {

    public List<String> collect(TrieNode node) {
        List<String> results = new ArrayList<>();
        dfs(node, results);
        return results;
    }

    private void dfs(TrieNode node, List<String> results) {
        if (node == null) return;

        if (node.isEndOfWord) {
            results.add(node.songTitle);
        }

        for (TrieNode child : node.child.values()) {
            dfs(child, results);
        }
    }
}
