package trie;

public class TrieMain {

    public static void main(String[] args) {

        System.out.println("Trie Data structure implementation");
        TrieFullImpl trie = new TrieFullImpl();

        trie.insert("h");
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("get");
        trie.insert("getting");
        trie.insert("geek");
        trie.insert("garden");
        trie.insert("hill");
        trie.insert("hilltop");
        trie.insert("geekook");
        trie.insert("geekchut");

        trie.print();

        trie.wordCount("hello");
//        trie.insert("hello");
//        trie.wordCount("hello");
//
//        trie.autoSuggestQuery("h");
//        trie.autoSuggestQuery("g");
//        trie.autoSuggestQuery("gt");
//
//        trie.query("hill");
//        trie.query("hell");
//        trie.query("helloo");
//
//        trie.delete("get");
//        trie.wordCount("get");
//        trie.print();
//
//        trie.insert("get");
//        trie.delete("getting");
//        trie.wordCount("get");
//        trie.wordCount("getting");
//        trie.print();
//
//        trie.delete("get");
//        trie.print();
//        trie.delete("getting");
//        trie.print();
//
//        trie.query("get");
//
//        trie.update("geekook", "geeksforgeeks");
//
//        trie.print();
//
//        //...........case 1
////        trie.delete("hill");
////        trie.print();
////        trie.autoSuggestQuery("h");
////        
////        trie.delete("hilltop");
////        trie.print();
////        trie.autoSuggestQuery("h");
//        //...........case 1
//        //...........case 2
//        trie.delete("hilltop");
//        trie.print();
//        trie.autoSuggestQuery("h");
//
//        trie.delete("hill");
//        trie.print();
//        trie.autoSuggestQuery("h");
//        //...........case 2
//
//        trie.query("hillt");
//
//        trie.autoSuggestQuery("g");
        System.out.println("------------------------------------------------------------------------------------------");
        Trie t = new Trie();
        //Testing
        //CASE#1
        t.insert("bcde");
        t.insert("bckg");
        t.delete("bcde");
        t.search("bcde");
        t.search("bckg");

        /*//CASE#2
		t.insert("bcde");
		t.insert("bcdefg");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcdefg");*/
 /*//CASE#3
		t.insert("bcde");
		t.insert("bc");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcde");
		t.search("bc");
		t.search("b");*/
 /*//CASE#4
		t.insert("bcde");
		t.delete("bcde");
		t.search("bcde");*/
    }

}
