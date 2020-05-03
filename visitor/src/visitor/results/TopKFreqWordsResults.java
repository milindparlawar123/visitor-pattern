package visitor.results;

public class TopKFreqWordsResults implements Results {
	private String topKOutputFilename;
   
	public TopKFreqWordsResults(String topKOutputFilename) {
		super();
		this.topKOutputFilename = topKOutputFilename;
		
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		
	}

}
