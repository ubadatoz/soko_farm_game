package Logic;

import Structure.Actions.Actions;
import Structure.Models.GameModel;
import Structure.Models.State;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends BaseLogic {

    private Queue<State> queueStates = new LinkedList<>();

    //State solutionNode = null;

    //boolean isGameFinished = false;

    State SolveBFS(State state)
    {
        queueStates.add(state);

        if (Actions.isFinal(state.getValue()))
            return state;

        while (queueStates.size() > 0)
        {
            State node = queueStates.poll();

            VisitedList.add(node);

            for (GameModel child : Actions.GetNextStates(node.getValue())) {

                if (!isVisited(child)) {

                    State state1 = new State(node, child);

                    if (!Actions.isFinal(child))
                        queueStates.add(state1);
                    else
                        return state1;
                }
            }
        }
        return null;
    }

    public BFS(GameModel game)
    {
        System.out.println("Solving ...");

        timer.start();

        State sol = SolveBFS(new State(null, game));

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
