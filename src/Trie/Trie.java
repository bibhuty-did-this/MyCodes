package Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie{

	static class Node{
		int terminating;
		final Node[] nodes=new Node[26];

		public Node next(final char c){
			return nodes[c-'a'];
		}


	}

	final static Node start=new Node();

	public int query(String s){
		return 0;
	}

	public static void main(String[] args){
		List<String> setOfStrings=new ArrayList<>();
		setOfStrings.add("pqrs");
		setOfStrings.add("pprt");
		setOfStrings.add("psst");
		setOfStrings.add("qqrs");
		setOfStrings.add("pqrs");
	}
}
