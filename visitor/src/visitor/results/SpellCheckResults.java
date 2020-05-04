package visitor.results;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import visitor.constants.Constants;

/**
 * @author Milind
 * below class is store misspelled word and
 * its predicted words and write to output file
 * later
 */
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

	/**
	 *below method is to write data to output file
	 */
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

	/**
	 * @param key
	 * @param list
	 * below method is to store key and its value
	 * in data structure
	 */
	public void storeWord(String key, List list) {

		this.store.put(key, list);
	}

	/**
	 *below method is to close file
	 */
	@Override
	public void close() {
		try {
			this.fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			
		}

	}

	@Override
	public String toString() {
		return "SpellCheckResults [store=" + store + ", file=" + file + ", fileWriter=" + fileWriter + "]";
	}

}
