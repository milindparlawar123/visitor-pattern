package visitor.results;

public class SpellCheckResults implements Results {
	private String spellCheckOutputFilename;

	public SpellCheckResults(String spellCheckOutputFilename) {
		super();
		this.spellCheckOutputFilename = spellCheckOutputFilename;
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		
	}

}
