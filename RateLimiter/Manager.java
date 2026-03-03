import java.util.HashMap;
import java.util.Map;

public class Manager
{
    private final Map<String, Counter> userHistory = new HashMap<>();
    private final RateLimiterStrategy strategy;

    public Manager(RateLimiterStrategy strategy)
    {
        this.strategy = strategy;
    }

    public boolean checkLimit(User u, RateLimitRule rule)
    {
        String uid = u.getUserId();
        if (!userHistory.containsKey(uid))
        {
            userHistory.put(uid, new Counter(System.currentTimeMillis() / 1000));
        }
        Counter userCounter = userHistory.get(uid);

        return strategy.isAllowed(rule, userCounter);
    }
}