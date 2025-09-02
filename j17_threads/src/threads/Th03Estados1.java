package threads;

public class Th03Estados1 {
	public static void main(String[] args) {
		
		Thread th1 = new Thread();
		System.out.println(th1.getState()); //new
		
		th1.start();
		System.out.println(th1.getState()); //runnable
		
		ThreadUtil.sleep(100); //ponemos a dormir el hilo del main 200 ms
		
		System.out.println(th1.getState()); //terminated
	}
}
