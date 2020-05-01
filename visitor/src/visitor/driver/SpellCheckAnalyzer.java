package visitor.driver;

import java.util.Iterator;

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
