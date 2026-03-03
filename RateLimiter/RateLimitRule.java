public class RateLimitRule
{
    private final int max_requests;
    private final long timeWindowInSeconds;

    public RateLimitRule(int max_requests, long timeWindowInSeconds)
    {
        this.max_requests = max_requests;
        this.timeWindowInSeconds = timeWindowInSeconds;
    }

    public int getMax_requests()
    {
        return max_requests;
    }

    public long getTimeWindowInSeconds()
    {
        return timeWindowInSeconds;
    }

}
