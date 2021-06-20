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
			System.out.println("Você está conectado");
			System.out.println("O que deseja fazer?");
			System.out.println("BIND (conectar com um servidor)"); // TO DO
			System.out.println("LISTP (listar as peças)"); // DONE
			System.out.println("GETP (busca uma peça)"); // DONE
			System.out.println("SHOWP (mostrar os atributos de uma peça)"); // DONE
			System.out.println("CLEARLIST (limpa a lista de sub-peças)"); // TO DO
			System.out.println("ADDSUBPART (adiciona n unidades de peças à lista de sub-peças)"); // TO DO
			System.out.println("ADDP (adiciona uma peça)"); // DONE
			System.out.println("QUIT (encerrar a execução)"); // ERRO
			 
			/* TODO 
			 * Conectar um cliente com mais de um servidor
			 * pegar a ref de uma peça e adicionar em outro servidor (pelo o que eu entendi add como sub peça)
			 * 
			 * lista de subParts - Uma parte pode ter uma lista de sub componentes 
			 * subc componentes são objetos parts também e podem estar espalhados por multiplos servidores
			 * se a peça não tem subc componentes, ela é primitiva 
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
				System.out.println("Digite o código da peça");
				String code = getInput();
				System.out.println(repository.getPart(code));			
			}
			else if ("SHOWP".equals(choice)) {
				System.out.println("Digite o código da peça");
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
				
				System.out.print("Digite o nome da peça: ");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.print("Digite a descrição da peça: ");
				String desc = scan.nextLine();
				
				System.out.println(repository.addPart(name, desc));				
			}
			else if ("QUIT".equals(choice)) {
				repository.stopServer();			
			}
			else {
				System.out.println("\nDigite um comando válido");
			}
		}

	}
		
	public static String getInput() {
		String input = scan.next();
		return input;
	}

}
