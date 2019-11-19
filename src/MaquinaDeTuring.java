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
            } else {
                System.out.println("No existe una transicion (estado=" + Estado_Actual + ", simbolo=" + Cinta.charAt(Simbolo_Actual) + ")");
                return false;
            }
        }
        return Estado_Actual.equals(Estado_aceptacion);
    }


}
