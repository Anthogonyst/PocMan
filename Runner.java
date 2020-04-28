package Maestus.PocMan;

/**
 * A runner for the game in question
 * Start by instantiating a program and then attaching it to a step program to process it
 * @author Oracle
 *
 */
public class Runner {
    public static void main(String[] args) {

    	PocMan ex = new PocMan();
        AppStep exa = new AppStep<PocMan>(ex);
        exa.start();
    }
}
