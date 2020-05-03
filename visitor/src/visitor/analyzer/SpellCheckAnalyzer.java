package visitor.analyzer;

import java.util.Iterator;

import visitor.myArrayList.Element;
import visitor.myArrayList.MyArrayList;
import visitor.results.Results;
import visitor.results.SpellCheckResults;
import visitor.myArrayList.Element;

public class SpellCheckAnalyzer implements Visitor {
	private String acceptableWordsFilename;
	private SpellCheckResults spellCheckResults;

	public SpellCheckAnalyzer(String string, Results spellCheckResults2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Element visitor) {
		//System.out.println((MyArrayList)visitor.);
		MyArrayList myArrayList= (MyArrayList)visitor;
		System.out.println("in SpellCheckAnalyzer");
		Iterator iterator= myArrayList.createIterator();
		while(iterator.hasNext())
		System.out.println(iterator.next());
		// TODO Auto-generated method stub
		
	}

}
