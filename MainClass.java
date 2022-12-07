import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		Helper virtualAssistant = new Helper("Helper");
		WebScrape weather = new WebScrape();
		Alarm clock = new Alarm();
		int minutes = 0;
		
		ArrayList<String> isAdmin = new ArrayList<String>();
		ArrayList<String> shoppingCart = new ArrayList<String>();
		ArrayList<Integer> commands = new ArrayList<Integer>();

		System.out.println("Is this an admin?");
		Scanner adminScanner = new Scanner(System.in);
		String answer = adminScanner.nextLine();
		isAdmin.add(answer);
	
		System.out.println("Welcome to Helper, the mini virtual assistant.\nEnter your name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("Hello " + name + " how can I help you today?");
		System.out.println("1 = Get the current date and time\n2 = Set a timer alarm\n3 = Add an item to your shopping cart\n4 = Remove an item from cart\n5 = Get all commands given to Helper\n6 = Display shopping cart\n7 = Get Weather\n8 = Exit");
		
		int reply = scan.nextInt();
	
		while(reply !=8) {
			switch(reply) {	
			case 1:
				virtualAssistant.getTime();
				break;
			case 2:
				System.out.println("How many minutes would you like to add to your timer?");
				Scanner scan1 = new Scanner(System.in);
				minutes = scan1.nextInt();
				clock.start(minutes);
				break;
			case 3:
				System.out.println("What would you like to add to your shopping cart? (Separate with a ',')");
				Scanner itemAdd = new Scanner(System.in);
				String items = itemAdd.nextLine();
				String[] newItems = items.split(",");
				for(int i = 0; i < newItems.length; i++) {
					shoppingCart.add(newItems[i]);
				}
				System.out.println(items + " have been added to the shopping cart.");
				break;
			case 4:
				System.out.println("What would you like to remove?");
				Scanner itemRemove = new Scanner(System.in);
				String itemDelete = itemRemove.nextLine();
					if(shoppingCart.contains(itemDelete)) {
						shoppingCart.remove(itemDelete);
					}
				break;
			case 5:
				commands.add(reply);
				if (isAdmin.contains("Yes") || isAdmin.contains("yes")) {
					System.out.println(commands);
				} else {
					System.out.println("You are not allowed to see the audit log.");
				}
				break;
			case 6:
				System.out.println(shoppingCart);
				System.out.println("There are " + shoppingCart.size() + " items in your cart.");
				break;
			case 7:
				weather.display();
				break;
			case 8:
				break;
			}
			commands.add(reply);
			System.out.println("Anything else?");
			reply = scan.nextInt();
		}
		scan.close();
		System.out.println("Thank you for using Helper.");
	}

}
