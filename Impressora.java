package theadsjava;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class Impressora implements Runnable{
    private final Armazem umAm;
    
    public Impressora(Armazem umAm){
        this.umAm=umAm;
    }
    
    public synchronized void run(){
        for(int i =0;i<50;i++){
            
            umAm.getBloq().lock();
            try{
                while(umAm.getMutex() == 0){
                    umAm.foiGerado.await();
                }
                
                System.out.println(umAm.getN());
                umAm.foiImpresso.signal();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                umAm.setMutex(0);
                umAm.getBloq().unlock();
            }
            
            
            
                
           }
            
        
    }
}