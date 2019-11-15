import java.util.*;

public class Mainn {

    public static void main(String[] args) {
        ArrayList<String> cuadruplas = new ArrayList<String>();
        int maquinas = 2;
        MaquinaDeTuring TM1 = Maquinas.EqualBinaryWords();
        //MaquinaDeTuring TM1 = Maquinas.Sumar();


        //  boolean done = TM1.Run("010000110101#010000110101", false);
        //boolean done = TM1.Run("B111B11", false);
        //  if (done) {
//            System.out.println("The input was accepted.");
//        } else {
//            System.out.println("The input was rejected.");
//        }


        Scanner in = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("Desea crear una maquina o ejecutar una maquina");
        System.out.println("Ingrese 1 si desea ejecutar una de las maquinas de turing ya existentes, ingrese 2 si desea generar una maquina nueva");
        int opc = in.nextInt();

        if (opc == 1) {


            System.out.println("Ingrese 1 si desea la maquina de suma, Ingrese 2 si desea la maquina de igualdad");
            int num = in.nextInt();
            System.out.println("usted tiene: " + num);

            switch (num) {
                case 1:
                    System.out.println("Maquina de suma");
                    System.out.println("Por favor ingrese el input, los numeros deben estar separados por");
                    String input = in.nextLine();
                    boolean donea = TM1.Correr("111B11", false);
                    if (donea) {
                        System.out.println("The input was accepted.");
                    } else {
                        System.out.println("The input was rejected.");
                    }
                    break;
                case 2:
                    System.out.println("Maquina de igualdad");
                    System.out.println("Por favor ingrese el input, los numeros deben estar separados por #(por un bug de momento el input se cambia en el codigo)");
                    String lapruebadelinput = in.nextLine();
                    lapruebadelinput = in.nextLine();
                    boolean dones = TM1.Correr(lapruebadelinput, false);
                    //boolean dones = TM1.Run("0101#0101", false);

                    if (dones) {
                        System.out.println("The input was accepted.");
                    } else {
                        System.out.println("The input was rejected.");
                    }
                    break;
                default:
                    System.out.println("Usted ingreso una opcion incorrecta");
                    break;
            }
        } else if (opc == 2) {

            System.out.println("Ingrese el nombre de la maquina de turing que desea agregar");
            String nombre = in.nextLine();
            nombre = in.nextLine();
            System.out.println(nombre + ".nombre");

            System.out.println("Ingrese cuantos estados tendra su maquina de turing, el primer estado (1) sera el inicial, y el estado de exito sera el ultimo");
            System.out.println("considere eso al momento de ingresar cuantos estados desea tener");
            int estados = in.nextInt();

            System.out.println("Ingrese su alfabeto, separado por comas");
            String alfabeto = in.nextLine();
            alfabeto = in.nextLine();
            System.out.println(alfabeto + ".alf");
            String[] a = alfabeto.split(",");
            Set<String> VALUES = new HashSet<String>(Arrays.asList(a));
            int opcionq = 0;
            int cont = 0;
            System.out.println("Ingreso de las cuadruplas");
            while (opcionq == 0) {
                cont++;
                System.out.println(" cuadrupla " + cont);

                System.out.println("Ingrese el numero de estado desde el que estara");
                int estadoinicial = in.nextInt();
                System.out.println("Ingrese el simbolo que se tiene que detectar");
                String simbolodeteccion = in.nextLine();
                simbolodeteccion = in.nextLine();
                System.out.println(simbolodeteccion + ".sim");
                System.out.println("Ingrese el caracter que desea poner (puede ser el mismo que detecta)");
                String caracter = in.nextLine();
                System.out.println(caracter + ".car");
                System.out.println("Ingrese el estado al que debe cambiar luego de realizar el cambio de caracter");
                int estadofinal = in.nextInt();
                System.out.println("Ingrese si desea moverse a la derecha(0) o izquierda(1)");
                int mov = in.nextInt();
                boolean prueba = false;
                if ((estadoinicial > estados) || (estadofinal > estados)) {
                    System.out.println("Error, el estado inicial o final no existe dentro de los estados permitidos");
                    System.out.println("pruebe un estado menor");
                } else {
                    if (!VALUES.contains(simbolodeteccion) || !VALUES.contains(caracter)) {
                        System.out.println("Error, se ingreso un caracter que no es reconocido");
                    } else {

                        if (mov == 0) {
                            prueba = true;
                        } else if (mov == 1) {
                            prueba = false;
                        } else {
                            System.out.println("Ingreso una direccion de movimiento incorrecta");
                        }
                        String cuadrupla = String.valueOf(estadoinicial) + "," + simbolodeteccion + "," + String.valueOf(estadofinal) + "," + caracter + "," + String.valueOf(prueba);
                        System.out.println("cuadrupla: " + cuadrupla);
                        cuadruplas.add(cuadrupla);
                        System.out.println("desea ingresar otra cuadrupla? si(0)? no(1)");
                        opcionq = in.nextInt();
                    }
                }
            }
            System.out.println("Ingrese el input que desea para la maquina");
            String input = in.nextLine();
            System.out.println("input: " + input);

            System.out.println("Los datos de su maquina de turing");
            System.out.println("Nombre: " + nombre);
            System.out.println("Alfabeto: " + alfabeto);
            System.out.println("Tiene " + estados + " estados");
            System.out.println("cuadruplas:");
            for (String cuadrupla : cuadruplas) {
                System.out.println(cuadrupla + "\n");
            }

        } else {
            System.out.println("Usted ingreso una opcion incorrecta");
        }


    }

}