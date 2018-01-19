import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Threading AU Spring'18 Assignment

public class ProducerConsumer
{
	static Logger logger = Logger.getLogger( ProducerConsumer.class.getName() );
	static int value = 0;
    public static class ProCon
    {
        LinkedList<Integer> list = new LinkedList<>();
        int iCapacity = 1;  //defines the consuming and producing capacity at a time

        public void produce() throws InterruptedException //producer function to produce items
        {
            
            while (value<10) //limiting total items to 10
            {
                synchronized (this)
                {
                    while (list.size()==iCapacity)
                        wait();
                    logger.log(Level.INFO,"Producer produced item {0} ", value);
                    list.add(value++);
                    notifyAll();
                    this.wait(1000);
                }
            }
        }
        
        public void consume() throws InterruptedException //consumer function to consume items
        {
            while (value<10)
            {
                synchronized (this)
                {
                    while (list.isEmpty())
                        wait();
                    int val = list.removeFirst();
                    logger.log(Level.INFO,"Consumer consumed item: {0} ", val);
                    notifyAll();
                    this.wait(1000);
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        final ProCon obj = new ProCon();
        
        Runnable r1 = () -> {
                try{
                    obj.produce();
                }
                catch(InterruptedException e){
                	Thread.currentThread().interrupt();
                }
        };
        
        Runnable r2 = () ->   {
                try{
                    obj.consume();
                }
                catch(InterruptedException e){
                	Thread.currentThread().interrupt();
                }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        t1.start(); //starting producer thread
        t2.start(); //starting consumer thread
        
        t1.join();  //joining the producer thread
        t2.join();
        logger.log(Level.INFO,"Finished");
    }
}