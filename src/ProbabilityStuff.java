import java.util.Random;

public class ProbabilityStuff {
    public static int[] indexSelector(int totalLength, int splitBy, int subLength) {
        int[] index = new int[totalLength / splitBy * subLength];
        int temp;
        boolean flag = false;
        Random ran = new Random();
        for (int i = 0, j = 0; i < totalLength / splitBy; i++) {
            for (; j < (i + 1) * subLength; j++, flag = false) {
                temp = ran.nextInt(splitBy) + 1 + i * splitBy;
                for (int k = 0; k < j; k++) {
                    if (index[k] == temp) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    j--;
                else {
                    index[j] = temp;
                    //   System.out.println(index[j]);
                }
            }
        }
        return index;
    }

    public static double average(double[] input) {
        double sum = 0;
        for (int i = 0; i < input.length; i++)
            sum += input[i];
        return sum / input.length;
    }

    public static double variance(double[] input, double avg) {
        double sum = 0;
        for (int i = 0; i < input.length; i++)
            sum += Math.pow(input[i], 2);
        return sum / input.length - Math.pow(avg, 2);
    }

    public static double normalDistribution(double x, double avg, double var) {
        return (1 / (Math.sqrt(2 * Math.PI * var))) * Math.exp(-1 * Math.pow(x - avg, 2) / (2 * var));
    }
}
