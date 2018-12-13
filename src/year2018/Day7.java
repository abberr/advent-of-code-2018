package year2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day7 extends Day{

    public Day7() {
        super(7);
    }

    @Override
    public String solveP1() {
        List<Character>[] nodes = new ArrayList[28];
        IntStream.range(0,28).forEach(i -> nodes[i] = new ArrayList<>());

        Boolean [] hasParent = new Boolean[28];

        //TODO Compress
        Arrays.stream(input).forEach(line -> {
            char s1 = line.charAt(5);
            char s2 = line.charAt(36);
            nodes[s2 - 'A'].add(s1);
            hasParent[s1 - 'A'] = true;
        });

        //Find top of tree
        int top = IntStream.range(0,28).filter(i -> hasParent[i]).findFirst().getAsInt();
        StringBuilder sb = new StringBuilder(top);



        return null;
    }

    @Override
    public String solveP2() {
        return null;
    }

}
