import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class PartiallyInitializedObject{
    static long counter;
    // final field will avoid partiallyInitializedObject
    // final long id = counter++;
    public int n;
    public int m;
    public PartiallyInitializedObject(int n , int m){
        this.n = n;
	this.m = m;
    }
}

