import org.apache.commons.cli.*;

public class ParserParams {

    public ParserParams() { }

    private Option createOption(String opt, String description) {
        Option newOption = new Option(opt, true, description);
        newOption.setOptionalArg(false);

        return newOption;
    }

    public String[] parseWriteRead(String[] commandLineArguments) throws ParseCommandLineException {
        Options posixOptions = new Options();

        posixOptions.addOption(createOption("w", "Write"));
        posixOptions.addOption(createOption("r", "Read"));

        CommandLineParser cmdLinePosixParser = new PosixParser();
        CommandLine commandLine = null;
        String[] valuesParams = new String[2];

        try {
            commandLine = cmdLinePosixParser.parse(posixOptions, commandLineArguments);

            if (commandLine.hasOption("w") && commandLine.hasOption("r")) {
                valuesParams[0] = commandLine.getOptionValue("w");
                valuesParams[1] = commandLine.getOptionValue("r");
            }
        }
        catch (Throwable e) {
            throw new ParseCommandLineException("Input data have invalid format.");
        }
        return valuesParams;
    }
}
