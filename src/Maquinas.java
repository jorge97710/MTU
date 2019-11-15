public final class Maquinas {
    private Maquinas() {
    }

    public static MaquinaDeTuring Sumar(){

        MaquinaDeTuring newTM = new MaquinaDeTuring();

        newTM.AgregarEstado("q1");
        newTM.AgregarEstado("q2");
        newTM.AgregarEstado("q3");
        newTM.EstadoInicial("q1");
        newTM.EstadoAceptacion("qa");
        newTM.EstadoNoAceptado("qr");

        newTM.AgregarTransicion("q1", '1', "q1", 'B', true);
        newTM.AgregarTransicion("q1", 'B', "q2", 'B', true);
        newTM.AgregarTransicion("q2", '1', "q2", '1', true);
        newTM.AgregarTransicion("q2", 'B', "q3", 'B', true);
        newTM.AgregarTransicion("q3", '1', "q3", 'B', true);
        newTM.AgregarTransicion("q3", 'B', "qa", '_', true);

        return newTM;

    }

    public static MaquinaDeTuring EqualBinaryWords() {
        MaquinaDeTuring newTM = new MaquinaDeTuring();
        newTM.AgregarEstado("q1");
        newTM.AgregarEstado("q2");
        newTM.AgregarEstado("q3");
        newTM.AgregarEstado("q4");
        newTM.AgregarEstado("q5");
        newTM.AgregarEstado("q6");
        newTM.AgregarEstado("q7");
        newTM.AgregarEstado("q8");
        newTM.AgregarEstado("qa");
        newTM.AgregarEstado("qr");
        newTM.EstadoInicial("q1");
        newTM.EstadoAceptacion("qa");
        newTM.EstadoNoAceptado("qr");
        newTM.AgregarTransicion("q1", '1', "q3", 'x', true);
        newTM.AgregarTransicion("q1", '0', "q2", 'x', true);
        newTM.AgregarTransicion("q1", '#', "q8", '#', true);
        newTM.AgregarTransicion("q2", '0', "q2", '0', true);
        newTM.AgregarTransicion("q2", '1', "q2", '1', true);
        newTM.AgregarTransicion("q2", '#', "q4", '#', true);
        newTM.AgregarTransicion("q3", '0', "q3", '0', true);
        newTM.AgregarTransicion("q3", '1', "q3", '1', true);
        newTM.AgregarTransicion("q3", '#', "q5", '#', true);
        newTM.AgregarTransicion("q4", 'x', "q4", 'x', true);
        newTM.AgregarTransicion("q4", '0', "q6", 'x', false);
        newTM.AgregarTransicion("q5", 'x', "q5", 'x', true);
        newTM.AgregarTransicion("q5", '1', "q6", 'x', false);
        newTM.AgregarTransicion("q6", '0', "q6", '0', false);
        newTM.AgregarTransicion("q6", '1', "q6", '1', false);
        newTM.AgregarTransicion("q6", 'x', "q6", 'x', false);
        newTM.AgregarTransicion("q6", '#', "q7", '#', false);
        newTM.AgregarTransicion("q7", '0', "q7", '0', false);
        newTM.AgregarTransicion("q7", '1', "q7", '1', false);
        newTM.AgregarTransicion("q7", 'x', "q1", 'x', true);
        newTM.AgregarTransicion("q8", 'x', "q8", 'x', true);
        newTM.AgregarTransicion("q8", '_', "qa", '_', true);
        return newTM;
    }

}