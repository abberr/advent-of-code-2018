package year2018;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 extends Day {

    public Day3() {
        super(3);
    }

    public class Instruction {
        public int id, x, y, width, height;

        public Instruction(String claim) {
            String regex = "#(\\d+)\\s@\\s(\\d+),(\\d+):\\s(\\d+)x(\\d+)";
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(claim);
            matcher.find();

            this.id = Integer.parseInt(matcher.group(1));
            this.x = Integer.parseInt(matcher.group(2));
            this.y = Integer.parseInt(matcher.group(3));
            this.width = Integer.parseInt(matcher.group(4));
            this.height = Integer.parseInt(matcher.group(5));
        }
    }


    @Override
    public String solveP1() {
        int[][] rug = createRug(input);

        return "" + countOverlappingSquares(rug);
    }

    @Override
    public String solveP2() {
        int[][] rug = createRug(input);

        for (String claim : input) {
            Instruction instruction = new Instruction(claim);

            boolean overlapping = false;

            for (int i = instruction.x; i < instruction.x + instruction.width; i++) {
                for (int j = instruction.y; j < instruction.y + instruction.height; j++) {
                    if (rug[i][j] != 1) {
                        overlapping = true;
                    }
                }
            }

            if (!overlapping) {
                return "" + instruction.id;
            }
        }

        return null;
    }

    public int[][] createRug(String[] input) {
        int[][] rug = new int[1000][1000];

        for (String claim : input) {
            Instruction instruction = new Instruction(claim);

            for (int i = instruction.x; i < instruction.x + instruction.width; i++) {
                for (int j = instruction.y; j < instruction.y + instruction.height; j++) {
                    rug[i][j]++;
                }
            }
        }

        return rug;
    }

    public int countOverlappingSquares(int[][] rug) {
        int counter = 0;
        for (int i = 0; i < rug.length; i++) {
            for (int j = 0; j < rug[0].length; j++) {
                if (rug[i][j] > 1) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
