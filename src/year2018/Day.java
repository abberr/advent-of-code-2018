package year2018;

import util.Util;

import java.io.IOException;

public abstract class Day {

    protected String [] input;

    public Day(int day) {
        try {
            input = Util.readInput("day" + day);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String p1 = solveP1();
        System.out.println("Part I: " + p1);

        String p2 = solveP2();
        System.out.println("Part II: " + p2);
    }

    public abstract String solveP1();
    public abstract String solveP2();


}
