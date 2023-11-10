package Structure.Models;

import java.util.Comparator;

public class StateCompareHillClimbing implements Comparator<State> {

    public int compare(State s1, State s2)
    {
        if (s1.getH() > s2.getH())
            return 1;
        else if (s1.getH() < s2.getH())
            return -1;
        return 0;
    }
}