package visitor.driver;

/**
 * @author Milind. 
 * This class contains all constant which can be used across
 *         application
 */
public class Constants {

	public static final String ROUND_TO_TWO_DECIMAL = "%.2f";
	public static final String NEW_LINE = "\n";
	public static final String ERROR_OPENING_FILE = "exception occured while opening the file";
	public static final String ERROR_CLOSING_FILE = "exception occured while closing the file";
	public static final String ERROR_WRITING_FILE = "exception occured while writing to the file";
	public static final String ERROR_READING_FILE = "exception occured while reading the file";
	public static final String ERROR = "exception occured while processing input file";
	public static final String ERROR_EMPTY_FILE = " file is empty";
	public static final String ERROR_INVALID_NUMBER = "Invalid number in file";
	public static final String ERROR_INVALID_INPUT_FILE ="invalid input file or input file in incorrect location";
	public static final String ERROR_IN_REGISTER_OBSERVERS = "exception occured while registering observers";
	public static final String ERROR_INVALID_ARGUMENTS = "invalid argumnets ";
	public static final String ERROR_ALL_ARG_FILES_REQUIRED = "provide all 3 files: input.txt , availableItemsFile.txt , outputFile.txt and Running average window size.";
	public static final String ERROR_DUPLICATE_FILES = "two files should not be same";
	
	public static final String MSG_BASIC ="BASIC::";
	public static final String MSG_EXTRAVAGANT = "EXTRAVAGANT::";
	public static final String MSG_LUXURIOUS = "LUXURIOUS::";
	public static final String MSG_YES="--YES";
	public static final String MSG_NO="--NO";
	
	public static final String ERROR_RUNNING_AVERAGE_WINDOW_SIZE_VAL = "privide valid running Average Window Size";
	public static final String ERROR_RUNNING_AVERAGE_WINDOW_SIZE =  "running Average Window Size should be greater than 0";
	public static final String ERROR_CAPACITY = "privide valid capacity value";
	public static final String ERROR_CAPACITY_SIZE = "privide valid capacity size, greater than 0";
	public static final String ERROR_DEBUG = "privide valid debug value";
	public static final String ERROR_MONEY_VAL = "Money earned in input file should be integer";
	public static final String ERROR_MONEY = "Money earned in input file should be greater than 0";
	public static final String ERROR_LINE_FORMAT = "Line in the input file does not follow the specified formats- for ex: key:value ";
	
	public static final String ERROR_FILE_NAME = "provide valid file name ";
	
	public static final String ARG_0="${inputFile}";
	public static final String ARG_1="${availableItemsFile}";
	public static final String ARG_2="${runningAverageWindowSize}";
	public static final String ARG_3="${outputFile}";
	
	

}
