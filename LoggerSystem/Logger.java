import java.time.LocalDateTime;

public class Logger
{
    private final Appender appender;
    private  final LogLevel minLogLevel;

    public Logger(LogLevel minLogLevel, Appender appender)
    {
        this.appender = appender;
        this.minLogLevel = minLogLevel;
    }

    public void log(LogLevel logLevel, String message, String className, String methodName, Exception exception)
    {
        if(logLevel.ordinal() >= minLogLevel.ordinal())
        {
            LogEvent logEvent = new LogEvent(message, LocalDateTime.now(), logLevel, String.valueOf(Thread.currentThread().getId()), className, methodName, exception);
            appender.append(logEvent);
        }

    }
}
