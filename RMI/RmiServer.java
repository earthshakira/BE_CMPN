import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;

public class RmiServer extends java.rmi.server.UnicastRemoteObject implements ReceiveMessageInterface{
	String address;
	Registry registry; 
	
	public String receiveMessage(String x) throws RemoteException{
		System.out.println(x);
		return x.toLowerCase();
	}
	
	public Double add(Double x,Double y)  throws RemoteException{
		System.out.println("Adding "+x+" and "+y+" :");
		return x+y;
	}
	
	public Double sub(Double x,Double y)  throws RemoteException{
		System.out.println("Subtracting "+x+" and "+y+" :");
		return x-y;
	}
	
	public Double mul(Double x,Double y)  throws RemoteException{
		System.out.println("Multiplying "+x+" and "+y+" :");
		return x*y;
	}
	
	public Double div(Double x,Double y)  throws RemoteException{
		System.out.println("Dividing "+x+" and "+y+" :");
		return x/y;
	}
	
	
	
	public RmiServer() throws RemoteException{
		try{  
			address = (InetAddress.getLocalHost()).toString();
		}
		catch(Exception e){
			System.out.println("can't get inet address.");
		}
		int port=3232; 
		System.out.println("this address=" + address +  ",port=" + port);
		try{
			registry = LocateRegistry.createRegistry(port);
			registry.rebind("rmiServer", this);
		}
		catch(RemoteException e){
			System.out.println("remote exception"+ e);
		}
	}
	static public void main(String args[]){
		try{
			RmiServer server = new RmiServer();
		}
		catch (Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
