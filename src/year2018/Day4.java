package year2018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Day4 extends Day {

    public Day4() {
        super(4);
    }

    @Override
    public String solveP1() {
        Map<Integer, Integer[]> guards = getTimetable(input);

        int maxGuard = guards.entrySet()
                .stream()
                .max((entry1, entry2) -> Arrays.stream(entry1.getValue()).mapToInt(i -> i).sum() > Arrays.stream(entry2.getValue()).mapToInt(i -> i).sum() ? 1 : -1)
                .get().getKey();

        int maxMinute = IntStream.range(0, 60)
                .reduce((a, b) -> guards.get(maxGuard)[a] < guards.get(maxGuard)[b] ? b : a)
                .getAsInt();

        return "" + maxGuard * maxMinute;
    }

    @Override
    public String solveP2() {
        Map<Integer, Integer[]> guards = getTimetable(input);

        int maxGuard = guards.entrySet().stream()
                .max((e1, e2) -> Arrays.stream(e1.getValue()).reduce(Integer::max).get() > Arrays.stream(e2.getValue()).reduce(Integer::max).get() ? 1 : -1)
                .get().getKey();

        int maxMinute = IntStream.range(0, 60)
                .reduce((a, b) -> guards.get(maxGuard)[a] < guards.get(maxGuard)[b] ? b : a)
                .getAsInt();

        return "" + maxGuard * maxMinute;
    }


    private Map<Integer, Integer[]> getTimetable(String[] input) {
        Map<Integer, Integer[]> guards = new HashMap<>();

        Arrays.sort(input);

        int guardNo = -1;
        int sleepMinute = -1;
        for (String line : input) {
            if (line.contains("#")) {
                guardNo = Integer.parseInt(line.replaceAll(".*#(\\d+).*", "$1"));
                if (!guards.containsKey(guardNo)) {
                    guards.put(guardNo, createMinuteArray());
                }
            } else if (line.contains("sleep")) {
                sleepMinute = Integer.parseInt(line.replaceAll(".*:(\\d+).*", "$1"));
            } else if (line.contains("wakes up")) {
                int wakeupMinute = Integer.parseInt(line.replaceAll(".*:(\\d+).*", "$1"));
                for (int i = sleepMinute; i < wakeupMinute; i++) {
                    guards.get(guardNo)[i] = guards.get(guardNo)[i] + 1;
                }
            }
        }
        return guards;
    }

    private static Integer[] createMinuteArray() {
        Integer[] array = new Integer[60];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        return array;
    }


}