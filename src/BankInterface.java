import java.rmi.*;

public interface BankInterface extends Remote {
    double checkBalance(String accountNumber) throws RemoteException;
    void deposit(String accountNumber, double amount) throws RemoteException;
    boolean withdraw(String accountNumber, double amount) throws RemoteException;
}
