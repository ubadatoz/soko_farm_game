package Structure.Models;

public class Cell {

    private int  Row_Index_At;
    public int getRowIndexAt() { return Row_Index_At; }
    public void setRowIndexAt(int  Row_Index_At){ this.Row_Index_At = Row_Index_At;}

    private int  Column_Index_At;
    public int getColumnIndexAt() { return Column_Index_At; }
    public void setColumnIndexAt(int  Column_Index_At){ this.Column_Index_At = Column_Index_At;}

    private int  Row_Index_To;
    public int getRowIndexTo() { return Row_Index_To; }
    public void setRowIndexTo(int  Row_Index_To){ this.Row_Index_To =Row_Index_To;}

    private int  Column_Index_To;
    public int getColumnIndexTo() { return Column_Index_To; }
    public void setColumn_Index_To(int  Column_Index_To){ this.Column_Index_To = Column_Index_To;}

    private int  Value;
    public int getValue() { return Value; }
    public void setValue(int  Value){ this.Value = Value;}


        public Cell() { }

        public Cell(int row_at, int column_at, int row_to, int column_to, int val)
        {
            this.Row_Index_At = row_at;
            this.Row_Index_To = row_to;

            this.Column_Index_At = column_at;
            this.Column_Index_To = column_to;

            this.Value = val;
        }

        public Cell(Cell cell)
        {
            this.Row_Index_At = cell.Row_Index_At;
            this.Row_Index_To = cell.Row_Index_To;

            this.Column_Index_At = cell.Column_Index_At;
            this.Column_Index_To = cell.Column_Index_To;

            this.Value = cell.Value;
        }

        public boolean isAtPosition()
        {
            return this.Row_Index_At == this.Row_Index_To &&
                   this.Column_Index_At == this.Column_Index_To;
        }

        // Deep Check Two Cells
        public boolean deepEqual(Cell cell)
        {
            return
                    this.Row_Index_At == cell.Row_Index_At &&
                            this.Row_Index_To == cell.Row_Index_To &&
                            this.Column_Index_At == cell.Column_Index_At &&
                            this.Column_Index_To == cell.Column_Index_To &&
                            this.Value == cell.Value;
        }

}
