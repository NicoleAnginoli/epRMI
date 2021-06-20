package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import interfaces.PartRepository;

public class Client {
	
	private static Scanner scan = null;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		PartRepository squaredapi = (PartRepository) Naming.lookup("rmi://localhost:7777/squared");
		
		scan = new Scanner(System.in);
		
		for(;;) {
			System.out.println("**********");
			System.out.println("1 - get the square of the number");
			System.out.println("2 - get the squareRoot of the number");
			System.out.println("**********");
			
			int choice = getChoice();
			if (choice == 1) {
				System.out.println(squaredapi.addPart("nome1", "des1"));
				
			}
			else if (choice == 2) {
				String code = getInput();
				System.out.println(squaredapi.getPart(code));
				
			}
			else {
				System.out.println(squaredapi.getPartList());
			}
		}

	}
	
	public static int getChoice() {
		
		System.out.println("enter choice");
		int input = scan.nextInt();
		return input;
	}
	
	public static String getInput() {
		System.out.println("enter a code");
		String input = scan.next();
		return input;
	}

}
