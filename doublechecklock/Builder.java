import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
class Builder{
    public int createNumber = 0;
    public AtomicInteger getNumber = new AtomicInteger(0);
    Random rand = new Random(47);
    //private volatile PartiallyInitializedObject partiallyInitializedObject;
    private PartiallyInitializedObject partiallyInitializedObject;

    public PartiallyInitializedObject get(){
        getNumber.incrementAndGet();
        return partiallyInitializedObject;
    }

    public void initialize(){
        partiallyInitializedObject = new PartiallyInitializedObject(rand.nextInt(20)+5 , rand.nextInt(20) +6);
        createNumber++;
    }
}
