import java.util.concurrent.Semaphore;

class RedCar extends Thread {
    private final Semaphore mySemaphore;
    private final Semaphore nextSemaphore;
    int waitscale = 100;
    int inscale = 1000;

    public RedCar(Semaphore mySemaphore, Semaphore nextSemaphore) {
        this.mySemaphore = mySemaphore;
        this.nextSemaphore = nextSemaphore;
        this.setName("Red Car");
    }

    public void run() {
        try {

            for (int i = 0; i < 100; i++) {
                this.mySemaphore.acquire();
                try {
                    Thread.sleep((int) (Math.random() * waitscale));
                } catch (InterruptedException e) {}
                System.out.println(Thread.currentThread().getName() + " --- wait");
                System.out.println(Thread.currentThread().getName() + " >>>     Crossing");
                try {
                    Thread.sleep((int) (Math.random() * inscale));
                } catch (InterruptedException e) {}
                System.out.println(Thread.currentThread().getName() + " <<<         exit");
                this.nextSemaphore.release();
            }
        } catch (InterruptedException e) {
        }

    }

}