import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.*;
public class RmiClient{
	static public void main(String args[]) {
		ReceiveMessageInterface rmiServer;
		Registry registry;
		String serverAddress=args[0];
		String serverPort=args[1];
		Scanner scr =  new Scanner(System.in);
		int ch;
		boolean exit = false;
		double x,y;
		System.out.println("Connecting to " +serverAddress + ":" + serverPort);
		try{
			registry=LocateRegistry.getRegistry(serverAddress,(new Integer(serverPort)).intValue());
			rmiServer=(ReceiveMessageInterface)(registry.lookup("rmiServer"));
			// call the remote method
//			rmiServer.receiveMessage(text);
			while(true){
				Double result=0.0;
				System.out.println("*************************************************");
				System.out.println("					Main Menu");
				System.out.println("*************************************************");
				System.out.println("		1.Plain Message");
				System.out.println("		2.Add");
				System.out.println("		3.Subtract");
				System.out.println("		4.Multiply");
				System.out.println("		5.Divide");
				System.out.println("		6.Plain Message");
				System.out.println("*************************************************");
				System.out.print("Enter Choice : ");
				ch=scr.nextInt();
				if(ch==1){
					System.out.print("Enter the message : ");					
					String message = scr.nextLine();
					String response=rmiServer.receiveMessage(message);
					System.out.println("Server: "+response);					
					continue;
				}
				if(ch!=6){
					System.out.print("Enter the 2 numbers : ");
					x=scr.nextDouble();
					y=scr.nextDouble();
				}
				switch(ch){
					case 2:result = rmiServer.add(x,y);
					break;
					case 3:result = rmiServer.sub(x,y);
					break;
					case 4:result = rmiServer.mul(x,y);
					break;
					case 5:result = rmiServer.div(x,y);
					break;
					case 6:
					default:System.out.println("Exiting...");
					exit = true;
				}
				
				if(exit)
					break;
				else System.out.println("Result: "+result);
			}
			
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		catch(NotBoundException e){
			System.err.println(e);
		}
	}
}
 
