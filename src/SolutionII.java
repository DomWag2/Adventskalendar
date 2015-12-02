import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Dominik Wagner on 02.12.2015.
 */
public class SolutionII {
    static int[][] field;
    int firstRule;
    int secondRule;
    int thirdRule;
    int fourthRule;


    public static void main(String[] args) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String lineF = null;
        try {
            lineF = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splittedL1 = lineF.split(" ");
        int[] lineIntsL1 = new int[splittedL1.length];
        for (int j = 0; j < splittedL1.length; j++) {
            lineIntsL1[j] = Integer.parseInt(splittedL1[j]);
        }
        int numberOfAliveRules = lineIntsL1[0];
        int numberOfBornRules = lineIntsL1[1];

        String lineF2 = null;
        try {
            lineF2 = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splittedL2 = lineF2.split(" ");
        int[] alive = new int[splittedL2.length];
        for (int j = 0; j < splittedL2.length; j++) {
            alive[j] = Integer.parseInt(splittedL2[j]);
        }

        String lineF3 = null;
        try {
            lineF3 = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splittedL3 = lineF3.split(" ");
        int[] born = new int[splittedL3.length];
        for (int j = 0; j < splittedL3.length; j++) {
            born[j] = Integer.parseInt(splittedL3[j]);
        }

        String lineF4 = null;
        try {
            lineF4 = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splittedL4 = lineF4.split(" ");
        int[] dimensions = new int[splittedL4.length];
        for (int j = 0; j < splittedL4.length; j++) {
            dimensions[j] = Integer.parseInt(splittedL4[j]);
        }
        field = new int[dimensions[0]][dimensions[1]];

        for (int z = 0; z < dimensions[0]; z++) {
            String lineFf = null;
            try {
                lineFf = bufferRead.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] splittedLff = lineFf.split(" ");
            int[] uniLine = new int[splittedLff.length];
            for (int j = 0; j < splittedLff.length; j++) {
                uniLine[j] = Integer.parseInt(splittedLff[j]);
            }
            field[z] = uniLine;
        }

        String lineFl = null;
        try {
            lineFl = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splittedLl = lineFl.split(" ");
        int[] iterations = new int[splittedLl.length];
        for (int j = 0; j < splittedLl.length; j++) {
            iterations[j] = Integer.parseInt(splittedLl[j]);
        }


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                int countNeighbours = 0;
                if ((j + 1) < field[i].length && field[i][j + 1] != 0) {
                    countNeighbours++;
                }
                if ((j - 1) >= 0 && field[i][j - 1] != 0) {
                    countNeighbours++;
                }
                if ((i + 1) < field.length && (j + 1) < field[i].length && field[i + 1][j + 1] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && (j + 1) < field[i].length && field[i - 1][j + 1] != 0) {
                    countNeighbours++;
                }
                if ((i + 1) < field.length && field[i + 1][j] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && field[i - 1][j] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && (j - 1) >= 0 && field[i - 1][j - 1] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && (j + 1) < field[i].length && field[i - 1][j + 1] != 0) {
                    countNeighbours++;
                }
                if (field[i][j] == 1 && !Arrays.asList(alive).contains(countNeighbours)) {
                    field[i][j] = 0;
                } else if (field[i][j] == 0 && Arrays.asList(born).contains(countNeighbours)) {
                    field[i][j] = 1;
                }
            }
        }


    }

    private int neighboursCheck() {
        int countNeighbours = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if ((j + 1) < field[i].length && field[i][j + 1] != 0) {
                    countNeighbours++;
                }
                if ((j - 1) >= 0 && field[i][j - 1] != 0) {
                    countNeighbours++;
                }
                if ((i + 1) < field.length && (j + 1) < field[i].length && field[i + 1][j + 1] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && (j + 1) < field[i].length && field[i - 1][j + 1] != 0) {
                    countNeighbours++;
                }
                if ((i + 1) < field.length && field[i + 1][j] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && field[i - 1][j] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && (j - 1) >= 0 && field[i - 1][j - 1] != 0) {
                    countNeighbours++;
                }
                if ((i - 1) >= 0 && (j + 1) < field[i].length && field[i - 1][j + 1] != 0) {
                    countNeighbours++;
                }
            }

        }
        return countNeighbours;
    }
}
