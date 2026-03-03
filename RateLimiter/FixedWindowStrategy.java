public class FixedWindowStrategy implements RateLimiterStrategy
{
    @Override
    public boolean isAllowed(RateLimitRule rateLimitRule, Counter counter)
    {
        long currentTime = System.currentTimeMillis() / 1000;
        long windowStart = counter.getWindowStart();
        long TimeWindowInSeconds = rateLimitRule.getTimeWindowInSeconds();

        if (currentTime - windowStart >= TimeWindowInSeconds)
        {
            counter.reset(currentTime);
            return true;
        }

        if (counter.getCount() < rateLimitRule.getMax_requests())
        {
            counter.increment();
            return true;
        }
        return false;
    }
}
