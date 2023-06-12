public class TimePrinterRunnable implements Runnable
{
    public void run()
    {
        long startTime = System.currentTimeMillis();

        while (true)
        {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Час, що минув від моменту запуску програми: " + (elapsedTime / 1000) + " с.");

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
