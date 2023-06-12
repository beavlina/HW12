public class FizzBuzzTest
{
    public static void main(String[] args) throws InterruptedException
    {
        FizzBuzz myFizzBuzz = new FizzBuzz(31);

        Thread threadA = new Thread(myFizzBuzz::fizz);
        Thread threadB = new Thread(myFizzBuzz::buzz);
        Thread threadC = new Thread(myFizzBuzz::fizzbuzz);
        Thread threadD = new Thread(myFizzBuzz::number);

        threadA.start();
        threadC.start();
        threadD.start();

        threadA.join();

        threadB.start();
        threadB.join();

        synchronized (threadC)
        {
            threadC.notify();
        }

        synchronized (threadD)
        {
            threadD.notify();
        }
    }
}
