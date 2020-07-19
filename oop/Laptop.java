/* Inheritance */
public class Laptop extends Product {
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