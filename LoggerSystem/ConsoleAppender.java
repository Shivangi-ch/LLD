public class ConsoleAppender implements Appender
{
    private final LogFormatter logFormatter;

    public ConsoleAppender(LogFormatter logFormatter)
    {
        this. logFormatter = logFormatter;
    }
    public void append(LogEvent logEvent)
    {
        var log = logFormatter.formatLog(logEvent);
        System.out.println(log);
    }
}
