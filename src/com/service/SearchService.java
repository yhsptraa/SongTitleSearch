package com.service;

import com.algoritm.DFS;
import com.model.TrieNode;
import com.trie.Trie;
import java.util.Collections;
import java.util.List;

public class SearchService {

    private final Trie trie;
    private final DFS dfs;

    public SearchService() {
        trie = new Trie();
        dfs = new DFS();
    }

    public void addSong(String title) {
        trie.insert(title);
    }

    public List<String> search(String prefix) {

        if (prefix == null || prefix.isBlank()) {
            return Collections.emptyList();
        }

        TrieNode node = trie.searchPrefix(prefix);

        if (node == null) {
            return Collections.emptyList();
        }

        List<String> results = dfs.collect(node);

        Collections.sort(results);

        return results;
    }
}