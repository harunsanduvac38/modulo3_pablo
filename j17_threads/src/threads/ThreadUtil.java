package threads;

import java.util.Random;

public class ThreadUtil {

	public static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//duerma el hilo actual entre 0 y 2 segundos
	public static void sleep() {
		sleep(new Random().nextLong(2000));
	}
}
