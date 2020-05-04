package visitor.results;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import visitor.constants.Constants;

public class TopKFreqWordsResults implements Results {
	private List<List<String>> data = new ArrayList<List<String>>();
	private File file;
	private BufferedWriter fileWriter;

	public TopKFreqWordsResults(String topKOutputFilename) {
		super();
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

	}

	@Override
	public void close() {
		try {
			this.fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	@Override
	public String toString() {
		return "TopKFreqWordsResults [data=" + data + ", file=" + file + ", fileWriter=" + fileWriter + "]";
	}
	
}
