import java.util.Random;
public class Game {
    private Random rd;
    private Board board;
    public Game(){
       board=new Board();
    }

    public void newBoard(){
        board.create();
    }
    public void print(){
        board.print();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
