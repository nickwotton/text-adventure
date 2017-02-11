import java.util.*;
import java.io.*;

public class Game {

	World w = new World();

	Inventory inventory = new Inventory();

	HashMap<String, String> commands = new HashMap<String, String>();

	public void initializeCommands() {
		//
		// First Room Commands
		//

		// Door Commands
		commands.put("lookatdoor", "It's an ordinary door.");

		// Note Commands
		commands.put("takenote", "You pick up the note.");
		commands.put("pickupnote", "You pick up the note.");
		commands.put("readnote", "Welcome to a Text-Based Adventure! (By Nick Wotton)");
		commands.put("lookatnote", "Welcome to a Text-Based Adventure! (By Nick Wotton)");
		commands.put("eatnote", "You really don't want to do that.");

		// Window Commands
		commands.put("gotowindow", "You stand at the window.");
		commands.put("headtowindow", "You stand at the window.");
		commands.put("lookoutwindow",
				"You see a forest not far from the building you're in.\nYou seem to be on the first story of the house");
		commands.put("lookout",
				"You see a forest not far from the building you're in.\nYou seem to be on the first story of the house");
		commands.put("lookatwindow", "It's an ordinary window.");

		// Table Commands
		commands.put("lookattable", "It's an ordinary table.");
		commands.put("pickuptable", "You try lift the table up, but it's too heavy.");
		commands.put("taketable", "Its a little too heavy to take.");

		// Bed Commands
		commands.put("getup", "You get off the bed.");
		commands.put("getoffbed", "You get off the bed.");
		commands.put("standup", "You get off the bed.");
		commands.put("lookatbed", "Looks comfy.");
		commands.put("sleepinbed", "It's not really the time for that.");
		commands.put("sleep", "It's not really the time for that.");
	}

	LinkedList<String> actions = new LinkedList<String>();

	public void initializeActions() {
		//
		// General Actions
		//

		actions.add("i");
		actions.add("inv");
		actions.add("inventory");
		actions.add("showinventory");
		actions.add("displayinventory");

		//
		// Bedroom Actions
		//

		// Door Actions
		actions.add("opendoor");
		actions.add("closedoor");

		// Window Actions
		actions.add("openwindow");
		actions.add("closewindow");
		actions.add("climboutwindow");
		actions.add("exitthroughwindow");
		actions.add("gooutwindow");
		actions.add("jumpoutwindow");
		actions.add("climbinwindow");
		actions.add("goinwindow");
		actions.add("enterthroughwindow");
		actions.add("jumpinwindow");
		actions.add("jumpthroughwindow");
		actions.add("climbthroughwindow");
		actions.add("breakwindow");
		actions.add("breakwindowwithfists");
		actions.add("breakwindowwithfist");
		actions.add("smashwindow");
		actions.add("smashwindowwithfists");
		actions.add("smashwindowwithfist");
		actions.add("kickwindow");
		actions.add("punchwindow");
	}

	public void performAction(String s) {
		switch (s) {
		//
		// INVENTORY
		//
		case "i":
			inventory.displayInv();
			break;
		case "inv":
			inventory.displayInv();
			break;
		case "inventory":
			inventory.displayInv();
			break;
		case "showinventory":
			inventory.displayInv();
			break;
		case "displayinventory":
			inventory.displayInv();
			break;
		}
		//
		// BEDROOM
		//
		if (w.area == 1) {
			switch (s) {
			case "opendoor":
				if (!w.bedroom.door) {
					w.bedroom.door = true;
					System.out.println("You open the door.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "closedoor":
				if (w.bedroom.door) {
					w.bedroom.door = false;
					System.out.println("You close the door.");
				} else {
					System.out.println("It's already closed.");
				}
				break;
			case "openwindow":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					System.out.println("You open the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "closewindow":
				if (w.bedroom.windowSmashed) {
					System.out.println("You can't do that because you broke the window");
					break;
				}
				if (w.bedroom.window) {
					w.bedroom.window = false;
					System.out.println("You close the window.");
				} else {
					System.out.println("It's already closed.");
				}
				break;
			case "climboutwindow":
				if (w.bedroom.window) {
					w.area = w.houseEast.areaNum;
					System.out.println("You squeeze out through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that");
				}
				break;
			case "exitthroughwindow":
				if (w.bedroom.window) {
					w.area = w.houseEast.areaNum;
					System.out.println("You squeeze out through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that");
				}
				break;
			case "gooutwindow":
				if (w.bedroom.window) {
					w.area = w.houseEast.areaNum;
					System.out.println("You squeeze out through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that");
				}
				break;
			case "jumpoutwindow":
				if (w.bedroom.window) {
					w.area = w.houseEast.areaNum;
					System.out.println("You jump out through the window.");
				} else {
					System.out.println("You jump through the glass and shatter the window.");
					w.area = w.houseEast.areaNum;
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
				}
				break;
			case "jumpthroughwindow":
				if (w.bedroom.window) {
					w.area = w.houseEast.areaNum;
					System.out.println("You jump through the window.");
				} else {
					System.out.println("You jump through the glass and shatter the window.");
					w.area = w.houseEast.areaNum;
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
				}
				break;
			case "climbthroughwindow":
				if (w.bedroom.window) {
					w.area = w.houseEast.areaNum;
					System.out.println("You climb through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that.");
				}
				break;
			case "breakwindow":
				if (!w.bedroom.window) {
					System.out.println("With what?");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "breakwindowwithfists":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "breakwindowwithfist":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "smashwindow":
				if (!w.bedroom.window) {
					System.out.println("With what?");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "smashwindowwithfists":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "smashwindowwithfist":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "kickwindow":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "punchwindow":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			default:
				System.out.println("You can't do that right now.");
				break;
			}
		}

		//
		// HouseEastSide
		//
		else if (w.area == 2) {
			switch (s) {
			case "climbinwindow":
				if (w.bedroom.window) {
					w.area = w.bedroom.areaNum;
					System.out.println("You struggle in through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that.");
				}
				break;
			case "goinwindow":
				if (w.bedroom.window) {
					w.area = w.bedroom.areaNum;
					System.out.println("You struggle in through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that.");
				}
				break;
			case "enterthroughwindow":
				if (w.bedroom.window) {
					w.area = w.bedroom.areaNum;
					System.out.println("You struggle in through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that.");
				}
				break;
			case "jumpinwindow":
				if (w.bedroom.window) {
					w.area = w.bedroom.areaNum;
					System.out.println("You jump in through the window.");
				} else {
					System.out.println("You jump through the glass and shatter the window.");
					w.area = w.bedroom.areaNum;
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
				}
				break;
			case "jumpthroughwindow":
				if (w.bedroom.window) {
					w.area = w.bedroom.areaNum;
					System.out.println("You jump through the window.");
				} else {
					System.out.println("You jump through the glass and shatter the window.");
					w.area = w.bedroom.areaNum;
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
				}
				break;
			case "climbthroughwindow":
				if (w.bedroom.window) {
					w.area = w.bedroom.areaNum;
					System.out.println("You climb through the window.");
				} else {
					System.out.println("The window is closed. You cannot do that.");
				}
				break;
			case "breakwindow":
				if (!w.bedroom.window) {
					System.out.println("With what?");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "breakwindowwithfists":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "breakwindowwithfist":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "smashwindow":
				if (!w.bedroom.window) {
					System.out.println("With what?");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "smashwindowwithfists":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "smashwindowwithfist":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "kickwindow":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			case "punchwindow":
				if (!w.bedroom.window) {
					w.bedroom.window = true;
					w.bedroom.windowSmashed = true;
					System.out.println("You smash the window glass.");
				} else if (w.bedroom.windowSmashed) {
					System.out.println("You already broke the window.");
				} else {
					System.out.println("It's already open.");
				}
				break;
			default:
				System.out.println("You can't do that right now.");
				break;
			}
		}
	}

	public void basicRun() {
		initializeCommands();
		initializeActions();
		checkIfDirection(fetchInput());
	}

	public String fetchInput() {
		Scanner input = new Scanner(System.in);
		// TODO: there needs to be a loop here to read the whole players command
		// it should return the whole command and break the loop when scan.next
		// doesn't produce anything
		/*
		 * String command = "start"; String[] a = new String[10]; // ASSUMES
		 * PLAYER INPUT WILL NOT BE GREATER THAN 10 WORDS a[0] = input.next();
		 */
		// Remove "the" "a" whitespace etc from commands
		String entry = input.nextLine().toLowerCase();
		entry = stripFillers(entry);
		return entry;
	}

	public String stripFillers(String s) {
		// Removes A, An, The
		String stripped = s;
		char[] chars = s.toCharArray();
		int arrayLeng = chars.length;
		// First pass for to find blank space
		for (int i = 1; i < arrayLeng - 1; i++) {
			if (chars[i] == 'a') {
				if (chars[i - 1] == ' ') {
					if (chars[i + 1] == ' ') {
						// Set the 'a' to a space so it can be filtered out
						chars[i] = ' ';
					}
				}
			}
			if (chars[i] == 'a') {
				if (chars[i - 1] == ' ') {
					if (chars[i + 1] == 'n') {
						if (chars[i + 2] == ' ') {
							// Set the 'an' to a space so it can be filtered out
							chars[i] = ' ';
							chars[i + 1] = ' ';
						}
					}
				}
			}
			if (chars[i] == 't') {
				if (chars[i + 1] == 'h') {
					if (chars[i + 2] == 'e') {
						// Set the 'the' to a space so it can be filtered out
						chars[i] = ' ';
						chars[i + 1] = ' ';
						chars[i + 2] = ' ';
					}
				}
			}
		}
		// Remove the blanks by writing over the array.
		// Will have to trim at end
		int count = 0;
		for (int i = 0; i < arrayLeng; i++) {
			if (chars[i] != ' ') {
				chars[count] = chars[i];
				count++;
			}
		}
		if (count != arrayLeng) {
			for (; count < arrayLeng; count++) {
				chars[count] = ' ';
			}
		}
		stripped = new String(chars);
		stripped = stripped.trim();
		// System.out.println(stripped);
		return stripped;
	}

	public void checkIfDirection(String c) {
		switch (c) {
		case "n":
			System.out.println("You head north.");
			basicRun();
			break;
		case "north":
			System.out.println("You head north.");
			basicRun();
			break;

		case "s":
			System.out.println("You head north.");
			basicRun();
			break;
		case "south":
			System.out.println("You head south.");
			basicRun();
			break;

		case "e":
			System.out.println("You head east.");
			basicRun();
			break;
		case "east":
			System.out.println("You head east.");
			basicRun();
			break;

		case "w":
			System.out.println("You head west.");
			basicRun();
			break;
		case "west":
			System.out.println("You head west.");
			basicRun();
			break;
		default:
			checkKnownCommands(c);
		}
	}

	public void checkKnownCommands(String c) {
		// TODO Build Hashmap of possible commands
		// if c is a key print the value
		
		if (commands.containsKey(c)) {
			// Check if they are picking something up

			// Check for note
			if (c.contains("note")) {
				if (!c.contains("read")) {
					if (inventory.has("Note")) {
						System.out.println("You already picked that up");
						basicRun();
					} else {
						inventory.add("Note");
						w.bedroom.noteTaken = true;
						System.out.println("Note added to inventory.");
					}
				}
			}

			System.out.println(commands.get(c));
		} else if (actions.contains(c)) {
			performAction(c);
		} else {
			System.out.println("Sorry this command is not recognized. Please try again.");
		}
		basicRun();
	}
}
