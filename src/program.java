import Levels.GameLevel;
import Logic.*;
import Structure.Models.GameModel;

import java.util.Scanner;

public class program {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameModel[] listLevels = GameLevel.ReadLevels();

        while (true) {
            for (int i = 0; i < listLevels.length; i++)
            {
                System.out.println(ANSI_GREEN+ (i+1) + "- Level " + (i + 1));
            }
            GameModel game = null;
            while (true) {
                System.out.println(ANSI_YELLOW + "\nEnter Level Number:");
                int levelNum = new Scanner(System.in).nextInt();

                if (levelNum < 1 || levelNum > listLevels.length) {
                    System.out.println(ANSI_RED + "Error, Enter Valid Level");
                    continue;
                }


                game = listLevels[levelNum - 1];

                break;
            }

            while (true) {
                System.out.println(ANSI_GREEN + "Choose Algorithm:");
                System.out.println(ANSI_RED+"q: Quit");
                System.out.println(ANSI_YELLOW+"1- UserPlay");
                System.out.println("2- DFS");
                System.out.println("3- BFS");
                System.out.println("4- UCS");

                char option = new Scanner(System.in).next().charAt(0);

                switch (option) {
                    case '1':
                        UserPlay u = new UserPlay(game);
                        break;
                    case '2':
                        DFS dfs = new DFS(game);
                        break;
                    case '3':
                        BFS bfs = new BFS(game);
                        break;
                    case '4':
                        UCS ucs = new UCS(game);
                        break;
                    case 'q':
                        return;
                }
            }
        }
    }
}
