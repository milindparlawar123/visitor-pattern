package visitor.results;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SpellCheckResults implements Results {
	private String spellCheckOutputFilename;
	private Map<String, List>  store;
	public SpellCheckResults(String spellCheckOutputFilename) {
		super();
		this.spellCheckOutputFilename = spellCheckOutputFilename;
		this.store=store= new LinkedHashMap<String, List>();
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		System.out.println(" write to file ");
		System.out.println(this.store);
		
	}
	
	public void storeWord(String key, List list) {
		
		this.store.put(key, list);
		//this.a
	}

}
