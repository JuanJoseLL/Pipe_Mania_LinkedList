import java.util.Random;
public class Board {
    private Pipe head;
    private Pipe tail;
    public int col=1;
    public int line=1;
    public Random rd=new Random();

    public void addLast(Pipe pipe){
        if(head == null){
            head = pipe;
            tail = pipe;
        }else{
            tail.setNext(pipe);
            tail = pipe;
        }
    }
    public void create(){
        if(col==8 && line==9){
            return;
        }
        if(line==9){
            col+=1;
            line=1;
        }
        addLast(new Pipe(col,line,"x"));
        line+=1;
        create();

    }
    public void print(){
        print(head);
    }
    private void print(Pipe current){
        if(current==null){
            return;
        }
        System.out.println("[ "+current.getColumn()+", "+current.getLine()+" ]");
        print(current.getNext());
    }
    public void linkedList(){
        head.setColumn(rd.nextInt(4)+1);
        head.setLine(rd.nextInt(4)+1);
        tail.setColumn(rd.nextInt(4)+head.getColumn());
        tail.setLine(rd.nextInt(4)+ head.getLine());
    }

    public Pipe getHead() {
        return head;
    }

    public void setHead(Pipe head) {
        this.head = head;
    }

    public Pipe getTail() {
        return tail;
    }

    public void setTail(Pipe tail) {
        this.tail = tail;
    }
}
