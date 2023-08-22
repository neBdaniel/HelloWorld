public class Test {
    public static void main(String[] args) {
        CreditCard wallet[] = new CreditCard[10];
        wallet[0] = new CreditCard("5391 0375 9387 5309", "John Bowman", "California Savings", 0.0, 2500);
        wallet[1] = new CreditCard("3485 0399 3395 1954", "John Bowman", "California Federal", 0.0, 3500);
        wallet[2] = new CreditCard("6011 4902 3294 2994", "John Bowman", "California Finance", 0.0, 5000);
        for (int i=1; i<=16; i++){
            wallet[0].chargeIt((double)i);
            wallet[1].chargeIt(2.0*i); // implicit cast
            wallet[2].chargeIt((double)3*i); // explicit cast
        }
        for (int i=0; i<3; i++){
            CreditCard.printCard(wallet[i]);
            while (wallet[i].getBalance()>100.0){
                wallet[i].makePayment(100.0);
                System.out.println("New balance = " + wallet[i].getBalance());
            }
        }           
    }
}
