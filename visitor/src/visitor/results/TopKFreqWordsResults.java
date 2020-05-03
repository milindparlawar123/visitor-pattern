package visitor.results;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import visitor.constants.Constants;

public class TopKFreqWordsResults implements Results {
	//private String topKOutputFilename;
	private List<List<String>> data = new ArrayList<List<String>>();
	private File file;
	private BufferedWriter fileWriter;
	public TopKFreqWordsResults(String topKOutputFilename) {
		super();
		//this.topKOutputFilename = topKOutputFilename;
		file = new File(topKOutputFilename);
		try {
			this.fileWriter = new BufferedWriter(new FileWriter(file));

		} catch (IOException e) {
			System.err.println(Constants.ERROR_OPENING_FILE);
			e.printStackTrace();
			System.exit(0);
		} finally {

		}
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		System.out.println(" write to file TopKFreqWordsResults ");
		for (List<String> ls : this.data) {
			try {
				this.fileWriter.write(ls.toString());
				this.fileWriter.write(Constants.NEW_LINE);
			} catch (IOException e) {
				System.err.println(Constants.ERROR_WRITING_FILE);
				e.printStackTrace();
				System.exit(0);
			} finally {
			}
		}
		this.close();
	}
	public void storeWords(List<String> ls) {
		
		this.data.add(ls);
		//this.a
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			this.fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
