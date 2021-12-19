package monitor;

import java.util.concurrent.TimeUnit;

public class TimeMonitor {

    private long start;
    private long finish;

    public void go(){
        //Przerwa w programie na zakończenie poprzednich działań CPU
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        this.start = System.nanoTime();
    }

    public void stop(){
        this.finish = System.nanoTime();
    }

    public double getMiliSec(){

        return TimeUnit.MILLISECONDS.convert((this.finish - this.start),TimeUnit.NANOSECONDS);
    }
}
