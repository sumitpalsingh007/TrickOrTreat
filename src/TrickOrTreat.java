import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrickOrTreat {

    static int totalChildren = 0;
    static int totalChildrenSum = 0;
    static int numberOfBoxes = 0;
    static List<Integer> candiesList = new ArrayList<Integer>();
    static List<Input> inputMap= new ArrayList();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (int j = 0; j < Integer.valueOf(line); j++) {
            totalChildren = 0;
            totalChildrenSum = 0;
            numberOfBoxes = 0;
            candiesList = new ArrayList<Integer>();
            String line1 = scanner.nextLine();
            String[] input = line1.split(" ");
            numberOfBoxes = Integer.valueOf(input[0]);
            for (int i = 1; i < input.length; i++) {
                candiesList.add(Integer.valueOf(input[i]));
            }
            String line2 = scanner.nextLine();
            totalChildrenSum = Integer.valueOf(line2);
            totalChildren = totalChildrenSum;
            inputMap.add(new Input(candiesList, totalChildren));
        }

        for (Input input : inputMap) {
            System.out.println(isDistributable(input.getTotalChildren(), input.getCandiesList()));
        }
    }

    private static String isDistributable(int totalChildren, final List<Integer> candiesList) {
        if (remainingSum(totalChildren, candiesList) > 0) {
            return "NO";
        }
        return "YES";
    }

    private static int remainingSum(int totalChildren, final List<Integer> candiesList) {

        if (totalChildrenSum <= 0 || candiesList.isEmpty()) {
            return totalChildren;
        }
        if (candiesList.contains(totalChildren)) {
            candiesList.remove(candiesList.indexOf(totalChildren));
            totalChildrenSum = totalChildrenSum - totalChildren;
            totalChildren = remainingSum(totalChildrenSum, candiesList);
        } else {
            totalChildren = remainingSum(totalChildren-1, candiesList);
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
