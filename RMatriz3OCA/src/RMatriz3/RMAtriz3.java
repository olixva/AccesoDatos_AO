package RMatriz3;

public class RMAtriz3 {

    public static void main(String[] args) {
        int[][][] numeros = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                { { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } },
                { { 19, 20, 21 }, { 22, 23, 24 }, { 25, 26, 27 } } };

        System.out.println("Recorrido con FOR explicito:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println();
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.println();
                for (int j2 = 0; j2 < numeros[i][j].length; j2++) {
                    System.out.print(numeros[i][j][j2] + " ");
                }
            }
        }

        System.out.println("\n\nRecorrido con FOREACH");
        
        for (int[][] arrayBidimensional : numeros) {
            System.out.println();
            for (int[] arrayUnidimensional : arrayBidimensional) {
                System.out.println();
                for (int elemento : arrayUnidimensional) {
                    System.out.print(elemento + " ");
                }
            }
        }
    }

}
