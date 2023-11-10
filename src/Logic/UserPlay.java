package Logic;

import Structure.Actions.Actions;
import Structure.Models.GameModel;
import Structure.Models.Positions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPlay {

    GameModel game;
    List<Positions> graphMoves = new ArrayList<>();
    List<GameModel> gameGraphStates = new ArrayList<>();
    boolean isGameFinished = false;

    public UserPlay(GameModel game)
    {
        this.game = game;
        this.play();
    }

    public void play()
    {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            Actions.printState(game);

            if (!isGameFinished) {
                if (Actions.isFinal(game)) {
                    this.isGameFinished = true;
                    System.out.println("\n <<<<<< ==== GAME FINISHED ==== >>>>>>\n");
                    continue;
                }
            }
                else {
                    System.out.println("\n (p:Print States, q:quit)");
                    System.out.println("\nEnter Key Action:");

                    char key_read = scanner.next().charAt(0);

                    switch (key_read) {
                        case 'p':
                        case 'P':
                            this.printStates();
                            break;

                        case 'q':
                        case 'Q':
                            System.out.println("\n <<<<<< ... Quit ... >>>>>>\n");
                            return;
                        default:
                            System.out.println("Invalid Input !\n");
                            break;
                    }
                    continue;
                }


                // Print Moves Able Positions
            ArrayList<Positions> positions = Actions.CheckMoves(game);

            System.out.println();
            System.out.print("\u001B[34m"+"Possible moves:");
            for (Positions position : positions) {
                    System.out.println(position + " ");
                }
            System.out.print("(a:left, d:right, w:up, s:down, q:quit)");
            System.out.print("\u001B[32m"+"\nEnter Key Action:"+"\u001B[0m");

            char key = new Scanner(System.in).next().charAt(0);

            if(key == 'Q' || key == 'q')
            {
                System.out.println("\u001B[35m"+" ============ EXIT =============\n");
                return;
            }

            keyAction(key);
        }
    }

    private void keyAction(char keyChar)
    {
        switch (keyChar)
        {
            case 'a':
            case 'A':
                game = Actions.Move(game, Positions.LEFT);
                this.gameGraphStates.add(game);
                this.graphMoves.add(Positions.LEFT);
                break;
            case 'd':
            case 'D':
                game = Actions.Move(game, Positions.RIGHT);
                this.gameGraphStates.add(game);
                this.graphMoves.add(Positions.RIGHT);
                break;

            case 'w':
            case 'W':
                game = Actions.Move(game, Positions.UP);
                this.gameGraphStates.add(game);
                this.graphMoves.add(Positions.UP);
                break;

            case 's':
            case 'S':
                game = Actions.Move(game, Positions.DOWN);
                this.gameGraphStates.add(game);
                this.graphMoves.add(Positions.DOWN);
                break;
            default:
                System.out.println("\u001B[31m"+"Invalid Input !\n");
                break;
        }
    }

    private void printStates() {

        for (int i = 0; i < gameGraphStates.size(); i++) {
            System.out.println("Move Number: " + (i + 1));
            System.out.println("Moved Direction To: " + this.graphMoves.get(i));
            Actions.printState(gameGraphStates.get(i));
            System.out.println("\n");
        }
    }

}

