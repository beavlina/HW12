public class TimeTracker
{
    public static void main(String[] args)
     {
        Thread timeThread = new Thread(new TimePrinterRunnable());
        Thread messageThread = new Thread(new MessagePrinterRunnable());
        timeThread.start();
        messageThread.start();
    }
}
