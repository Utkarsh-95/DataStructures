/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    // Constructor
    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}
