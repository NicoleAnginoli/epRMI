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
		
		PartRepository repository = (PartRepository) Naming.lookup("rmi://localhost:7777/rmiServer");
		
		scan = new Scanner(System.in);
		
		for(;;) {
			System.out.println("\n*************");
			System.out.println("Voc� est� conectado");
			System.out.println("O que deseja fazer?");
			System.out.println("BIND (conectar com um servidor)"); // TO DO
			System.out.println("LISTP (listar as pe�as)"); // DONE
			System.out.println("GETP (busca uma pe�a)"); // DONE
			System.out.println("SHOWP (mostrar os atributos de uma pe�a)"); // DONE
			System.out.println("CLEARLIST (limpa a lista de sub-pe�as)"); // TO DO
			System.out.println("ADDSUBPART (adiciona n unidades de pe�as � lista de sub-pe�as)"); // TO DO
			System.out.println("ADDP (adiciona uma pe�a)"); // DONE
			System.out.println("QUIT (encerrar a execu��o)"); // ERRO
			 
			/* TODO 
			 * Conectar um cliente com mais de um servidor
			 * pegar a ref de uma pe�a e adicionar em outro servidor (pelo o que eu entendi add como sub pe�a)
			 * 
			 * lista de subParts - Uma parte pode ter uma lista de sub componentes 
			 * subc componentes s�o objetos parts tamb�m e podem estar espalhados por multiplos servidores
			 * se a pe�a n�o tem subc componentes, ela � primitiva 
			 * */
			
			System.out.println("\nDigite um dos comandos listados");
			
			String choice = getInput();
			if ("BIND".equals(choice)) {
				System.out.println(repository.addPart("nome1", "des1"));			
			}
			else if ("LISTP".equals(choice)) {
				System.out.println(repository.getPartList());		
			}
			else if ("GETP".equals(choice)) {
				System.out.println("Digite o c�digo da pe�a");
				String code = getInput();
				System.out.println(repository.getPart(code));			
			}
			else if ("SHOWP".equals(choice)) {
				System.out.println("Digite o c�digo da pe�a");
				String code = getInput();
				System.out.println(repository.getPartAttributes(code));						
			}
			else if ("CLEARLIST".equals(choice)) {
				System.out.println(repository.addPart("nome1", "des1"));			
			}
			else if ("ADDSUBPART".equals(choice)) {
				System.out.println(repository.addPart("nome1", "des1"));
			}
			else if ("ADDP".equals(choice)) {
				
				System.out.print("Digite o nome da pe�a: ");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.print("Digite a descri��o da pe�a: ");
				String desc = scan.nextLine();
				
				System.out.println(repository.addPart(name, desc));				
			}
			else if ("QUIT".equals(choice)) {
				repository.stopServer();			
			}
			else {
				System.out.println("\nDigite um comando v�lido");
			}
		}

	}
		
	public static String getInput() {
		String input = scan.next();
		return input;
	}

}
