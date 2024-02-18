import java.util.Random;
import java.util.Scanner;

/**
 * Programa de simulación de La Primitiva
 * @author MATEO,ADRI
 * @version 1.0
 * @date 16/02/24
 */
//TODO: Refactorizar para cambiar el nombre de la clase
public class CognomNom_Primitiva {
    /**
     * Método main ejecutable
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Método para mostrar el menú principal
     * @since 1.3
     */
    private static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        do {
            System.out.println("***** PRIMITIVA ******");
            System.out.println("1. Hacer apuesta");
            System.out.println("2. Girar el bombo");
            System.out.println("3. Juego nuevo");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int[] apuesta = introducirAposta();
                    int[] combinacionGanadora = calcularCombinacionGanadora();
                    int premio = comprobarAciertos(apuesta, combinacionGanadora);
                    System.out.println("El teu premi és: " + premio + " €");
                    break;
                case 2:
                    int[] combinacionGanadora1 = calcularCombinacionGanadora();
                    System.out.println("La combinació guanyadora és: " + java.util.Arrays.toString(combinacionGanadora1));
                    break;
                case 3:
                    // En construcción
                    break;
                case 4:
                    System.out.println("Sortint...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opció no vàlida. Introdueix un número del 1 al 4.");
            }
        } while (!salir);
    }

    /**
     * Método para introducir la apuesta del usuario.
     * @return un array en el que se encuentre la apuesta del usuario.
     * @since 1.0
     */

    private static int[] introducirAposta() {
        Scanner scanner = new Scanner(System.in);
        int[] apuesta = new int[7];
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Introduce la apuesta (6 números del 1 al 49):");
            for (int i = 0; i < 6; i++) {
                apuesta[i] = scanner.nextInt();
                if (apuesta[i] < 1 || apuesta[i] > 49) {
                    System.out.println("Los números deben estar entre 1 y 49. Inténtalo de nuevo.");
                    scanner.nextLine();
                    break;
                }
            }
            System.out.println("Introduce el reintegro (0 al 9):");
            apuesta[6] = scanner.nextInt();
            if (apuesta[6] < 0 || apuesta[6] > 9) {
                System.out.println("El reintegro debe estar entre 0 y 9. Inténtalo de nuevo.");
                scanner.nextLine();
            } else {
                entradaValida = true;
            }
        }

        return apuesta;
    }

    /**
     * Método para generar la combinación ganadora
     * @return un array con 7 números random, los 6 primeros (únicos) del 1 al 49 y el último del 0 al 9
     * @since 1.2
     */
    private static int[] calcularCombinacionGanadora(){

        int[] combinacion = new int[7];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int min = 1;
            int max = 49;
            combinacion[i] = random.nextInt(max - min + 1) + min;


            for (int j = 0; j < i; j++) {
                if (combinacion[i] == combinacion[j]) {
                    i--;
                    break;
                }
            }
        }

        combinacion[6] = random.nextInt(10);

        return combinacion;
    }

    /**
     * Método que calcula el premio obtenido por el jugador comparando su apuesta con la combinación ganadora.
     * @param apuesta un array de enteros representando la apuesta del jugador.
     * @param combinacionGanadora un array de enteros representando la combinación ganadora.
     * @return el premio obtenido por el jugador.
     * @since 1.1
     */
    public static int comprobarAciertos(int[] apuesta, int[] combinacionGanadora) {
        int premio = 0;
        int aciertos = 0;

        for (int i = 0; i < 6; i++) {
            if (apuesta[i] == combinacionGanadora[i]) {
                aciertos++;
                premio += 20;
            }
        }

        if (apuesta[6] == combinacionGanadora[6]) {
            premio += 6;
        }

        return premio;
    }


    /**
     * Este método lee un entero por teclado dentro de un dominio determinado
     * @param mensaje parametrizado para mostrar al usuario
     * @param min valor mínimo aceptado
     * @param max valor máximo aceptado
     * @return retorna un int
     * @since 1.0
     */
    private static int leerInt(String mensaje, int min, int max) {
        Scanner leer = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecto = false;
        do{
            System.out.println(mensaje);
            valorCorrecto = leer.hasNextInt();
            if (!valorCorrecto){
                System.out.println("ERROR: Valor no entero.");
                leer.nextLine();
            }else{ // Tengo un entero
                x = leer.nextInt();
                leer.nextLine();
                if (x < min || x > max){
                    System.out.println("Opción no válida");
                    valorCorrecto = false;
                }
            }
        }while(!valorCorrecto);

        return x;
    }

    /**
     * Este método sirve para capturar floats desde teclado con control de errores
     * @param mensaje
     * @return
     * @since 1.0
     */
    private static float leerFloat(String mensaje){
        Scanner leer = new Scanner(System.in);
        float x = 0;
        boolean valorCorrecto = false;
        do{
            System.out.print(mensaje);
            valorCorrecto = leer.hasNextFloat();

            if (!valorCorrecto){
                System.out.println("ERROR: Valor no float.");
            }else{
                x = leer.nextFloat();
            }
            leer.nextLine();
        }while(!valorCorrecto);

        return x;
    }

}
