public class CrossCond {
    public static void main(String[] args) {
        Bridge b = new Bridge();
        int rcars = 3;
        int bcars = 2;
        RedCar r[] = new RedCar[rcars];
        BlueCar bl[] = new BlueCar[bcars];

        for (int i = 0; i < rcars; i++) {
            r[i] = new RedCar(b);
            r[i].start();
        }

        for (int i = 0; i < bcars; i++) {
            bl[i] = new BlueCar(b);
            bl[i].start();
        }
        for (int i = 0; i < rcars; i++)
            try {
                r[i].join();
            } catch (InterruptedException e) {
            }
        for (int i = 0; i < bcars; i++)
            try {
                bl[i].join();
            } catch (InterruptedException e) {
            }
    }

}