package com.algoritm;

import com.model.TrieNode;
import java.util.ArrayList;
import java.util.List;

public class DFS {

    private static final int LIMIT = 10;

    public List<String> collect(TrieNode node) {
        List<String> results = new ArrayList<>();
        dfs(node, results);
        return results;
    }

    private void dfs(
            TrieNode node,
            List<String> results
    ) {
        if (node == null) {
            return;
        }
        if (results.size() >= LIMIT) {
            return;
        }
        if (node.isEndOfWord) {
            results.add(node.songTitle);
        }
        for (TrieNode child : node.child.values()) {
            dfs(child, results);
        }
    }
}