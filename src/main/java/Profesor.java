public class Profesor extends Thread{

    //La clase profesor será la consumidora
    private String nombre;
    private DepositoCafes deposito;
    private int cafesAConsumir;

    public Profesor (DepositoCafes deposito, String nombre, int cafesAConsumir){
        this.deposito=deposito;
        this.nombre=nombre;
        this.cafesAConsumir=cafesAConsumir;
    }

    public void run(){
        for (int i = 0; i < cafesAConsumir; i++) {
            try {
                deposito.retirarCafe("Profesor: " + nombre);

                Thread.sleep((int)(Math.random()*1500));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
