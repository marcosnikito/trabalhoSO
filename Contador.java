package theadsjava;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class Contador implements Runnable{
    private Armazem umAm;
   

    public Contador(Armazem umAm) {
        this.umAm=umAm;
        
    }

    public synchronized void run() {
        for(int i=0;i<50;i++){
            umAm.getBloq().lock();
            
            
            try {
                while(umAm.getMutex() == 1){
                    umAm.foiImpresso.await();
                }
                umAm.setN(i);
                umAm.foiGerado.signal();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                umAm.setMutex(1);
                umAm.getBloq().unlock();
            }
            
            
            
            
        }
    } 
    
}
