//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int numar_noduri = 4;
        int[][] adjacencyMatrix = new int[numar_noduri][numar_noduri];

        int i;
        for(i = 0; i < numar_noduri - 1; ++i) {
            adjacencyMatrix[i][i + 1] = 1;
            adjacencyMatrix[i + 1][i] = 1;
        }

        adjacencyMatrix[numar_noduri - 1][0] = 1;
        adjacencyMatrix[0][numar_noduri - 1] = 1;

        for(i = 0; i < numar_noduri - 1; ++i) {
            adjacencyMatrix[numar_noduri - 1][i] = 1;
            adjacencyMatrix[i][numar_noduri - 1] = 1;
        }

        displayMatrix(adjacencyMatrix);
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
