package com.h.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *https://www.techiedelight.com/find-maximum-occurring-word-given-set-strings/
 * Find the maximum occurring word in a given set of strings
Input:
keys = [code, coder, coding, codable, codec, codecs, coded, codeless, codec, codecs, codependence, codex, codify, 
codependents, codes, code, coder, codesign, codec, codeveloper, codrive, codec, codecs, codiscovered]
 
Output:
The maximum occurring word is codec.
Its count is 4
 * */

class TrieNode {
	// `count` and `key` is only set for leaf nodes
	// `key` stores the string, and `count` stores its frequency so far
	String key;
	int count;

	// each node stores a map to its child nodes
	Map<Character, TrieNode> character = null;

	TrieNode() {
		character = new HashMap<>();
	}
}

public class MaxOccurring {
	// Iterative function to insert a string into a Trie
	public static void insert(TrieNode head, String str) {
		// start from the root node
		TrieNode curr = head;

		for (char c : str.toCharArray()) {
			// create a new node if the path doesn't exist
			curr.character.putIfAbsent(c, new TrieNode());

			// go to the next node
			curr = curr.character.get(c);
		}

		// store key and its count in leaf nodes
		curr.key = str;
		curr.count += 1;
	}

	// Function to perform preorder traversal on a Trie and find a word with the
	// maximum frequency
	public static int preorder(TrieNode curr, int maxCount, StringBuilder key) {
		// return false if Trie is empty
		if (curr == null) {
			return maxCount;
		}

		for (Map.Entry<Character, TrieNode> entry : curr.character.entrySet()) {
			// leaf nodes have a non-zero count
			if (maxCount < entry.getValue().count) {
				key.replace(0, key.length(), entry.getValue().key);
				maxCount = entry.getValue().count;
			}

			// recur for current node's children
			maxCount = preorder(entry.getValue(), maxCount, key);
		}

		return maxCount;
	}

	public static void main(String[] args) {
		// given set of keys
		List<String> dict = Arrays.asList("code", "coder", "coding", "codable", "codec", "codecs", "coded", "codeless",
				"codec", "codecs", "codependence", "codex", "codify", "codependents", "codes", "code", "coder",
				"codesign", "codec", "codeveloper", "codrive", "codec", "codecs", "codiscovered");

		// Insert all keys into a Trie
		TrieNode head = new TrieNode();
		for (String word : dict) {
			insert(head, word);
		}

		int count = 0;
		StringBuilder key = new StringBuilder();

		// perform preorder traversal on a Trie and find the key
		// with maximum frequency
		count = preorder(head, count, key);

		System.out.println("Word : " + key);
		System.out.println("Count: " + count);
	}
}