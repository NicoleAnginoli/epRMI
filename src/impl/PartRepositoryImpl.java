package impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import interfaces.Part;
import interfaces.PartRepository;
import server.Server;

public class PartRepositoryImpl {

	private List<Part> parts;

	private String repositoryName;
	private Server server;
	
	private Server servidor;
	
	public PartRepositoryImpl(Server server) {
		this.server = server;
		this.parts = new ArrayList<Part>();
		this.repositoryName = "1";
	}
//	@Override
//	public String addPart(String name, String description) {
//		PartImpl parts = new PartImpl();
//		parts.setPartName(name);
//		parts.setPartDescription(description);
//		return parts.getPartCode();
//	}
//
//	@Override
//	public double getSquareRoot(double input) {
//		return Math.sqrt(input);
//	}
//
//	@Override
//	public String getPart(String partCode) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPartList() throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
