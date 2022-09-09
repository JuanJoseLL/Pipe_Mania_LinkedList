public class Pipe {
    private Pipe next;
    private Pipe prev;
    private Pipe up;
    private Pipe down;
    private int column;
    private int line;
    private String typePipe;

    public Pipe(int column, int line, String typePipe) {
        this.column = column;
        this.line = line;
        this.typePipe = typePipe;
    }

    public Pipe getUp() {
        return up;
    }

    public void setUp(Pipe up) {
        this.up = up;
    }

    public Pipe getDown() {
        return down;
    }

    public void setDown(Pipe down) {
        this.down = down;
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
