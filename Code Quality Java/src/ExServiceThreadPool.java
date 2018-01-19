import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExServiceThreadPool {
	final BlockingQueue<Integer> queue = null;
	ExecutorService executor = Executors.newFixedThreadPool(2);

	public void addThread(Runnable r) {
		executor.submit(r);
	}

	public void finish() {
		try {
			executor.shutdown();
			executor.awaitTermination(50, TimeUnit.SECONDS);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			Logger.getLogger(ExServiceThreadPool.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Finished");
	}

}