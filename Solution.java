import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



import javafx.util.Pair;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//player class
class Player {
    String name;
    double height;
    double bmi;
    int score;
    int defends;
    PlayerType playerType;
    SelectionType selectionType;

    public static Player parseInput(List<String> tokens) {
        Player player = new Player();


        player.name = tokens.get(0);
        player.height = Double.parseDouble(tokens.get(1));
        player.bmi = Double.parseDouble(tokens.get(2));
        player.score = Integer.parseInt(tokens.get(3));
        player.defends = Integer.parseInt(tokens.get(4));

        return player;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", bmi=" + bmi +
                ", score=" + score +
                ", defends=" + defends +
                '}';
    }
}

enum PlayerType {
    STRIKER, DEFENDER, NA
}

enum SelectionType {
    SELECT, REJECT;
}

class SelectionCriteria {
    //initialize the defaults for selection criteria
    double height = 5.8;
    double bmi = 23;
    int score = 50;
    int defends = 30;

    public Pair<SelectionType, PlayerType> analyzePlayer(Player p) {
        if (p.height < height || p.bmi >= bmi || (p.score < score && p.defends < defends))
        {
            return new Pair<>(SelectionType.REJECT, PlayerType.NA);
        }

        if (p.score < score && p.defends > defends) {
            //when more defends than score, put in defender list

            return new Pair<>(SelectionType.SELECT, PlayerType.DEFENDER);
        } else if (p.score > score && p.defends < defends) {
            //when more defends than score, put in defender list
            return new Pair<>(SelectionType.SELECT, PlayerType.STRIKER);
        } else if (p.score >= score && p.defends >= defends) {
            // when both the striker and defender qualify
            int diffScore = p.score - score;
            int diffDefender = p.defends - defends;

            if (diffScore > diffDefender)
                return new Pair<>(SelectionType.SELECT, PlayerType.STRIKER);
            else
                return new Pair<>(SelectionType.SELECT, PlayerType.DEFENDER);
        }

        return null;
    }
}

class Result {

    /*
     * Complete the 'getSelectionStatus' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY applications as parameter.
     */
    class PlayerScoreComparator implements Comparator<Player> {

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(Player p1, Player p2) {
            if (p1.score < p2.score)
                return 1;
            else if (p1.score > p2.score)
                return -1;
            return 0;
        }
    }

    class PlayerDefendsComparator implements Comparator<Player> {

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(Player p1, Player p2) {
            if (p1.defends < p2.defends)
                return 1;
            else if (p1.defends > p2.defends)
                return -1;
            return 0;
        }
    }

    class PlayerNameComparator implements Comparator<Player> {

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(Player p1, Player p2) {
            return p1.name.compareTo(p2.name);
        }
    }

    private List<List<String>> analyzeSelection(List<Player> players) {
        List<List<String>> result = new ArrayList<>();

        PriorityQueue<Player> striker = new PriorityQueue<>(50, new PlayerScoreComparator());
        PriorityQueue<Player> defender = new PriorityQueue<>(50, new PlayerDefendsComparator());
        PriorityQueue<Player> playerList = new PriorityQueue<>(50, new PlayerNameComparator());

        SelectionCriteria selectionCriteria = new SelectionCriteria();

        for (int i = 0; i < players.size(); ++i) {
            Player p = players.get(i);

            Pair<SelectionType, PlayerType> selectionCriteriaPlayerTypePair = selectionCriteria.analyzePlayer(p);

            switch (selectionCriteriaPlayerTypePair.getKey()) {
                case SELECT:
                    if (selectionCriteriaPlayerTypePair.getValue().equals(PlayerType.DEFENDER))
                    {
                        defender.add(p);
                    }
                    else if (selectionCriteriaPlayerTypePair.getValue().equals(PlayerType.STRIKER))
                        striker.add(p);
                    break;
                case REJECT:
                    p.playerType=PlayerType.NA;
                    p.selectionType = SelectionType.REJECT;
                    playerList.add(p);
                    break;

            }

        }

        //System.out.println("striker.size()" + striker.size());
        //System.out.println("defender.size()" + defender.size());

        PriorityQueue<Player> biggerList = null;
        PriorityQueue<Player> smallerList = null;

        PlayerType biggerType= null;
        PlayerType smallerType= null;
        int n=0;
        if(striker.size() > defender.size())
        {
            biggerType = PlayerType.STRIKER;
            smallerType = PlayerType.DEFENDER;
            n= defender.size();
            biggerList= striker;
            smallerList = defender;
        }else
        {
            biggerType = PlayerType.DEFENDER;
            smallerType = PlayerType.STRIKER;
            n = striker.size();
            biggerList= defender;
            smallerList = striker;
        }

        while(biggerList.size() - smallerList.size() > 1)
        {
            smallerList.add(biggerList.poll());
        }

        n = smallerList.size();

        //remove from the bigger type
        int i = 0;
        while (i++ < n) {
            Player p = biggerList.poll();
            p.playerType=biggerType;
            p.selectionType = SelectionType.SELECT;
            playerList.add(p);
        }

        while(!biggerList.isEmpty())
        {
            Player p = biggerList.poll();
            p.playerType=PlayerType.NA;
            p.selectionType = SelectionType.REJECT;
            playerList.add(p);
        }

        while(!smallerList.isEmpty())
        {
            Player p = smallerList.poll();
            p.playerType=smallerType;
            p.selectionType = SelectionType.SELECT;
            playerList.add(p);
        }

        while(!playerList.isEmpty())
        {

//add the players to the result now
            Player p = playerList.poll();

            List<String> r = new ArrayList<>();
            r.add(p.name);
            r.add(p.selectionType.toString());
            r.add(p.playerType.toString());
            result.add(r);

        }
        return result;

    }

    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {


        List<Player> players = new ArrayList<>();

        //get the input
        for (int i = 0; i < applications.size(); ++i) {
            List<String> input = applications.get(i);

            Player p = Player.parseInput(input);
            System.out.println(p);
            players.add(p);
        }



        Result r = new Result();

        return r.analyzeSelection(players);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int applicationsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int applicationsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> applications = new ArrayList<>();

        IntStream.range(0, applicationsRows).forEach(i -> {
            try {
                applications.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<String>> result = Result.getSelectionStatus(applications);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
