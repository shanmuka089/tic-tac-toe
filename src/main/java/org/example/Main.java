package org.example;

public class Main
{

    public static void main(String[] args)
    {

        new Game(new Player("Shanu", Symbol.X), new Player("Parthu", Symbol.O)).play();
    }

}