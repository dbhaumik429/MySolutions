package com.debu.string;

import java.io.IOException;
import java.util.*;

/**
 * Created by Aspire V3 on 09-05-2018.
 */
public class WeightedStringHackerRank {


    static String[] weightedUniformStrings(String s, int[] queries) {

        String[] result = new String[queries.length];

        List<Character> chars = new ArrayList(
                Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                ));

        Map<Character, Integer> weights = new HashMap<>();
        Map<Character, Integer> charCountMap = new HashMap<>();
        Map<Character, Boolean> charsOccured = new HashMap<>();
        Set<Integer> weightsOccured = new HashSet<>();

        for (int i = 0; i < chars.size(); i++) {
            weights.put(chars.get(i), i + 1);
        }

        for (int i = 1; i < s.length(); ++i) {
            Character c = s.charAt(i);
            charsOccured.put(c, true);

            if (c.equals(s.charAt(i - 1))) {
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    charCountMap.put(c, 2);
                }
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            weightsOccured.add(weights.get(s.substring(i,i+1)));
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            Character c = entry.getKey();

            if (charCountMap.get(c) != null) {
                Integer occuredTimes = entry.getValue();
                while (occuredTimes > 0) {
                    weightsOccured.add(weights.get(c.toString()) * occuredTimes--);
                }
            }
        }

        for (int i = 0; i < queries.length; ++i) {
            if (weightsOccured.contains(i)) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(result[resultItr]);

            if (resultItr != result.length - 1) {
                System.out.println("\n");
            }
        }

    }
}





