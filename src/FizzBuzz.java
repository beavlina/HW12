import java.util.concurrent.ConcurrentHashMap;

public class FizzBuzz
{
    private ConcurrentHashMap<Integer, Object> values;
    public FizzBuzz(int n)
    {
        values = new ConcurrentHashMap<Integer, Object>();
        for (int i = 1; i <= n; i++)
        {
            values.put(i, Integer.valueOf(i));
        }
    }

    public void fizz()
    {
        for (int i = 1; i <= values.size(); i++)
        {
            if (i % 3 == 0)
            {
                values.put(i, "fizz");
            }
        }
    }

    public void buzz()
    {
        for (int i = 1; i <= values.size(); i++)
        {
            if (i % 5 == 0)
            {
                values.put(i, "buzz");
            }
        }
    }

    public void fizzbuzz()
    {
        synchronized (Thread.currentThread())
        {
            try
            {
                Thread.currentThread().wait();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

        for (int i = 1; i <= values.size(); i++)
        {
            if (i % 5 == 0 && i % 3 == 0)
            {
                values.put(i, "fizzbuzz");
            }
        }
    }

    public void number()
    {
        synchronized (Thread.currentThread())
        {
            try
            {
                Thread.currentThread().wait();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        System.out.println(String.join(", ", values.values().stream().map(c -> c.toString()).toList()));
    }
}
