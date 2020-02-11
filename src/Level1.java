import java.util.*;
// Вращение матрицы на T шагов
public class Level1 {
    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {
        // данный массив строк преобразуем в двумерный массив символов
        char[][] mtrx = new char[M][N];
        for (int i = 0; i < M; i++) {
            mtrx[i] = Matrix[i].toCharArray();
        }
        int min = Math.min(M, N);
        char[][] mtrxRes = new char[M][N];
        // цикл переключения колец матрицы
        for (int indexRing = 0; indexRing < min / 2; indexRing++) {
            // цикл строк
            for (int i = indexRing; i < M - indexRing; i++) {
                // цикл столбцов
                for (int j = indexRing; j < N - indexRing; j++) {
                    int strIndex = i;
                    int colIndex = j;
                    // цикл шагов вращения
                    for (int k = 0; k < T; k++) {
                        if (strIndex >= indexRing && strIndex < M - indexRing - 1 && colIndex == indexRing) {
                            strIndex++;
                        } else if (colIndex > indexRing && colIndex < N - indexRing && strIndex == indexRing) {
                            colIndex--;
                        } else if (strIndex > indexRing && strIndex < M - indexRing && colIndex == N - indexRing - 1) {
                            strIndex--;
                        } else if (colIndex < N - indexRing - 1 && colIndex >= indexRing && strIndex == M - indexRing - 1) {
                            colIndex++;
                        }
                        mtrxRes[i][j] = mtrx[strIndex][colIndex];
                    }
                }
            }
        }
       // преобразуем измененую матрицу символов в массив строк
        for (int i = 0; i < M; i++) {
            Matrix[i] = "";
            for (int j = 0; j < N; j++) {
                Matrix[i] = Matrix[i] + mtrxRes[i][j];
            }
        }
    }
}