import java.util.Scanner;

/**
 * Programa de simulació de La Primitiva
 * @auhor //TODO: MATEO,ADRI
 * @version 1.0
 * @date //TODO: 16/02/24
 */
//TODO: Fer refractor per canviar el nom de la classe
public class CognomNom_Primitiva {
    /**
     * Mètode main executable
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * //TODO: Completar
     * @since 1.0
     */
    private static void menuPrincipal(){
        System.out.println("***** PRIMITIVA ******");

        int[] aposta = introduirAposta();
        int[] combinacioGuanyadora = calcularCombinacioGuanyadora();
        int premi;

        if (combinacioGuanyadora != null) {
            System.out.println("La combinació ganadora és: ");

            for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                System.out.print(combinacioGuanyadora[i] + " ");
            }

            System.out.println("Reintegrament " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);
        }

        premi = comprovarEncerts(aposta, combinacioGuanyadora);
        System.out.println("El teu premi és: "+premi+" €");
    }

    /**
     * Método para introducir la apuesta del usuario.
     * @return un array en el que se encuentre la apuesta del usuario.
     * @since 1.0
     */

    private static int[] introduirAposta() {
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
     * //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] calcularCombinacioGuanyadora(){
        int[] combinacio = null;

        //TODO: Fer el codi del mètode

        return combinacio;
    }

    /**
     * Método que calcula el premio obtenido por el jugador comparando su apuesta con la combinación ganadora.
     * @param apuesta un array de enteros representando la apuesta del jugador.
     * @param combinacionGanadora un array de enteros representando la combinación ganadora.
     * @return el premio obtenido por el jugador.
     * @since 1.1
     */
    public int comprobarAciertos(int[] apuesta, int[] combinacionGanadora) {
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
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min valor min acceptat
     * @param max valor max acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.println(missatge);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        }while(!valorCorrecte);

        return x;
    }

    /**
     * Aquest mètode serveix per capturar floats des de teclat amb control d'errors
     * @param missatge
     * @return
     * @since 1.0
     */
    private static float llegirFloat(String missatge){
        Scanner llegir = new Scanner(System.in);
        float x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.print(missatge);
            valorCorrecte = llegir.hasNextFloat();

            if (!valorCorrecte){
                System.out.println("ERROR: Valor no float.");
            }else{
                x = llegir.nextFloat();
            }
            llegir.nextLine();
        }while(!valorCorrecte);

        return x;
    }

}
