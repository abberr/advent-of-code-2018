package year2018;

public class Day5 extends Day {

    public Day5() {
        super(5);
    }

    @Override
    public String solveP1() {
        String input = this.input[0];

        input = reduce(input);

        return "" + input.length();
    }

    @Override
    public String solveP2() {
        //String reducedInput = solveP1();
        String input = this.input[0];

        int minLength = Integer.MAX_VALUE;
        for (int i = 'a'; i <= 'z'; i++) {
            String newInput = input.replaceAll((char)i + "|" + (char)(i - 32), "");
            newInput = reduce(newInput);

            minLength = newInput.length() < minLength ? newInput.length() : minLength;
        }

        return "" + minLength;
    }

    public String reduce(String input) {
        while (true) {
            String inputBefore = input;
            for (int i = 'a'; i <= 'z'; i++) {
                input = input.replaceAll("" + (char) i + (char) (i - 32), "");
                input = input.replaceAll("" + (char) (i - 32) + (char) (i), "");
            }
            if (input.equals(inputBefore)) return input;
        }
    }
}
