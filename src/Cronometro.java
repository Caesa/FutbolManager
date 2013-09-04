/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emi
 */
public class Cronometro extends Thread{
    
    int min = 0, seg = 0, ds = 0;//unidades de medida
          
        @Override
        public void run() {
            try {
                while (true) {//ciclo infinito
                    if (ds == 99) {//si los decisegundos son iguales a 99
                        ds = 0;//decisegundo vuelve a empezar en cero
                        seg++;//y aumenta un segundo
                    }
                    if (seg == 59) {//si los segundos son iguales a 59
                        seg = 0;//segundo vuelve a empezar en cero
                        min++;//y aumenta un minuto
                    }
                    if (min == 45) {//si los minutos son iguales a 59
                        min = 45;//minuto vuelve a empezar en cero
                        
                        Thread.interrupted();
                    }


                    ds = ds + 99;//aumentan las decimas de segundo


                    Thread.sleep(10);//que duerma una decima de segundo
                }
            } catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    
    
}
