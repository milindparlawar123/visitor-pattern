package visitor.driver;

import visitor.analyzer.SpellCheckAnalyzer;
import visitor.analyzer.TopKMostFreqAnalyzer;
import visitor.analyzer.Visitor;
import visitor.myArrayList.Element;
import visitor.myArrayList.MyArrayList;
import visitor.results.Results;
import visitor.results.SpellCheckResults;
import visitor.results.TopKFreqWordsResults;
import visitor.util.FileProcessor;
import visitor.validator.DriverValidator;

public class Driver {
	private static void runAnalysis(FileProcessor fileProcessor, Visitor... visitors) {

		Element myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

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

		try {
			new DriverValidator(args.length, args);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.exit(0);
		} finally {

		}

		FileProcessor fileProcessor = null;
		try {
			fileProcessor = new FileProcessor(args[0]);// "input.txt"
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {

		}

		Results topKFreqWordsResults = new TopKFreqWordsResults(args[3]);// "topk_output.txt"
		Visitor topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(Integer.parseInt(args[2]), topKFreqWordsResults);

		Results spellCheckResults = new SpellCheckResults(args[4]);// "spellcheck_output.txt"
		Visitor spellCheckAnalyzer = new SpellCheckAnalyzer(args[1], spellCheckResults);// "acceptable_words.txt"

		runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);

		persistResults(topKFreqWordsResults, spellCheckResults);
	}
}
