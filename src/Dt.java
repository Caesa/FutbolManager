/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emi
 */
public class Dt {
    String nombre, contfis, equipo;
    int edad, sueldo, presupuesto;

    public Dt(String nombre, String contfis, String equipo, int edad, int sueldo, int presupuesto) {
        this.nombre = nombre;
        this.contfis = contfis;
        this.equipo = equipo;
        this.edad = edad;
        this.sueldo = sueldo;
        this.presupuesto = presupuesto;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContfis() {
        return contfis;
    }

    public void setContfis(String contfis) {
        this.contfis = contfis;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
