/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import javafx.fxml.FXML;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{

    private int currentPlayer;
    private int[][] board;
    public GameBoard()
    {
        currentPlayer = 0;// Start with player 1=0
        board = new int[3][3];
    }

    public int getNextPlayer()
    {

        //return 0;
        return currentPlayer;

    }



    public boolean play(int col, int row)
    {

        //return true;
        if (board[col][row] == 0)// Check if field 0 is available.

            {
            board[col][row] = currentPlayer+1;// Marks the field with the players id ( 1 or 2).
                /*
                if (currentPlayer == 0)
                    currentPlayer = 1;
                else
                    currentPlayer = 0;
                */

                currentPlayer = 1 - currentPlayer;// Switch between player 1 and 2.

            return true;
        }
        return false;
    }

    public boolean isGameOver()
    {
        return false;
    }

    public int getWinner()
    {
        // Checks board.
        for (int i = 0; i < 3; i++)
        {//Checking if all three cells in a row have the same value and are different from zero (0).
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            {
                return board[i][0];// Returns the player ID if a row is filled with the same marker.
            }
        }

        // Checks columns
        for (int i = 0; i < 3; i++)
        {// Checking if all three cells in row i have the same value and are different from zero (0).
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i])
            {
                return board[0][i];// Returns the player ID if a column is filled with the same marker
            }
        }

        // Checks diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            return board[0][0];// Returns the player ID if the top-left to bottom-right diagonal is filled with the same marker.
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            return board[0][2];// Returns the player ID if the top-right to bottom-left diagonal is filled with the same marker.
        }

        // Checks if draw.
        boolean draw = true;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == 0)
                {
                    draw = false;
                    break;
                }
            }
        }

        if (draw)
        {
            return 0; // Indicates a tie.
        }


        return -1; //No winner.
    }

    public void newGame()
    {
        currentPlayer = 0;
        board = new int[3][3];
    }

}
