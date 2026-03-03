public class Counter
{
    private int count = 0;
    private long windowStart;


    public Counter(long startTime)
    {
        this.windowStart = startTime;
    }

    public void increment()
    {
        count++;
    }

    public void reset(long newStartTime)
    {
        this.windowStart = newStartTime;
        count = 1;
    }

    public int getCount()
    {
        return count;
    }

    public long getWindowStart()
    {
        return windowStart;
    }
}
