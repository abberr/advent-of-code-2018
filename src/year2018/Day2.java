package year2018;

public class Day2 extends Day {


    public Day2() {
        super(2);
    }

    @Override
    public String solveP1() {
        int nmbrOfPairs = 0;
        int nmbrOfTrices = 0;

        for (String line : input) {
            nmbrOfPairs = containsDuplicateChar(line, 2) ? nmbrOfPairs+1 : nmbrOfPairs;
            nmbrOfTrices = containsDuplicateChar(line, 3) ? nmbrOfTrices+1 : nmbrOfTrices;
        }

        return "" + nmbrOfPairs * nmbrOfTrices;
    }

    private boolean containsDuplicateChar(String line, int duplicateNumber) {

        for (char c : line.toCharArray()) {
            int nmbrOfOccurences = line.length() - line.replaceAll("" + c,"").length();
            if (nmbrOfOccurences == duplicateNumber) {
                return true;
            }
        }

        return false;
    }


    @Override
    public String solveP2() {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (differOnlyOneCharacter(input[i], input[j])) {
                    return commonCharacters(input[i], input[j]);
                }
            }
        }

        return "";
    }

    private boolean differOnlyOneCharacter(String s1, String s2) {
        int nmbrOfDifferences = 0;
        for (int i = 0; i < s1.length(); i++) {
            nmbrOfDifferences = s1.charAt(i) == s2.charAt(i) ? nmbrOfDifferences  : nmbrOfDifferences + 1;
        }

        return nmbrOfDifferences == 1;
    }

    private String commonCharacters(String s1, String s2) {
        System.out.println(s1 + "\n" + s2);
        return s1.replaceAll("[^"+s2+"]","");
    }
}
