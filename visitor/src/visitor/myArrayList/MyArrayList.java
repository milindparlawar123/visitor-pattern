package visitor.myArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import visitor.analyzer.Visitor;
import visitor.util.FileProcessor;
import visitor.myArrayList.Element;

/**
 * @author Milind
 * below class is to process input file and
 * store it in array list and returns 
 * MyArrayList object and accept method is to
 * call particular visitor to process further
 * 
 */
public class MyArrayList implements Element {
	private static List<String> ls = new ArrayList<String>();

	public static class Builder {

		private FileProcessor fileProcessor;

		public Builder() {
			super();
		}

		public Builder withFileProcessor(FileProcessor fileProcessor) {
			this.fileProcessor = fileProcessor;
			return this;
		}

		public Element build() {

			try {
				String numberStr = null;
				while ((numberStr = this.fileProcessor.readSentence()) != "") {
					// System.out.println(numberStr.trim());
					ls.add(numberStr.trim());
				}
				
				this.fileProcessor.fileClose();

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
			}
			return new MyArrayList();
		}

	}

	/**
	 *Accepts visitor to execute call of
	 *called visitor
	 */
	@Override
	public void accept(Visitor visitorIn) {
		// TODO Auto-generated method stub
		// System.out.println(ls);
		visitorIn.visit(this);

	}

	public static Iterator createIterator() {
		return ls.iterator();
	}

	public static List<String> getLs() {
		return ls;
	}

	public static void setLs(List<String> ls) {
		MyArrayList.ls = ls;
	}

	@Override
	public String toString() {
		return "MyArrayList []";
	}


}
