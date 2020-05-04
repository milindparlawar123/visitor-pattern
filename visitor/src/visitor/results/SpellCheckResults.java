package visitor.results;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import visitor.constants.Constants;

public class SpellCheckResults implements Results {
	private Map<String, List> store;
	private File file;
	private BufferedWriter fileWriter;

	public SpellCheckResults(String spellCheckOutputFilename) {
		super();
		this.store = new LinkedHashMap<String, List>();
		file = new File(spellCheckOutputFilename);
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
		this.store.forEach((k, v) -> {
			try {
				this.fileWriter.write(k + " :: " + v);
				this.fileWriter.write(Constants.NEW_LINE);
			} catch (IOException e) {
				System.err.println(Constants.ERROR_WRITING_FILE);
				e.printStackTrace();
				System.exit(0);
			} finally {
			}
		});

		this.close();

	}

	public void storeWord(String key, List list) {

		this.store.put(key, list);
	}

	@Override
	public void close() {
		try {
			this.fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}

	}

	@Override
	public String toString() {
		return "SpellCheckResults [store=" + store + ", file=" + file + ", fileWriter=" + fileWriter + "]";
	}

}
