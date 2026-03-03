public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        RateLimiterStrategy strategy = new FixedWindowStrategy();
        Manager manager = new Manager(strategy);

        RateLimitRule rule = new RateLimitRule(5, 10);

        User u1 = new User("Alice_123");

        for (int i = 1; i <= 7; i++)
        {
            boolean allowed = manager.checkLimit(u1, rule);
            if (allowed)
            {
                System.out.println("Request " + i + ": Allowed ✅");
            }
            else
            {
                System.out.println("Request " + i + ": Rejected ❌ (Rate Limit Exceeded)");
            }
            Thread.sleep(100);
        }
    }
}