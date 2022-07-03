public class Store {

    private final int SIZECARSHOP = 3;
    private int product = 0;

    //метод покупки авто
    public synchronized void get(int idBayer) {
        while (product < 1) {
            try {
                System.out.println("Машин нет");
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель " + idBayer + " уехал на новеньком авто");
        notify();
    }

    //метод производства авто
    public synchronized void put() {
        while (product >= SIZECARSHOP) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель Toyota выпустил 1 авто");
        System.out.println("Машин на складе: " + product);
        notify();
    }
}