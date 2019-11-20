import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Maquinas {
    private Maquinas() {
    }

    public static MaquinaDeTuring MTU1() {
        System.out.println("####################### Maquina 1 #######################");

        String MT1 = "MT1.txt";
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

        //MT1t=MT4t;

        String[] MT1fs = MT1t.split("111");

//        System.out.println("Maquina");
        MT1fs[0] = MT1fs[0] + "111";
//        System.out.println(MT1fs[0]);
//        System.out.println("Cadena");
        MT1fs[1] = "01" + MT1fs[1];

        //Maquina 1
        MaquinaDeTuring newTM = new MaquinaDeTuring();

        Set<String> Estados = new HashSet();
        String Estado_Inicial;
        String Separador_Transiciones = "11";
        String Separador_partes = "1";
        ArrayList<String> Maquina1 = new ArrayList<String>();
        ArrayList<String> Maquina2 = new ArrayList<String>();
        ArrayList<String> Maquina3 = new ArrayList<String>();
        ArrayList<String> Maquina4 = new ArrayList<String>();/*Maquina 1*/
        String[] MT1EstadoInicial = MT1fs[0].split(Separador_partes, 2);
//        System.out.println("Estado inicial maquina 1 " + MT1EstadoInicial[0]);
        Estado_Inicial = "q" + Integer.toString(MT1EstadoInicial[0].length() - 2);
//        System.out.println("el estado es: " + Estado_Inicial);
        String[] MT1Transiciones = MT1EstadoInicial[1].split(Separador_Transiciones);
        //System.out.println("tiene " + MT1Transiciones.length + " transiciones");
        Collections.addAll(Maquina1, MT1Transiciones);
        //  System.out.println(Maquina1.size());
//        System.out.println("#############Mauquina 1################");

        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //          System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
//                    System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
//                        System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
//                        System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //              System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >= 3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
//                System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                      System.out.println("Movimiento: Stay");
                        Movimiento = null;
                        break;
                    case 2:
                        //                    System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //                  System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                //newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
//                //System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//              System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }

        //System.out.println("La cadena es: " + MT1fs[1]);



        for (String s : Estados) {
            //          System.out.println("Estado : " + s +"-");
            newTM.AgregarEstado(s);
        }
        newTM.AgregarEstado("qa");
        newTM.AgregarEstado("qr");
        newTM.EstadoAceptacion("qa");
        newTM.EstadoNoAceptado("qr");
        newTM.EstadoInicial(Estado_Inicial);
        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //        System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
                    //              System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
                        //                System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
                        //              System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //    System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >= 3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
                //          System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                System.out.println("Movimiento: Stay");
                        Movimiento = true;
                        break;
                    case 2:
                        //              System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //            System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
                  System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//                System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }


        return newTM;
    }


    public static MaquinaDeTuring MTU2()
    {
        System.out.println("####################### Maquina 2 #######################");

        String MT1 = "MT2.txt";
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

        //MT1t=MT4t;

        String[] MT1fs = MT1t.split("111");

//        System.out.println("Maquina");
        MT1fs[0] = MT1fs[0] + "111";
//        System.out.println(MT1fs[0]);
//        System.out.println("Cadena");
        MT1fs[1] = "01" + MT1fs[1];

        //Maquina 1
        MaquinaDeTuring newTM = new MaquinaDeTuring();

        Set<String> Estados = new HashSet();
        String Estado_Inicial;
        String Separador_Transiciones = "11";
        String Separador_partes = "1";
        ArrayList<String> Maquina1 = new ArrayList<String>();
        ArrayList<String> Maquina2 = new ArrayList<String>();
        ArrayList<String> Maquina3 = new ArrayList<String>();
        ArrayList<String> Maquina4 = new ArrayList<String>();/*Maquina 1*/
        String[] MT1EstadoInicial = MT1fs[0].split(Separador_partes, 2);
//        System.out.println("Estado inicial maquina 1 " + MT1EstadoInicial[0]);
        Estado_Inicial = "q" + Integer.toString(MT1EstadoInicial[0].length() - 2);
//        System.out.println("el estado es: " + Estado_Inicial);
        String[] MT1Transiciones = MT1EstadoInicial[1].split(Separador_Transiciones);
        //System.out.println("tiene " + MT1Transiciones.length + " transiciones");
        Collections.addAll(Maquina1, MT1Transiciones);
        //  System.out.println(Maquina1.size());
//        System.out.println("#############Mauquina 1################");

        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //          System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
//                    System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
//                        System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
//                        System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //              System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >= 3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
//                System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                      System.out.println("Movimiento: Stay");
                        Movimiento = null;
                        break;
                    case 2:
                        //                    System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //                  System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                //newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
//                //System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//              System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }

        //System.out.println("La cadena es: " + MT1fs[1]);



        for (String s : Estados) {
            //          System.out.println("Estado : " + s +"-");
            newTM.AgregarEstado(s);
        }
        newTM.AgregarEstado("qa");
        newTM.AgregarEstado("qr");
        newTM.EstadoAceptacion("qa");
        newTM.EstadoNoAceptado("qr");
        newTM.EstadoInicial(Estado_Inicial);
        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //        System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
                    //              System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
                        //                System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
                        //              System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //    System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >= 3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
                //          System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                System.out.println("Movimiento: Stay");
                        Movimiento = true;
                        break;
                    case 2:
                        //              System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //            System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
                System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//                System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }


        return newTM;
    }


    public static MaquinaDeTuring MTU3() {
        System.out.println("####################### Maquina 3 #######################");

        String MT1 = "MT3.txt";
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

        //MT1t=MT4t;

        String[] MT1fs = MT1t.split("111");

//        System.out.println("Maquina");
        MT1fs[0] = MT1fs[0] + "111";
//        System.out.println(MT1fs[0]);
//        System.out.println("Cadena");
        MT1fs[1] = "01" + MT1fs[1];

        //Maquina 1
        MaquinaDeTuring newTM = new MaquinaDeTuring();

        Set<String> Estados = new HashSet();
        String Estado_Inicial;
        String Separador_Transiciones = "11";
        String Separador_partes = "1";
        ArrayList<String> Maquina1 = new ArrayList<String>();
        ArrayList<String> Maquina2 = new ArrayList<String>();
        ArrayList<String> Maquina3 = new ArrayList<String>();
        ArrayList<String> Maquina4 = new ArrayList<String>();/*Maquina 1*/
        String[] MT1EstadoInicial = MT1fs[0].split(Separador_partes, 2);
//        System.out.println("Estado inicial maquina 1 " + MT1EstadoInicial[0]);
        Estado_Inicial = "q" + Integer.toString(MT1EstadoInicial[0].length() - 2);
//        System.out.println("el estado es: " + Estado_Inicial);
        String[] MT1Transiciones = MT1EstadoInicial[1].split(Separador_Transiciones);
        //System.out.println("tiene " + MT1Transiciones.length + " transiciones");
        Collections.addAll(Maquina1, MT1Transiciones);
        //  System.out.println(Maquina1.size());
//        System.out.println("#############Mauquina 1################");

        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //          System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
//                    System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
//                        System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
//                        System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //              System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >= 3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
//                System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                      System.out.println("Movimiento: Stay");
                        Movimiento = null;
                        break;
                    case 2:
                        //                    System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //                  System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                //newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
//                //System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//              System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }

        //System.out.println("La cadena es: " + MT1fs[1]);



        for (String s : Estados) {
            //          System.out.println("Estado : " + s +"-");
            newTM.AgregarEstado(s);
        }
        newTM.AgregarEstado("qa");
        newTM.AgregarEstado("qr");
        newTM.EstadoAceptacion("qa");
        newTM.EstadoNoAceptado("qr");
        newTM.EstadoInicial(Estado_Inicial);
        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //        System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
                    //              System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
                        //                System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
                        //              System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //    System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >=3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
                //          System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                System.out.println("Movimiento: Stay");
                        Movimiento = true;
                        break;
                    case 2:
                        //              System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //            System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
                System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//                System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }


        return newTM;
    }

    public static MaquinaDeTuring MTU4() {
        System.out.println("####################### Maquina 4 #######################");

        String MT1 = "MT4.txt";
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

        //MT1t=MT4t;

        String[] MT1fs = MT1t.split("111");

//        System.out.println("Maquina");
        MT1fs[0] = MT1fs[0] + "111";
//        System.out.println(MT1fs[0]);
//        System.out.println("Cadena");
        MT1fs[1] = "01" + MT1fs[1];

        //Maquina 1
        MaquinaDeTuring newTM = new MaquinaDeTuring();

        Set<String> Estados = new HashSet();
        String Estado_Inicial;
        String Separador_Transiciones = "11";
        String Separador_partes = "1";
        ArrayList<String> Maquina1 = new ArrayList<String>();
        ArrayList<String> Maquina2 = new ArrayList<String>();
        ArrayList<String> Maquina3 = new ArrayList<String>();
        ArrayList<String> Maquina4 = new ArrayList<String>();/*Maquina 1*/
        String[] MT1EstadoInicial = MT1fs[0].split(Separador_partes, 2);
//        System.out.println("Estado inicial maquina 1 " + MT1EstadoInicial[0]);
        Estado_Inicial = "q" + Integer.toString(MT1EstadoInicial[0].length() - 2);
//        System.out.println("el estado es: " + Estado_Inicial);
        String[] MT1Transiciones = MT1EstadoInicial[1].split(Separador_Transiciones);
        //System.out.println("tiene " + MT1Transiciones.length + " transiciones");
        Collections.addAll(Maquina1, MT1Transiciones);
        //  System.out.println(Maquina1.size());
//        System.out.println("#############Mauquina 1################");

        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //          System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
//                    System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
//                        System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
//                        System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //              System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >= 3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
//                System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                      System.out.println("Movimiento: Stay");
                        Movimiento = null;
                        break;
                    case 2:
                        //                    System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //                  System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                //newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
//                //System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//              System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }

        //System.out.println("La cadena es: " + MT1fs[1]);



        for (String s : Estados) {
            //          System.out.println("Estado : " + s +"-");
            newTM.AgregarEstado(s);
        }
        newTM.AgregarEstado("qa");
        newTM.AgregarEstado("qr");
        newTM.EstadoAceptacion("qa");
        newTM.EstadoNoAceptado("qr");
        newTM.EstadoInicial(Estado_Inicial);
        for (String s : Maquina1) {
            String Estado_leer = null, Estado_Destino = null;
            Character Simbolo_leer, Simbolo_Escribir;
            Boolean Movimiento = null;
            //        System.out.println(s);
            String[] MT1Partes = s.split("1");
            //System.out.println(MT1Partes.length);
            if (MT1Partes.length == 5) {

                if (MT1Partes[0].length() >= 3) {
                    int l = MT1Partes[0].length();
                    //              System.out.println("Estado a leer: q" + Integer.toString(l - 2));
                    Estado_leer = "q" + Integer.toString(l - 2);
                    Estados.add("q" + Integer.toString(l - 2));
                } else {
                    if (MT1Partes[0].length() == 2) {
                        //                System.out.println("Estado a leer (rechazo): " + "qr");
                        Estado_leer = "qr";
                    }

                    if (MT1Partes[0].length() == 1) {
                        //              System.out.println("Estado a leer (aceptacion): " + "qa");
                        Estado_leer = "qa";
                    }
                }


                //    System.out.println("Simbolo a leer: " + MT1Partes[1].length());

                Simbolo_leer = (char) (MT1Partes[1].length() + '0');
                if (MT1Partes[2].length() >= 3) {
                    int l = MT1Partes[2].length();
//                    System.out.println("Estado destino: q" + Integer.toString(l - 2));
                    Estados.add("q" + Integer.toString(l - 2));
                    Estado_Destino = "q" + Integer.toString(l - 2);

                } else {
                    if (MT1Partes[2].length() == 2) {
                        //                      System.out.println("Estado destino (rechazo): " + "qr");
                        Estado_Destino = "qr";
                    }

                    if (MT1Partes[2].length() == 1) {
                        //                    System.out.println("Estado destino (aceptacion): " + "qa");
                        Estado_Destino = "qa";
                    }
                }
                //          System.out.println("Simbolo a escribir: " + MT1Partes[3].length());
                Simbolo_Escribir = (char) (MT1Partes[3].length() + '0');
                switch (MT1Partes[4].length()) {
                    case 1:
                        //                System.out.println("Movimiento: Stay");
                        Movimiento = true;
                        break;
                    case 2:
                        //              System.out.println("Movimiento: Left");
                        Movimiento = false;
                        break;
                    case 3:
                        //            System.out.println("Movimiento: Right");
                        Movimiento = true;
                        break;
                }

                newTM.AgregarTransicion(Estado_leer, Simbolo_leer, Estado_Destino, Simbolo_Escribir, Movimiento);
                System.out.println(Estado_leer+"|"+ Simbolo_leer+"|"+ Estado_Destino+ "|"+Simbolo_Escribir+"|"+Movimiento);
//                System.out.println("--------------Cambio de Transicion--------------\n");

            }
        }


        return newTM;
    }


    public static MaquinaDeTuring Sumar() {

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