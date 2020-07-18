class Product {
    private String name;
    private double price;

    public Product() {
        System.out.println("Product!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /* Overriding */
    public void description() {
        System.out.println("Name: " + name + " - Price: " + price);
    }

    /* Overloading */
    public double calcTax(double tax) {
        return tax == 0 ? price : price * tax;
    }
}

/* Inheritance */
class Laptop extends Product {
    private String cpu;
    private String ram;

    public Laptop() {
        System.out.println("Laptop!");
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    /* Overriding */
    public void description() {
        System.out.println("Name: " + getName() + " - Price: " + getPrice() + " - CPU: " + cpu + " - RAM: " + ram);
    }

    /* Overloading */
    public double calcTax(double tax, double subTax) {
        return (tax == 0 || subTax == 0) ? getPrice() : (getPrice() * tax * subTax);
    }
}

abstract class Animal {
    public abstract void animalSound();
    
    public void sleep() {
        System.out.println("Zzz");
    }
}

class Pig extends Animal {

    public Pig() {
        System.out.println("Pig!");
    }

    @Override
    public void animalSound() {
        System.out.println("Sound: wee wee");
    }
    
}

interface Tax {
    public double getTaxValue();
}

class CheckingAccount implements Tax {

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

class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Product Name");
        product.setPrice(33.7);
        product.description();
        System.out.println(product.calcTax(2));
        System.out.println(product.calcTax(0));

        System.out.println();

        Laptop laptop = new Laptop();
        laptop.setName("Laptop name");
        laptop.setPrice(88.1);
        laptop.setCpu("i5");
        laptop.setRam("8gb");
        laptop.description();
        System.out.println(laptop.calcTax(2, 3));
        System.out.println(laptop.calcTax(2));

        System.out.println();

        Pig pig = new Pig();
        pig.animalSound();
        pig.sleep();

        System.out.println();

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(100);
        System.out.println(checkingAccount.getTaxValue());
    }
}