import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class BankServer extends UnicastRemoteObject implements BankInterface {
    private HashMap<String, Double> accounts;

    protected BankServer() throws RemoteException {
        super();
        accounts = new HashMap<>();
        accounts.put("123", 1000.0);
        accounts.put("456", 2000.0);
        accounts.put("789", 3000.0);
    }
    @Override
    public double checkBalance(String accountNumber) throws RemoteException {
        logRequest("checkBalance", accountNumber);
        return accounts.getOrDefault(accountNumber, -1.0);
    }
    @Override
    public void deposit(String accountNumber, double amount) throws RemoteException {
        logRequest("deposit", accountNumber, amount);
        accounts.put(accountNumber, accounts.get(accountNumber) + amount);
    }
    @Override
    public boolean withdraw(String accountNumber, double amount) throws RemoteException {
        logRequest("withdraw", accountNumber, amount);
        if (accounts.get(accountNumber) >= amount) {
            accounts.put(accountNumber, accounts.get(accountNumber) - amount);
            return true;
        }
        return false;
    }
    private void logRequest(String operation, String accountNumber) {
        logRequest(operation, accountNumber, -1.0);
    }
    private void logRequest(String operation, String accountNumber, double amount) {
        try {
            String clientIp = getClientHost();
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  // Get current Date-Time
            System.out.println("[" + timestamp + "] " + "Request from " + clientIp + " - Operation: " + operation + ", Account: " + accountNumber + (amount >= 0 ? ", Amount: " + amount : ""));
        } catch (ServerNotActiveException e) {
            System.out.println("Unable to retrieve client IP address: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        try {
            BankServer server = new BankServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("BankService", server);
            System.out.println("Bank server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
