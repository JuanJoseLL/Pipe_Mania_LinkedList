package model;

public class Pipe {
    private Pipe next;
    private Pipe prev;

    private boolean correctPosition;
    private int column;
    private int line;
    private String typePipe;

    public Pipe(int column, int line, String typePipe) {
        this.column = column;
        this.line = line;
        this.typePipe = typePipe;
    }

    public boolean isCorrectPosition() {
        return correctPosition;
    }

    public void setCorrectPosition(boolean correctPosition) {
        this.correctPosition = correctPosition;
    }

    public Pipe getNext() {
        return next;
    }

    public void setNext(Pipe next) {
        this.next = next;
    }

    public String getTypePipe() {
        return typePipe;
    }

    public void setTypePipe(String typePipe) {
        this.typePipe = typePipe;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public Pipe getPrev() {
        return prev;
    }

    public void setPrev(Pipe prev) {
        this.prev = prev;
    }
}
