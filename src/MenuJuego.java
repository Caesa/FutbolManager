
import java.awt.Point;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emi
 */
public class MenuJuego extends javax.swing.JFrame {

    DefaultListModel listModelTit = new DefaultListModel();//lista para los titulares
    DefaultListModel listModelEquipos = new DefaultListModel();//lista para los equipos en la tabla de posiciones
    DefaultListModel listModelPuntos = new DefaultListModel();//lista para los puntos en la tabla de posiciones
    DefaultListModel listModelSup = new DefaultListModel();//lista para los suplentes
    String[] titulares = new String[11];
    String[] suplentes = new String[7];
    String formacselec = "4-4-2";//variable para la formacion seleccionada
    int equiposelec = 0;
    String[] todoslosequipos = new String[20];//array contenedor de todos los equipos
    String[] contrincantes = new String[19];//array contenedor de los contrincantes
    LeerArchivo a = new LeerArchivo();
    CrearArchivo s = new CrearArchivo();
    String miequipo = a.leerstring("Equipo del DT.txt");//variable para mi equipo
    int pjugados = 0;
    String equipocontrario = contrincantes[pjugados];
    int cr = 0;
    int min = 0;
    int seg = 0;
    int dec = 0;
    // Aquí se pone en marcha el timer cada segundo. 
    Timer timer = new Timer();
    TimerTask timerTask;
    Random random = new Random();
    int misgoles = 0;
    int susgoles = 0;
    int[] puntos = new int[20];
    int jugadorseleccionado = 0;//variable para saber que jugador deseo cambiar

    /**
     * Creates new form MenuJuego
     */
    public MenuJuego() {
        initComponents();
        setLocationRelativeTo(null);
        for (int i = 0; i < puntos.length; i++) {//seteo los equipos y  los puntos en la tabla de posiciones
            System.out.println(puntos[i]);
            listModelEquipos.addElement(todoslosequipos[i]);
            listModelPuntos.addElement(puntos[i]);
        }
        todoslosequipos = a.leerarrayequipos("Equipos.txt");
        int cont = 0;
        System.out.println("Mi equipo: " + miequipo);
        for (int i = 0; i < todoslosequipos.length; i++) {
            System.out.println("todos " + i + " : " + todoslosequipos[i]);
            if (!todoslosequipos[i].equals(miequipo)) {
                contrincantes[cont] = todoslosequipos[i];
                System.out.println("contra " + cont + " : " + contrincantes[cont]);
                cont++;
            }

        }
        btnSegTiempo.setVisible(false);
        lblContrincanteNombre.setText(equipocontrario);
        lblMiEquipoNombre.setText(miequipo);
        lstTitulares.setModel(listModelTit);
        lstEquiposTabla.setModel(listModelEquipos);
        lstPuntos.setModel(listModelPuntos);
        lstSuplentes.setModel(listModelSup);
        lblFormacionActual.setText("" + cmbxFormaciones.getSelectedItem());
        cmbxFormaciones.setEnabled(false);
        lblImagenForm.setEnabled(false);
        btnGuardarForm.setEnabled(false);
        LeerArchivo a = new LeerArchivo();
        String equipo = a.leerstring("Equipo del DT.txt");
        if (equipo.equals("All Boys")) {
            equiposelec = 1;
            titulares = a.leerarray("All Boys Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("All Boys Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Argentinos")) {
            equiposelec = 2;
            titulares = a.leerarray("Argentinos Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Argentinos Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Arsenal")) {
            equiposelec = 3;
            titulares = a.leerarray("Arsenal Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Arsenal Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Atlético Rafaela")) {
            equiposelec = 4;
            titulares = a.leerarray("Atl Rafaela Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Atl Rafaela Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Belgrano")) {
            equiposelec = 5;
            titulares = a.leerarray("Belgrano Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Belgrano Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Boca")) {
            equiposelec = 6;
            titulares = a.leerarray("Boca Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Boca Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Colon")) {
            equiposelec = 7;
            titulares = a.leerarray("Colon Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Colon Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Estudiantes")) {
            equiposelec = 7;
            titulares = a.leerarray("Estudiantes Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Estudiantes Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Colon")) {
            equiposelec = 7;
            titulares = a.leerarray("Colon Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Colon Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Godoy Cruz")) {
            equiposelec = 7;
            titulares = a.leerarray("Godoy Cruz Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Godoy Cruz Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Independiente")) {
            equiposelec = 7;
            titulares = a.leerarray("Independiente Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Independiente Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Lanus")) {
            equiposelec = 7;
            titulares = a.leerarray("Lanus Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Lanus Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Newells")) {
            equiposelec = 7;
            titulares = a.leerarray("Newells Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Newells Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Quilmes")) {
            equiposelec = 7;
            titulares = a.leerarray("Quilmes Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Quilmes Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Racing")) {
            equiposelec = 7;
            titulares = a.leerarray("Racing Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Racing Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("River")) {
            equiposelec = 7;
            titulares = a.leerarray("River Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("River Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("San Lorenzo")) {
            equiposelec = 7;
            titulares = a.leerarray("San Lorenzo Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("San Lorenzo Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("San Martín de San Juan")) {
            equiposelec = 7;
            titulares = a.leerarray("SM de SJ Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("SM de SJ Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Tigre")) {
            equiposelec = 7;
            titulares = a.leerarray("Tigre Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Tigre Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Union")) {
            equiposelec = 7;
            titulares = a.leerarray("Union Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Union Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
        if (equipo.equals("Velez")) {
            equiposelec = 7;
            titulares = a.leerarray("Velez Titulares.txt");
            for (int i = 0; i < 11; i++) {
                listModelTit.addElement(titulares[i]);
            }
            suplentes = a.leerarraysup("Velez Suplentes.txt");
            for (int i = 0; i < 7; i++) {
                listModelSup.addElement(suplentes[i]);
            }
        }
    }
    /* Inicia el timer
     * 
     */

    private void startTimer() {//cronometro del partido
        min = 0;
        seg = 0;
        dec = 0;
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                runTask();
            }
        };
        // Dentro de 0 milisegundos avísame cada 1000 milisegundos 
        timer.scheduleAtFixedRate(timerTask, 0, 10);
    }
    /*
     * Frena el timer
     */

    private void stopTimer() {

        timer.cancel();
        timerTask = null;
        timer = null;
    }

    /*
     * Reiniciar el contador del tiempo en juego
     */
    private void restartTimer() {
        min = 0;
        seg = 0;
        dec = 0;
    }

    /*
    
     /*
     * Se habilita cada 1 segundo.
     */
    private void runTask() {//cronometro del partido en donde se determinan cuando se convertiran los goles dependiendo de la cantidad

        if (cr == 0) {
            if (susgoles == 1) {
                if (min == 23) {
                    lblSuMarcador.setText("" + susgoles);
                }
            }
            if (misgoles == 2) {
                if (min == 39) {
                    lblMiMarcador.setText("1");
                }
            }
            if (susgoles == 2) {
                if (min == 43) {
                    lblSuMarcador.setText("1");
                }
            }
            if (misgoles == 3) {
                if (min == 37) {
                    lblMiMarcador.setText("1");
                }
            }
            if (susgoles == 3) {
                if (min == 17) {
                    lblSuMarcador.setText("1");
                }
            }
            if (susgoles == 3) {
                if (min == 32) {
                    lblSuMarcador.setText("2");
                }
            }
            if (susgoles == 4) {
                if (min == 22) {
                    lblSuMarcador.setText("1");
                }
            }
            if (susgoles == 4) {
                if (min == 25) {
                    lblSuMarcador.setText("2");
                }
            }
            if (misgoles == 4) {
                if (min == 12) {
                    lblMiMarcador.setText("1");
                }
            }
            if (misgoles == 4) {
                if (min == 36) {
                    lblMiMarcador.setText("2");
                }
            }
            if (dec == 99) {
                dec = 0;
                seg++;
            }
            if (seg == 59) {
                seg = 0;
                min++;
            }
            if (min == 45) {
                stopTimer();
                btnSegTiempo.setVisible(true);
                cr = 1;
                min = 0;
            }
            if (seg < 10) {
                lblTiempo.setText(min + ":" + "0" + seg);
            }
            if (seg >= 10) {
                lblTiempo.setText(min + ":" + seg);
            }

            dec = dec + 99;

        }

        if (cr == 1) {
            if (misgoles == 1) {
                if (min == 27) {
                    lblMiMarcador.setText("" + misgoles);
                }
            }
            if (misgoles == 2) {
                if (min == 41) {
                    lblMiMarcador.setText("2");
                }
            }
            if (susgoles == 2) {
                if (min == 15) {
                    lblSuMarcador.setText("2");
                }
            }
            if (misgoles == 3) {
                if (min == 17) {
                    lblMiMarcador.setText("2");
                }
            }
            if (misgoles == 3) {
                if (min == 44) {
                    lblMiMarcador.setText("3");
                }
            }
            if (susgoles == 3) {
                if (min == 31) {
                    lblSuMarcador.setText("3");
                }
            }
            if (susgoles == 4) {
                if (min == 22) {
                    lblSuMarcador.setText("3");
                }
            }
            if (susgoles == 4) {
                if (min == 38) {
                    lblSuMarcador.setText("4");
                }
            }
            if (misgoles == 4) {
                if (min == 19) {
                    lblMiMarcador.setText("3");
                }
            }
            if (misgoles == 4) {
                if (min == 26) {
                    lblMiMarcador.setText("4");
                }
            }
            if (dec == 99) {
                dec = 0;
                seg++;
            }
            if (seg == 59) {
                seg = 0;
                min++;
            }

            if (seg < 10) {
                lblTiempo.setText((min + 45) + ":" + "0" + seg);
            }
            if (seg >= 10) {
                lblTiempo.setText((min + 45) + ":" + seg);
            }

            if (min == 45) {
                stopTimer();
                btnContinuar.setEnabled(true);
                cr = 0;
                lblTiempo.setText("90:00");
                min = 0;
            }

            dec = dec + 99;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgSalir = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        btnSalirMP = new javax.swing.JButton();
        btnSdelJuego = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        frmAlineacion442 = new javax.swing.JFrame();
        jSeparator3 = new javax.swing.JSeparator();
        btnGuardarAlin442 = new javax.swing.JButton();
        btnDefLatDer = new javax.swing.JButton();
        btnDefCenDer = new javax.swing.JButton();
        btnDefCenIzq = new javax.swing.JButton();
        btnDefLatIzq = new javax.swing.JButton();
        btnMedLatDer = new javax.swing.JButton();
        btnMedCenDer = new javax.swing.JButton();
        btnMedCenIzq = new javax.swing.JButton();
        btnMedLatIzq = new javax.swing.JButton();
        btnDelDer = new javax.swing.JButton();
        btnDelIzq = new javax.swing.JButton();
        btnArquero = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        btnArqueroSup = new javax.swing.JButton();
        btnDefSup442 = new javax.swing.JButton();
        btnDefSup2442 = new javax.swing.JButton();
        btnMedSup442 = new javax.swing.JButton();
        btnMedSup2442 = new javax.swing.JButton();
        btnDelSup442 = new javax.swing.JButton();
        btnDelSup2442 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        lblImAlineacion = new javax.swing.JLabel();
        btnCancelarAlin442 = new javax.swing.JButton();
        btnDesselecjug442 = new javax.swing.JButton();
        frmEquipo = new javax.swing.JFrame();
        btnFormacion = new javax.swing.JButton();
        btnAlineacion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAtras1 = new javax.swing.JButton();
        frmAlineacion343 = new javax.swing.JFrame();
        btnGuardarAlin343 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        btnDelIzq343 = new javax.swing.JButton();
        btnDelCtr343 = new javax.swing.JButton();
        btnDelDer343 = new javax.swing.JButton();
        btnMedIzq343 = new javax.swing.JButton();
        btnMedDer343 = new javax.swing.JButton();
        btnMedCenIzq343 = new javax.swing.JButton();
        btnMedCenDer343 = new javax.swing.JButton();
        btnDefIzq343 = new javax.swing.JButton();
        btnDefCtr343 = new javax.swing.JButton();
        btnDefDer343 = new javax.swing.JButton();
        btnArq343 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnArqSup343 = new javax.swing.JButton();
        btnDefSup1343 = new javax.swing.JButton();
        btnDefSup2343 = new javax.swing.JButton();
        btnDefSup3343 = new javax.swing.JButton();
        btnMedSup343 = new javax.swing.JButton();
        btnMedSup2343 = new javax.swing.JButton();
        btnDelSup343 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnCancelarAlin343 = new javax.swing.JButton();
        btnDesselecc = new javax.swing.JButton();
        frmFormación = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        lblFormacion = new javax.swing.JLabel();
        btnEditarForm = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        cmbxFormaciones = new javax.swing.JComboBox();
        lblImagenForm = new javax.swing.JLabel();
        btnGuardarForm = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        frmJuego = new javax.swing.JFrame();
        lblMiMarcador = new javax.swing.JLabel();
        lblSuMarcador = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lblMiEquipoNombre = new javax.swing.JLabel();
        lblContrincanteNombre = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnSegTiempo = new javax.swing.JButton();
        btnComenzarPartido = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        frmFinal = new javax.swing.JFrame();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        btnContinuarFinal = new javax.swing.JButton();
        frmCreditos = new javax.swing.JFrame();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnContinuarCreditos = new javax.swing.JButton();
        btnPPartido = new javax.swing.JButton();
        btnEquipo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTitulares = new javax.swing.JList();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lblFormacionActual = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEquiposTabla = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPuntos = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSuplentes = new javax.swing.JList();

        jLabel2.setText("¿Que deseas hacer?");

        btnSalirMP.setText("Salir al menú principal");
        btnSalirMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMPActionPerformed(evt);
            }
        });

        btnSdelJuego.setText("Salir del juego");
        btnSdelJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSdelJuegoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgSalirLayout = new javax.swing.GroupLayout(dlgSalir.getContentPane());
        dlgSalir.getContentPane().setLayout(dlgSalirLayout);
        dlgSalirLayout.setHorizontalGroup(
            dlgSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSalirLayout.createSequentialGroup()
                .addGroup(dlgSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgSalirLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalirMP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSdelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgSalirLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgSalirLayout.setVerticalGroup(
            dlgSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalirMP)
                    .addComponent(btnSdelJuego)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frmAlineacion442.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frmAlineacion442.setMinimumSize(new java.awt.Dimension(400, 324));
        frmAlineacion442.getContentPane().setLayout(null);
        frmAlineacion442.getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 350, 610, 2);

        btnGuardarAlin442.setText("Guardar");
        btnGuardarAlin442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlin442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnGuardarAlin442);
        btnGuardarAlin442.setBounds(481, 360, 140, 23);

        btnDefLatDer.setText("jButton2");
        btnDefLatDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefLatDerActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDefLatDer);
        btnDefLatDer.setBounds(50, 40, 140, 23);

        btnDefCenDer.setText("jButton5");
        btnDefCenDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefCenDerActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDefCenDer);
        btnDefCenDer.setBounds(50, 70, 140, 23);

        btnDefCenIzq.setText("jButton6");
        btnDefCenIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefCenIzqActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDefCenIzq);
        btnDefCenIzq.setBounds(50, 100, 140, 23);

        btnDefLatIzq.setText("jButton8");
        btnDefLatIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefLatIzqActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDefLatIzq);
        btnDefLatIzq.setBounds(50, 130, 140, 23);

        btnMedLatDer.setText("jButton9");
        btnMedLatDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedLatDerActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnMedLatDer);
        btnMedLatDer.setBounds(50, 160, 140, 23);

        btnMedCenDer.setText("jButton10");
        btnMedCenDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedCenDerActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnMedCenDer);
        btnMedCenDer.setBounds(50, 190, 140, 23);

        btnMedCenIzq.setText("jButton11");
        btnMedCenIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedCenIzqActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnMedCenIzq);
        btnMedCenIzq.setBounds(50, 220, 140, 23);

        btnMedLatIzq.setText("jButton12");
        btnMedLatIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedLatIzqActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnMedLatIzq);
        btnMedLatIzq.setBounds(50, 250, 140, 23);

        btnDelDer.setText("jButton15");
        btnDelDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDerActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDelDer);
        btnDelDer.setBounds(50, 280, 140, 23);

        btnDelIzq.setText("jButton16");
        btnDelIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelIzqActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDelIzq);
        btnDelIzq.setBounds(50, 310, 140, 23);

        btnArquero.setText("jButton17");
        btnArquero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArqueroActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnArquero);
        btnArquero.setBounds(50, 10, 140, 23);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(java.awt.Color.orange);
        jLabel42.setText("GK");
        frmAlineacion442.getContentPane().add(jLabel42);
        jLabel42.setBounds(430, 0, 30, 40);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(java.awt.Color.red);
        jLabel43.setText("DEF");
        frmAlineacion442.getContentPane().add(jLabel43);
        jLabel43.setBounds(430, 30, 40, 40);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(java.awt.Color.red);
        jLabel44.setText("DEF");
        frmAlineacion442.getContentPane().add(jLabel44);
        jLabel44.setBounds(430, 60, 40, 40);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(java.awt.Color.green);
        jLabel46.setText("MED");
        frmAlineacion442.getContentPane().add(jLabel46);
        jLabel46.setBounds(430, 90, 40, 40);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(java.awt.Color.green);
        jLabel47.setText("MED");
        frmAlineacion442.getContentPane().add(jLabel47);
        jLabel47.setBounds(430, 120, 40, 40);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("DEL");
        frmAlineacion442.getContentPane().add(jLabel48);
        jLabel48.setBounds(430, 160, 40, 20);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(java.awt.Color.red);
        jLabel49.setText("DFC");
        frmAlineacion442.getContentPane().add(jLabel49);
        jLabel49.setBounds(10, 100, 28, 17);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(java.awt.Color.red);
        jLabel50.setText("DFI");
        frmAlineacion442.getContentPane().add(jLabel50);
        jLabel50.setBounds(10, 130, 40, 20);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(java.awt.Color.green);
        jLabel51.setText("MCDD");
        frmAlineacion442.getContentPane().add(jLabel51);
        jLabel51.setBounds(0, 190, 50, 20);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(java.awt.Color.green);
        jLabel52.setText("MCDI");
        frmAlineacion442.getContentPane().add(jLabel52);
        jLabel52.setBounds(0, 220, 40, 20);

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(java.awt.Color.green);
        jLabel53.setText("MI");
        frmAlineacion442.getContentPane().add(jLabel53);
        jLabel53.setBounds(10, 250, 20, 17);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("DD");
        frmAlineacion442.getContentPane().add(jLabel54);
        jLabel54.setBounds(10, 280, 20, 20);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setText("DI");
        frmAlineacion442.getContentPane().add(jLabel55);
        jLabel55.setBounds(10, 310, 20, 17);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setForeground(java.awt.Color.orange);
        jLabel56.setText("GK");
        frmAlineacion442.getContentPane().add(jLabel56);
        jLabel56.setBounds(10, 0, 30, 40);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setForeground(java.awt.Color.red);
        jLabel57.setText("DFD");
        frmAlineacion442.getContentPane().add(jLabel57);
        jLabel57.setBounds(10, 30, 40, 40);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setForeground(java.awt.Color.green);
        jLabel58.setText("MD");
        frmAlineacion442.getContentPane().add(jLabel58);
        jLabel58.setBounds(10, 150, 30, 40);

        btnArqueroSup.setText("jButton1");
        btnArqueroSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArqueroSupActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnArqueroSup);
        btnArqueroSup.setBounds(470, 10, 150, 23);

        btnDefSup442.setText("jButton2");
        btnDefSup442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefSup442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDefSup442);
        btnDefSup442.setBounds(470, 40, 150, 23);

        btnDefSup2442.setText("jButton3");
        btnDefSup2442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefSup2442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDefSup2442);
        btnDefSup2442.setBounds(470, 70, 150, 23);

        btnMedSup442.setText("jButton4");
        btnMedSup442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSup442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnMedSup442);
        btnMedSup442.setBounds(470, 100, 150, 23);

        btnMedSup2442.setText("jButton5");
        btnMedSup2442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSup2442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnMedSup2442);
        btnMedSup2442.setBounds(470, 130, 150, 23);

        btnDelSup442.setText("jButton6");
        btnDelSup442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSup442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDelSup442);
        btnDelSup442.setBounds(470, 160, 150, 23);

        btnDelSup2442.setText("jButton7");
        btnDelSup2442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSup2442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDelSup2442);
        btnDelSup2442.setBounds(470, 190, 150, 23);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("DEL");
        frmAlineacion442.getContentPane().add(jLabel60);
        jLabel60.setBounds(430, 190, 40, 20);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setForeground(java.awt.Color.red);
        jLabel59.setText("DFC");
        frmAlineacion442.getContentPane().add(jLabel59);
        jLabel59.setBounds(10, 70, 28, 17);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("DI");
        frmAlineacion442.getContentPane().add(jLabel45);
        jLabel45.setBounds(260, 70, 20, 17);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("DD");
        frmAlineacion442.getContentPane().add(jLabel62);
        jLabel62.setBounds(340, 70, 20, 17);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setForeground(java.awt.Color.green);
        jLabel63.setText("MD");
        frmAlineacion442.getContentPane().add(jLabel63);
        jLabel63.setBounds(360, 130, 30, 30);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setForeground(java.awt.Color.green);
        jLabel64.setText("MI");
        frmAlineacion442.getContentPane().add(jLabel64);
        jLabel64.setBounds(220, 140, 20, 17);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setForeground(java.awt.Color.green);
        jLabel65.setText("MCDI");
        frmAlineacion442.getContentPane().add(jLabel65);
        jLabel65.setBounds(250, 200, 40, 17);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setForeground(java.awt.Color.green);
        jLabel66.setText("MCDD");
        frmAlineacion442.getContentPane().add(jLabel66);
        jLabel66.setBounds(310, 200, 50, 17);

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setForeground(java.awt.Color.red);
        jLabel67.setText("DFI");
        frmAlineacion442.getContentPane().add(jLabel67);
        jLabel67.setBounds(210, 230, 40, 14);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setForeground(java.awt.Color.red);
        jLabel68.setText("DFC");
        frmAlineacion442.getContentPane().add(jLabel68);
        jLabel68.setBounds(320, 250, 28, 17);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setForeground(java.awt.Color.red);
        jLabel69.setText("DFD");
        frmAlineacion442.getContentPane().add(jLabel69);
        jLabel69.setBounds(370, 230, 30, 17);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel70.setForeground(java.awt.Color.orange);
        jLabel70.setText("GK");
        frmAlineacion442.getContentPane().add(jLabel70);
        jLabel70.setBounds(300, 270, 20, 14);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setForeground(java.awt.Color.red);
        jLabel71.setText("DFC");
        frmAlineacion442.getContentPane().add(jLabel71);
        jLabel71.setBounds(260, 250, 28, 17);

        lblImAlineacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4-4-2.jpg"))); // NOI18N
        frmAlineacion442.getContentPane().add(lblImAlineacion);
        lblImAlineacion.setBounds(200, 40, 211, 260);

        btnCancelarAlin442.setText("Cancelar");
        btnCancelarAlin442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlin442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnCancelarAlin442);
        btnCancelarAlin442.setBounds(320, 360, 140, 23);

        btnDesselecjug442.setText("Desseleccionar jugador");
        btnDesselecjug442.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesselecjug442ActionPerformed(evt);
            }
        });
        frmAlineacion442.getContentPane().add(btnDesselecjug442);
        btnDesselecjug442.setBounds(320, 320, 300, 23);

        frmEquipo.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFormacion.setText("Formación");
        btnFormacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormacionActionPerformed(evt);
            }
        });

        btnAlineacion.setText("Alineación");
        btnAlineacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlineacionActionPerformed(evt);
            }
        });

        btnAtras1.setText("Atrás");
        btnAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmEquipoLayout = new javax.swing.GroupLayout(frmEquipo.getContentPane());
        frmEquipo.getContentPane().setLayout(frmEquipoLayout);
        frmEquipoLayout.setHorizontalGroup(
            frmEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmEquipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFormacion, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(btnAlineacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmEquipoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        frmEquipoLayout.setVerticalGroup(
            frmEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmEquipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlineacion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtras1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frmAlineacion343.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frmAlineacion343.getContentPane().setLayout(null);

        btnGuardarAlin343.setText("Guardar");
        btnGuardarAlin343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlin343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnGuardarAlin343);
        btnGuardarAlin343.setBounds(471, 360, 130, 23);
        frmAlineacion343.getContentPane().add(jSeparator6);
        jSeparator6.setBounds(10, 350, 590, 2);

        btnDelIzq343.setText("jButton13");
        btnDelIzq343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelIzq343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDelIzq343);
        btnDelIzq343.setBounds(40, 310, 130, 23);

        btnDelCtr343.setText("jButton14");
        btnDelCtr343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCtr343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDelCtr343);
        btnDelCtr343.setBounds(40, 280, 130, 23);

        btnDelDer343.setText("jButton15");
        btnDelDer343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDer343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDelDer343);
        btnDelDer343.setBounds(40, 250, 130, 23);

        btnMedIzq343.setText("jButton16");
        btnMedIzq343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedIzq343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnMedIzq343);
        btnMedIzq343.setBounds(40, 220, 130, 23);

        btnMedDer343.setText("jButton17");
        btnMedDer343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedDer343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnMedDer343);
        btnMedDer343.setBounds(40, 130, 130, 23);

        btnMedCenIzq343.setText("jButton18");
        btnMedCenIzq343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedCenIzq343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnMedCenIzq343);
        btnMedCenIzq343.setBounds(40, 190, 130, 23);

        btnMedCenDer343.setText("jButton19");
        btnMedCenDer343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedCenDer343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnMedCenDer343);
        btnMedCenDer343.setBounds(40, 160, 130, 23);

        btnDefIzq343.setText("jButton20");
        btnDefIzq343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefIzq343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDefIzq343);
        btnDefIzq343.setBounds(40, 100, 130, 23);

        btnDefCtr343.setText("jButton21");
        btnDefCtr343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefCtr343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDefCtr343);
        btnDefCtr343.setBounds(40, 70, 130, 23);

        btnDefDer343.setText("jButton22");
        btnDefDer343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefDer343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDefDer343);
        btnDefDer343.setBounds(40, 40, 130, 23);

        btnArq343.setText("jButton23");
        btnArq343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArq343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnArq343);
        btnArq343.setBounds(40, 10, 130, 23);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.orange);
        jLabel12.setText("GK");
        frmAlineacion343.getContentPane().add(jLabel12);
        jLabel12.setBounds(430, 0, 30, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.red);
        jLabel13.setText("DEF");
        frmAlineacion343.getContentPane().add(jLabel13);
        jLabel13.setBounds(430, 90, 40, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.red);
        jLabel14.setText("DFC");
        frmAlineacion343.getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 70, 28, 17);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.red);
        jLabel16.setText("DFI");
        frmAlineacion343.getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 100, 40, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(java.awt.Color.green);
        jLabel17.setText("MED");
        frmAlineacion343.getContentPane().add(jLabel17);
        jLabel17.setBounds(430, 120, 40, 40);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(java.awt.Color.green);
        jLabel18.setText("MCDD");
        frmAlineacion343.getContentPane().add(jLabel18);
        jLabel18.setBounds(0, 160, 50, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(java.awt.Color.green);
        jLabel19.setText("MCDI");
        frmAlineacion343.getContentPane().add(jLabel19);
        jLabel19.setBounds(0, 190, 40, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(java.awt.Color.green);
        jLabel20.setText("MI");
        frmAlineacion343.getContentPane().add(jLabel20);
        jLabel20.setBounds(10, 220, 20, 17);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("DD");
        frmAlineacion343.getContentPane().add(jLabel21);
        jLabel21.setBounds(10, 250, 20, 20);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("DEL");
        frmAlineacion343.getContentPane().add(jLabel22);
        jLabel22.setBounds(430, 190, 40, 20);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("DI");
        frmAlineacion343.getContentPane().add(jLabel23);
        jLabel23.setBounds(10, 310, 20, 17);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(java.awt.Color.orange);
        jLabel24.setText("GK");
        frmAlineacion343.getContentPane().add(jLabel24);
        jLabel24.setBounds(300, 270, 20, 14);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(java.awt.Color.red);
        jLabel25.setText("DFD");
        frmAlineacion343.getContentPane().add(jLabel25);
        jLabel25.setBounds(360, 240, 30, 17);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(java.awt.Color.red);
        jLabel26.setText("DFC");
        frmAlineacion343.getContentPane().add(jLabel26);
        jLabel26.setBounds(290, 240, 28, 17);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(java.awt.Color.red);
        jLabel27.setText("DFI");
        frmAlineacion343.getContentPane().add(jLabel27);
        jLabel27.setBounds(230, 240, 40, 14);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(java.awt.Color.green);
        jLabel28.setText("MD");
        frmAlineacion343.getContentPane().add(jLabel28);
        jLabel28.setBounds(360, 130, 30, 30);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(java.awt.Color.green);
        jLabel29.setText("MCDD");
        frmAlineacion343.getContentPane().add(jLabel29);
        jLabel29.setBounds(310, 200, 50, 17);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(java.awt.Color.green);
        jLabel30.setText("MCDI");
        frmAlineacion343.getContentPane().add(jLabel30);
        jLabel30.setBounds(250, 200, 40, 17);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(java.awt.Color.green);
        jLabel31.setText("MI");
        frmAlineacion343.getContentPane().add(jLabel31);
        jLabel31.setBounds(220, 140, 20, 17);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("DD");
        frmAlineacion343.getContentPane().add(jLabel32);
        jLabel32.setBounds(350, 70, 20, 17);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("DC");
        frmAlineacion343.getContentPane().add(jLabel33);
        jLabel33.setBounds(290, 70, 20, 17);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("DI");
        frmAlineacion343.getContentPane().add(jLabel34);
        jLabel34.setBounds(230, 70, 20, 17);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3-4-3.jpg"))); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(211, 260));
        jLabel4.setMinimumSize(new java.awt.Dimension(211, 260));
        jLabel4.setPreferredSize(new java.awt.Dimension(211, 260));
        frmAlineacion343.getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 30, 210, 260);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(java.awt.Color.orange);
        jLabel35.setText("GK");
        frmAlineacion343.getContentPane().add(jLabel35);
        jLabel35.setBounds(10, 0, 30, 40);

        btnArqSup343.setText("jButton1");
        btnArqSup343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArqSup343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnArqSup343);
        btnArqSup343.setBounds(460, 10, 140, 23);

        btnDefSup1343.setText("jButton2");
        btnDefSup1343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefSup1343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDefSup1343);
        btnDefSup1343.setBounds(460, 40, 140, 23);

        btnDefSup2343.setText("jButton3");
        btnDefSup2343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefSup2343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDefSup2343);
        btnDefSup2343.setBounds(460, 70, 140, 23);

        btnDefSup3343.setText("jButton4");
        btnDefSup3343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefSup3343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDefSup3343);
        btnDefSup3343.setBounds(460, 100, 140, 23);

        btnMedSup343.setText("jButton5");
        btnMedSup343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSup343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnMedSup343);
        btnMedSup343.setBounds(460, 130, 140, 23);

        btnMedSup2343.setText("jButton6");
        btnMedSup2343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSup2343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnMedSup2343);
        btnMedSup2343.setBounds(460, 160, 140, 23);

        btnDelSup343.setText("jButton7");
        btnDelSup343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSup343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDelSup343);
        btnDelSup343.setBounds(460, 190, 140, 23);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(java.awt.Color.red);
        jLabel36.setText("DFD");
        frmAlineacion343.getContentPane().add(jLabel36);
        jLabel36.setBounds(10, 30, 40, 40);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(java.awt.Color.red);
        jLabel37.setText("DEF");
        frmAlineacion343.getContentPane().add(jLabel37);
        jLabel37.setBounds(430, 30, 40, 40);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(java.awt.Color.green);
        jLabel38.setText("MD");
        frmAlineacion343.getContentPane().add(jLabel38);
        jLabel38.setBounds(10, 120, 30, 40);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(java.awt.Color.green);
        jLabel39.setText("MED");
        frmAlineacion343.getContentPane().add(jLabel39);
        jLabel39.setBounds(430, 150, 40, 40);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("DC");
        frmAlineacion343.getContentPane().add(jLabel40);
        jLabel40.setBounds(10, 280, 20, 20);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(java.awt.Color.red);
        jLabel41.setText("DEF");
        frmAlineacion343.getContentPane().add(jLabel41);
        jLabel41.setBounds(430, 60, 40, 40);

        btnCancelarAlin343.setText("Cancelar");
        btnCancelarAlin343.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlin343ActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnCancelarAlin343);
        btnCancelarAlin343.setBounds(330, 360, 130, 23);

        btnDesselecc.setText("Desseleccionar jugador");
        btnDesselecc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesseleccActionPerformed(evt);
            }
        });
        frmAlineacion343.getContentPane().add(btnDesselecc);
        btnDesselecc.setBounds(333, 320, 260, 23);

        frmFormación.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Formación acutal:");

        lblFormacion.setText("4-4-2");

        btnEditarForm.setText("Editar");
        btnEditarForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFormActionPerformed(evt);
            }
        });

        cmbxFormaciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "4-4-2", "3-4-3" }));
        cmbxFormaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxFormacionesActionPerformed(evt);
            }
        });

        lblImagenForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4-4-2.jpg"))); // NOI18N

        btnGuardarForm.setText("Guardar");
        btnGuardarForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFormActionPerformed(evt);
            }
        });

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmFormaciónLayout = new javax.swing.GroupLayout(frmFormación.getContentPane());
        frmFormación.getContentPane().setLayout(frmFormaciónLayout);
        frmFormaciónLayout.setHorizontalGroup(
            frmFormaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmFormaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmFormaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(frmFormaciónLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                        .addComponent(btnGuardarForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frmFormaciónLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblFormacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarForm)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtras))
                    .addComponent(cmbxFormaciones, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(frmFormaciónLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lblImagenForm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frmFormaciónLayout.setVerticalGroup(
            frmFormaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmFormaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmFormaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblFormacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarForm)
                    .addComponent(btnAtras))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbxFormaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImagenForm)
                .addGap(16, 16, 16)
                .addComponent(btnGuardarForm)
                .addContainerGap())
        );

        frmJuego.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frmJuego.getContentPane().setLayout(null);

        lblMiMarcador.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblMiMarcador.setText("0");
        frmJuego.getContentPane().add(lblMiMarcador);
        lblMiMarcador.setBounds(97, 90, 26, 58);

        lblSuMarcador.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblSuMarcador.setText("0");
        frmJuego.getContentPane().add(lblSuMarcador);
        lblSuMarcador.setBounds(289, 90, 26, 58);
        frmJuego.getContentPane().add(jSeparator7);
        jSeparator7.setBounds(10, 240, 392, 2);

        lblMiEquipoNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMiEquipoNombre.setText("Mi equipo");
        frmJuego.getContentPane().add(lblMiEquipoNombre);
        lblMiEquipoNombre.setBounds(60, 190, 170, 29);

        lblContrincanteNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblContrincanteNombre.setText("Su equipo");
        frmJuego.getContentPane().add(lblContrincanteNombre);
        lblContrincanteNombre.setBounds(250, 190, 180, 29);

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        frmJuego.getContentPane().add(btnContinuar);
        btnContinuar.setBounds(323, 253, 79, 23);

        btnSegTiempo.setText("Iniciar segundo tiempo");
        btnSegTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSegTiempoActionPerformed(evt);
            }
        });
        frmJuego.getContentPane().add(btnSegTiempo);
        btnSegTiempo.setBounds(130, 70, 150, 90);

        btnComenzarPartido.setText("Iniciar partido");
        btnComenzarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarPartidoActionPerformed(evt);
            }
        });
        frmJuego.getContentPane().add(btnComenzarPartido);
        btnComenzarPartido.setBounds(130, 70, 150, 90);

        lblTiempo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTiempo.setText("00:00");
        frmJuego.getContentPane().add(lblTiempo);
        lblTiempo.setBounds(173, 114, 60, 29);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setText("Terminó la temporada");

        jLabel7.setText("───────────────────────────────────────────────");

        jLabel5.setText("Has llegado al final del juego. Intenta nuevamente con un nuevo equipo,");

        jLabel61.setText("desafíate a ti mismo. Conviertete en el mejor DT del planeta.");

        btnContinuarFinal.setText("Continuar");
        btnContinuarFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmFinalLayout = new javax.swing.GroupLayout(frmFinal.getContentPane());
        frmFinal.getContentPane().setLayout(frmFinalLayout);
        frmFinalLayout.setHorizontalGroup(
            frmFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmFinalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(frmFinalLayout.createSequentialGroup()
                        .addGroup(frmFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel61))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmFinalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnContinuarFinal)
                .addGap(157, 157, 157))
        );
        frmFinalLayout.setVerticalGroup(
            frmFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmFinalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel61)
                .addGap(18, 18, 18)
                .addComponent(btnContinuarFinal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Harlow Solid Italic", 1, 48)); // NOI18N
        jLabel8.setText("Fubtol Manager");

        jLabel9.setText("Idea y elaboración: Emiliano Mónaco");

        btnContinuarCreditos.setText("Continuar");
        btnContinuarCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarCreditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmCreditosLayout = new javax.swing.GroupLayout(frmCreditos.getContentPane());
        frmCreditos.getContentPane().setLayout(frmCreditosLayout);
        frmCreditosLayout.setHorizontalGroup(
            frmCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmCreditosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnContinuarCreditos)
                .addGap(150, 150, 150))
            .addGroup(frmCreditosLayout.createSequentialGroup()
                .addGroup(frmCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frmCreditosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(frmCreditosLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frmCreditosLayout.setVerticalGroup(
            frmCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(btnContinuarCreditos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(449, 380));
        setName("frmJuego"); // NOI18N

        btnPPartido.setText("Proximo partido");
        btnPPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPPartidoActionPerformed(evt);
            }
        });

        btnEquipo.setText("Equipo");
        btnEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Alineación:");

        jScrollPane1.setViewportView(lstTitulares);

        jLabel15.setText("Formación actual:");

        jScrollPane2.setViewportView(lstEquiposTabla);

        jScrollPane3.setViewportView(lstPuntos);

        jScrollPane4.setViewportView(lstSuplentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnPPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFormacionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator5))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormacionActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dlgSalir.setVisible(true);
        dlgSalir.setSize(490, 110);
        dlgSalir.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMPActionPerformed
        // TODO add your handling code here:
        new FutbolManagger().setVisible(true);
        dlgSalir.hide();
        this.hide();
    }//GEN-LAST:event_btnSalirMPActionPerformed

    private void btnSdelJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSdelJuegoActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSdelJuegoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dlgSalir.hide();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipoActionPerformed
        // TODO add your handling code here:
        frmEquipo.setVisible(true);
        frmEquipo.setSize(450, 340);
        this.setVisible(false);
        frmEquipo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEquipoActionPerformed

    private void btnFormacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormacionActionPerformed
        // TODO add your handling code here:
        frmFormación.setVisible(true);
        frmFormación.setSize(450, 450);
        frmEquipo.hide();
        frmFormación.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnFormacionActionPerformed

    private void btnAlineacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlineacionActionPerformed
        // TODO add your handling code here:
        if (formacselec.equals("4-4-2")) {//ventana para modificar la alineacion en el caso que la formacion sea 442
            frmAlineacion442.setVisible(true);
            frmAlineacion442.setSize(653, 430);
            frmAlineacion442.setLocationRelativeTo(null);
            frmEquipo.hide();
            btnDesselecjug442.setEnabled(false);
            btnArqueroSup.setEnabled(false);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnDelSup442.setEnabled(false);
            btnDelSup2442.setEnabled(false);
            btnArquero.setText(titulares[0]);
            btnDefLatDer.setText(titulares[1]);
            btnDefCenDer.setText(titulares[2]);
            btnDefCenIzq.setText(titulares[3]);
            btnDefLatIzq.setText(titulares[4]);
            btnMedLatDer.setText(titulares[5]);
            btnMedCenDer.setText(titulares[6]);
            btnMedCenIzq.setText(titulares[7]);
            btnMedLatIzq.setText(titulares[8]);
            btnDelDer.setText(titulares[9]);
            btnDelIzq.setText(titulares[10]);
            btnArqueroSup.setText(suplentes[0]);
            btnDefSup442.setText(suplentes[1]);
            btnDefSup2442.setText(suplentes[2]);
            btnMedSup442.setText(suplentes[3]);
            btnMedSup2442.setText(suplentes[4]);
            btnDelSup442.setText(suplentes[5]);
            btnDelSup2442.setText(suplentes[6]);

        }

        if (formacselec.equals("3-4-3")) {//ventana para modificar la alineacion en caso de que la formacion sea 343
            frmAlineacion343.setVisible(true);
            frmAlineacion343.setSize(653, 430);
            frmAlineacion343.setLocationRelativeTo(null);
            frmEquipo.hide();
            btnDesselecc.setEnabled(false);
            btnArqSup343.setEnabled(false);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnDelSup343.setEnabled(false);
            btnArq343.setText(titulares[0]);
            btnDefDer343.setText(titulares[1]);
            btnDefCtr343.setText(titulares[2]);
            btnDefIzq343.setText(titulares[3]);
            btnMedDer343.setText(titulares[4]);
            btnMedCenDer343.setText(titulares[5]);
            btnMedCenIzq343.setText(titulares[6]);
            btnMedIzq343.setText(titulares[7]);
            btnDelDer343.setText(titulares[8]);
            btnDelCtr343.setText(titulares[9]);
            btnDelIzq343.setText(titulares[10]);
            btnArqSup343.setText(suplentes[0]);
            btnDefSup1343.setText(suplentes[1]);
            btnDefSup2343.setText(suplentes[2]);
            btnDefSup3343.setText(suplentes[3]);
            btnMedSup343.setText(suplentes[4]);
            btnMedSup2343.setText(suplentes[5]);
            btnDelSup343.setText(suplentes[6]);

        }
    }//GEN-LAST:event_btnAlineacionActionPerformed

    private void btnAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        frmEquipo.hide();
    }//GEN-LAST:event_btnAtras1ActionPerformed

    private void btnEditarFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFormActionPerformed
        // TODO add your handling code here:
        cmbxFormaciones.setEnabled(true);
        lblImagenForm.setEnabled(true);
        btnGuardarForm.setEnabled(true);
    }//GEN-LAST:event_btnEditarFormActionPerformed

    private void cmbxFormacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxFormacionesActionPerformed
        // TODO add your handling code here:
        formacselec = "" + cmbxFormaciones.getSelectedItem();//dependiendo de la formacion seleccionada cambia la imagen
        if (formacselec.equals("4-4-2")) {
            lblImagenForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4-4-2.jpg")));
        }

        if (formacselec.equals("3-4-3")) {
            lblImagenForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3-4-3.jpg")));
        }

    }//GEN-LAST:event_cmbxFormacionesActionPerformed

    private void btnGuardarFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFormActionPerformed
        // TODO add your handling code here:
        if (formacselec.equals("4-4-2")) {
            lblImAlineacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4-4-2.jpg")));
            lblFormacion.setText(formacselec);
        }

        if (formacselec.equals("3-4-3")) {
            lblImAlineacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3-4-3.jpg")));
            lblFormacion.setText(formacselec);//al modificar de 442 a 343 se saca a un defensor y se ingresa a un delantero
            String auxiliar = suplentes[6];
            suplentes[6] = suplentes[5];
            suplentes[5] = suplentes[4];
            suplentes[4] = suplentes[3];
            suplentes[3] = titulares[3];
            titulares[3] = titulares[4];
            titulares[4] = titulares[5];
            titulares[5] = titulares[6];
            titulares[6] = titulares[7];
            titulares[7] = titulares[8];
            titulares[8] = titulares[9];
            titulares[9] = titulares[10];
            titulares[10] = auxiliar;

        }

        cmbxFormaciones.setEnabled(false);
        lblImagenForm.setEnabled(false);
        btnGuardarForm.setEnabled(false);
    }//GEN-LAST:event_btnGuardarFormActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        frmEquipo.setVisible(true);
        frmEquipo.setSize(450, 340);
        frmFormación.hide();
        frmEquipo.setLocationRelativeTo(null);
        lblFormacionActual.setText("" + cmbxFormaciones.getSelectedItem());
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnPPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPPartidoActionPerformed
        // TODO add your handling code here:
        btnContinuar.setEnabled(false);
        btnSegTiempo.setVisible(false);
        btnComenzarPartido.setVisible(true);
        frmJuego.setVisible(true);
        this.setVisible(false);
        frmJuego.setSize(450, 330);
        frmJuego.setLocationRelativeTo(null);
        for (int i = 0; i < contrincantes.length; i++) {
            System.out.println(contrincantes[i]);
        }
        lblContrincanteNombre.setText(contrincantes[pjugados]);//el contrincante dependera de los partidos jugados
        lblMiMarcador.setText("0");
        lblSuMarcador.setText("0");
        misgoles = (int) (Math.random() * 4 + 1);//random para los goles hasta 4
        susgoles = (int) (Math.random() * 4 + 1);
    }//GEN-LAST:event_btnPPartidoActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        pjugados++;
        if (pjugados == 19) {//se determina el final del torneo
            frmJuego.hide();
            frmFinal.setVisible(true);
            frmFinal.setSize(485, 210);
            frmFinal.setLocationRelativeTo(null);
        }
        if (pjugados < 19) {
            this.setVisible(true);
            listModelEquipos.removeAllElements();
            listModelPuntos.removeAllElements();
            frmJuego.hide();
            for (int i = 0; i < todoslosequipos.length; i++) {//se hace un random para cada equipo para que pueda sumar puntos en la tabla
                if (!todoslosequipos[i].equals(miequipo)) {
                    if (!todoslosequipos[i].equals(lblContrincanteNombre.getText())) {
                        int rnd = (int) (Math.random() * 3 + 1);
                        if (rnd == 1) {
                            puntos[i] = puntos[i] + 0;
                        }
                        if (rnd == 2) {
                            puntos[i] = puntos[i] + 1;
                        }
                        if (rnd == 3) {
                            puntos[i] = puntos[i] + 3;
                        }
                    }
                }
                if (todoslosequipos[i].equals(miequipo)) {
                    if (misgoles > susgoles) {
                        puntos[i] = puntos[i] + 3;
                    }
                    if (misgoles == susgoles) {
                        puntos[i] = puntos[i] + 1;
                    }
                    if (misgoles < susgoles) {
                        puntos[i] = puntos[i] + 0;
                    }
                }
                if (todoslosequipos[i].equals(equipocontrario)) {
                    if (susgoles > misgoles) {
                        puntos[i] = puntos[i] + 3;
                    }
                    if (misgoles == susgoles) {
                        puntos[i] = puntos[i] + 1;
                    }
                    if (susgoles < misgoles) {
                        puntos[i] = puntos[i] + 0;
                    }
                }
            }
            for (int i = 0; i < puntos.length; i++) {//se acomodan los equipos y los puntos en la tabla
                for (int e = 1; e < puntos.length; e++) {
                    if (puntos[i] > puntos[e]) {
                        int auxpuntos = puntos[i];
                        puntos[i] = puntos[e];
                        puntos[e] = auxpuntos;
                        String auxequipos = todoslosequipos[i];
                        todoslosequipos[i] = todoslosequipos[e];
                        todoslosequipos[e] = auxequipos;
                    }
                }
            }
            int auxpunt = puntos[0];
            String auxequip = todoslosequipos[0];
            puntos[0] = puntos[1];
            puntos[1] = puntos[2];
            puntos[2] = puntos[3];
            puntos[3] = puntos[4];
            puntos[4] = puntos[5];
            puntos[5] = puntos[6];
            puntos[6] = puntos[7];
            puntos[7] = puntos[8];
            puntos[8] = puntos[9];
            puntos[9] = puntos[10];
            puntos[10] = puntos[11];
            puntos[11] = puntos[12];
            puntos[12] = puntos[13];
            puntos[13] = puntos[14];
            puntos[14] = puntos[15];
            puntos[15] = puntos[16];
            puntos[16] = puntos[17];
            puntos[17] = puntos[18];
            puntos[18] = puntos[19];
            puntos[19] = auxpunt;
            todoslosequipos[0] = todoslosequipos[1];
            todoslosequipos[1] = todoslosequipos[2];
            todoslosequipos[2] = todoslosequipos[3];
            todoslosequipos[3] = todoslosequipos[4];
            todoslosequipos[4] = todoslosequipos[5];
            todoslosequipos[5] = todoslosequipos[6];
            todoslosequipos[6] = todoslosequipos[7];
            todoslosequipos[7] = todoslosequipos[8];
            todoslosequipos[8] = todoslosequipos[9];
            todoslosequipos[9] = todoslosequipos[10];
            todoslosequipos[10] = todoslosequipos[11];
            todoslosequipos[11] = todoslosequipos[12];
            todoslosequipos[12] = todoslosequipos[13];
            todoslosequipos[13] = todoslosequipos[14];
            todoslosequipos[14] = todoslosequipos[15];
            todoslosequipos[15] = todoslosequipos[16];
            todoslosequipos[16] = todoslosequipos[17];
            todoslosequipos[17] = todoslosequipos[18];
            todoslosequipos[18] = todoslosequipos[19];
            todoslosequipos[19] = auxequip;
            for (int i = 0; i < puntos.length; i++) {
                System.out.println(puntos[i]);
                listModelEquipos.addElement(todoslosequipos[i]);
                listModelPuntos.addElement(puntos[i]);
            }
        }
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnComenzarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarPartidoActionPerformed
        // TODO add your handling code here:
        btnComenzarPartido.setVisible(false);
        startTimer();

    }//GEN-LAST:event_btnComenzarPartidoActionPerformed

    private void btnSegTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSegTiempoActionPerformed
        // TODO add your handling code here:        
        btnSegTiempo.setVisible(false);
        startTimer();

    }//GEN-LAST:event_btnSegTiempoActionPerformed

    private void btnGuardarAlin343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlin343ActionPerformed
        // TODO add your handling code here:
        titulares[0] = btnArq343.getText();
        titulares[1] = btnDefDer343.getText();
        titulares[2] = btnDefCtr343.getText();
        titulares[3] = btnDefIzq343.getText();
        titulares[4] = btnMedDer343.getText();
        titulares[5] = btnMedCenDer343.getText();
        titulares[6] = btnMedCenIzq343.getText();
        titulares[7] = btnMedIzq343.getText();
        titulares[8] = btnDelDer343.getText();
        titulares[9] = btnDelCtr343.getText();
        titulares[10] = btnDelIzq343.getText();
        suplentes[0] = btnArqSup343.getText();
        suplentes[1] = btnDefSup1343.getText();
        suplentes[2] = btnDefSup2343.getText();
        suplentes[3] = btnDefSup3343.getText();
        suplentes[4] = btnMedSup343.getText();
        suplentes[5] = btnMedSup2343.getText();
        suplentes[6] = btnDelSup343.getText();

        listModelTit.clear();
        for (int i = 0; i < 11; i++) {
            listModelTit.addElement(titulares[i]);
        }

        frmAlineacion343.hide();
        frmEquipo.setVisible(true);
        frmEquipo.setSize(450, 340);
        frmEquipo.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnGuardarAlin343ActionPerformed

    private void btnArq343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArq343ActionPerformed
        // TODO add your handling code here:
        btnArqSup343.setEnabled(true);
        btnArq343.setEnabled(false);
        btnCancelarAlin343.setEnabled(true);
    }//GEN-LAST:event_btnArq343ActionPerformed

    private void btnCancelarAlin343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlin343ActionPerformed
        // TODO add your handling code here:
        frmAlineacion343.hide();
        frmEquipo.setVisible(true);
        frmEquipo.setSize(450, 340);
        frmEquipo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCancelarAlin343ActionPerformed

    private void btnArqSup343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArqSup343ActionPerformed
        // TODO add your handling code here:
        titulares[0] = btnArqSup343.getText();
        suplentes[0] = btnArq343.getText();
        btnArq343.setText(titulares[0]);
        btnArqSup343.setText(suplentes[0]);
        btnArqSup343.setEnabled(false);
        btnArq343.setEnabled(true);
    }//GEN-LAST:event_btnArqSup343ActionPerformed

    private void btnDefDer343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefDer343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 1;
        btnDefSup1343.setEnabled(true);
        btnDefSup2343.setEnabled(true);
        btnDefSup3343.setEnabled(true);
    }//GEN-LAST:event_btnDefDer343ActionPerformed

    private void btnDefCtr343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefCtr343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 2;
        btnDefSup1343.setEnabled(true);
        btnDefSup2343.setEnabled(true);
        btnDefSup3343.setEnabled(true);
    }//GEN-LAST:event_btnDefCtr343ActionPerformed

    private void btnDefIzq343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefIzq343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 3;
        btnDefSup1343.setEnabled(true);
        btnDefSup2343.setEnabled(true);
        btnDefSup3343.setEnabled(true);
    }//GEN-LAST:event_btnDefIzq343ActionPerformed

    private void btnMedDer343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedDer343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 4;
        btnMedSup343.setEnabled(true);
        btnMedSup2343.setEnabled(true);
    }//GEN-LAST:event_btnMedDer343ActionPerformed

    private void btnMedCenDer343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedCenDer343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 5;
        btnMedSup343.setEnabled(true);
        btnMedSup2343.setEnabled(true);
    }//GEN-LAST:event_btnMedCenDer343ActionPerformed

    private void btnMedCenIzq343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedCenIzq343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 6;
        btnMedSup343.setEnabled(true);
        btnMedSup2343.setEnabled(true);
    }//GEN-LAST:event_btnMedCenIzq343ActionPerformed

    private void btnMedIzq343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedIzq343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 7;
        btnMedSup343.setEnabled(true);
        btnMedSup2343.setEnabled(true);
    }//GEN-LAST:event_btnMedIzq343ActionPerformed

    private void btnDelDer343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDer343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 8;
        btnDelSup343.setEnabled(true);
    }//GEN-LAST:event_btnDelDer343ActionPerformed

    private void btnDelCtr343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCtr343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 9;
        btnDelSup343.setEnabled(true);
    }//GEN-LAST:event_btnDelCtr343ActionPerformed

    private void btnDelIzq343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelIzq343ActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 10;
        btnDelSup343.setEnabled(true);
    }//GEN-LAST:event_btnDelIzq343ActionPerformed

    private void btnDefSup1343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefSup1343ActionPerformed
        // TODO add your handling code here:
        if (jugadorseleccionado == 1) {
            titulares[1] = btnDefSup1343.getText();
            suplentes[1] = btnDefDer343.getText();
            btnDefDer343.setText(titulares[1]);
            btnDefSup1343.setText(suplentes[1]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 2) {
            titulares[2] = btnDefSup1343.getText();
            suplentes[1] = btnDefCtr343.getText();
            btnDefCtr343.setText(titulares[2]);
            btnDefSup1343.setText(suplentes[1]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefCtr343.setEnabled(true);
        }
        if (jugadorseleccionado == 3) {
            titulares[3] = btnDefSup1343.getText();
            suplentes[1] = btnDefIzq343.getText();
            btnDefIzq343.setText(titulares[3]);
            btnDefSup1343.setText(suplentes[1]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefIzq343.setEnabled(true);
        }
    }//GEN-LAST:event_btnDefSup1343ActionPerformed

    private void btnDefSup2343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefSup2343ActionPerformed
        // TODO add your handling code here:
        if (jugadorseleccionado == 1) {
            titulares[1] = btnDefSup2343.getText();
            suplentes[2] = btnDefDer343.getText();
            btnDefDer343.setText(titulares[1]);
            btnDefSup2343.setText(suplentes[2]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 2) {
            titulares[2] = btnDefSup2343.getText();
            suplentes[2] = btnDefCtr343.getText();
            btnDefCtr343.setText(titulares[2]);
            btnDefSup2343.setText(suplentes[2]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefCtr343.setEnabled(true);
        }
        if (jugadorseleccionado == 3) {
            titulares[3] = btnDefSup2343.getText();
            suplentes[2] = btnDefIzq343.getText();
            btnDefIzq343.setText(titulares[3]);
            btnDefSup2343.setText(suplentes[2]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefIzq343.setEnabled(true);
        }
    }//GEN-LAST:event_btnDefSup2343ActionPerformed

    private void btnDefSup3343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefSup3343ActionPerformed
        // TODO add your handling code here:
        if (jugadorseleccionado == 1) {
            titulares[1] = btnDefSup3343.getText();
            suplentes[3] = btnDefDer343.getText();
            btnDefDer343.setText(titulares[1]);
            btnDefSup3343.setText(suplentes[3]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 2) {
            titulares[2] = btnDefSup3343.getText();
            suplentes[3] = btnDefCtr343.getText();
            btnDefCtr343.setText(titulares[2]);
            btnDefSup3343.setText(suplentes[3]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefCtr343.setEnabled(true);
        }
        if (jugadorseleccionado == 3) {
            titulares[3] = btnDefSup3343.getText();
            suplentes[3] = btnDefIzq343.getText();
            btnDefIzq343.setText(titulares[3]);
            btnDefSup3343.setText(suplentes[3]);
            btnDefSup1343.setEnabled(false);
            btnDefSup2343.setEnabled(false);
            btnDefSup3343.setEnabled(false);
            btnDefIzq343.setEnabled(true);
        }
    }//GEN-LAST:event_btnDefSup3343ActionPerformed

    private void btnMedSup343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSup343ActionPerformed
        // TODO add your handling code here:
        if (jugadorseleccionado == 4) {
            titulares[4] = btnMedSup343.getText();
            suplentes[4] = btnMedDer343.getText();
            btnMedDer343.setText(titulares[4]);
            btnMedSup343.setText(suplentes[4]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 5) {
            titulares[5] = btnMedSup343.getText();
            suplentes[4] = btnMedCenDer343.getText();
            btnMedCenDer343.setText(titulares[5]);
            btnMedSup343.setText(suplentes[4]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedCenDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 6) {
            titulares[6] = btnMedSup343.getText();
            suplentes[4] = btnMedCenIzq343.getText();
            btnMedCenIzq343.setText(titulares[6]);
            btnMedSup343.setText(suplentes[4]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedCenIzq343.setEnabled(true);
        }
        if (jugadorseleccionado == 7) {
            titulares[7] = btnMedSup343.getText();
            suplentes[4] = btnMedIzq343.getText();
            btnMedIzq343.setText(titulares[7]);
            btnMedSup343.setText(suplentes[4]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedIzq343.setEnabled(true);
        }
    }//GEN-LAST:event_btnMedSup343ActionPerformed

    private void btnMedSup2343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSup2343ActionPerformed
        // TODO add your handling code here:
        if (jugadorseleccionado == 4) {
            titulares[4] = btnMedSup2343.getText();
            suplentes[5] = btnMedDer343.getText();
            btnMedDer343.setText(titulares[4]);
            btnMedSup2343.setText(suplentes[5]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 5) {
            titulares[5] = btnMedSup2343.getText();
            suplentes[5] = btnMedCenDer343.getText();
            btnMedCenDer343.setText(titulares[5]);
            btnMedSup2343.setText(suplentes[5]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedCenDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 6) {
            titulares[6] = btnMedSup2343.getText();
            suplentes[5] = btnMedCenIzq343.getText();
            btnMedCenIzq343.setText(titulares[6]);
            btnMedSup2343.setText(suplentes[5]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedCenIzq343.setEnabled(true);
        }
        if (jugadorseleccionado == 7) {
            titulares[7] = btnMedSup2343.getText();
            suplentes[5] = btnMedIzq343.getText();
            btnMedIzq343.setText(titulares[7]);
            btnMedSup2343.setText(suplentes[5]);
            btnMedSup343.setEnabled(false);
            btnMedSup2343.setEnabled(false);
            btnMedIzq343.setEnabled(true);
        }
    }//GEN-LAST:event_btnMedSup2343ActionPerformed

    private void btnDelSup343ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSup343ActionPerformed
        // TODO add your handling code here:
        if (jugadorseleccionado == 8) {
            titulares[8] = btnDelSup343.getText();
            suplentes[6] = btnDelDer343.getText();
            btnDelDer343.setText(titulares[8]);
            btnDelSup343.setText(suplentes[6]);
            btnDelSup343.setEnabled(false);
            btnDelDer343.setEnabled(true);
        }
        if (jugadorseleccionado == 9) {
            titulares[9] = btnDelSup343.getText();
            suplentes[6] = btnDelCtr343.getText();
            btnDelCtr343.setText(titulares[9]);
            btnDelSup343.setText(suplentes[6]);
            btnDelSup343.setEnabled(false);
            btnDelCtr343.setEnabled(true);
        }
        if (jugadorseleccionado == 10) {
            titulares[10] = btnDelSup343.getText();
            suplentes[6] = btnDelIzq343.getText();
            btnDelIzq343.setText(titulares[10]);
            btnDelSup343.setText(suplentes[6]);
            btnDelSup343.setEnabled(false);
            btnDelIzq343.setEnabled(true);
        }

    }//GEN-LAST:event_btnDelSup343ActionPerformed

    private void btnDesseleccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesseleccActionPerformed
        // TODO add your handling code here:
        btnArq343.setEnabled(true);
        btnDefCtr343.setEnabled(true);
        btnDefDer343.setEnabled(true);
        btnDefIzq343.setEnabled(true);
        btnMedDer343.setEnabled(true);
        btnMedCenDer343.setEnabled(true);
        btnMedCenIzq343.setEnabled(true);
        btnMedIzq343.setEnabled(true);
        btnDelDer343.setEnabled(true);
        btnDelCtr343.setEnabled(true);
        btnDelIzq343.setEnabled(true);
        btnArqSup343.setEnabled(false);
        btnDefSup1343.setEnabled(false);
        btnDefSup2343.setEnabled(false);
        btnDefSup3343.setEnabled(false);
        btnMedSup343.setEnabled(false);
        btnMedSup2343.setEnabled(false);
        btnDelSup343.setEnabled(false);
    }//GEN-LAST:event_btnDesseleccActionPerformed

    private void btnArqueroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArqueroActionPerformed
        // TODO add your handling code here:
        btnArqueroSup.setEnabled(true);
        btnArquero.setEnabled(false);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnArqueroActionPerformed

    private void btnArqueroSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArqueroSupActionPerformed
        // TODO add your handling code here:
        btnDesselecjug442.setEnabled(false);
        titulares[0] = btnArqueroSup.getText();
        suplentes[0] = btnArquero.getText();
        btnArquero.setText(titulares[0]);
        btnArqueroSup.setText(suplentes[0]);
        btnArqueroSup.setEnabled(false);
        btnArquero.setEnabled(true);
    }//GEN-LAST:event_btnArqueroSupActionPerformed

    private void btnDefLatDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefLatDerActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 1;
        btnDefSup442.setEnabled(true);
        btnDefSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnDefLatDerActionPerformed

    private void btnDefCenDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefCenDerActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 2;
        btnDefSup442.setEnabled(true);
        btnDefSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnDefCenDerActionPerformed

    private void btnDefCenIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefCenIzqActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 3;
        btnDefSup442.setEnabled(true);
        btnDefSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnDefCenIzqActionPerformed

    private void btnDefLatIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefLatIzqActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 4;
        btnDefSup442.setEnabled(true);
        btnDefSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnDefLatIzqActionPerformed

    private void btnMedLatDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedLatDerActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 5;
        btnMedSup442.setEnabled(true);
        btnMedSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnMedLatDerActionPerformed

    private void btnMedCenDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedCenDerActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 6;
        btnMedSup442.setEnabled(true);
        btnMedSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnMedCenDerActionPerformed

    private void btnMedCenIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedCenIzqActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 7;
        btnMedSup442.setEnabled(true);
        btnMedSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnMedCenIzqActionPerformed

    private void btnMedLatIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedLatIzqActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 8;
        btnMedSup442.setEnabled(true);
        btnMedSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnMedLatIzqActionPerformed

    private void btnDelDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDerActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 9;
        btnDelSup442.setEnabled(true);
        btnDelSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnDelDerActionPerformed

    private void btnDelIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelIzqActionPerformed
        // TODO add your handling code here:
        jugadorseleccionado = 10;
        btnDelSup442.setEnabled(true);
        btnDelSup2442.setEnabled(true);
        btnDesselecjug442.setEnabled(true);
    }//GEN-LAST:event_btnDelIzqActionPerformed

    private void btnDefSup442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefSup442ActionPerformed
        // TODO add your handling code here:
        btnDesselecjug442.setEnabled(false);
        if (jugadorseleccionado == 1) {
            titulares[1] = btnDefSup442.getText();
            suplentes[1] = btnDefLatDer.getText();
            btnDefLatDer.setText(titulares[1]);
            btnDefSup442.setText(suplentes[1]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefLatDer.setEnabled(true);
        }
        if (jugadorseleccionado == 2) {
            titulares[2] = btnDefSup442.getText();
            suplentes[1] = btnDefCenDer.getText();
            btnDefCenDer.setText(titulares[2]);
            btnDefSup442.setText(suplentes[1]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefCenDer.setEnabled(true);
        }
        if (jugadorseleccionado == 3) {
            titulares[3] = btnDefSup442.getText();
            suplentes[1] = btnDefCenIzq.getText();
            btnDefCenIzq.setText(titulares[3]);
            btnDefSup442.setText(suplentes[1]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefCenIzq.setEnabled(true);
        }
        if (jugadorseleccionado == 4) {
            titulares[4] = btnDefSup442.getText();
            suplentes[1] = btnDefLatIzq.getText();
            btnDefLatIzq.setText(titulares[4]);
            btnDefSup442.setText(suplentes[1]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefLatIzq.setEnabled(true);
        }
    }//GEN-LAST:event_btnDefSup442ActionPerformed

    private void btnDefSup2442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefSup2442ActionPerformed
        // TODO add your handling code here:
        btnDesselecjug442.setEnabled(false);
        if (jugadorseleccionado == 1) {
            titulares[1] = btnDefSup2442.getText();
            suplentes[2] = btnDefLatDer.getText();
            btnDefLatDer.setText(titulares[1]);
            btnDefSup2442.setText(suplentes[2]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefLatDer.setEnabled(true);
        }
        if (jugadorseleccionado == 2) {
            titulares[2] = btnDefSup2442.getText();
            suplentes[2] = btnDefCenDer.getText();
            btnDefCenDer.setText(titulares[2]);
            btnDefSup2442.setText(suplentes[2]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefCenDer.setEnabled(true);
        }
        if (jugadorseleccionado == 3) {
            titulares[3] = btnDefSup2442.getText();
            suplentes[2] = btnDefCenIzq.getText();
            btnDefCenIzq.setText(titulares[3]);
            btnDefSup2442.setText(suplentes[2]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefCenIzq.setEnabled(true);
        }
        if (jugadorseleccionado == 4) {
            titulares[4] = btnDefSup2442.getText();
            suplentes[2] = btnDefLatIzq.getText();
            btnDefLatIzq.setText(titulares[4]);
            btnDefSup2442.setText(suplentes[2]);
            btnDefSup442.setEnabled(false);
            btnDefSup2442.setEnabled(false);
            btnDefLatIzq.setEnabled(true);
        }
    }//GEN-LAST:event_btnDefSup2442ActionPerformed

    private void btnMedSup442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSup442ActionPerformed
        // TODO add your handling code here:
        btnDesselecjug442.setEnabled(false);
        if (jugadorseleccionado == 5) {
            titulares[5] = btnMedSup442.getText();
            suplentes[3] = btnMedLatDer.getText();
            btnMedLatDer.setText(titulares[5]);
            btnMedSup442.setText(suplentes[3]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedLatDer.setEnabled(true);
        }
        if (jugadorseleccionado == 6) {
            titulares[6] = btnMedSup442.getText();
            suplentes[3] = btnMedCenDer.getText();
            btnMedCenDer.setText(titulares[6]);
            btnMedSup442.setText(suplentes[3]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedCenDer.setEnabled(true);
        }
        if (jugadorseleccionado == 7) {
            titulares[7] = btnMedSup442.getText();
            suplentes[3] = btnMedCenIzq.getText();
            btnMedCenIzq.setText(titulares[7]);
            btnMedSup442.setText(suplentes[3]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedCenIzq.setEnabled(true);
        }
        if (jugadorseleccionado == 8) {
            titulares[8] = btnMedSup442.getText();
            suplentes[3] = btnMedLatIzq.getText();
            btnMedLatIzq.setText(titulares[8]);
            btnMedSup442.setText(suplentes[3]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedLatIzq.setEnabled(true);
        }
    }//GEN-LAST:event_btnMedSup442ActionPerformed

    private void btnMedSup2442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSup2442ActionPerformed
        // TODO add your handling code here:
        btnDesselecjug442.setEnabled(false);
        if (jugadorseleccionado == 5) {
            titulares[5] = btnMedSup2442.getText();
            suplentes[4] = btnMedLatDer.getText();
            btnMedLatDer.setText(titulares[5]);
            btnMedSup2442.setText(suplentes[4]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedLatDer.setEnabled(true);
        }
        if (jugadorseleccionado == 6) {
            titulares[6] = btnMedSup2442.getText();
            suplentes[4] = btnMedCenDer.getText();
            btnMedCenDer.setText(titulares[6]);
            btnMedSup2442.setText(suplentes[4]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedCenDer.setEnabled(true);
        }
        if (jugadorseleccionado == 7) {
            titulares[7] = btnMedSup2442.getText();
            suplentes[4] = btnMedCenIzq.getText();
            btnMedCenIzq.setText(titulares[7]);
            btnMedSup2442.setText(suplentes[4]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedCenIzq.setEnabled(true);
        }
        if (jugadorseleccionado == 8) {
            titulares[8] = btnMedSup2442.getText();
            suplentes[4] = btnMedLatIzq.getText();
            btnMedLatIzq.setText(titulares[8]);
            btnMedSup2442.setText(suplentes[4]);
            btnMedSup442.setEnabled(false);
            btnMedSup2442.setEnabled(false);
            btnMedLatIzq.setEnabled(true);
        }
    }//GEN-LAST:event_btnMedSup2442ActionPerformed

    private void btnDelSup442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSup442ActionPerformed
        // TODO add your handling code here:
        btnDesselecjug442.setEnabled(false);
        if (jugadorseleccionado == 9) {
            titulares[9] = btnDelSup442.getText();
            suplentes[5] = btnDelDer.getText();
            btnDelDer.setText(titulares[9]);
            btnDelSup442.setText(suplentes[5]);
            btnDelSup442.setEnabled(false);
            btnDelSup2442.setEnabled(false);
            btnDelDer.setEnabled(true);
        }
        if (jugadorseleccionado == 10) {
            titulares[10] = btnDelSup442.getText();
            suplentes[5] = btnDelIzq.getText();
            btnDelIzq.setText(titulares[10]);
            btnDelSup442.setText(suplentes[5]);
            btnDelSup442.setEnabled(false);
            btnDelSup2442.setEnabled(false);
            btnDelIzq.setEnabled(true);
        }
    }//GEN-LAST:event_btnDelSup442ActionPerformed

    private void btnDelSup2442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSup2442ActionPerformed
        // TODO add your handling code here:
        btnDesselecjug442.setEnabled(false);
        if (jugadorseleccionado == 9) {
            titulares[9] = btnDelSup2442.getText();
            suplentes[6] = btnDelDer.getText();
            btnDelDer.setText(titulares[9]);
            btnDelSup2442.setText(suplentes[6]);
            btnDelSup442.setEnabled(false);
            btnDelSup2442.setEnabled(false);
            btnDelDer.setEnabled(true);
        }
        if (jugadorseleccionado == 10) {
            titulares[10] = btnDelSup2442.getText();
            suplentes[6] = btnDelIzq.getText();
            btnDelIzq.setText(titulares[10]);
            btnDelSup2442.setText(suplentes[6]);
            btnDelSup442.setEnabled(false);
            btnDelSup2442.setEnabled(false);
            btnDelIzq.setEnabled(true);
        }
    }//GEN-LAST:event_btnDelSup2442ActionPerformed

    private void btnGuardarAlin442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlin442ActionPerformed
        // TODO add your handling code here:
        titulares[0] = btnArquero.getText();
        titulares[1] = btnDefLatDer.getText();
        titulares[2] = btnDefCenDer.getText();
        titulares[3] = btnDefCenIzq.getText();
        titulares[4] = btnDefLatIzq.getText();
        titulares[5] = btnMedLatDer.getText();
        titulares[6] = btnMedCenDer.getText();
        titulares[7] = btnMedCenIzq.getText();
        titulares[8] = btnMedLatIzq.getText();
        titulares[9] = btnDelDer.getText();
        titulares[10] = btnDelIzq.getText();
        suplentes[0] = btnArqueroSup.getText();
        suplentes[1] = btnDefSup442.getText();
        suplentes[2] = btnDefSup2442.getText();
        suplentes[3] = btnMedSup442.getText();
        suplentes[4] = btnMedSup2442.getText();
        suplentes[5] = btnDelSup442.getText();
        suplentes[6] = btnDelSup2442.getText();

        listModelTit.clear();
        listModelSup.clear();
        for (int i = 0; i < 11; i++) {
            listModelTit.addElement(titulares[i]);
        }
        for (int i = 0; i < 7; i++) {
            listModelSup.addElement(suplentes[i]);
        }
        frmAlineacion442.hide();
        frmEquipo.setVisible(true);
        frmEquipo.setSize(450, 340);
        frmEquipo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnGuardarAlin442ActionPerformed

    private void btnCancelarAlin442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlin442ActionPerformed
        // TODO add your handling code here:
        frmAlineacion442.hide();
        frmEquipo.setVisible(true);
        frmEquipo.setSize(450, 340);
        frmEquipo.setLocationRelativeTo(null);
        for (int i = 0; i < 11; i++) {
            titulares[i] = (String) (listModelTit.getElementAt(i));
        }
        for (int i = 0; i < 7; i++) {
            suplentes[i] = (String) (listModelSup.getElementAt(i));
        }
        btnDesselecjug442.setEnabled(false);
        btnArqueroSup.setEnabled(false);
        btnDefSup442.setEnabled(false);
        btnDefSup2442.setEnabled(false);
        btnMedSup442.setEnabled(false);
        btnMedSup2442.setEnabled(false);
        btnDelSup442.setEnabled(false);
        btnDelSup2442.setEnabled(false);
        btnArquero.setText(titulares[0]);
        btnDefLatDer.setText(titulares[1]);
        btnDefCenDer.setText(titulares[2]);
        btnDefCenIzq.setText(titulares[3]);
        btnDefLatIzq.setText(titulares[4]);
        btnMedLatDer.setText(titulares[5]);
        btnMedCenDer.setText(titulares[6]);
        btnMedCenIzq.setText(titulares[7]);
        btnMedLatIzq.setText(titulares[8]);
        btnDelDer.setText(titulares[9]);
        btnDelIzq.setText(titulares[10]);
        btnArqueroSup.setText(suplentes[0]);
        btnDefSup442.setText(suplentes[1]);
        btnDefSup2442.setText(suplentes[2]);
        btnMedSup442.setText(suplentes[3]);
        btnMedSup2442.setText(suplentes[4]);
        btnDelSup442.setText(suplentes[5]);
        btnDelSup2442.setText(suplentes[6]);
    }//GEN-LAST:event_btnCancelarAlin442ActionPerformed

    private void btnDesselecjug442ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesselecjug442ActionPerformed
        // TODO add your handling code here:
        btnArquero.setEnabled(true);
        btnDefLatDer.setEnabled(true);
        btnDefCenDer.setEnabled(true);
        btnDefCenIzq.setEnabled(true);
        btnDefLatIzq.setEnabled(true);
        btnMedLatDer.setEnabled(true);
        btnMedCenDer.setEnabled(true);
        btnMedCenIzq.setEnabled(true);
        btnMedLatIzq.setEnabled(true);
        btnDelDer.setEnabled(true);
        btnDelIzq.setEnabled(true);
        btnArqueroSup.setEnabled(false);
        btnDefSup442.setEnabled(false);
        btnDefSup2442.setEnabled(false);
        btnMedSup442.setEnabled(false);
        btnMedSup2442.setEnabled(false);
        btnDelSup442.setEnabled(false);
        btnDelSup2442.setEnabled(false);
        btnDesselecjug442.setEnabled(false);
    }//GEN-LAST:event_btnDesselecjug442ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        CrearArchivo j = new CrearArchivo();
        j.nuevoarchivogardadotitulares("Titulares", titulares[0], titulares[1], titulares[2], titulares[3], titulares[4], titulares[5], titulares[6], titulares[7], titulares[8], titulares[9], titulares[10]);
        j.nuevoarchivoindividual("Formación", formacselec);
        j.nuevoarchivoindividual("Partidos jugados", "" + pjugados);
        j.nuevoarchivogardadosuplentes("Suplentes", suplentes[0], suplentes[1], suplentes[2], suplentes[3], suplentes[4], suplentes[5], suplentes[6]);
        j.nuevoarchivoindividual("Guardado", "1");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnContinuarFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarFinalActionPerformed
        // TODO add your handling code here:
        frmFinal.hide();
        frmCreditos.setVisible(true);
        frmCreditos.setSize(410, 200);
        frmCreditos.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnContinuarFinalActionPerformed

    private void btnContinuarCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarCreditosActionPerformed
        // TODO add your handling code here:
        frmCreditos.hide();
        new FutbolManagger().setVisible(true);
    }//GEN-LAST:event_btnContinuarCreditosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJuego().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlineacion;
    private javax.swing.JButton btnArq343;
    private javax.swing.JButton btnArqSup343;
    private javax.swing.JButton btnArquero;
    private javax.swing.JButton btnArqueroSup;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnAtras1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarAlin343;
    private javax.swing.JButton btnCancelarAlin442;
    private javax.swing.JButton btnComenzarPartido;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnContinuarCreditos;
    private javax.swing.JButton btnContinuarFinal;
    private javax.swing.JButton btnDefCenDer;
    private javax.swing.JButton btnDefCenIzq;
    private javax.swing.JButton btnDefCtr343;
    private javax.swing.JButton btnDefDer343;
    private javax.swing.JButton btnDefIzq343;
    private javax.swing.JButton btnDefLatDer;
    private javax.swing.JButton btnDefLatIzq;
    private javax.swing.JButton btnDefSup1343;
    private javax.swing.JButton btnDefSup2343;
    private javax.swing.JButton btnDefSup2442;
    private javax.swing.JButton btnDefSup3343;
    private javax.swing.JButton btnDefSup442;
    private javax.swing.JButton btnDelCtr343;
    private javax.swing.JButton btnDelDer;
    private javax.swing.JButton btnDelDer343;
    private javax.swing.JButton btnDelIzq;
    private javax.swing.JButton btnDelIzq343;
    private javax.swing.JButton btnDelSup2442;
    private javax.swing.JButton btnDelSup343;
    private javax.swing.JButton btnDelSup442;
    private javax.swing.JButton btnDesselecc;
    private javax.swing.JButton btnDesselecjug442;
    private javax.swing.JButton btnEditarForm;
    private javax.swing.JButton btnEquipo;
    private javax.swing.JButton btnFormacion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarAlin343;
    private javax.swing.JButton btnGuardarAlin442;
    private javax.swing.JButton btnGuardarForm;
    private javax.swing.JButton btnMedCenDer;
    private javax.swing.JButton btnMedCenDer343;
    private javax.swing.JButton btnMedCenIzq;
    private javax.swing.JButton btnMedCenIzq343;
    private javax.swing.JButton btnMedDer343;
    private javax.swing.JButton btnMedIzq343;
    private javax.swing.JButton btnMedLatDer;
    private javax.swing.JButton btnMedLatIzq;
    private javax.swing.JButton btnMedSup2343;
    private javax.swing.JButton btnMedSup2442;
    private javax.swing.JButton btnMedSup343;
    private javax.swing.JButton btnMedSup442;
    private javax.swing.JButton btnPPartido;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirMP;
    private javax.swing.JButton btnSdelJuego;
    private javax.swing.JButton btnSegTiempo;
    private javax.swing.JComboBox cmbxFormaciones;
    private javax.swing.JDialog dlgSalir;
    private javax.swing.JFrame frmAlineacion343;
    private javax.swing.JFrame frmAlineacion442;
    private javax.swing.JFrame frmCreditos;
    private javax.swing.JFrame frmEquipo;
    private javax.swing.JFrame frmFinal;
    private javax.swing.JFrame frmFormación;
    private javax.swing.JFrame frmJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblContrincanteNombre;
    private javax.swing.JLabel lblFormacion;
    private javax.swing.JLabel lblFormacionActual;
    private javax.swing.JLabel lblImAlineacion;
    private javax.swing.JLabel lblImagenForm;
    private javax.swing.JLabel lblMiEquipoNombre;
    private javax.swing.JLabel lblMiMarcador;
    private javax.swing.JLabel lblSuMarcador;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JList lstEquiposTabla;
    private javax.swing.JList lstPuntos;
    private javax.swing.JList lstSuplentes;
    private javax.swing.JList lstTitulares;
    // End of variables declaration//GEN-END:variables
}
