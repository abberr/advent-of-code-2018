package main;

import year2018.*;

public class Main {

    public static void main (String [] args) {

        Day day = new Day5();
        day.run();


        //solveAllPuzzles();
    }

    private static void solveAllPuzzles() {
        Day [] days = new Day[25];
        days[0] = new Day1();
        days[1] = new Day2();

        for (Day day : days) {
            System.out.println(day.solveP1() + "\n" + day.solveP2());
        }
    }
}
