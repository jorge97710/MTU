import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {/* The name of the file to open.*/
        MaquinaDeTuring TM1 = Maquinas.MTU1();
        MaquinaDeTuring TM2 = Maquinas.MTU2();
        MaquinaDeTuring TM3 = Maquinas.MTU1();
        MaquinaDeTuring TM4 = Maquinas.MTU4();


        String MT1 = "MT1.txt";
        String MT2 = "MT2.txt";
        String MT3 = "MT3.txt";
        String MT4 = "MT4.txt";

        String MT1t = null;
        String MT2t = null;
        String MT3t = null;
        String MT4t = null;


        try {/* FileReader reads text files in the default encoding.*/
            FileReader fileReader = new FileReader(MT1);/* Always wrap FileReader in BufferedReader.*/
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            MT1t = bufferedReader.readLine();
            //       System.out.println(MT1t);/* Always close files.*/
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + MT1 + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + MT1 + "'");/* Or we could just do this: ex.printStackTrace();*/
        }

        try {/* FileReader reads text files in the default encoding.*/
            FileReader fileReader = new FileReader(MT2);/* Always wrap FileReader in BufferedReader.*/
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            MT2t = bufferedReader.readLine();
            //       System.out.println(MT1t);/* Always close files.*/
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + MT2 + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + MT2 + "'");/* Or we could just do this: ex.printStackTrace();*/
        }

        try {/* FileReader reads text files in the default encoding.*/
            FileReader fileReader = new FileReader(MT3);/* Always wrap FileReader in BufferedReader.*/
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            MT3t = bufferedReader.readLine();
            //       System.out.println(MT1t);/* Always close files.*/
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + MT3 + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + MT3 + "'");/* Or we could just do this: ex.printStackTrace();*/
        }

        try {/* FileReader reads text files in the default encoding.*/
            FileReader fileReader = new FileReader(MT4);/* Always wrap FileReader in BufferedReader.*/
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            MT4t = bufferedReader.readLine();
            //       System.out.println(MT1t);/* Always close files.*/
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + MT4 + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + MT4 + "'");/* Or we could just do this: ex.printStackTrace();*/
        }

        String[] MT1fs = MT1t.split("111");
        MT1fs[1] = "01" + MT1fs[1];
        String Cadena_Parseada[] = MT1fs[1].split("1");
        String prueba = "";
        for (String s : Cadena_Parseada) {
            prueba = prueba + Integer.toString(s.length());
        }

        System.out.println("a leer MT1: " + prueba);


        String[] MT2fs = MT2t.split("111");
        MT2fs[1] = "01" + MT2fs[1];
        String Cadena_Parseada2[] = MT2fs[1].split("1");
        String prueba2 = "";
        for (String s : Cadena_Parseada2) {
            prueba2 = prueba2 + Integer.toString(s.length());
        }

        System.out.println("a leer MT2: " + prueba2);

        String[] MT3fs = MT3t.split("111");
        MT3fs[1] = "01" + MT3fs[1];
        String Cadena_Parseada3[] = MT3fs[1].split("1");
        String prueba3 = "";
        for (String s : Cadena_Parseada3) {
            prueba3 = prueba3 + Integer.toString(s.length());
        }

        System.out.println("a leer MT3: " + prueba3);


        String[] MT4fs = MT4t.split("111");
        MT4fs[1] = "01" + MT4fs[1];
        String Cadena_Parseada4[] = MT4fs[1].split("1");
        String prueba4 = "";
        for (String s : Cadena_Parseada4) {
            prueba4 = prueba4 + Integer.toString(s.length());
        }

        System.out.println("a leer MT4: " + prueba4);

        System.out.println("####################### Maquina 1 #######################");
        boolean Maq1 = TM1.Correr(prueba,"Maquina 1");
        System.out.println("####################### Maquina 2 #######################");

        boolean Maq2 = TM2.Correr(prueba2,"Maquina 2");
        System.out.println("####################### Maquina 3 #######################");

        boolean Maq3 = TM3.Correr(prueba3,"Maquina 3");
        System.out.println("####################### Maquina 4 #######################");

        boolean Maq4 = TM4.Correr(prueba4,"Maquina 4");
        if (Maq1) {
            System.out.println("-----------------------Cadena Aceptada-----------------------");
        } else {
            System.out.println("Cadena Rechazada");
        }

        if (Maq2) {
            System.out.println("-----------------------Cadena Aceptada-----------------------");
        } else {
            System.out.println("Cadena Rechazada");
        }

        if (Maq3) {
            System.out.println("-----------------------Cadena Aceptada-----------------------");
        } else {
            System.out.println("Cadena Rechazada");
        }

        if (Maq4) {
            System.out.println("-----------------------Cadena Aceptada-----------------------");
        } else {
            System.out.println("Cadena Rechazada");
        }



    }
}
