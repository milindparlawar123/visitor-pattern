package visitor.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import visitor.myArrayList.Element;
import visitor.myArrayList.MyArrayList;
import visitor.results.Results;
import visitor.util.FileProcessor;

public class SpellCheckAnalyzer implements Visitor {
	//private String acceptableWordsFilename;
	private Results spellCheckResults;
	private FileProcessor fileProcessor;
	private List<String> acceptableWords;

	public SpellCheckAnalyzer(String fName, Results spellCheckResults) {

		// TODO Auto-generated method stub
		this.fileProcessor = new FileProcessor(fName);
		this.spellCheckResults=spellCheckResults;
		this.acceptableWords= new ArrayList<String>();
		try {
			String numberStr = null;
			while ((numberStr = this.fileProcessor.readSentence()) != "") {
				// System.out.println(numberStr.trim());
				acceptableWords.add(numberStr.trim());
			}
			this.fileProcessor.fileClose();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return new MyArrayList();

	}

	@Override
	public void visit(Element visitor) {
		// System.out.println((MyArrayList)visitor.);
		MyArrayList myArrayList = (MyArrayList) visitor;
		System.out.println("in SpellCheckAnalyzer");

		Iterator iterator = myArrayList.createIterator();
		while (iterator.hasNext()) {
			String sentence= (String) iterator.next();
			String[] words= sentence.split(" ");
			for(String word: words) {
				if(word.length()>2) {
					for(String acptWord: acceptableWords) {
					
					}
				}
			}
			//System.out.println(iterator.next());
			System.out.println("...");
		}
		System.out.println("end");
		System.out.println(this.acceptableWords);
		// TODO Auto-generated method stub

	}

}
