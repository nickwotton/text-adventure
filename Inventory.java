import java.util.LinkedList;

public class Inventory {
	
	LinkedList<String> inventory = new LinkedList<String>();
	
	public void displayInv(){
		System.out.println("Inventory:");
		if(inventory.isEmpty()){
			System.out.println("\tYour inventory is empty!");
		}
		for(String s: inventory){
			System.out.println("\t" + s);
		}
	}
	
	public boolean has(String s){
		boolean answer = false;
		for(String i: inventory){
			if(s.equals(i)){
				answer = true;
			}
		}
		return answer;
	}
	
	public void add(String s){
		inventory.add(s);
	}
}
