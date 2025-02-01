import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void iniciarPrograma() {
        Scanner entrada = new Scanner(System.in);
        System.out.println(ANSI.ANSI_BLUE + "Bienvenido al programa de cifrado Cesar" + ANSI.ANSI_RESET);

        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("Selecciona una de las siguientes opciones: ");
                System.out.println("\n1 Encriptar un mensaje \n2 Desencriptar un mensaje \n3 Desencriptar usando fuerza bruta \n0 salir del programa");
                System.out.println(" ");
                System.out.println(ANSI.ANSI_BLUE + "Seleccione su opción: " + ANSI.ANSI_RESET);
                int opcion = entrada.nextInt();
                System.out.println(" ");
                entrada.nextLine();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ha seleccionado encriptar un mensaje" );
                        System.out.println(ANSI.ANSI_BLUE +  "Por favor ingresa el nombre del archivo txt que deseas encriptar: "+ ANSI.ANSI_RESET);
                        String fileName = entrada.nextLine();
                        if (Validador.isFileExists(fileName)) {
                            System.out.println("El archivo ha sido validado");
                            String mensajeAhoraSiFinal = Cipher.encriptar(FileManager.readFile((fileName)), Cipher.key());
                            FileManager.writeFile(mensajeAhoraSiFinal);
                            System.out.println(ANSI.ANSI_YELLOW + "Se ha creado un archivo con su mensaje cifrado"+ ANSI.ANSI_RESET);
                            System.out.println(ANSI.ANSI_YELLOW + "Nombre del archivo: 'Mensaje Cifrado.txt'" + ANSI.ANSI_RESET);
                            opcionValida = true;
                        } else {
                            System.out.println(ANSI.ANSI_RED + "El archivo no existe. Por favor, vuelva a intentarlo." + ANSI.ANSI_RESET);
                        }
                    }
                    case 2 -> {
                        System.out.println("Ha seleccionado desencriptar un mensaje");
                        System.out.println(ANSI.ANSI_BLUE + "Ingrese el nombre del archivo a desencriptar" + ANSI.ANSI_RESET);
                        Cipher.desencriptar(FileManager.readFile(entrada.nextLine()), Cipher.key());
                        opcionValida = true;
                    }
                    case 3 -> {
                        System.out.println("Ha seleccionado desencriptar usando fuerza bruta ");
                        System.out.println(ANSI.ANSI_BLUE + "Ingrese el nombre del archivo txt a desencriptar" + ANSI.ANSI_RESET);
                        opcionValida = true;
                        BruteForce.decryptBruteForce(FileManager.readFile(entrada.nextLine()));

                    }
                    case 0 -> {
                        System.out.println(ANSI.ANSI_BLUE +"Ha seleccionado salir del programa. Hasta luego!" + ANSI.ANSI_RESET);
                        opcionValida = true;

                    }
                    default -> System.out.println(ANSI.ANSI_RED + "Ha ingresado una opcion no valida, intente nuevamente" + ANSI.ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI.ANSI_RED + "Ha ingresado una opcion no valida, intente nuevamente" + ANSI.ANSI_RESET);
                entrada.nextLine();
            } catch (IOException e) {
                System.out.println(ANSI.ANSI_RED + "El archivo ingresado no se encontró, por favor verifique el nombre del archivo" + ANSI.ANSI_RESET);
                opcionValida = false;
            }
        }
    }
}