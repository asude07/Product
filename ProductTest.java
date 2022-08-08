import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		Product[] products= new Product[0];
		
		
		System.out.println("---------------"
				+ "\n1-Add product"
				+ "\n2-Enter type"
				+ "\n3-Print products"
				+ "\n4-Calculate total price"
				+ "\n5-Exit"
				+ "\n---------------");
		System.out.println();
		
		System.out.println("Enter operation: ");
		int oprtn = key.nextInt();
		key.nextLine();
		
		while (oprtn<5) {
			
			if (oprtn == 1) {
				Product p1 = new Product();
				
				Product tmp[]= new Product[products.length+1];
				
				System.out.println("Product name:");
				String name = key.nextLine();
				
				System.out.println("Product price:");
				double price = key.nextDouble();
				key.nextLine();
				
				System.out.println("Quantity:");
				int quantity = key.nextInt();
				
				p1.setProductionInformation(name, price, quantity);

				System.out.println();
				
				for(int a=0; a<products.length; a++) {
					tmp[a]=products[a];
				}
				
				tmp[products.length]=p1;
				products=tmp;
			}
				
			if (oprtn == 2) {
				
				System.out.println("Product name:");
				String n=key.nextLine();

				System.out.println("Type:");
				String type=key.next();
				System.out.println();
				
				for(int i=0;i<products.length;i++) {

					if(products[i].getName().equals(n)) {

						products[i].setType(type);
					}
				}
			}
			
			if (oprtn == 3) {
				
				for (int a=0; a<products.length; a++) {
					
					products[a].printInfo();
				}
				System.out.println();
			}
				
			if (oprtn == 4) {
				
				double totalprice=0;

				boolean error=false;

				for(int i=0;i<products.length;i++){

					if(products[i].getType()==null){
						error=true;
						System.out.println("You didn't enter types of the below given products:");
						break;
					}	
				}
				
				if (error) {
					for(int i=0;i<products.length;i++) {
						if(products[i].getType()==null){
							System.out.println("- "+products[i].getName());
						}
					}
					System.out.println();
				}
				
				else {
					for(int i=0;i<products.length;i++) {
						double x;
						if (products[i].getType().equals("Vegetable")) {
							x = (products[i].getPrice()*products[i].getQuantity()) - (products[i].getPrice()*products[i].getQuantity()*0.05);
							totalprice += x;
						}
						
						else if(products[i].getType().equals("Dairy")) {
							x = (products[i].getPrice()*products[i].getQuantity()) - (products[i].getPrice()*products[i].getQuantity()*0.1);
							totalprice += x;
						}
						
						else {
							totalprice += products[i].getPrice()*products[i].getQuantity();
						}
					}
					totalprice -= totalprice*0.15;
					System.out.println("Total price of your shopping is "+ totalprice + " TL.");
					System.out.println();
				}
			}
			
			System.out.println("Enter operation: ");
			oprtn = key.nextInt();
			key.nextLine();
					
		}
		
		System.out.println("Bye!");

	}

}
