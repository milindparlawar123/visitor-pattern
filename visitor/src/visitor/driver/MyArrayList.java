package visitor.driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList implements Element {
	private static List<String> ls = new ArrayList<String>();

	public static class Builder {

		private FileProcessor fileProcessor;

		public Builder() {
			super();
		}

		public Builder withFileProcessor(FileProcessor fileProcessor) {
			// TODO Auto-generated method stub
			this.fileProcessor = fileProcessor;
			return this;
		}

		public Element build() {
			// TODO Auto-generated method stub

			try {
				String numberStr = null;
				while ((numberStr = this.fileProcessor.readSentence()) != "") {
					// System.out.println(numberStr.trim());
					ls.add(numberStr.trim());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new MyArrayList();
		}

	}

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

}
