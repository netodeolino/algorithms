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