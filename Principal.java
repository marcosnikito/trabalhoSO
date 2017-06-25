
package theadsjava;

/**
 *
 * @author Marcos
 */
public class Principal {
    public static void main(String[] args) {
        Armazem armazem = new Armazem();
        armazem.setN(0);
        Contador cont = new Contador(armazem);
        Impressora impressora = new Impressora(armazem);
        Thread thread1 = new Thread(cont);
        Thread thread2 = new Thread(impressora);
        
        thread1.start();
        thread2.start();
        
    }
    
}