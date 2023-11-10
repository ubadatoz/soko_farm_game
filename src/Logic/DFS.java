package Logic;

import Structure.Actions.Actions;
import Structure.Models.GameModel;
import Structure.Models.State;

import java.util.Stack;

public class DFS extends BaseLogic {

    private Stack<State> stackStates = new Stack<State>();

    State solutionNode = null;

    boolean isGameFinished = false;

    State SolveDFS(State state)
    {
        stackStates.push(state);

        while (stackStates.size() > 0)
        {
            State node = stackStates.pop();

            VisitedList.add(node);

            if (Actions.isFinal(node.getValue()))
                return node;

            for (GameModel child : Actions.GetNextStates(node.getValue())) {
                if (!isVisited(child)) {
                        stackStates.push(new State(node, child));
                }
            }
        }
        return null;
    }

    public DFS(GameModel game)
    {
        System.out.println("Solving ...");

        timer.start();

        State sol = SolveDFS(new State(null, game));

        timer.stop();

        if (sol != null)
            System.out.println("------ << Successfully Solved >> -------");
        else
            System.out.println("NO SOLUTION FOUND.");

        while (sol.hasPrevious()) {
            solution.add(sol.getValue());

            sol = sol.getParent();
        }

        this.Play();

    }
}
