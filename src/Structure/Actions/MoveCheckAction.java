package Structure.Actions;

import Structure.Models.GameModel;

public class MoveCheckAction {

    public static boolean CheckLeftMove(GameModel game) {
        // player row position index
        int cell_row = game.getPlayer().getRowIndexAt();

        // player column position index
        int cell_column = game.getPlayer().getColumnIndexAt();

        int[][] board = game.getBoard();

        if (board[cell_row][cell_column-1] == 2)
        {
            return cell_column - 1 >= 0 // check Left move array boundary
                    && game.getBoard()[cell_row][cell_column - 1] != 1 // check cell is not a block
                    && game.getBoard()[cell_row][cell_column - 2] != 1 // check next_cell is not a block
                    && game.getBoard()[cell_row][cell_column - 2] != 4;
        }
        else if (board[cell_row][cell_column-1] == 4)
        {
            return cell_column - 1 >= 0 // check Left move array boundary
                    && game.getBoard()[cell_row][cell_column - 1] != 1 // check cell is not a block
                    && game.getBoard()[cell_row][cell_column - 2] != 1 // check next_cell is not a block
                    && game.getBoard()[cell_row][cell_column - 2] != 2;
        }
        else  {

            return cell_column - 1 >= 0 // check Left move array boundary
                    && game.getBoard()[cell_row][cell_column - 1] != 1; // check cell is not a block
        }

    }

    public static boolean CheckRightMove(GameModel game) {
        // player row position index
        int cell_row = game.getPlayer().getRowIndexAt();

        // player column position index
        int cell_column = game.getPlayer().getColumnIndexAt();
        int[][] board = game.getBoard();

        if (board[cell_row][cell_column+1] == 2)
        {
            return cell_column + 1 <= game.getColumn_boundary() // check Right move array boundary
                    && game.getBoard()[cell_row][cell_column + 1] != 1 // check cell is not a block
                    && game.getBoard()[cell_row][cell_column + 2] != 1// check next_cell is not a block
                    && game.getBoard()[cell_row][cell_column + 2] != 4;

        } else if (board[cell_row][cell_column+1] == 4)
        {
            return cell_column + 1 <= game.getColumn_boundary() // check Right move array boundary
                    && game.getBoard()[cell_row][cell_column + 1] != 1 // check cell is not a block
                    && game.getBoard()[cell_row][cell_column + 2] != 1// check next_cell is not a block
                    && game.getBoard()[cell_row][cell_column + 2] != 2;

        }
        else  {

            return cell_column + 1 <= game.getColumn_boundary() // check Right move array boundary
                   && game.getBoard()[cell_row][cell_column + 1] != 1; // check cell is not a block
        }

    }

    public static boolean CheckUpMove(GameModel game) {
        // player row position index
        int cell_row = game.getPlayer().getRowIndexAt();

        // player column position index
        int cell_column = game.getPlayer().getColumnIndexAt();
        int[][] board = game.getBoard();

        if (board[cell_row-1][cell_column] == 2)
        {
            return cell_row - 1 >= 0 // check Up move array boundary
                    && game.getBoard()[cell_row - 1][cell_column] != 1 // check cell is not a block
                    && game.getBoard()[cell_row - 2][cell_column] != 1// check next_cell is not a block
                    && game.getBoard()[cell_row - 2][cell_column] != 4;

        }   else if (board[cell_row-1][cell_column] == 4)
        {
            return cell_row - 1 >= 0 // check Up move array boundary
                    && game.getBoard()[cell_row - 1][cell_column] != 1 // check cell is not a block
                    && game.getBoard()[cell_row - 2][cell_column] != 1// check next_cell is not a block
                    && game.getBoard()[cell_row - 2][cell_column] != 2;

        }
        else  {

            return cell_row - 1 >= 0 // check Left move array boundary
                    && game.getBoard()[cell_row-1][cell_column ] != 1; // check cell is not a block
        }

    }

    public static boolean CheckDownMove(GameModel game) {
        // player row position index
        int cell_row = game.getPlayer().getRowIndexAt();

        // player column position index
        int cell_column = game.getPlayer().getColumnIndexAt();
        int[][] board = game.getBoard();

        if (board[cell_row+1][cell_column] == 2)
        {
            return cell_row + 1 <= game.getColumn_boundary() // check Down move array boundary
                    && game.getBoard()[cell_row + 1][cell_column] != 1 // check cell is not a block
                    && game.getBoard()[cell_row + 2][cell_column] != 1// check next_cell is not a block
                    && game.getBoard()[cell_row + 2][cell_column] != 4;

        } else if (board[cell_row+1][cell_column] == 4)
        {
            return cell_row + 1 <= game.getColumn_boundary() // check Down move array boundary
                    && game.getBoard()[cell_row + 1][cell_column] != 1 // check cell is not a block
                    && game.getBoard()[cell_row + 2][cell_column] != 1// check next_cell is not a block
                    && game.getBoard()[cell_row + 2][cell_column] != 2;

        }
        else  {

            return cell_row + 1 <= game.getColumn_boundary() // check Down move array boundary
                    && game.getBoard()[cell_row+1][cell_column ] != 1; // check cell is not a block
        }

    }
}
