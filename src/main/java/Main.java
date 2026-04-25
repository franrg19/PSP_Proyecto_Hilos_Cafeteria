public class Main {
    public static void main(String[] args) {
        DepositoCafes depositoCafes = new DepositoCafes(5);
        Cafetera cafetera = new Cafetera(depositoCafes,20);
        Profesor p1= new Profesor(depositoCafes,"Ana",7);
        Profesor p2= new Profesor(depositoCafes,"Fran",7);
        Profesor p3= new Profesor(depositoCafes,"Maria",6);


        cafetera.start();
        p1.start();
        p2.start();
        p3.start();


    }
}
