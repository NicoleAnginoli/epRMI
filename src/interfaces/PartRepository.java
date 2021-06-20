package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PartRepository extends Remote {

	public String addPart(String name, String description) throws RemoteException;
	public String getPart(String partCode) throws RemoteException;
	public String getPartList() throws RemoteException;
	public double getSquareRoot(double input) throws RemoteException;
}
