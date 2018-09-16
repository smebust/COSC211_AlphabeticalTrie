import java.util.Vector;

public class Trie implements CS211CountingDictionaryInterface {

	TrieNode root = new TrieNode();
	
	public void insert(String key) {
		root.insert(key,"");
	}

	public boolean delete(String key) { 
		if (root.find(key)==null)
			return false;
		else root.delete(key);
		return true;
	}

	public int find(String key) {
		if (root == null) 
			return -1;
		else {
			Word w = root.find(key);
			if (w==null)
				return -1;
			else return w.getCount();
		}
	}
	
	public Vector<Word> prefixMatch(String start) {
		Vector v = new Vector<Word>();
		v = root.prefixMatch(v,start);
		return v;
	}
	
	public Vector<Word> spellCheck1(String start) {
		Vector v = new Vector<Word>();
		root.spellCheck1(v,start);
		return v;
	}

	@Override
	public Vector<Word> allKeyValue() {
		Vector v = new Vector<Word>();
		root.allKeyValue(v);
		return v;
	}

	public Vector<Word> spellCheck2(String key, int errs) {
		Vector ws = new Vector<Word>();
		root.spellCheck2(ws,key,errs+1);
		return ws;
	}
	
	//returns all dictionary words X letters long
	public Vector<Word> xLetterWords(int x) {
		Vector ws = new Vector<Word>();
		root.xLetterWords(ws,x);
		return ws;
	}

	//returns all dictionary words containing the given string
	public Vector<Word> matchString(String match) {
		Vector ws = new Vector<Word>();
		root.matchString(ws,match);
		return ws;
	}

	public void print() {
		root.print("");
	}
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("hello");
		t.insert("why");;
		t.insert("hellor");
		t.insert("hello");
		t.insert("mezzo");
		t.insert("mezza");
		t.insert("a");
		t.insert("he");
		t.insert("him");
		t.insert("zen");
		t.insert("new");
		t.insert("not");
		t.insert("caw");
		t.insert("cow");
		t.insert("cry");
		t.insert("gawp");
		t.insert("yawp");


		t.print();
		
		System.out.println(t.find("hello"));
		System.out.println(t.find("hellor"));
		System.out.println(t.find("why"));
		
		System.out.println("All Key Value");
		Vector<Word> ws = t.allKeyValue();
		for (Word w: ws) {
			System.out.println("WS "+w);
		}
		
		System.out.println("Prefix Match");
		ws = t.prefixMatch("hel");
		for (Word w: ws) {
			System.out.println("SS "+w);
		}
		
		System.out.println("Spell Check 1");
		ws = t.spellCheck1("hazzo");
		for (Word w: ws) {
			System.out.println("ST "+w);
		}
		
		System.out.println("Spell Check 2");
		ws = t.spellCheck2("zqwp",2);
		for (Word w: ws) {
			System.out.println("EM "+w);
		}
		
		System.out.println(t.delete("why"));
		t.print(); 

		System.out.println("X Letter Words");
		ws = t.xLetterWords(3);
		for (Word w: ws) {
			System.out.println("XL "+w);
		}

		System.out.println("String Match");
		ws = t.matchString("a");
		for (Word w: ws) {
			System.out.println("SM "+w);
		}
		
	}
	

}
