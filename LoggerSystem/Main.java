import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Logger consoleLogger =  setupConsoleLogger();
        consoleLogger.log(LogLevel.INFO, "Console logger setup complete", "Main", "main", null);

        Logger fileLogger =  setupFileLogger();
        fileLogger.log(LogLevel.INFO, "File logger setup complete", "Main", "main", null);

        Logger compositeLogger =  setupCompositeLogger();
        compositeLogger.log(LogLevel.INFO, "Composite logger setup complete", "Main", "main", null);

        try
        {
            throw new Exception("test exception log");
        }
        catch (Exception e)
        {
            compositeLogger.log(LogLevel.ERROR, "Composite logger setup complete", "Main", "main", e);
        }

    }

    private static Logger setupConsoleLogger()
    {
        JsonLogFormatter logFormatter = new JsonLogFormatter();
        ConsoleAppender consoleAppender = new ConsoleAppender(logFormatter);
        Logger logger = new Logger(LogLevel.INFO, consoleAppender);
        return logger;
    }

    private static Logger setupFileLogger()
    {
        JsonLogFormatter logFormatter = new JsonLogFormatter();
        FileAppender fileAppender = new FileAppender("/home/svng/Documents/LoggerSystem/Logs.txt", logFormatter);
        Logger logger = new Logger(LogLevel.INFO, fileAppender);
        return logger;
    }
    private static Logger setupCompositeLogger()
    {
        JsonLogFormatter logFormatter = new JsonLogFormatter();
        ConsoleAppender consoleAppender = new ConsoleAppender(logFormatter);
        FileAppender fileAppender = new FileAppender("/home/svng/Documents/LoggerSystem/Logs.txt", logFormatter);
        List<Appender> appenders = new ArrayList<>();
        appenders.add(consoleAppender);
        appenders.add(fileAppender);
        CompositeAppender compositeAppender = new CompositeAppender(appenders);
        Logger logger = new Logger(LogLevel.INFO, compositeAppender);
        return logger;
    }

}