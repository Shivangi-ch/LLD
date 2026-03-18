import java.time.LocalDateTime;

public class LogEvent
{
    private final String message;
    private final LocalDateTime timestamp;
    private final LogLevel level;
    private final String threadId;
    private final String className;
    private final String methodName;
    private Exception exception;

    public LogEvent(String message, LocalDateTime timestamp, LogLevel level,
        String threadId, String className, String methodName, Exception exception)
    {
        this.message = message;
        this.timestamp = timestamp;
        this.level = level;
        this.threadId = threadId;
        this.className = className;
        this.methodName = methodName;
        this.exception = exception;
    }
    public LogEvent(String message, LocalDateTime timestamp, LogLevel level,
                    String threadId, String className, String methodName)
    {
        this.message = message;
        this.timestamp = timestamp;
        this.level = level;
        this.threadId = threadId;
        this.className = className;
        this.methodName = methodName;
    }

    public String getMessage()
    {
        return message;
    }

    public  String getThreadId()
    {
        return threadId;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public LogLevel getLevel()
    {
        return level;
    }

    public String getClassName()
    {
        return className;
    }

    public  String getMethodName()
    {
        return methodName;
    }

    public Exception getException()
    {
        return exception;
    }
}
