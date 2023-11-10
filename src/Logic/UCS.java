package Logic;

import Structure.Actions.Actions;
import Structure.Models.GameModel;
import Structure.Models.State;

import java.util.PriorityQueue;

public class UCS extends BaseLogic {

    PriorityQueue<State> priorityQueue = new PriorityQueue<>(new State());

    State SolveUCS(State state)
    {
        priorityQueue.add(state);

        if (Actions.isFinal(state.getValue()))
            return state;

        while (priorityQueue.size() > 0)
        {
            State node = priorityQueue.poll();

            VisitedList.add(node);

            for (GameModel child : Actions.GetNextStates(node.getValue())) {
                if (!isVisited(child)) {

                    State state1 = new State(node, child);

                    state1.setCost(state1.getCost() + node.getCost());

                    if (!Actions.isFinal(child))
                        priorityQueue.add(state1);
                    else
                        return state1;
                }
            }
        }
        return null;
    }

    public UCS(GameModel game)
    {
        System.out.println("Solving ...");
        timer.start();
        State sol = SolveUCS(new State(null, game));
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
