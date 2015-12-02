import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    // Pizza contents
    private static int[] M = new int[]{120, 0, 0, 0, 0};
    private static int[] S = new int[]{90, 68, 0, 0, 0};
    private static int[] P = new int[]{44, 0, 53, 0, 0};
    private static int[] F = new int[]{37, 0, 0, 0, 69};
    private static int[] H = new int[]{100, 0, 25, 49, 0};

    public static void main(String[] args) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        int numberTests = 0;
        try {
            numberTests = Integer.parseInt(bufferRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<int[]> testCases = new ArrayList<>();
        for (int i = numberTests; i > 0; i--) {
            try {
                String line = bufferRead.readLine();
                String[] contents = line.split(" |:");
                int[] contentsInt = new int[contents.length];
                for (int j = 0; j < contents.length; j++) {
                    contentsInt[j] = Integer.parseInt(contents[j]);
                }
                /*for (int t:contentsInt) {
                    System.out.println(t);
                }*/
                testCases.add(contentsInt);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        ArrayList<String> result = testPizzas(testCases);

        for (String k : result) {
            System.out.print(k);
        }
    }

    private static ArrayList<String> testPizzas(ArrayList<int[]> testCases) {
        ArrayList<int[]> pizzasKinds = new ArrayList<>();
        pizzasKinds.add(M);
        pizzasKinds.add(S);
        pizzasKinds.add(P);
        pizzasKinds.add(F);
        pizzasKinds.add(H);
        ArrayList<String> resultss = new ArrayList<String>();
        /*for (int[] lol:pizzasKinds){
            System.out.println();
            for(int lo:lol){
                System.out.print(lo);
            }
        }*/
        for (int[] k : testCases) {
            int[] stockContent = Arrays.copyOfRange(k, 0, 5);

            int[] nOfPizzas = Arrays.copyOfRange(k, 5, 10);
            /*for (int t:nOfPizzas){
                System.out.println(t);
            }*/
            for (int r = 0; r < pizzasKinds.size(); r++) {
                int[] cc = pizzasKinds.get(r);
                int c = nOfPizzas[r];
                for (int z = 0; z < stockContent.length; z++) {
                    stockContent[z] = stockContent[z] - c * cc[z];
                    //System.out.println(c*cc[z]);
                }
            }
            for (int e : stockContent) {
                if (e < 0) {
                    resultss.add("Nein");
                    break;
                } else {
                    resultss.add("Ja");
                    break;
                }
            }
            resultss.add("\n");
        }
        return resultss;
    }
}