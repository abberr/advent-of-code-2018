package year2018;

import java.util.ArrayList;

public class Day1 extends Day{

    public Day1() {
        super(1);
    }

    @Override
    public String solveP1() {
        int sum = 0;
        for (String row : input) {
            sum += Integer.parseInt(row);
        }

        return "" + sum;
    }

    @Override
    public String solveP2() {
        int sum = 0;
        ArrayList<Integer> sums = new ArrayList<>();
        int i = 0;
        while(true) {
            sum += Integer.parseInt(input[i]);
            if (sums.contains(sum)) {
                return "" + sum;
            }

            sums.add(sum);
            i = (i + 1) % input.length;
        }
    }
}
