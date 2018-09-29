
//Structure and some method headers provided by prof. John Rager

import java.util.Vector;

public class TrieNode {

	private Word wordHere;

	private TrieNode[] links;

	public TrieNode() {
		wordHere = null;
		links= new TrieNode[26];
	}

	private int let(char c) {
		return c - 'a';
	}

	private char firstChar(String key) { 
		return key.charAt(0);
	}
	
	private String rest(String key) {
		return key.substring(1,key.length());
	}
	
	private TrieNode linkWordStart(String start) {
		return links[let(firstChar(start))];
	}
	//Returns the TrieNode in the arrayspace correspoding to the first char value of the String 'start'
	

	public void insert(String key,String toHere) {
		if(key.length() != 0){
			toHere = toHere + firstChar(key);
			if(linkWordStart(key) == null){
				links[let(firstChar(key))] = new TrieNode();
				linkWordStart(key).insert(rest(key), toHere);
			} else {
				linkWordStart(key).insert(rest(key), toHere);
			}
		} else {
			if(wordHere == null){
				wordHere = new Word(toHere, 1);
			} else {
				wordHere.inc();
			}
		}
	}

	public boolean anyKids(){
		boolean toRet = false;
		for(int i = 0; i<this.links.length; i++){
			if(links[i] != null) toRet = true;
		}
		return toRet;
	}

	
	public Word find(String key) {
		if (key.length() == 0) {
			if (wordHere==null)
				return null;
			else return wordHere;
		}
		else {
			if (linkWordStart(key) == null)
				return null;
			else return linkWordStart(key).find(rest(key));
		}		
	}

	public void allKeyValue(Vector v) {
		if (wordHere != null) v.add(wordHere);
		for (int i =0; i<26; i++) {
			if (links[i]!=null){
				links[i].allKeyValue(v);
			}
		}
	}

	public void spellCheck1(Vector v, String start) {
		if(linkWordStart(start) != null){
			linkWordStart(start).spellCheck1(v, rest(start));
		} else {
			allKeyValue(v); 
		}
	}

	public Vector<Word> prefixMatch(Vector v, String start) {
		Vector<Word> w = v;
		if(start.length() != 0){
			if(linkWordStart(start) != null){
				return linkWordStart(start).prefixMatch(v, rest(start));
			} else {
				Word s = new Word("No Words", 1);
				w.add(s);
				System.out.println("Here4");
				return w;
			}
		}else{
			this.allKeyValue(w);
			return w;
		}
	}

	public void spellCheck2(Vector ws, String key, int errs) {	
		if(errs > 0){
			if(wordHere != null && key.length()==0){
				ws.add(wordHere);
			} else {
				for(int i = 0; i < 26; i++){
					if(links[i] != null){
						if(key.length() != 0){
							if(links[i] == linkWordStart(key)){
								links[i].spellCheck2(ws, rest(key), errs);
							}else{
								links[i].spellCheck2(ws, rest(key), errs-1);
							}
						}
					}
				}
			}
		}
	}

	/*
	No predefined method header

	Adds all dictionary words with the given string to the given vector
	*/
	
	public void matchString(Vector w, String match){
		if(match.length() == 0){
			allKeyValue(w);
		}else{
			for(int i = 0; i < 26; i++){
				if(links[i] != null){
					if(links[i] == linkWordStart(match)){
						links[i].matchString(w, rest(match));
					} else {
						links[i].matchString(w, match);
					}
				}
			}
		}
	}

	/*
	No predefined method header

	Adds all words with x amount of characters to the given vector
	*/
	public void xLetterWords(Vector w, int x){
		if(x >= 0){
			if(wordHere != null && x == 0){
				w.add(wordHere);
			} else {
				for(int i = 0; i < 26; i++){
					if(links[i] != null){
						links[i].xLetterWords(w, x-1);
					}
				}
			}
		}
	}
	

	public void print(String string) {
		if (wordHere != null)
			System.out.println(string+" "+wordHere);
		else System.out.println(string+" empty");
		for (int i =0; i<26; i++) {
			if (links[i]!=null){
				links[i].print(string+"-");
			}
		}
	}

	public boolean delete(String key) {
		if(key.length() == 0){
			if(wordHere != null){
				wordHere = null;
				return true;
			} else {
				for(int i = 0; i<26; i++){
					if(links[i] != null){
						if(links[i].anyKids() != true){
							links[i] = null;
						}
					}
				}
				return false;
			}
		} else {
			if(linkWordStart(key) == null){
				return false;
			} else {
				return linkWordStart(key).delete(rest(key));
			}
		}
	}
}


