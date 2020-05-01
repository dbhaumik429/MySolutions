package com.debu.javapractise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Player implements Comparable<Player>{

    private String name;

    Player(String n )
    {
        this.name = n;
    }

    @Override
    public int compareTo(Player o) {
        return (-1)*this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class ComparableExample {


    public static void main(String[] args) {

        Player p = new Player("AAA");
        Player p1 = new Player("BBB");
        Player p2 = new Player("CCC");
        Player p3 = new Player("DDD");
        Player p4 = new Player("EEE");

        List<Player> l = Arrays.asList(p, p1, p2, p3, p4);

        Collections.sort(l);

        System.out.println(l);

    }
}
