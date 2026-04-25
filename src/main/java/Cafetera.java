public class Cafetera extends Thread{
    private DepositoCafes deposito;
    private int totalCafes;

    public Cafetera(DepositoCafes deposito, int totalCafes){
        this.deposito=deposito;
        this.totalCafes=totalCafes;
    }

    public void run (){
        for (int i = 1; i < totalCafes; i++) {
            try {
                Thread.sleep((int)(Math.random()*1000));

                String cafe = "Cafe- "  + i;
                deposito.depositarCafe(cafe);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
