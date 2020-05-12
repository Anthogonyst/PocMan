//package Maestus.PocMan;

/**
 * Interface to update game Application
 * @author Oracle
 *
 */
public interface IApplication {
	abstract void nextFrame();
	abstract void updateUI();
	abstract void togglePause();
}
