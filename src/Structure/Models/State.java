package Structure.Models;

import java.util.Comparator;
import java.util.Random;

public class State implements Comparator<State> {
    private  State parent;
    private GameModel value;
    private int cost = 1;
    private int h = 0;

    public State(State parent, GameModel value)
    {
        this.parent = parent;
        this.value = value;

//        this.cost = new Random().nextInt();
    }

    public State(State parent, GameModel value, int cost)
    {
        this.parent = parent;
        this.value = value;
        this.cost = cost;
    }

    public State() {}

    public boolean hasPrevious()
    {
        return this.parent != null;
    }

    public State getParent() {
        return parent;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public GameModel getValue() {
        return value;
    }

    public void setValue(GameModel value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compare(State o1, State o2) {
        return o1.cost + o1.h > o2.cost + o2.h ? 1 : -1;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
