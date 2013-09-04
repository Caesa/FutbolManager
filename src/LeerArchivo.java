
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emi
 */
public class LeerArchivo {

    public String[] leerarray(String nombre){
        try {
            String[] jugadores = new String[11];
            File f;
            FileReader lectorArchivo;
            //Creamos el objeto del archivo que vamos a leer
            f = new File(nombre);
            //Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
            lectorArchivo = new FileReader(f);
            //Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
            BufferedReader br = new BufferedReader(lectorArchivo);
            //Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
            String aux = "";/*variable auxiliar*/
            for (int i=0; i<11; i++) {
                aux = br.readLine();
                if (aux != null) {
                    jugadores[i] =aux;
                } else {
                    break;
                }
            }
            br.close();
            lectorArchivo.close();
            return jugadores;
        }catch (IOException e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
        }
    
    public String[] leerarraysup(String nombre){
        try {
            String[] jugadores = new String[7];
            File f;
            FileReader lectorArchivo;
            //Creamos el objeto del archivo que vamos a leer
            f = new File(nombre);
            //Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
            lectorArchivo = new FileReader(f);
            //Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
            BufferedReader br = new BufferedReader(lectorArchivo);
            //Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
            String aux = "";/*variable auxiliar*/
            for (int i=0; i<7; i++) {
                aux = br.readLine();
                if (aux != null) {
                    jugadores[i] =aux;
                } else {
                    break;
                }
            }
            br.close();
            lectorArchivo.close();
            return jugadores;
        }catch (IOException e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
        }
    
    public String[] leerarrayequipos(String nombre){
        try {
            String[] equipos = new String[20];
            File f;
            FileReader lectorArchivo;
            //Creamos el objeto del archivo que vamos a leer
            f = new File(nombre);
            //Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
            lectorArchivo = new FileReader(f);
            //Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
            BufferedReader br = new BufferedReader(lectorArchivo);
            //Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
            String aux = "";/*variable auxiliar*/
            for (int i=0; i<20; i++) {
                aux = br.readLine();
                if (aux != null) {
                    equipos[i] =aux;
                } else {
                    break;
                }
            }
            br.close();
            lectorArchivo.close();
            return equipos;
        }catch (IOException e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
        }
    
    public String leerstring(String nombre){
        try {
            File f;
            FileReader lectorArchivo;
            //Creamos el objeto del archivo que vamos a leer
            f = new File(nombre);
            //Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
            lectorArchivo = new FileReader(f);
            //Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
            BufferedReader br = new BufferedReader(lectorArchivo);
            String l = "";
            //Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
            String aux = "";/*variable auxiliar*/
            for (int i=0; i<11; i++) {
                aux = br.readLine();
                if (aux != null) {
                    l =aux;
                } else {
                    break;
                }
            }
            br.close();
            lectorArchivo.close();
            return l;
        }catch (IOException e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
        }
    
    }
