package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution {

    static final List<Input> inputList= new ArrayList();

    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (int j = 0; j < Integer.valueOf(line); j++) {
            int totalChildren = 0;
            int totalChildrenSum = 0;
            int numberOfBoxes = 0;
            final List<Integer> candiesList = new ArrayList<Integer>();
            String line1 = scanner.nextLine();
            String[] input = line1.split(" ");
            numberOfBoxes = Integer.valueOf(input[0]);
            for (int i = 1; i < input.length; i++) {
                candiesList.add(Integer.valueOf(input[i]));
            }
            if (numberOfBoxes != candiesList.size()) {
                throw new Exception("invalid input");
            }
            String line2 = scanner.nextLine();
            totalChildrenSum = Integer.valueOf(line2);
            totalChildren = totalChildrenSum;
            inputList.add(new Input(candiesList, totalChildren));
        }

        for (Input input : inputList) {
            System.out.println(distribute(input.getTotalChildren(), input.getCandiesList()));
        }
    }

    private static String distribute(int totalChildren, final List<Integer> candiesList) {
        if (remainingSum(totalChildren, candiesList, totalChildren) != 0) {
            return "NO";
        }
        return "YES";
    }

    private static int remainingSum(int totalChildren, final List<Integer> candiesList, int totalChildrenSum) {

        if (totalChildren <= 0 || candiesList.isEmpty()) {
            return totalChildren;
        }
        if (candiesList.contains(totalChildren)) {
            candiesList.remove(candiesList.indexOf(totalChildren));
            totalChildrenSum = totalChildrenSum - totalChildren;
            totalChildren = remainingSum(totalChildrenSum, candiesList, totalChildrenSum);
        } else {
            totalChildren = remainingSum(totalChildren-1, candiesList, totalChildrenSum);
        }
        return totalChildren;
    }
}

class Input {
    List<Integer> candiesList;
    int totalChildren;

    Input(List<Integer> candiesList, int totalChildren) {
        this.candiesList = candiesList;
        this.totalChildren = totalChildren;
    }

    public List<Integer> getCandiesList() {
        return candiesList;
    }

    public int getTotalChildren() {
        return totalChildren;
    }
}

