import java.util.Random;
import java.util.Scanner;

/**
 * Programa de simulació de La Primitiva
 * @auhor //TODO: Nom Alumne
 * @version 1.0
 * @date //TODO: data
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
     * //Métode per mostrar el menú principal
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

            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    int[] aposta = introduirAposta();
                    int[] combinacioGuanyadora = calcularCombinacioGuanyadora();
                    int premi = comprovarEncerts(aposta, combinacioGuanyadora);
                    System.out.println("El teu premi és: " + premi + " €");
                    break;
                case 2:
                    calcularCombinacioGuanyadora();
                    int[] combinacioGuanyadora1 = calcularCombinacioGuanyadora();
                    System.out.println("La combinació guanyadora és: " + combinacioGuanyadora1);
                    break;
                case 3:
                    //En construcció
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
     * //TODO: Completasr
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = null;

        //TODO: Fer el codi del mètode

        return aposta;
    }

    /**
     * Metodo para generar la combinación ganadora
     * @return un array con 7 numeros random, los 6 primeros (únicos) del 1 al 49 y el último del 0 al 9
     * @since 1.2
     */
    private static int[] calcularCombinacioGuanyadora(){

        int[] combinacio = new int[7];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int min = 1;
            int max = 49;
            combinacio[i] = random.nextInt(max - min + 1) + min;


            for (int j = 0; j < i; j++) {
                if (combinacio[i] == combinacio[j]) {
                    i--;
                    break;
                }
            }
        }

        combinacio[6] = random.nextInt(10);

        return combinacio;
    }

    /**
     * //TODO: Completar
     * @param aposta //TODO: Completar
     * @param combinacioGuanyadora //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
        //TODO: Fer el codi del mètode

        //Comprobar reintegrament
        //TODO: Fer el codi del mètode

        //Calcular premi
        //TODO: Fer el codi del mètode

        return premi;
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
