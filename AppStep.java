//package Maestus.PocMan;

/**
 * A time keeping program that maintains a consistent frame rate for the application
 * 
 * @author Oracle
 *
 * @param <T> of <code>IApplication</code>
 */
public final class AppStep<T extends IApplication> {
	
	private final T app;
	
	public AppStep(T app) {
		this.app = app;
	}
	
	void start() {
		int UPDATES = 60;  // Sets to 60 fps
		int UPDATEUNIT = 1000000; // Divisor for nanoseconds
		Thread t = new Thread();
		
		try {
			t.sleep(100);
			
			// Converts the current time
			long executionStamp = System.nanoTime() / UPDATEUNIT; 
			while(true) { 
				long now = System.nanoTime() / UPDATEUNIT;
				// Gets the delta time between now and the last frame
				long difference  = now - executionStamp;
				long interval = 1000 / UPDATES;

				if (difference > interval) {
					app.nextFrame();
					executionStamp = System.nanoTime() / UPDATEUNIT;
				}
				
				// Updating the ui should always be able to have unlimited FPS if you don�t want the user to lock it manually
				app.updateUI();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
