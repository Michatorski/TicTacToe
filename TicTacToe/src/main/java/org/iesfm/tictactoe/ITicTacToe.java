package org.iesfm.tictactoe;

import org.iesfm.tictactoe.exceptions.InvalidPositionException;
import org.iesfm.tictactoe.exceptions.NotYourTurnException;
import org.iesfm.tictactoe.exceptions.PositionInUseException;

public interface ITicTacToe {

    void putX (int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException;
    void putO(int x, int y) throws InvalidPositionException, PositionInUseException, NotYourTurnException;

    Character [][] getBoard();

    void setBoard(Character[][] board);

    void reset();

    boolean isFinished();

    Character getWinner();

    Character getTurn();
}
