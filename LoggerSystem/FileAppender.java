import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileAppender  implements  Appender
{
    private final LogFormatter logFormatter;
    private final String filePath;

    public FileAppender(String filePath, LogFormatter logFormatter)
    {
        this.filePath = filePath;
        this.logFormatter = logFormatter;
    }

    public void append(LogEvent logEvent)
    {
        var log = logFormatter.formatLog(logEvent);
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND))
        {
            writer.write(log);
            writer.newLine();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}