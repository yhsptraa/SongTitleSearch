package com.service;

import com.algoritm.DFS;
import com.model.TrieNode;
import com.trie.Trie;
import java.util.List;

public class SearchService {
    private Trie trie;
    private DFS dfs;

    public SearchService() {
        this.trie = new Trie();
        this.dfs = new DFS();
    }

    public void addSong(String title) {
        trie.insert(title);
    }

    public List<String> search(String prefix) {
        TrieNode prefixNode = trie.searchPrefix(prefix);
        return dfs.collect(prefixNode);
    }
}
