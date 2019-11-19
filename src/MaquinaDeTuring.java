import java.util.*;

public class MaquinaDeTuring {

    public Set<String> Estados;
    public Set<Transicion> Transiciones;
    public String Estado_Inicial;
    public String Estado_aceptacion;
    public String Estado_rechazo;
    public String Cinta;
    public String Estado_Actual;
    public int Simbolo_Actual;

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");

    }

    public String Ceros(int numero) {
        StringBuilder ceros = new StringBuilder();

        for (int i = 0; i < numero; i++) {
            ceros.append("0");
        }

        return ceros.toString();
    }

    public MaquinaDeTuring() {
        Estados = new HashSet<String>();
        Transiciones = new HashSet<Transicion>();
        Estado_Inicial = new String("");
        Estado_aceptacion = new String("");
        Estado_rechazo = new String("");
        Cinta = new String("");
        Estado_Actual = new String("");
        Simbolo_Actual = 0;
    }

    public void AgregarEstado(String Estado) {
        if (!Estados.contains(Estado)) Estados.add(Estado);
    }

    public void EstadoInicial(String Estado_Inicial) {
        if (Estados.contains(Estado_Inicial)) this.Estado_Inicial = Estado_Inicial;
    }

    public void EstadoAceptacion(String Estado_aceptacion) {
        if (Estados.contains(Estado_aceptacion) && !Estado_rechazo.equals(Estado_aceptacion)) {
            this.Estado_aceptacion = Estado_aceptacion;
        }
    }

    public void EstadoNoAceptado(String Estado_rechazo) {
        if (Estados.contains(Estado_rechazo) && !Estado_aceptacion.equals(Estado_rechazo)) {
            this.Estado_rechazo = Estado_rechazo;
        }
    }

    static class Transicion {
        String Estado_base;
        char Simbolo_base;
        String Estado_objetivo;
        char Simbolo_escribir;
        boolean Accion;
    }

    public void AgregarTransicion(String Estado_Actual, char Simbolo_Actual, String Estado_Destino, char Simbolo_escribir, boolean Acc) {
        if (Estados.contains(Estado_Actual) && Estados.contains(Estado_Destino)) {
            Transicion newTransicion = new Transicion();
            newTransicion.Estado_base = Estado_Actual;
            newTransicion.Simbolo_base = Simbolo_Actual;
            newTransicion.Estado_objetivo = Estado_Destino;
            newTransicion.Simbolo_escribir = Simbolo_escribir;
            newTransicion.Accion = Acc;
            Transiciones.add(newTransicion);
        }
    }

    public boolean Correr(String Cadena) {
        Estado_Actual = Estado_Inicial;
        Cinta = Cadena;


//Tenemos la primera impresion
        System.out.println("\nCinta 1");
        StringBuilder impc1 = new StringBuilder("_");
        impc1.append("q");
        impc1.append(Ceros(Integer.parseInt(Estado_Inicial.split("q")[1]) + 2)).append("1");

        for (Transicion s : Transiciones) {
            int val1, val2, val3, val4, val5;
            if (s.Estado_base.equals("qa")) {
                val1 = 1;
            } else if (s.Estado_base.equals("qr")) {
                val1 = 2;
            } else {
                val1 = Integer.parseInt(s.Estado_base.split("q")[1]) + 2;

            }
            val2 = Integer.parseInt(String.valueOf(s.Simbolo_base));


            if (s.Estado_objetivo.equals("qa")) {
                val3 = 1;
            } else if (s.Estado_objetivo.equals("qr")) {
                val3 = 2;
            } else {
                val3 = Integer.parseInt(s.Estado_objetivo.split("q")[1]) + 2;
            }

            val4 = Integer.parseInt(String.valueOf(s.Simbolo_escribir));

            if (s.Accion) {
                val5 = 3;
            } else {
                val5 = 2;
            }

            //  System.out.println(s.Estado_base + "-" + s.Simbolo_base + "-" + s.Estado_objetivo + "-" + s.Simbolo_escribir + "-" + s.Accion);
            //System.out.println(Ceros(val1) + "1"+Ceros(val2) + "1"+Ceros(val3) + "1"+Ceros(val4) + "1"+Ceros(val5) + "11");

            impc1.append(Ceros(val1)).append("1").append(Ceros(val2)).append("1").append(Ceros(val3)).append("1").append(Ceros(val4)).append("1").append(Ceros(val5)).append("11");
        }
        impc1.append("1");
        System.out.println(impc1);

        System.out.println("\nCinta 2");
        StringBuilder impc2 = new StringBuilder();
        for (int i = 0; i < Cinta.length(); i++) {
            impc2.append(Ceros(Integer.parseInt(String.valueOf(Cinta.charAt(i))))).append("1");
        }
        System.out.println("_q" + impc2 + "_");
        System.out.println("\nCinta 3");
        System.out.println("_q" + Ceros(Integer.parseInt(Estado_Inicial.split("q")[1]) + 2) + "_\n");


        while (!Estado_Actual.equals(Estado_aceptacion) && !Estado_Actual.equals(Estado_rechazo)) {
            boolean Hay_Transicion = false;
            Transicion Transicion_Actual = null;


            if (Simbolo_Actual <= 0) {
                System.out.println(" " + Estado_Actual + " " + Cinta.substring(Simbolo_Actual));
            } else {
                System.out.println(Cinta.substring(0, Simbolo_Actual) + " " + Estado_Actual + " " + Cinta.substring(Simbolo_Actual));
            }


            Iterator<Transicion> Conjunto_Transiciones = Transiciones.iterator();
            while (Conjunto_Transiciones.hasNext() && !Hay_Transicion) {
                Transicion Opcion_Transicion = Conjunto_Transiciones.next();
                if (Opcion_Transicion.Estado_base.equals(Estado_Actual) && Opcion_Transicion.Simbolo_base == Cinta.charAt(Simbolo_Actual)) {
                    Hay_Transicion = true;
                    Transicion_Actual = Opcion_Transicion;
                }
            }

            if (Hay_Transicion) {
                Estado_Actual = Transicion_Actual.Estado_objetivo;
                char[] tempCinta = Cinta.toCharArray();
                tempCinta[Simbolo_Actual] = Transicion_Actual.Simbolo_escribir;
                Cinta = new String(tempCinta);

//Final de determinacion de transicion actual (imprimir cintas aca)



                String valor;
                StringBuilder cadenados = new StringBuilder();
                if (Simbolo_Actual <= 0) {
                    valor = " " + Estado_Actual + " " + Cinta.substring(Simbolo_Actual);
                } else {
                    valor = Cinta.substring(0, Simbolo_Actual) + " " + Estado_Actual + " " + Cinta.substring(Simbolo_Actual);
                }


                for (int i = 0; i < valor.length(); i++) {
                    if (isNumeric(String.valueOf(valor.charAt(i)))) {
                        cadenados.append(Ceros(Integer.parseInt(String.valueOf(valor.charAt(i))))).append("1");
                        // System.out.println(Ceros(Integer.parseInt(String.valueOf(valor.charAt(i)))));
                    } else if (String.valueOf(valor.charAt(i)).equals("q")) {
                        cadenados.append("q");
                        //System.out.println("q");
                    }

                }
                System.out.println("\nCinta 2");

                System.out.println("_" + cadenados + "_");


                if (Transicion_Actual.Accion) {
                    Simbolo_Actual++;
                } else {
                    Simbolo_Actual--;
                }

                if (Simbolo_Actual < 0)
                    Simbolo_Actual = 0;

                while (Cinta.length() <= Simbolo_Actual) {
                    Cinta = Cinta.concat("_");
                }


                System.out.println("\nCinta 3");
                int val1;
                if (Estado_Actual.equals("qa")) {
                    val1 = 1;
                } else if (Estado_Actual.equals("qr")) {
                    val1 = 2;
                } else {
                    val1 = Integer.parseInt(Estado_Actual.split("q")[1]) + 2;

                }
                System.out.println("_q" + Ceros(val1) + "_\n");


            } else {
                System.out.println("No existe una transicion (estado=" + Estado_Actual + ", simbolo=" + Cinta.charAt(Simbolo_Actual) + ")");
                return false;
            }
        }

        return Estado_Actual.equals(Estado_aceptacion);
    }


}
