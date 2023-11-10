package Levels;

import Structure.Models.GameModel;
import Structure.Models.Pair;
import Structure.Models.PairList;

import java.util.ArrayList;
import java.util.List;

public class GameLevel {

    public static GameModel[] ReadLevels()
    {
        GameModel[] gameModels = new GameModel[2];


        Pair plant1 =new Pair(4, 3, 4, 2, 4);
        Pair plant2 = new Pair(3, 3, 3, 2, 2);

        Pair player = new Pair(4, 5, 2, 3,8);

        gameModels[0] = new GameModel(6, 7,
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 1, 1},
                        {1, 1,-2, 2, 0, 0, 1},
                        {1, 1,-2, 4, 0, 8, 1},
                        {1, 1, 1, 1, 1, 1, 1},
                }, new Pair(player),new Pair(plant1),new Pair(plant2)

        );

        // Level 2
         plant1 =new Pair(4, 4, 4, 3, 4);
         plant2 = new Pair(2, 2, 3, 3, 2);
         player = new Pair(4, 5, 2, 3,8);

        gameModels[1] = new GameModel(6, 8,
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1, 1},
                        {1, 0, 2, 0, 0, 1, 1, 1},
                        {1, 1, 1,-2, 0, 0, 1, 1},
                        {1, 1, 0,-2, 4, 8, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1},
                }, new Pair(player),new Pair(plant1),new Pair(plant2)

        );

        return gameModels;
    }

}
