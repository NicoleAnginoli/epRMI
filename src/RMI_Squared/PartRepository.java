package RMI_Squared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PartRepository extends Remote {
	public double getSquare(double input) throws RemoteException;
	public double getSquareRoot(double input) throws RemoteException;
	
}
