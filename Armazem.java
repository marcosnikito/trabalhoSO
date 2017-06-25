package theadsjava;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Marcos
 */
public class Armazem {
    private static int n;
    private int mutex;
    private final Lock bloq = new ReentrantLock(true);
    protected final Condition foiGerado = bloq.newCondition();
    protected final Condition foiImpresso = bloq.newCondition();

    public int getMutex() {
        return mutex;
    }

    public void setMutex(int mutex) {
        this.mutex= mutex;
    }
    public Armazem(){
        mutex=0;
    }

    public Lock getBloq() {
        return bloq;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        Armazem.n = n;
    }
    
    
}
    
