import java.util.List;

public class CompositeAppender implements Appender
{
    private final List<Appender> listAppender;
    public CompositeAppender(List<Appender> listAppender)
    {
        this.listAppender = listAppender;
    }

    public void append(LogEvent logEvent)
    {
        for(Appender ap : listAppender)
        {
            ap.append(logEvent);
        }
    }
}
