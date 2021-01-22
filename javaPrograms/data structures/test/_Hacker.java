class Hacker implements Runnable
{
  public void run()
  {
    try
    {
      for(int i=0;i<2;i++)
      {
        Thread.sleep(100);
        System.out.print(" "+Thread.currentThread().getName());
      }
    }
   catch(InterruptedException e)
    {
      System.out.print("Exception Occured "+e);
    }
  }
}
public class HackerEarth 
{
  public static void main(String args[])
  {
    Hacker obj = new Hacker();
    Thread t = new Thread(obj,"Java");
    Thread t1 = new Thread(obj,"PHP");
    t.start();
    t.join();
    t1.start();
  }
}