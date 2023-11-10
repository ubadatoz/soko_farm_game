package Structure.Models;

public class Pair {

    // Fields
    private int Row_Index_At;
    private int Column_Index_At;
    private int  value;

    public int getRowIndexAt() { return Row_Index_At; }
    public void setRowIndexAt(int Row_Index_At){ this.Row_Index_At = Row_Index_At;}

    public int getColumnIndexAt() { return Column_Index_At; }
    public void setColumnIndexAt(int  Column_Index_At){ this.Column_Index_At = Column_Index_At;}

    private int  Row_Index_To;
    public int getRowIndexTo() { return Row_Index_To; }
    public void setRowIndexTo(int  Row_Index_To){ this.Row_Index_To =Row_Index_To;}

    private int  Column_Index_To;
    public int getColumnIndexTo() { return Column_Index_To; }
    public void setColumn_Index_To(int  Column_Index_To){ this.Column_Index_To = Column_Index_To;}


    public int getValue() { return value; }
    public void setValue(int  Value){ this.value = Value;}

    // default constructor
    public Pair() {}

    public Pair(int row_at, int column_at, int row_to, int column_to, int val)
    {
        this.Row_Index_At = row_at;
        this.Row_Index_To = row_to;

        this.Column_Index_At = column_at;
        this.Column_Index_To = column_to;

        this.value = val;
    }

    // copy constructor
    public Pair(Pair pair)
    {

        this.Row_Index_At = pair.Row_Index_At;
        this.Row_Index_To = pair.Row_Index_To;
        this.Column_Index_At = pair.Column_Index_At;
        this.Column_Index_To = pair.Column_Index_To;
        this.value = pair.value;
    }

    public boolean isAtPosition()
    {

        return this.Row_Index_At == this.Row_Index_To &&
                this.Column_Index_At == this.Column_Index_To;
    }

    // Deep Check
    public boolean equals(Pair obj) {
        return obj.Row_Index_At == this.Row_Index_At
                && obj.Column_Index_At == this.Column_Index_At;
    }

    // Deep Check Two Cells

    public boolean deepEqual(Pair pair)
    {
        return
                this.Row_Index_At == pair.Row_Index_At &&
                        this.Row_Index_To == pair.Row_Index_To &&
                        this.Column_Index_At == pair.Column_Index_At &&
                        this.Column_Index_To == pair.Column_Index_To &&
                        this.value == pair.value;
    }
}
