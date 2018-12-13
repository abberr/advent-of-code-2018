package year2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toCollection;

public class Day6 extends Day {

    public Day6() {
        super(6);
    }

    @Override
    public String solveP1() {

        List<Point> points = Arrays.stream(input)
                .map(Point::new)
                .collect(Collectors.toList());

        //TODO find max x & y
        Point[][] map = new Point[500][500];

        //Evaluate squares
        IntStream.range(0, map.length).forEach(y -> {
            IntStream.range(0, map[0].length).forEach(x -> {
                List<Point> closestPoints = points.stream()
                        .sorted(comparing(p -> p.manhattanDistanceTo(x, y))).limit(2)
                        .collect(toCollection(ArrayList::new));

                map[y][x] = closestPoints.get(0).manhattanDistanceTo(x, y) != closestPoints.get(1).manhattanDistanceTo(x, y) ? closestPoints.get(0) : null;
            });
        });

        //Find infinity points
        IntStream.range(0, map.length).forEach(y ->
                IntStream.range(0, map[0].length)
                        .filter(x -> y == 0 || y == map.length - 1 || x == 0 || x == map[0].length - 1)
                        .mapToObj(x -> map[y][x])
                        .distinct()
                        .forEach(p -> points.remove(p))
        );

        //Find max area
        long maxArea = points.stream().mapToLong(p ->
                Arrays.stream(map).flatMap(Arrays::stream)
                        .filter(p2 -> p2 != null)
                        .filter(p2 -> p2.equals(p))
                        .count()
        ).max().getAsLong();

        //Arrays.stream(map).flatMap(Arrays::stream).forEach(System.out::println);
        //points.stream().forEach(System.out::println);


        return "" + maxArea;
    }

    @Override
    public String solveP2() {

        List<Point> points = Arrays.stream(input)
                .map(Point::new)
                .collect(Collectors.toList());

        int[][] map = new int[500][500];

        IntStream.range(0, map.length).forEach(y ->
            IntStream.range(0, map[0].length).forEach(x ->
                map[y][x] = points.stream().mapToInt(p -> p.manhattanDistanceTo(x,y)).sum()
            )
        );

        return "" + Arrays.stream(map).flatMapToInt(Arrays::stream).filter(x -> x<10000).count();
    }


    public class Point {
        public int x, y;

        public Point(String line) {
            this.x = Integer.parseInt(line.split(", ")[0]);
            this.y = Integer.parseInt(line.split(", ")[1]);
        }

        public int manhattanDistanceTo(int x, int y) {
            return Math.abs(this.x - x) + Math.abs(this.y - y);
        }

        public String toString() {
            return "{" + x + ", " + y + "}";
        }
    }
}