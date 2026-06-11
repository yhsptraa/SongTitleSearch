package com.gui;

import com.data.SongTitle;
import com.service.SearchService;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SongSearchGUI extends JFrame {

    private final SearchService service;

    private JTextField searchField;
    private DefaultListModel<String> model;
    private JList<String> suggestionList;
    private JLabel infoLabel;

    public SongSearchGUI() {

        service = new SearchService();

        for (String song : SongTitle.songs) {
            service.addSong(song);
        }

        initializeUI();
    }

    private void initializeUI() {

        setTitle("Song Title Search - Trie + DFS");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        searchField = new JTextField();

        model = new DefaultListModel<>();

        suggestionList = new JList<>(model);

        infoLabel = new JLabel("Mulai ketik judul lagu...");

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(
                new JLabel("Cari Lagu: "),
                BorderLayout.WEST
        );

        topPanel.add(
                searchField,
                BorderLayout.CENTER
        );

        add(topPanel, BorderLayout.NORTH);

        add(
                new JScrollPane(suggestionList),
                BorderLayout.CENTER
        );

        add(infoLabel, BorderLayout.SOUTH);

        searchField
                .getDocument()
                .addDocumentListener(
                        new DocumentListener() {

                            @Override
                            public void insertUpdate(DocumentEvent e) {
                                search();
                            }

                            @Override
                            public void removeUpdate(DocumentEvent e) {
                                search();
                            }

                            @Override
                            public void changedUpdate(DocumentEvent e) {
                                search();
                            }
                        }
                );

        setVisible(true);
    }

    private void search() {

        String keyword = searchField.getText().trim();

        model.clear();

        if (keyword.isEmpty()) {

            infoLabel.setText("Mulai ketik judul lagu...");

            return;
        }

        List<String> results = service.search(keyword);

        if (results.isEmpty()) {

            model.addElement("Lagu tidak ditemukan");

            infoLabel.setText(
                    "Tidak ditemukan lagu dengan prefix \"" +
                    keyword +
                    "\""
            );

            return;
        }

        for (String song : results) {
            model.addElement(song);
        }

        infoLabel.setText(
                "Ditemukan "
                        + results.size()
                        + " rekomendasi lagu"
        );
    }
}