package visitor.driver;

public class Driver {
	private static void runAnalysis(FileProcessor fileProcessor, Visitor... visitors) {

		Element myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

		System.out.println((MyArrayList) myArrayList);
		for (Visitor visitor : visitors) {
			myArrayList.accept(visitor);
		}
	}

	private static void persistResults(Results... analysisResults) {
		for (Results results : analysisResults) {
			results.writeToFile();
		}
	}

	public static void main(String[] args) {
		// TODO command-line args validation.
		// TODO command-line parsing and initialization of following variables.
		// 1. inputFilename.
		// 2. acceptableWordsFilename.
		// 3. k.
		// 4. topKOutputFilename.
		// 5. spellCheckOutputFilename.

		FileProcessor fileProcessor = null;
		try {
			fileProcessor = new FileProcessor("input.txt");
		} catch (Exception e) {
			// TODO: handle exception
		}

		Results topKFreqWordsResults = new TopKFreqWordsResults("topk_output.txt");
		Visitor topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(2, topKFreqWordsResults);

		Results spellCheckResults = new SpellCheckResults("spellcheck_output.txt");
		Visitor spellCheckAnalyzer = new SpellCheckAnalyzer("acceptable_words.txt", spellCheckResults);

		runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);

		persistResults(topKFreqWordsResults, spellCheckResults);
	}
}
