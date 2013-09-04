
import java.io.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emi
 */
public class CrearArchivo {
    public void nuevoarchivocompleto(String nombreArchivo, String textouno, String textodos, String textotres, String textocuatro){
        File f;
        FileWriter escritordearchivo;
        
        //Escritura
        try{
            f = new File(nombreArchivo+".txt");
            escritordearchivo = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritordearchivo);
            PrintWriter salida = new PrintWriter(bw);
            salida.write("Datos generales del DT"+"\r\n"+"****************************************************"+"\r\n"+"Nombre: "+textouno+"\r\n"+"Equipo: "+textodos+"\r\n"+"Presupuesto disponible para transferencias: "+textotres+"\r\n"+"Edad: "+textocuatro);
            salida.close();
            bw.close();
        }
        catch(IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void nuevoarchivogardadotitulares(String nombreArchivo, String arquero, String lateralder, String centralder, String centralizq, String lateralizq, String volanteder, String volantecender, String volantecenizq, String volanteizq, String delder, String delizq){
        File f;
        FileWriter escritordearchivo;
        
        //Escritura
        try{
            f = new File(nombreArchivo+".txt");
            escritordearchivo = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritordearchivo);
            PrintWriter salida = new PrintWriter(bw);
            salida.write(arquero+"\r\n"+lateralder+"\r\n"+centralder+"\r\n"+centralizq+"\r\n"+lateralizq+"\r\n"+volanteder+"\r\n"+volantecender+"\r\n"+volantecenizq+"\r\n"+volanteizq+"\r\n"+delder+"\r\n"+delizq);
            salida.close();
            bw.close();
        }
        catch(IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void nuevoarchivogardadosuplentes(String nombreArchivo, String arquerosup, String defsup1, String defsup2, String medsup1, String medsup2, String delsup1, String delsup2){
        File f;
        FileWriter escritordearchivo;
        
        //Escritura
        try{
            f = new File(nombreArchivo+".txt");
            escritordearchivo = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritordearchivo);
            PrintWriter salida = new PrintWriter(bw);
            salida.write(arquerosup+"\r\n"+defsup1+"\r\n"+defsup2+"\r\n"+medsup1+"\r\n"+medsup2+"\r\n"+delsup1+"\r\n"+delsup2);
            salida.close();
            bw.close();
        }
        catch(IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    public void nuevoarchivoindividual(String nombreArchivo, String texto){
        File f;
        FileWriter escritordearchivo;
        
        //Escritura
        try{
            f = new File(nombreArchivo+".txt");
            escritordearchivo = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritordearchivo);
            PrintWriter salida = new PrintWriter(bw);
            salida.write(texto);
            salida.close();
            bw.close();
        }
        catch(IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}