import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String [] args) {

        // The name of the file to open.
        String MT1 = "C:\\Users\\jazmi\\OneDrive\\Documentos\\GitHub\\MTU\\src\\MT1.txt";
        String MT2 = "C:\\Users\\jazmi\\OneDrive\\Documentos\\GitHub\\MTU\\src\\MT2.txt";
        String MT3 = "C:\\Users\\jazmi\\OneDrive\\Documentos\\GitHub\\MTU\\src\\MT3.txt";
        String MT4 = "C:\\Users\\jazmi\\OneDrive\\Documentos\\GitHub\\MTU\\src\\MT4.txt";



        // This will reference one line at a time
        String MT1t = null;
        String MT2t = null;
        String MT3t = null;
        String MT4t = null;


        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(MT1);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            MT1t = bufferedReader.readLine();
                System.out.println(MT1t);
            // Always close files.
            bufferedReader.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            MT1 + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + MT1 + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(MT2);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            MT2t = bufferedReader.readLine();
            System.out.println(MT2t);
            // Always close files.
            bufferedReader.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            MT2 + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + MT2 + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }



        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(MT3);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            MT3t = bufferedReader.readLine();
            System.out.println(MT3t);
            // Always close files.
            bufferedReader.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            MT3 + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + MT3 + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(MT4);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            MT4t = bufferedReader.readLine();
            System.out.println(MT4t);
            // Always close files.
            bufferedReader.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            MT4 + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + MT4 + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        String[] MT1fs = MT1t.split("111" );
        String[] MT2fs = MT2t.split("111" );
        String[] MT3fs = MT3t.split("111" );
        String[] MT4fs = MT4t.split("111" );

        System.out.println("Para MT1");
        System.out.println("Maquina");
        MT1fs[0]=MT1fs[0]+"111";
        System.out.println(MT1fs[0]);
        System.out.println("Cadena");
        MT1fs[1]="01"+MT1fs[1];
        System.out.println(MT1fs[1]);

        System.out.println("Para MT2");
        System.out.println("Maquina");
        MT2fs[0]=MT2fs[0]+"111";
        System.out.println(MT2fs[0]);
        System.out.println("Cadena");
        MT2fs[1]="01"+MT2fs[1];
        System.out.println(MT2fs[1]);

        System.out.println("Para MT3");
        System.out.println("Maquina");
        MT3fs[0]=MT3fs[0]+"111";
        System.out.println(MT3fs[0]);
        System.out.println("Cadena");
        MT3fs[1]="01"+MT3fs[1];
        System.out.println(MT3fs[1]);

        System.out.println("Para MT4");
        System.out.println("Maquina");
        MT4fs[0]=MT4fs[0]+"111";
        System.out.println(MT4fs[0]);
        System.out.println("Cadena");
        MT4fs[1]="01"+MT4fs[1];
        System.out.println(MT4fs[1]);

        ArrayList<String> Maquina1 = new ArrayList<String>();
        ArrayList<String> Maquina2 = new ArrayList<String>();
        ArrayList<String> Maquina3 = new ArrayList<String>();
        ArrayList<String> Maquina4 = new ArrayList<String>();


        String[] MT1EstadoInicial = MT1fs[0].split("1",2 );
        System.out.println("Estado inicial maquina 1" + MT1EstadoInicial[0]);
        String[] MT1Transiciones = MT1EstadoInicial[1].split("11");
        System.out.println("tiene " + MT1Transiciones.length+ " transiciones");
        Collections.addAll(Maquina1, MT1Transiciones);
System.out.println(Maquina1.size());
        for (String s : Maquina1) {
            System.out.println(s);
        }




    }
}
