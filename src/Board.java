import java.util.Random;
public class Board {
    private Pipe head;
    private Pipe tail;
    public int col=0;
    public int line=0;
    public Random rd=new Random();

    public void addLast(Pipe pipe){
        if(head == null){
            head = pipe;
            tail = pipe;
            tail.setPrev(head);
        }else{
            tail.setNext(pipe);
            pipe.setPrev(tail);
            tail = pipe;

        }
    }
    public void create(){
        if(line==7 && col==8){
            return;
        }
        if(col==8){
            col=0;
            line+=1;
        }
        addLast(new Pipe(col,line,"x"));
        col+=1;
        create();
    }
    public void startAndFinal(){
        int colStart= rd.nextInt(4);
        int lineStart=rd.nextInt(4);
        int colEnd=rd.nextInt(4)+3;
        int lineEnd=rd.nextInt(4)+3;
        changePipe(lineStart,colStart,"F");
        changePipe(lineEnd,colEnd,"D");
    }
    public void changePipe(int line, int col,String type){
        changePipe(line,col,head,type);
    }
    private void changePipe(int line,int col,Pipe current,String type){
        if(current == null){
            System.out.println("Invalid position");
            return;
        }
        if(current.getLine() == line && current.getColumn() == col){
            if(current.getTypePipe().equals("F") || current.getTypePipe().equals("D")){
                System.out.println("You can´t change the start or finish ");
            }else{
                current.setTypePipe(type);

            }

        }else{
            changePipe(line,col,current.getNext(),type);
        }

    }

    public void print(){
        print(head);
    }
    private void print(Pipe current){
        if(current==null){
            return;
        }
        if(current.getColumn()==7){
            System.out.print("[ "+current.getTypePipe()+" ]\n");
        }else{
            System.out.print("[ "+current.getTypePipe()+" ]");
        }

        print(current.getNext());
    }
   /* public void printPrueba(){
        printPrueba(head);
    }
    public void printPrueba(Pipe current){
        if(current==null){
            return;
        }
        if(current.getColumn()==7){
            System.out.print("[ "+current.getLine()+", "+current.getColumn()+" ]\n");
        }else{
            System.out.print("[ "+current.getLine()+", "+current.getColumn()+" ]");
        }

        printPrueba(current.getNext());
    }*/
    public boolean simulate(){
        return simulate("D",head);
    }
    private boolean simulate(String goal,Pipe current){
        if(current==null){
            return false;
        }
        if (current.getTypePipe().equals("F")) {
            if(current.getNext().getTypePipe().equals("=") ){
                boolean path=simulatePipe("=",goal,current.getNext());
                System.out.println("Horizontal"+path);
            }
            if(current.getNext().getTypePipe().equals("o") ){
                boolean path=simulatePipe("o",goal,current.getNext());
                System.out.println("Giro"+path);
            }

        }
        return true;
    }
    private boolean simulatePipe(String goal,String pipe,Pipe current){
        if(pipe.equals("=")){
            return true;
        }else{

        }
        if(pipe.equals("o")){
            return true;
        }else{
            simulatePipe(goal,pipe,current.getNext());
        }
        return true;
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
