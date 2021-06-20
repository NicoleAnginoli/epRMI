package interfaces;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PartRepository extends Remote {

	public String addPart(String name, String description) throws RemoteException;
	public String getPartAttributes(String partCode) throws RemoteException;
	public Part getPart(String partCode) throws RemoteException;
	public String getPartList() throws RemoteException;
	public void stopServer() throws RemoteException, NotBoundException;
	
}
