public class CheckingAccount implements Tax {
    private double balance;

    public CheckingAccount() {
        System.out.println("CheckingAccount!");
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double getTaxValue() {
        return balance + (balance * 0.03);
    }
}