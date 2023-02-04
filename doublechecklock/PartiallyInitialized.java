import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;



public class PartiallyInitialized {
    static class Initialize implements Runnable{
        Builder builder;
        public Initialize(Builder builder){
            this.builder = builder;
        }
        @Override
        public void run() {
            while(!Thread.interrupted()){
                builder.initialize();
            }
        }
    }
    static class GetObject implements Runnable{
        static int count =0;
        final int id = count++;
        CyclicBarrier cyclicBarrier;
        Builder builder;
        public GetObject(CyclicBarrier c, Builder builder){
            cyclicBarrier = c;
            this.builder = builder;
        }
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                PartiallyInitializedObject p = builder.get();
                if (p!=null && p.n <= 0) {
                    System.out.println("Thread " + id +" Find Partially Initialized Object " + p.n);
                    Thread.currentThread().interrupt();
                }
		if (p!=null && p.m <=0 ) {
                    System.out.println("Thread " + id +" Find Partially Initialized Object " + p.n);
                    Thread.currentThread().interrupt();
                }
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + id +" Interrupted");
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException{
        // first initialize(), second get()
        // 1 initialize(), 9 get()
        Builder builder = new Builder();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService exec = Executors.newFixedThreadPool(10);

        exec.execute(new Initialize(builder));
        for(int i=0; i<9; i++){
            exec.execute(new GetObject(cyclicBarrier, builder));
        }
        // exec.execute(new Initialize(builder));
        try {
            cyclicBarrier.await(20, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("No Partially Initialized Object Found");
        }
        exec.shutdownNow();
        System.out.println("Builder create "+builder.createNumber +" Object And Try to get "+ builder.getNumber.get()+ " times");
    }
}
