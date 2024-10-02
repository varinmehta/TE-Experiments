import java.util.*;

public class Test{
    public interface User {
        String name = "";
        String address = "";
        int mobile_no = 0;
        String email ="";
        int age = 0;
    }
    public class IndividualInvestor implements User {
        private int investorId;
        public void viewMarketData() {}
        public void viewPortfolio() {}
        public void buyInvestment() {}
        public void sellInvestment() {}
    }
    public class WealthManager implements User {
        private int managerId;
        public void manageClients() {}
        public void generateReport() {}
        public void buyInvestment(Client client, Investment investment) {}
        public void sellInvestment(Client client, Investment investment) {}
    }
    public class Client implements User {
        private int clientId;
        private Portfolio portfolio;
        public void viewPortfolio() {}
    }
    public class StockExchange {
        public MarketData provideMarketData() { return new MarketData(); }
    }
    public class MarketData {
        private String stockSymbol;
        private double currentPrice;
        private String news;
    }
    public class Portfolio {
        private List<Investment> investments;
        public void addInvestment(Investment investment) {}
        public void removeInvestment(Investment investment) {}
        public List<Investment> getInvestments() { return investments; }
    }
    public class Investment {
        private String investmentName;
        private double amount;
        private double price;
    }
    public class Transaction {
        private Investment investment;
        private String type; // Buy or Sell
        private double amount;
        public void execute() {}
    }
    public class Report {
        private String reportID;
        private Portfolio portfolio;
        private String reportType;
        private Date reportDate;
        public void generate(){}
        public void viewReportDetails(){}
    }


}