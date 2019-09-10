import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
public class Bridge{

    int capacity = 1;
    int spaces = capacity;
        private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private Condition priority = lock.newCondition();
    int waitscale = 100;
        int inscale = 10000;

        void arrive () {
            //Car arrival
            try {
               Thread.sleep((int)(Math.random()*waitscale));
            } catch (InterruptedException e) { }
            System.out.println(Thread.currentThread().getName()+" --- wait");
            //Car waiting
            lock.lock();
            try {
                while (spaces == 0) {
        		try {       priority.await();
                        	cond.await();
			} catch (InterruptedException e) { }
    		}
                //Car entering
                System.out.println(Thread.currentThread().getName()+" >>>     Crossing");
                //Decrement capacity
                spaces--;
                //Tell everybody
            	cond.signal();
            } finally {
               	lock.unlock() ;
            }
        }
        
        void depart () {
            //Car departure
            lock.lock();
            try {
                while (spaces == capacity) 
                      try {
                       		cond.await();
		      } catch (InterruptedException e) { }
		//Car exiting
                System.out.println(Thread.currentThread().getName()+" <<<         Exited the Bridge");
                //Increment capacity
                spaces++;
                //Tell everybody
                cond.signalAll();
            } finally {
               	lock.unlock() ;
            }    
        }
           
        void cross() {    
            try {
                Thread.sleep((int)(Math.random()*inscale));
            } catch (InterruptedException e) { }
       }
}