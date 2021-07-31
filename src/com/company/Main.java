

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for(int k=0 ; k<tests ; k++){
            int n = scanner.nextInt();
            int[][] men = new int[n][n];
            int[][] women = new int[n][n];
            int[] womenPartner = new int[n];
            int[] nextToPropose = new int[n];
            LinkedList<Integer> freeMen = new LinkedList<>();
            int[][] ranking = new int[n][n];
            Arrays.fill(womenPartner, -1);
            Arrays.fill(nextToPropose, 0);

            for(int i=0 ; i<n ; i++)
                freeMen.add(i);

            for(int i=0 ; i<n ; i++)
                for(int j=0 ; j<n ; j++)
                    men[i][j] = scanner.nextInt()-1;
            for(int i=0 ; i<n ; i++)
                for(int j=0 ; j<n ; j++) {
                    women[i][j] = scanner.nextInt() - 1;
                    ranking[i][women[i][j]] = j;
                }

            while(freeMen.size() > 0){
                int m = freeMen.getFirst();
                int w = men[m][nextToPropose[m]];
                nextToPropose[m] += 1;

                if (womenPartner[w] == -1) {
                    womenPartner[w] = m;
                    freeMen.removeFirst();
                }
                else {
                    int m1 = womenPartner[w];
                    if(ranking[w][m] < ranking[w][m1]) {
                        womenPartner[w] = m;
                        freeMen.removeFirst();
                        freeMen.add(m1);
                    }
                }
            }

            System.out.println("#" + (k+1));
            for(int i=0 ; i<n ; i++)
                System.out.printf("%d ", womenPartner[i]+1);
            System.out.println("\n");
        }
    }
}
