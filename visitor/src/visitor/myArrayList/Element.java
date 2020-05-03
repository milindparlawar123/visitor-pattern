package visitor.myArrayList;

import visitor.analyzer.Visitor;

public interface Element {

	void accept(Visitor visitor);
}
