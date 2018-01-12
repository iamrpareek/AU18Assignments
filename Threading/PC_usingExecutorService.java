import java.util.Iterator;
import java.util.ArrayList;

//Threading AU Spring'18 Assignment

public class PC_usingExecutorService {
	
	ExServiceThreadPool threadPool; //creating an executor service thread pool
    static ArrayList cData = new ArrayList(); 

    private void init()
    {
        threadPool = new ExServiceThreadPool();
        for(int i = 0; i < 10; i++){  //Running on loop to define the total capacity
            threadPool.addThread(new Producer(i));   
            threadPool.addThread(new Consumer(i));
        }
        threadPool.finish();
    }

    private class Producer implements Runnable {
            int data;
            public Producer(int datatoput) {
               data = datatoput;
             }
        @Override
        public void run() 
        {
        	System.out.println("Producer produced item " + data);
            try {
            	threadPool.queue.put(data);
            	Thread.sleep(1000);	
            }
            catch (InterruptedException e) { }
        }
    }
    
    private class Consumer implements Runnable 
    {
    	int datatake,data;
    	public Consumer(int datatoput) {
                    data = datatoput;
        }
    	@Override
        public void run() 
    	{
    		try{
    			Thread.sleep(1000);
    			System.out.println("Consumer consumed item " + data);
    			Thread.sleep(1000);
    			datatake = threadPool.queue.take();
                cData.add(datatake);
            }
    		catch (InterruptedException e) { }
        }
    }
    
    public static void main(String[] args)
    {
    	PC_usingExecutorService pc = new PC_usingExecutorService();
        pc.init();
        
    }
}