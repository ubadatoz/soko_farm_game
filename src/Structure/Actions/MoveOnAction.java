package Structure.Actions;

import Structure.Models.GameModel;
import Structure.Models.Pair;
import Structure.Models.Positions;

public class MoveOnAction {

    public static GameModel MoveUp(GameModel game) {

        GameModel gameCopy = new GameModel(game);

        int[][] board = gameCopy.getBoard();

        if (MoveCheckAction.CheckUpMove(gameCopy)){

            // new position cell
            int row_index = gameCopy.getPlayer().getRowIndexAt();
            int column_index = gameCopy.getPlayer().getColumnIndexAt();

            if (board[row_index-1][column_index] == 0)
            {
                board[row_index-1][column_index] = 8;

            } else if (board[row_index-1][column_index] == gameCopy.getPlant1().getValue()) {

                gameCopy.getPlant1().setRowIndexAt(row_index-2);
                board[row_index-1][column_index] = 8;
                board[row_index-2][column_index] = gameCopy.getPlant1().getValue();
            }
            else if (board[row_index-1][column_index] == gameCopy.getPlant2().getValue()){

                gameCopy.getPlant2().setRowIndexAt(row_index+2);

                board[row_index-1][column_index] = 8;
                board[row_index-2][column_index] = gameCopy.getPlant2().getValue();

            }else if (board[row_index-1][column_index] == -2) {

                board[row_index-1][column_index] = 8;
            }
            // change player coordinates
            gameCopy.getPlayer().setRowIndexAt(row_index -1);

            gameCopy.setLastPosition(Positions.UP);

            board[row_index][column_index] = 0;

            return gameCopy;

        }

        System.out.println("\u001B[31m"+"cant do this action");
        return gameCopy;
    }

    public static GameModel MoveDown(GameModel game) {

        GameModel gameCopy = new GameModel(game);

        int[][] board = gameCopy.getBoard();

        if (MoveCheckAction.CheckDownMove(gameCopy)){

            int row_index = gameCopy.getPlayer().getRowIndexAt();
            int column_index = gameCopy.getPlayer().getColumnIndexAt();

            if (board[row_index+1][column_index] == 0)
            {
                board[row_index+1][column_index] = 8;

            } else if (board[row_index+1][column_index] == gameCopy.getPlant1().getValue()) {

                    gameCopy.getPlant1().setRowIndexAt(row_index+2);
                    board[row_index+1][column_index] = 8;
                    board[row_index+2][column_index] = gameCopy.getPlant1().getValue();
            }
            else if (board[row_index+1][column_index] == gameCopy.getPlant2().getValue()){

                    gameCopy.getPlant2().setRowIndexAt(row_index+2);

                board[row_index+1][column_index] = 8;
                board[row_index+2][column_index] = gameCopy.getPlant2().getValue();

            }else if (board[row_index+1][column_index] == -2) {
                board[row_index+1][column_index] = 8;
            }

            // change player coordinates
            gameCopy.getPlayer().setRowIndexAt(row_index +1);

            gameCopy.setLastPosition(Positions.DOWN);

            board[row_index][column_index] = 0;

            return gameCopy;
        }

        System.out.println("\u001B[31m"+"cant do this action");
        return gameCopy;

    }

    public static GameModel MoveLeft(GameModel game) {

        GameModel gameCopy = new GameModel(game);
        int[][] board = gameCopy.getBoard();

        if (MoveCheckAction.CheckLeftMove(gameCopy)){

            // new position cell
            int row_index = gameCopy.getPlayer().getRowIndexAt();
            int column_index = gameCopy.getPlayer().getColumnIndexAt() ;


            if (board[row_index][column_index-1] == 0)
            {
                board[row_index][column_index-1] = 8;

            }else if (board[row_index][column_index-1] == gameCopy.getPlant1().getValue()) {

                gameCopy.getPlant1().setColumnIndexAt(column_index-2);
                board[row_index][column_index-1] = 8;
                board[row_index][column_index-2] = gameCopy.getPlant1().getValue();
            }
            else if (board[row_index][column_index-1] == gameCopy.getPlant2().getValue()){

                gameCopy.getPlant2().setColumnIndexAt(column_index-2);
                board[row_index][column_index-1] = 8;
                board[row_index][column_index-2] = gameCopy.getPlant2().getValue();


            } else if (board[row_index][column_index-1] == -2) {
                board[row_index][column_index-1] = 8;
            }
            // change player coordinates
            gameCopy.getPlayer().setColumnIndexAt(column_index -1);

            gameCopy.setLastPosition(Positions.LEFT);

            board[row_index][column_index] = 0;

            return gameCopy;
        }

        System.out.println("\u001B[31m"+"cant do this action");
        return gameCopy;
    }

    public static GameModel MoveRight(GameModel game) {

        GameModel gameCopy = new GameModel(game);
        int[][] board = gameCopy.getBoard();

        if (MoveCheckAction.CheckRightMove(gameCopy)){

            // new position cell
            int row_index = gameCopy.getPlayer().getRowIndexAt();
            int column_index = gameCopy.getPlayer().getColumnIndexAt() ;


            if (board[row_index][column_index+1] == 0)
            {
                board[row_index][column_index+1] = 8;

            } else if (board[row_index][column_index+1] == gameCopy.getPlant1().getValue()) {

                gameCopy.getPlant1().setColumnIndexAt(column_index+2);
                board[row_index][column_index+1] = 8;
                board[row_index][column_index+2] = gameCopy.getPlant1().getValue();
            }
            else if (board[row_index][column_index+1] == gameCopy.getPlant2().getValue()){

                gameCopy.getPlant2().setColumnIndexAt(column_index+2);
                board[row_index][column_index+1] = 8;
                board[row_index][column_index+2] = gameCopy.getPlant2().getValue();

            }else if (board[row_index][column_index+1] == -2) {

                board[row_index][column_index+1] = 8;

            }
            // change player coordinates
            gameCopy.getPlayer().setColumnIndexAt(column_index+1);

            gameCopy.setLastPosition(Positions.RIGHT);

            board[row_index][column_index] = 0;

            return gameCopy;
        }

        System.out.println("\u001B[31m"+"cant do this action");
        return gameCopy;
    }
}
