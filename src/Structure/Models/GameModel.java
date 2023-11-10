package Structure.Models;

import java.util.Arrays;

public class GameModel {

    // row boundary
    private  int row_boundary;
    // column boundary
    private  int column_boundary;
    // game board
    public int[][] board;
    public static final int BLOCK = 1000;
    // player cell position
    private Pair player;
    private Pair plant1;
    private Pair plant2;

    private Positions lastPosition;

    public GameModel() { }

    public GameModel(int row_boundary, int column_boundary, int[][] board,
                     Pair player,Pair plant1,Pair plant2 )
    {
        this.row_boundary = row_boundary;
        this.column_boundary = column_boundary;
        this.board = board;
        this.player = player;
        this.plant1 = plant1;
        this.plant2 = plant2;

        }


    // copy constructor (Deep Copy)
    public GameModel(GameModel gameModel)
    {
        this.row_boundary = gameModel.row_boundary;
        this.column_boundary = gameModel.column_boundary;
        this.board = new int[row_boundary][column_boundary];

        for(int i=0; i<this.row_boundary; i++)
        {
            for(int j=0; j< this.column_boundary; j++)
            {
                this.board[i][j] = gameModel.board[i][j];
            }
        }

        // pair deep copy
        this.player = new Pair(gameModel.player);
        this.plant1 = new Pair(gameModel.plant1);
        this.plant2 = new Pair(gameModel.plant2);

    }

    public boolean deepEqual(GameModel game)
     {
        return  game.player.equals(game.player) &&
                game.plant1.equals(game.plant1) &&
                game.plant2.equals(game.plant2);
    }

    // Deep Check
    public boolean equals(GameModel obj) {

        return
                obj.player.equals(this.player)
                && Arrays.deepEquals(this.board, obj.board)
                && obj.plant1.equals(this.plant1)
                && obj.plant2.equals(this.plant2);
    }

    // Getter Methods
    public int getRow_boundary() {
        return row_boundary;
    }

    public int getColumn_boundary() {
        return column_boundary;
    }

    public int[][] getBoard() {
        return board;
    }



    public void setBoard(int[][] b) { board = b; }

    public Pair getPlayer() {
       return player;
    }
    public Pair getPlant1() {
        return plant1;
    }
    public Pair getPlant2() {
        return plant2;
    }

    public int get(int row_index, int column_index) {
        if (row_index < 0 || row_index >= row_boundary ||
                column_index < 0  ||column_index >= column_boundary) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        return board[row_index][column_index];
    }

    public void set(int row_index, int column_index, int value) {

        if (row_index < 0  ||row_index >= row_boundary ||
                column_index < 0 || column_index >= column_boundary){

            throw new IndexOutOfBoundsException("Index out of range"); }

        board[row_index][column_index] = value;
    }

    public Positions getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(Positions lastPosition) {
        this.lastPosition = lastPosition;
    }
}


