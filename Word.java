import java.util.Vector;

public class Word implements Comparable<Word> {

	private String theWord;
	private int theCount;
	
	public String toString() {
		return theWord+"  "+theCount;
	}

	public String getWord(){
		return theWord;
	}

	public int getCount(){
		return theCount;
	}

	public void inc(){
		theCount++;
	}
	
	public Word(String word, Integer count) {
		this.theWord = word;
		this.theCount = count;
	}

	/* compare to should return a positive number if this is greater
	 * than other, 0 if they are equal and a negative number if this is less.
	 * 
	 * this is greater (less than) if its count is greater (less than) that of 
	 * other.  If the counts are equal, you should determine which theWord is
	 * larger as a String.  compareTo is implemented in Java for Strings, you
	 * should use it
	 */
	public int compareTo(Word other) {
		if(this.theCount < other.getCount()){
			return -1;
		} else if(this.theCount > other.getCount()){
			return 1;
		} else{
			if(this.theWord.length() < other.getWord().length()) {
				return -1;
			} else if (this.theWord.length() > other.getWord().length()){
				return 1;
			} else {
				return this.theWord.compareTo(other.getWord());
			}
		}
	}

}
