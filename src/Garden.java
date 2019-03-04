import java.util.Scanner;

public class Garden {
    private String[][] input;
    private int[] indexToAdd;
    private Setosa[] setosaList = new Setosa[40];
    private Versicolor[] versicolorList = new Versicolor[40];
    private Virginica[] virginicaList = new Virginica[40];

    public Garden(String[][] input, int[] indexToAdd) {
        this.input = input;
        this.indexToAdd = indexToAdd;
        addToGarden();
        averageAndVariance();
    }

    private void addToGarden() {
        for (int i = 0, j = 0, k = 0, z = 0; i < indexToAdd.length; i++) {
            if (input[indexToAdd[i]][4].equals("setosa")) {
                setosaList[j] = new Setosa(Double.parseDouble(input[indexToAdd[i]][0]), Double.parseDouble(input[indexToAdd[i]][1]), Double.parseDouble(input[indexToAdd[i]][2]), Double.parseDouble(input[indexToAdd[i]][3]));
                j++;
            } else if (input[indexToAdd[i]][4].equals("versicolor")) {
                versicolorList[k] = new Versicolor(Double.parseDouble(input[indexToAdd[i]][0]), Double.parseDouble(input[indexToAdd[i]][1]), Double.parseDouble(input[indexToAdd[i]][2]), Double.parseDouble(input[indexToAdd[i]][3]));
                k++;
            } else if (input[indexToAdd[i]][4].equals("virginica")) {
                virginicaList[z] = new Virginica(Double.parseDouble(input[indexToAdd[i]][0]), Double.parseDouble(input[indexToAdd[i]][1]), Double.parseDouble(input[indexToAdd[i]][2]), Double.parseDouble(input[indexToAdd[i]][3]));
                z++;
            }
        }
    }

    private void averageAndVariance() {
        double[] data = new double[40];
        for (int j = 0; j < 40; j++)
            data[j] = setosaList[j].petalLength;
        Setosa.petalLeAvg = ProbabilityStuff.average(data);
        Setosa.petalLeVar = ProbabilityStuff.variance(data, Setosa.petalLeAvg);
        for (int j = 0; j < 40; j++)
            data[j] = setosaList[j].petalWidth;
        Setosa.petalWiAvg = ProbabilityStuff.average(data);
        Setosa.petalWiVar = ProbabilityStuff.variance(data, Setosa.petalWiAvg);
        for (int j = 0; j < 40; j++)
            data[j] = setosaList[j].sepalLength;
        Setosa.sepalLeAvg = ProbabilityStuff.average(data);
        Setosa.sepalLeVar = ProbabilityStuff.variance(data, Setosa.sepalLeAvg);
        for (int j = 0; j < 40; j++)
            data[j] = setosaList[j].sepalWidth;
        Setosa.sepalWiAvg = ProbabilityStuff.average(data);
        Setosa.sepalWiVar = ProbabilityStuff.variance(data, Setosa.sepalWiAvg);

        for (int j = 0; j < 40; j++)
            data[j] = versicolorList[j].petalLength;
        Versicolor.petalLeAvg = ProbabilityStuff.average(data);
        Versicolor.petalLeVar = ProbabilityStuff.variance(data, Versicolor.petalLeAvg);
        for (int j = 0; j < 40; j++)
            data[j] = versicolorList[j].petalWidth;
        Versicolor.petalWiAvg = ProbabilityStuff.average(data);
        Versicolor.petalWiVar = ProbabilityStuff.variance(data, Versicolor.petalWiAvg);
        for (int j = 0; j < 40; j++)
            data[j] = versicolorList[j].sepalLength;
        Versicolor.sepalLeAvg = ProbabilityStuff.average(data);
        Versicolor.sepalLeVar = ProbabilityStuff.variance(data, Versicolor.sepalLeAvg);
        for (int j = 0; j < 40; j++)
            data[j] = versicolorList[j].sepalWidth;
        Versicolor.sepalWiAvg = ProbabilityStuff.average(data);
        Versicolor.sepalWiVar = ProbabilityStuff.variance(data, Versicolor.sepalWiAvg);


        for (int j = 0; j < 40; j++)
            data[j] = virginicaList[j].petalLength;
        Virginica.petalLeAvg = ProbabilityStuff.average(data);
        Virginica.petalLeVar = ProbabilityStuff.variance(data, Virginica.petalLeAvg);
        for (int j = 0; j < 40; j++)
            data[j] = virginicaList[j].petalWidth;
        Virginica.petalWiAvg = ProbabilityStuff.average(data);
        Virginica.petalWiVar = ProbabilityStuff.variance(data, Virginica.petalWiAvg);
        for (int j = 0; j < 40; j++)
            data[j] = virginicaList[j].sepalLength;
        Virginica.sepalLeAvg = ProbabilityStuff.average(data);
        Virginica.sepalLeVar = ProbabilityStuff.variance(data, Virginica.sepalLeAvg);
        for (int j = 0; j < 40; j++)
            data[j] = virginicaList[j].sepalWidth;
        Virginica.sepalWiAvg = ProbabilityStuff.average(data);
        Virginica.sepalWiVar = ProbabilityStuff.variance(data, Virginica.sepalWiAvg);

    }

    public void probabilityExaminer(int[] indexToExamine) {
        Scanner keyb = new Scanner(System.in);
        double successRate = 0;
        String answer;
        for (int i = 0; i < indexToExamine.length; i++) {
            //System.out.println("Enter flower's specifications:");
            //double sepalLe = keyb.nextDouble(), sepalWi = keyb.nextDouble(), petalLe = keyb.nextDouble(), petalWi = keyb.nextDouble();
            System.out.println("Flower index: " + indexToExamine[i] + "     Line: " + (indexToExamine[i] + 1) + "     Specifications:");
            double sepalLe = Double.parseDouble(input[indexToExamine[i]][0]), sepalWi = Double.parseDouble(input[indexToExamine[i]][1]),
                    petalLe = Double.parseDouble(input[indexToExamine[i]][2]), petalWi = Double.parseDouble(input[indexToExamine[i]][3]);
            System.out.println("sepal length = " + sepalLe + "    sepal width = " + sepalWi + "   petal length = " + petalLe + "    petal width = " + petalWi);
            double setosaProb, virginicaProb, versicolorProb;
            setosaProb = ProbabilityStuff.normalDistribution(sepalLe, Setosa.sepalLeAvg, Setosa.sepalLeVar)
                    * ProbabilityStuff.normalDistribution(sepalWi, Setosa.sepalWiAvg, Setosa.sepalWiVar)
                    * ProbabilityStuff.normalDistribution(petalLe, Setosa.petalLeAvg, Setosa.petalLeVar)
                    * ProbabilityStuff.normalDistribution(petalWi, Setosa.petalWiAvg, Setosa.petalWiVar);

            virginicaProb = ProbabilityStuff.normalDistribution(sepalLe, Virginica.sepalLeAvg, Virginica.sepalLeVar)
                    * ProbabilityStuff.normalDistribution(sepalWi, Virginica.sepalWiAvg, Virginica.sepalWiVar)
                    * ProbabilityStuff.normalDistribution(petalLe, Virginica.petalLeAvg, Virginica.petalLeVar)
                    * ProbabilityStuff.normalDistribution(petalWi, Virginica.petalWiAvg, Virginica.petalWiVar);

            versicolorProb = ProbabilityStuff.normalDistribution(sepalLe, Versicolor.sepalLeAvg, Versicolor.sepalLeVar)
                    * ProbabilityStuff.normalDistribution(sepalWi, Versicolor.sepalWiAvg, Versicolor.sepalWiVar)
                    * ProbabilityStuff.normalDistribution(petalLe, Versicolor.petalLeAvg, Versicolor.petalLeVar)
                    * ProbabilityStuff.normalDistribution(petalWi, Versicolor.petalWiAvg, Versicolor.petalWiVar);
            //   System.out.println(setosaProb + " " +virginicaProb + " " + versicolorProb);
            System.out.println("prediction: ");
            if (setosaProb > virginicaProb && setosaProb > versicolorProb)
                answer = input[1][4];
            else if (virginicaProb > setosaProb && virginicaProb > versicolorProb)
                answer = input[150][4];
            else
                answer = input[60][4];
            System.out.println(answer);
            System.out.println("Real name:\n" + input[indexToExamine[i]][4]);
            if (answer.equals(input[indexToExamine[i]][4]))
                successRate++;
            System.out.println("####################################################################################");
        }
        System.out.printf("Accuracy: %.3f", successRate / 30 * 100);
    }
}
