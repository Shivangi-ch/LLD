public class JsonLogFormatter implements LogFormatter
{
    public JsonLogFormatter() { }

    public String formatLog(LogEvent logEvent)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        sb.append("\"message\":\"");
        var msg = logEvent.getMessage();
        sb.append(msg);
        sb.append("\",");

        sb.append("\"timestamp\":\"");
        var tp = logEvent.getTimestamp();
        sb.append(tp.toString());
        sb.append("\",");

        sb.append("\"level\":\"");
        var ll = logEvent.getLevel();
        sb.append(ll.toString());
        sb.append("\",");

        sb.append("\"threadId\":\"");
        var tr = logEvent.getThreadId();
        sb.append(tr);
        sb.append("\",");

        sb.append("\"className\":\"");
        var cn = logEvent.getClassName();
        sb.append(cn);
        sb.append("\",");

        sb.append("\"methodName\":\"");
        var mn = logEvent.getMethodName();
        sb.append(mn);
        sb.append("\",");

        sb.append("\"exception\":\"");
        var ex = logEvent.getException();
        if(ex != null)
        {
            var emsg = logEvent.getException().getMessage();
            sb.append(emsg);
        }
        else
        {
            sb.append("null");
        }
        sb.append("\"");

        sb.append("}");

        return sb.toString();
    }
}
