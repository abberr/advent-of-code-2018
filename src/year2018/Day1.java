package year2018;

import java.util.ArrayList;
import java.util.Arrays;

public class Day1 extends Day{

    public Day1() {
        super(1);
    }

    @Override
    public String solveP1() {

        return "" + Arrays.stream(input).mapToInt(Integer::parseInt)
                .reduce((x,y) -> x+y)
                .getAsInt();
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
