package visitor.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import visitor.myArrayList.Element;
import visitor.myArrayList.MyArrayList;
import visitor.results.Results;
import visitor.results.SpellCheckResults;
import visitor.util.FileProcessor;

/**
 * @author Milind
 * below class is for -  a sentence, check whether there is a 
 * spelling mistake in any of the constituent words
 * if yes, then store that word and its predicted words
 * in data structure  
 */
public class SpellCheckAnalyzer implements Visitor {
	private Results spellCheckResults;
	private FileProcessor fileProcessor;
	private List<String> acceptableWords;

	public SpellCheckAnalyzer(String fName, Results spellCheckResults) {

		this.fileProcessor = new FileProcessor(fName);
		this.spellCheckResults = spellCheckResults;
		this.acceptableWords = new ArrayList<String>();
		try {
			String numberStr = null;
			while ((numberStr = this.fileProcessor.readLine()) != null) {
				this.acceptableWords.add(numberStr.trim());
			}
			this.fileProcessor.fileClose();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}

	/**
	 * check is there any spelling mistake in
	 * words and if yes then call spellCheckResults
	 * to store word and its predicted words
	 */
	@Override
	public void visit(Element visitor) {

		MyArrayList myArrayList = (MyArrayList) visitor;
		SpellCheckResults spellCheckResults = (SpellCheckResults) this.spellCheckResults;
		Iterator iterator = myArrayList.createIterator();
		while (iterator.hasNext()) {
			String sentence = (String) iterator.next();
			String[] words = sentence.split(" ");
			for (String word : words) {
				List<String> ls = new ArrayList<String>();
				if (word.length() > 2) {
					for (String acptWord : this.acceptableWords) {
						int count = 0;
						if (word.length() == acptWord.length()) {

							for (int i = 0; i < word.length(); i++) {
								if (word.charAt(i) != acptWord.charAt(i)) {
									count++;
								}
							}
						}
						if (count == 1) {
							ls.add(acptWord);
						}

					}
				}
				if (ls.size() > 0) {
					spellCheckResults.storeWord(word, ls);
					//System.out.println(word + " :: " + ls);
				}
			}
		}

	}

	@Override
	public String toString() {
		return "SpellCheckAnalyzer [spellCheckResults=" + spellCheckResults + ", fileProcessor=" + fileProcessor
				+ ", acceptableWords=" + acceptableWords + "]";
	}

}
