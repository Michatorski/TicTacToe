package org.iesfm.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConsoleTicTacToe game = new ConsoleTicTacToe( new Scanner(System.in), new TicTacToe() );

        game.run();
    }
}
