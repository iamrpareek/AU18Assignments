import java.util.LinkedList;

//Threading AU Spring'18 Assignment

public class ProducerConsumer
{
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
                    System.out.println("Producer produced item " + value);
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        
        public void consume() throws InterruptedException //consumer function to consume items
        {
            while (value<10)
            {
                synchronized (this)
                {
                    while (list.size()==0)
                        wait();
                    int val = list.removeFirst();
                    System.out.println("Consumer consumed item "+ val);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        final ProCon obj = new ProCon();
        
        Runnable r1 = new Runnable(){
            @Override
            public void run(){
                try{
                    obj.produce();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        
        Runnable r2 = new Runnable()
        {
            @Override
            public void run()
            {
                try{
                    obj.consume();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        t1.start(); //starting producer thread
        t2.start(); //starting consumer thread
        
        t1.join();  //joining the producer thread
        t2.join();
        System.out.println("Finished");
    }
}