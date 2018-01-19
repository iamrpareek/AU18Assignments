import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

//Threading AU Spring'18 Assignment

public class PcExecutorService {
	static Logger logger = Logger.getLogger( ProducerConsumer.class.getName() );
	ExServiceThreadPool threadPool; // creating an executor service thread pool
	static ArrayList cData = new ArrayList();

	private void init() {
		threadPool = new ExServiceThreadPool();
		for (int i = 0; i < 10; i++) { // Running on loop to define the total capacity
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
		public void run() {
			logger.log(Level.INFO,"Producer produced item {0}", data);
			try {
				threadPool.queue.put(data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private class Consumer implements Runnable {
		int datatake;
		int data;

		public Consumer(int datatoput) {
			data = datatoput;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				logger.log(Level.INFO,"Consumer consumed item {0}", data);
				Thread.sleep(1000);
				datatake = threadPool.queue.take();
				cData.add(datatake);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static void main(String[] args) {
		PcExecutorService pc = new PcExecutorService();
		pc.init();

	}
}