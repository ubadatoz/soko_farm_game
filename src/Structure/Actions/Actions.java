package Structure.Actions;

import Structure.Models.GameModel;
import Structure.Models.Positions;

import java.util.ArrayList;
import java.util.Arrays;

public class Actions {

    // Get Moves Able Positions
    public static ArrayList<Positions> CheckMoves(GameModel game)
    {
        ArrayList<Positions> data = new ArrayList<>();

        if(MoveCheckAction.CheckUpMove(game))
            data.add(Positions.UP);

        if(MoveCheckAction.CheckDownMove(game))
            data.add(Positions.DOWN);

        if(MoveCheckAction.CheckLeftMove(game))
            data.add(Positions.LEFT);

        if(MoveCheckAction.CheckRightMove(game))
            data.add(Positions.RIGHT);

        return data;
    }
    public static GameModel Move(GameModel game,  Positions newPosition)
    {
        switch (newPosition) {
            case UP:
                return MoveOnAction.MoveUp(game);
            case DOWN:
                return MoveOnAction.MoveDown(game);
            case LEFT:
                return MoveOnAction.MoveLeft(game);
            default:
                return MoveOnAction.MoveRight(game);
        }
    }
    public static ArrayList<GameModel> GetNextStates(GameModel gameModel)
    {
        ArrayList<GameModel> nextStates = new ArrayList<>(); // Store States

        ArrayList<Positions> moves = CheckMoves(gameModel); // Get All Move able positions

        // Move to all positions
        for(var movePosition : moves)
        {
            nextStates.add(Move(gameModel,movePosition));
        }

        return nextStates;
    }
    public static boolean isFinal(GameModel game)
    {


            if (!(game.getPlant1().isAtPosition()&&game.getPlant2().isAtPosition())) {
                return false;
            }

        return true;

    }

    public static boolean Equals(GameModel game1, GameModel game2) {
        return game1.equals(game2);
    }

    public static void printState(GameModel game)
    {
        int[][] board = game.getBoard();

     //   System.out.println("Move to: " + game.getLastPosition().name());

        for (int i = 0; i < game.getRow_boundary(); i++)
        {
            System.out.print("\u001B[34m"+"|"+"\u001B[0m");

            for (int j = 0; j < game.getColumn_boundary(); j++)
            {

                if (board[i][j] == 1)
                    System.out.print("\u001B[33m"+"■"+"\u001B[34m"+"|"+"\u001B[0m");

                else if (board[i][j] == game.getPlayer().getValue())
                    System.out.print("\u001B[31m"+"8"+"\u001B[34m"+"|"+"\u001B[0m");

                else if (board[i][j] == game.getPlant1().getValue() ||
                         board[i][j] == game.getPlant2().getValue())
                    System.out.print("\u001B[32m"+"y"+"\u001B[34m"+"|"+"\u001B[0m");

                else if (board[i][j] == 0)
                    System.out.print("\u001B[34m"+" |"+"\u001B[0m");

                else if (board[i][j] == board[game.getPlant1().getRowIndexTo()][game.getPlant1().getColumnIndexAt()]||
                         board[i][j] == board[game.getPlant2().getRowIndexTo()][game.getPlant2().getColumnIndexAt()])
                    System.out.print("\u001B[36m"+"*"+"\u001B[34m"+"|"+"\u001B[0m");

                else
                    System.out.print("\u001B[36m"+"*"+"\u001B[34m"+"|"+"\u001B[0m");
            }
            System.out.println();
        }

        System.out.println("Player Position At Cell("
                + game.getPlayer().getRowIndexAt() + ","
                + game.getPlayer().getColumnIndexAt()+")");
    }
}
