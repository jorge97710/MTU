import java.util.*;

public class MaquinaDeTuring {
    private Set<String> Estados;
    private Set<Transicion> Transiciones;
    private String Estado_Inicial;
    private String Estado_aceptacion;
    private String Estado_rechazo;
    private String Cinta;
    private String Estado_Actual;
    private int Simbolo_Actual;

    class Transicion {
        String Estado_base;
        char Simbolo_base;
        String Estado_objetivo;
        char Simbolo_escribir;
        boolean Accion;    //true is right, false is left

        boolean isConflicting(String state, char symbol) {
            if (state.equals(Estado_base) && symbol == Simbolo_base) {
                return true;
            } else {
                return false;
            }
        }
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

    public boolean Correr(String Cadena, boolean silentmode) {
        Estado_Actual = Estado_Inicial;
        Cinta = Cadena;

        while (!Estado_Actual.equals(Estado_aceptacion) && !Estado_Actual.equals(Estado_rechazo)) {
            boolean Hay_Transicion = false;
            Transicion Transicion_Actual = null;

            if (!silentmode) {
                if (Simbolo_Actual > 0) {
                    System.out.println(Cinta.substring(0, Simbolo_Actual) + " " + Estado_Actual + " " + Cinta.substring(Simbolo_Actual));
                } else {
                    System.out.println(" " + Estado_Actual + " " + Cinta.substring(Simbolo_Actual));
                }
            }

            Iterator<Transicion> TransicionsIterator = Transiciones.iterator();

            while (TransicionsIterator.hasNext() && !Hay_Transicion) {
                Transicion nextTransicion = TransicionsIterator.next();
                if (nextTransicion.Estado_base.equals(Estado_Actual) && nextTransicion.Simbolo_base == Cinta.charAt(Simbolo_Actual)) {
                    Hay_Transicion = true;
                    Transicion_Actual = nextTransicion;
                }
            }

            if (!Hay_Transicion) {
                System.err.println("No existe una transicion (estado=" + Estado_Actual + ", simbolo=" + Cinta.charAt(Simbolo_Actual) + ")");
                return false;
            } else {
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
            }
        }
        return Estado_Actual.equals(Estado_aceptacion);
    }

    public void AgregarEstado(String newState) {
        if (!Estados.contains(newState)) {
            Estados.add(newState);
        }
    }

    public void EstadoInicial(String newEstado_Inicial) {
        if (Estados.contains(newEstado_Inicial)) {
            Estado_Inicial = newEstado_Inicial;
        }
    }

    public void EstadoAceptacion(String newEstado_aceptacion) {
        if (Estados.contains(newEstado_aceptacion) && !Estado_rechazo.equals(newEstado_aceptacion)) {
            Estado_aceptacion = newEstado_aceptacion;
        }

    }

    public void EstadoNoAceptado(String newEstado_rechazo) {
        if (Estados.contains(newEstado_rechazo) && !Estado_aceptacion.equals(newEstado_rechazo)) {
            Estado_rechazo = newEstado_rechazo;
        }
    }

    public void AgregarTransicion(String rState, char rSymbol, String wState, char wSymbol, boolean mDirection) {
        if (!Estados.contains(rState) || !Estados.contains(wState)) {
            return;
        }

        boolean conflict = false;
        Iterator<Transicion> TransicionsIterator = Transiciones.iterator();

        while (TransicionsIterator.hasNext() && !conflict) {
            Transicion nextTransicion = TransicionsIterator.next();
            if (nextTransicion.isConflicting(rState, rSymbol)) {
                conflict = true;
            }

        }

        if (!conflict) {
            Transicion newTransicion = new Transicion();
            newTransicion.Estado_base = rState;
            newTransicion.Simbolo_base = rSymbol;
            newTransicion.Estado_objetivo = wState;
            newTransicion.Simbolo_escribir = wSymbol;
            newTransicion.Accion = mDirection;
            Transiciones.add(newTransicion);
        }
    }
}
