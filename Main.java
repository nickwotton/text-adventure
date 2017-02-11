import java.util.Scanner;
// So the idea is to have a text based adventure game where the player navigates the environment with word based commands
// The game should read the players input and produce different text based on their responses
// May want to consider a list of legal keywords

public class Main {
	public static void main(String[] args) {
		Game g = new Game();
		System.out.println(
				"You awake in a small room. There's a small table with a paper on it next to the bed you're lying in.");
		System.out.println(
				"A window is open on the wall to the left of the bed. A door is closed directly across from the bed.");
		g.basicRun();
	}
}