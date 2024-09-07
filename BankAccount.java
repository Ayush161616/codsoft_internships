import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        this.balance=initialBalance;

    }
    public double getBalance(){
        return balance;

    }
    public void deposit(double amount){
        balance+=amount;
    }
    public boolean withdraw(double amount){
        if (amount<=balance){
            balance-=amount;
            return true;
        }else {
            return false;
        }
    }
}
class ATM{
    private BankAccount account;
    public ATM(BankAccount account){
        this.account=account;
    }
    public boolean withdraw(double amount){
        return account.withdraw(amount);

    }
    public void deposit(double amount){
        account.deposit(amount);
    }
    public double checkBalance(){
        return account.getBalance();
    }

}
 class ATMGUI{
    private ATM atm;
    private ATMGUI(ATM atm){
        this.atm=atm;
        JFrame frame = new JFrame("ATM Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        JButton withdrawButton = new JButton("Withdraw");
        JButton dipositButton = new JButton("Deposit");
        JButton balanceButton = new JButton("Check Balance");
        JLabel resultLabel = new JLabel(" ");
        panel.add(withdrawButton);
        panel.add(dipositButton);
        panel.add(balanceButton);
        panel.add(resultLabel);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountString = JOptionPane.showInputDialog("Enter Ammount to Withdraw: ");
                try {
                    double ammount = Double.parseDouble(amountString);
                    boolean success = atm.withdraw(ammount);
                    if(success){
                        resultLabel.setText("Withdraw successfull . New balance: "+atm.checkBalance());

                    }
                    else {
                        resultLabel.setText("Insuffiecient Funds. Current balance: "+atm.checkBalance());
                    }
                } catch (NumberFormatException ex){
                    resultLabel.setText("Invalid input. Please Enter the valid number.");


                }
            }
        });
        dipositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountString = JOptionPane.showInputDialog("Enter Ammount to deposit: ");
                try {
                    double amount = Double.parseDouble(amountString);
                    atm.deposit(amount);
                    resultLabel.setText("Deposit successfull. New Balance"+atm.checkBalance());
                }catch (NumberFormatException ex){
                    resultLabel.setText("Invalid input. Please Enter the valid number.");

                }
            }
        });
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Current Balance: ");

            }
        });
        frame.add(panel);
        frame.setVisible(true);

    }

     public static void main(String[] args) {
         BankAccount account = new BankAccount(1000);
         //Initial balance is 1000
         ATM atm = new ATM(account);
         new ATMGUI(atm);
     }
}
