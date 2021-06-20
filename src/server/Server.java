package server;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import helper.PartList;
import impl.PartImpl;
import interfaces.Part;
import interfaces.PartRepository;

public class Server extends UnicastRemoteObject implements PartRepository{
	
	private String serverName;
	
	private Integer partsQuantity;
	
	private PartRepository partRepository;
	
	private PartList partList;
	
	private Registry registry;
	
	public Server() throws RemoteException {
		super();
	}
	
	public Server(String name) throws RemoteException, AlreadyBoundException{
		this.serverName = name;
		//this.partRepository = new PartRepositoryImpl(this);
		this.partList = new PartList();
		//PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(partRepository,0);
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(7777);
		registry.bind("rmiServer", new Server("nome"));
		System.out.println("O servidor está rodando...");
	}
	
	public void stopServer() throws RemoteException, NotBoundException {
		registry = LocateRegistry.getRegistry();
		registry.unbind(this.serverName);
		System.out.println("Servidor "+this.serverName+" finalizado.");

	}

	@Override
	public String addPart(String name, String description) throws RemoteException {
		Part part = new PartImpl(name, description);
		part.setPartRepository(partRepository);
		this.partList.addPart(part);
		return "A peça de código "+part.getPartCode()+" foi criada";
	}
	
	@Override
	public String getPartAttributes(String partCode) throws RemoteException {
		StringBuilder strBuilder = new StringBuilder("Part: ");
		for (Part part : partList.getParts()) {
			if (part.getPartCode().contentEquals(partCode)) {
				strBuilder.append("\n ref: " + part);
				strBuilder.append("\n code: " + part.getPartCode());
				strBuilder.append("\n name: " + part.getPartName());
				strBuilder.append("\n description: " + part.getPartDescription());
				return strBuilder.toString();
			}	
		}
		return "Não existe uma peça com esse código";
	}
	
	@Override
	public Part getPart(String partCode) throws RemoteException {
		for (Part part : partList.getParts()) {
			if (part.getPartCode().contentEquals(partCode)) {
				return part;
			}	
		}
		return null;
	}

	@Override
	public String getPartList() throws RemoteException {
		StringBuilder strBuilder = new StringBuilder("Parts: ");
		
		if(partList.getParts().isEmpty()) {
			return "Não há nenhuma peça na lista";
		}
		
		for (Part part : partList.getParts()) {
			strBuilder.append("\n "+part.getPartCode());
		}
		
		return strBuilder.toString();
	}

}
