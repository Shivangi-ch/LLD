public interface RateLimiterStrategy
{
    public boolean isAllowed(RateLimitRule rateLimitRule, Counter counter);

}
