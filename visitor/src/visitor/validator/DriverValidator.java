package visitor.validator;

import java.util.Arrays;

import visitor.constants.Constants;

/**
 * @author Milind below class is to validate arguments provided to driver class
 */
public class DriverValidator {
	private int argsLength;
	private String args[];

	private static class ValidatorFetcher {

		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether there are 5 arguments present or not.
		 *         if not it will throw error else will return to calling method
		 */
		public static Validator argsLengthValidator(DriverValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (d.getArgsLength() != 5) {
						throw new Exception(Constants.ERROR_INVALID_ARGUMENTS);
					}
				}
			};
		}

		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether all inputs file provided or not and it
		 *         will also check that 4 files path and names are not same
		 */
		public static Validator argsValidator(DriverValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if ((d.getArgs()[0].equals(Constants.ARG_0)) || (d.getArgs()[1].equals(Constants.ARG_1))
							|| (d.getArgs()[2].equals(Constants.ARG_2)) || (d.getArgs()[3].equals(Constants.ARG_3))
							|| (d.getArgs()[4].equals(Constants.ARG_4))) {
						throw new Exception(Constants.ERROR_ALL_ARG_FILES_REQUIRED);
					} else if (d.getArgs()[0].equals(d.getArgs()[1]) || d.getArgs()[0].equals(d.getArgs()[3])
							|| d.getArgs()[0].equals(d.getArgs()[4]) || d.getArgs()[1].equals(d.getArgs()[3])
							|| d.getArgs()[1].equals(d.getArgs()[4]) || d.getArgs()[3].equals(d.getArgs()[4])) {
						throw new Exception(Constants.ERROR_DUPLICATE_FILES);
					} else {
						Integer args2;
						try {
							args2 = Integer.parseInt(d.getArgs()[2]);
							if (args2 <= 0) {
								throw new Exception(Constants.ERROR_MOST_FREQ_SIZE);
							}
						} catch (NumberFormatException e) {
							throw new Exception(Constants.ERROR_MOST_FREQ_SIZE_VAL);
						}
						if (d.getArgs()[0].trim().length() == 0 || d.getArgs()[1].trim().length() == 0
								|| d.getArgs()[3].trim().length() == 0 || d.getArgs()[4].trim().length() == 0) {
							throw new Exception(Constants.ERROR_FILE_NAME);
						}
					}
				}
			};
		}
	}

	public DriverValidator(int argsLength, String[] args) throws Exception {
		this.argsLength = argsLength;
		this.args = args;

		ValidatorUtil.validate("failed", ValidatorFetcher.argsLengthValidator(this),
				ValidatorFetcher.argsValidator(this));
	}

	public int getArgsLength() {
		return argsLength;
	}

	public void setArgsLength(int argsLength) {
		this.argsLength = argsLength;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "Driver [argsLength=" + argsLength + ", args=" + Arrays.toString(args) + "]";
	}

}
