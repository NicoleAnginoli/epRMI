package RMI_Squared;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMI_SquaredServer extends UnicastRemoteObject implements PartRepository {

	public RMI_SquaredServer() throws RemoteException {
		super();
	}

	@Override
	public double getSquare(double input) {
		return input * input;
	}

	@Override
	public double getSquareRoot(double input) {
		return Math.sqrt(input);
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(7777);
		registry.bind("squared", new RMI_SquaredServer());
		System.out.println("running");

	}

}
