package Logic;

import Structure.Actions.Actions;
import Structure.Models.GameModel;
import Structure.Models.State;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseLogic {

    ArrayList<State> VisitedList = new ArrayList<>();

    ArrayList<GameModel> solution = new ArrayList<>();

    protected TimeUnite timer = new TimeUnite();

    public boolean isVisited(GameModel game)
    {
        for (State game1 : VisitedList)
        {
            if (Actions.Equals(game1.getValue(), game))
                return true;
        }
        return false;
    }


    protected void Play()
    {
        while (true)
        {
            System.out.println("\u001B[32m"+"p: print states || q: quit\n"+"\u001B[0m");

            char action = new Scanner(System.in).next().charAt(0);

            switch (action)
            {
                case 'p':
                    int moveNumber = 1;

                    for (int i = solution.size() - 1; i >= 0; i--)
                    {
                        System.out.println("Move Number: " + moveNumber);

                        Actions.printState(solution.get(i));

                        System.out.print("\n");

                        moveNumber += 1;
                    }

                    for (int i = solution.size() - 1; i >= 0; i--) {
                        System.out.print("\u001B[34m"+solution.get(i).getLastPosition().name() + " ");
                    }
                    System.out.println();
                    System.out.println("\u001B[35m"+"Solution Node Depth: " + solution.size());
                    System.out.println("Visited Nodes Count: " + VisitedList.size());
                    System.out.println("\u001B[31m"+"Execution Time: " + timer.getElapsedTime() + " ms");

                    break;
                case 'q':
                    System.out.println("Exiting ..");
                    return;
            }
        }
    }


}
