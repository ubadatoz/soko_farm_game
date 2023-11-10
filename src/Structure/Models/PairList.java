package Structure.Models;

import java.util.ArrayList;
import java.util.List;

public class PairList {

        public List<Pair> pairs = new ArrayList<>();

        // Indexer
        public List<Pair> getCells(int row, int column) {

            for (int i = 0 ; i<this.pairs.size();i++){
                if (pairs.get(i).getRowIndexAt() == row && pairs.get(i).getColumnIndexAt() == column) {
                    return pairs;
                }
                return null;
            }
            return null;
         }

    public Pair getCell(int row, int column) {

        for (Pair pair : pairs) {
            if (pair.getRowIndexAt() == row && pair.getColumnIndexAt() == column) {
                return pair;
            }
        }
        return null;
    }


    public int getvalue(int row, int column) {

        for (Pair pair : pairs) {
            if (pair.getRowIndexAt() == row && pair.getColumnIndexAt() == column) {
                return pair.getValue();
            }
        }
        return 0;
    }

    public void setCell(int row, int column,Pair value) {
        pairs.add(value);
    }


    public boolean Exist(Pair pair)
    {
        return getCell(pair.getRowIndexAt(), pair.getColumnIndexAt()) != null;
    }

    // Default Constructor
    public PairList() { }

    public PairList(List<Pair> pairs) {this.pairs = pairs;}

    // Deep Copy Constructor
    public PairList(PairList pairList)
    {
        for (Pair pair : pairList.pairs)
        {
            this.pairs.add(new Pair(pair));
        }
    }

    public Pair GetByPositionTo(int row_index, int column_index)//ggggggggggggggggggggggggggggggggggg
    {
        for (Pair pair : pairs)
        {
            if (pair.getRowIndexAt() == row_index && pair.getColumnIndexAt() == column_index){
                return pair;
            }
        }
        return null;
        }

    // Deep Check
    public boolean deepEqual(PairList pairList)
    {
        for (int i = 0; i < this.pairs.size(); i++)
        {
            if (!pairs.get(i).deepEqual(pairList.pairs.get(i)))
                return false;
        }
        return true;
    }

}

