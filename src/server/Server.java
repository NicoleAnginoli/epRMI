package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import helper.PartList;
import impl.PartImpl;
import impl.PartRepositoryImpl;
import interfaces.Part;
import interfaces.PartRepository;

public class Server extends UnicastRemoteObject implements PartRepository{
	
	private String serverName;
	
	private Integer partsQuantity;
	
	private PartRepositoryImpl partRepository;
	
	private PartList partList;
	
	public Server() throws RemoteException {
		super();
	}
	
	public Server(String name) throws RemoteException, AlreadyBoundException{
		this.serverName = name;
		this.partRepository = new PartRepositoryImpl(this);
		this.partList = new PartList();
		PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(partRepository,0);
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(7777);
		registry.bind("squared", new Server("nome"));
		System.out.println("running");
	}

	@Override
	public String addPart(String name, String description) throws RemoteException {
		Part part = new PartImpl(name, description);
		part.setPartRepository(partRepository);
		this.partList.addPart(part);
		return part.getPartCode();
	}
	
	@Override
	public String getPart(String partCode) throws RemoteException {
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
		return null;
	}
	

	@Override
	public double getSquareRoot(double input) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Integer getQuantityOfParts() {
		return this.partsQuantity;
	}

	@Override
	public String getPartList() throws RemoteException {
		StringBuilder strBuilder = new StringBuilder("Parts: ");
		
		for (Part part : partList.getParts()) {
			strBuilder.append(part.getPartCode()+", ");
		}
		
		return strBuilder.toString();
	}

}
