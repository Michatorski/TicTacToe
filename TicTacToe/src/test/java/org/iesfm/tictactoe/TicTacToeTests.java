package org.iesfm.tictactoe;

import org.iesfm.tictactoe.exceptions.InvalidPositionException;
import org.iesfm.tictactoe.exceptions.NotYourTurnException;
import org.iesfm.tictactoe.exceptions.PositionInUseException;
import org.junit.Assert;
import org.junit.Test;



public class TicTacToeTests {
        private TicTacToe game = new TicTacToe();
    @Test
    public void finishedTest(){
        Character[][] board = {
                {TicTacToe.X, TicTacToe.X, TicTacToe.O},
                {TicTacToe.O, TicTacToe.O, TicTacToe.O},
                {TicTacToe.X, TicTacToe.O, TicTacToe.X}
        };
        game.setBoard(board);

        //Test execution
        boolean finished = game.isFinished();


        //Assertions
        Assert.assertTrue(finished);
    }

    @Test
    public void noMoreMovesDrawTest(){
        Character[][] board = {
                {TicTacToe.X, TicTacToe.X, TicTacToe.O},
                {TicTacToe.O, TicTacToe.O, TicTacToe.X},
                {TicTacToe.X, TicTacToe.O, TicTacToe.X}
        };
        game.setBoard(board);

        //Test execution

        Character winner = game.getWinner();

        //Assertions
        Assert.assertNull( winner);
    }

    @Test (expected = InvalidPositionException.class)
    public void invalidPositionTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };

        game.setBoard(board);

        game.putX(3, 4);
    }

    @Test
    public void putXTest() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null}, //Position 0.0 0.1 0.2
                {null, null, null}, //Position 1.0 1.1 1.2
                {null, null, null}  //Position 2.0 2.1 2.2
        };

        game.setBoard(board);

        game.putX(1, 1);

        Character[][] expectedBoard = {
                {null, null, null},
                {null, TicTacToe.X, null},
                {null, null, null}
        };

        Assert.assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test (expected =  PositionInUseException.class)
    public void occupiedPosition() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null}, //Position 0.0 0.1 0.2
                {null, TicTacToe.O, TicTacToe.X}, //Position 1.0 1.1 1.2
                {null, null, null}  //Position 2.0 2.1 2.2
        };

        game.setBoard(board);
        game.putX(1, 2);
    }

    @Test (expected = NotYourTurnException.class)
    public void wrongTurn() throws NotYourTurnException, PositionInUseException, InvalidPositionException {
        Character[][] board = {
                {null, null, null}, //Position 0.0 0.1 0.2
                {null, null, TicTacToe.X}, //Position 1.0 1.1 1.2
                {null, null, null}  //Position 2.0 2.1 2.2
        };

        game.setBoard(board);
        game.putX(1, 23);
    }

    @Test
    public void notFinishedTest(){
        Character[][] board = {
                {TicTacToe.X, null, null},
                {null, TicTacToe.O, null},
                {null, null, TicTacToe.X}
        };
        game.setBoard(board);

        //Test execution
        boolean finished = game.isFinished();


        //Assertions
        Assert.assertFalse(finished);
    }

}
