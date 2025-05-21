package com.pautib;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * An inverted index is a data structure that maps terms, such as, words to the documents
 * where they appear.
 * Assumes that String terms are mapped to documents that are also Strings
 * Assumes word casing does not matter
 */
public class InvertedIndex {

    private Map<String, Set<String>> map;

    public InvertedIndex() {
        map = new ConcurrentHashMap<>();
    }

    // Inserts a document into the index
    public void insertDoc(String doc) {
        String[] words = doc.toLowerCase().split("\\W+");
        for (String word : words){
            map.computeIfAbsent(word, _ -> ConcurrentHashMap.newKeySet()).add(doc);
        }
    }

    // Search documents containing a single term
    public List<String> search(String term) {
        Set<String> result = map.getOrDefault(term.toLowerCase(), ConcurrentHashMap.newKeySet());
        return new ArrayList<>(result);
    }

    // Delete a document from the index. Let's also delete the keys with empty Set values at the end
    public void delete(String doc) {
        for (Set<String> stringSet : map.values()) {
            stringSet.remove(doc);
        }
        map.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    // Search for documents containing two terms
    public List<String> andSearch(String term1, String term2) {
        Set<String> search1 = new HashSet<>(map.getOrDefault(term1.toLowerCase(), Set.of()));
        Set<String> search2 = map.getOrDefault(term2.toLowerCase(), Set.of());
        search1.retainAll(search2);
        return new ArrayList<>(search1);
    }

    // Search for documents containing one term or the other
    public List<String> orSearch(String term1, String term2) {
        Set<String> search1 = new HashSet<>(map.getOrDefault(term1.toLowerCase(), Set.of()));
        Set<String> search2 = map.getOrDefault(term2.toLowerCase(), Set.of());
        search1.addAll(search2);
        return new ArrayList<>(search1);
    }

    // Notes: We have to use new HashSet<> to wrap the search1 set in andSearch/onSearch methods
    // because with map.getOrDefault() we are retrieving the actual set inside the map and we don't
    // want to modify that value

}
