import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {/* The name of the file to open.*/
        MaquinaDeTuring TM1 = Maquinas.MTU1();
        String MT1 = "C:\\Users\\jazmi\\OneDrive\\Documentos\\GitHub\\MTU\\src\\MT1.txt";
        String MT1t = null;

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


        String[] MT1fs = MT1t.split("111");
        MT1fs[1] = "01" + MT1fs[1];

        String Cadena_Parseada[] = MT1fs[1].split("1");
        String prueba = "";

        for (String s : Cadena_Parseada) {
            prueba = prueba + Integer.toString(s.length());
        }

        System.out.println("a leer: " + prueba);

        boolean donea = TM1.Correr(prueba);
        if (donea) {
            System.out.println("Cadena Aceptada");
        } else {
            System.out.println("Cadena Rechazada");
        }


    }
}
