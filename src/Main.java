/*
 * Developed by Nima Hosseini on 3/2/19 9:42 PM.
 * Last modified 3/2/19 9:36 PM.
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        File flowers = null;
        fileChooser.showOpenDialog(null);
        flowers = fileChooser.getSelectedFile();
        // File flowers = new File("K:\\Java stuff\\AP - Prof.Bejani\\Machine Learning - 1\\iris.csv");
        for (int u = 0; u < 5; u++) {
            System.out.println("test " + (u + 1));
            Scanner fileScanner = null;
            try {
                fileScanner = new Scanner(flowers);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String[][] input = new String[151][];
            for (int i = 0; i < 151; i++) {
                input[i] = fileScanner.nextLine().split(",");
                //System.out.println(input[i][0]);
            }
            int[] indexToLearn = ProbabilityStuff.indexSelector(150, 50, 40);
            int[] indexToAsk = new int[30];
            boolean flag = false;
            System.out.println("Test case lines :");
            for (int i = 1, k = 0; i <= 150; i++, flag = false) {
                for (int j = 0; j < indexToLearn.length; j++) {
                    if (indexToLearn[j] == i) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    indexToAsk[k] = i;
                    System.out.print(indexToAsk[k] + 1 + ", ");
                    k++;
                }
            }
            Garden garden1 = new Garden(input, indexToLearn);
            System.out.println();
            garden1.probabilityExaminer(indexToAsk);
            fileScanner.close();
            System.out.println("\n\n\n");
        }
    }
}
