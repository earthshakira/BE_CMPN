 import java.rmi.*;

public interface ReceiveMessageInterface extends Remote{
  String receiveMessage(String x) throws RemoteException;
  Double add(Double x,Double y) throws RemoteException;
  Double sub(Double x,Double y) throws RemoteException;
  Double mul(Double x,Double y) throws RemoteException;
  Double div(Double x,Double y) throws RemoteException;
}
