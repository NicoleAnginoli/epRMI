package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaces.PartRepository;

public class Server extends UnicastRemoteObject implements PartRepository {

	public Server() throws RemoteException {
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
		registry.bind("squared", new Server());
		System.out.println("running");

	}

}
