public class DepositoCafes {
    private int capacidad;
    private int cafes;

    public DepositoCafes (int capacidad){
        this.capacidad=capacidad;
        this.cafes=0;
    }

    public synchronized void depositarCafe (String cafe) throws InterruptedException{
        // Comprobamos si hay espacio en el_deposito de cafes.
        while(cafes==capacidad){
            System.out.println("⚠️ Deposito de cafes lleno. Cafetera en espera ... ");
            wait();
        }

        cafes++;
        System.out.println("Cafetera deposita " + cafe + " En deposito:  " + cafes);
        notifyAll();
    }

    public synchronized void retirarCafe (String profesor) throws InterruptedException{
        while(cafes==0){
            System.out.println(profesor + " espera deposito vacio ... ");
            wait();
        }
        cafes--;
        String cafe = "Cafe-" + (cafes+1);
        System.out.println(profesor + " retira " + cafe + " en deposito: " + cafes);
        notifyAll();
    }
}
