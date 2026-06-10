package com.service;

import java.util.Collections;
import java.util.List;

public class SearchFormatter {
    
    public static void urutkanLagu(List<String> laguList) {
        Collections.sort(laguList);
    }

    public static void tampilkanTotal(List<String> laguList, String prefix) {
        System.out.println("\n-> Ditemukan " + laguList.size() + " rekomendasi lagu:");

    }
}
