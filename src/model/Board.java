package model;

import java.util.Random;
public class Board {
    private Pipe head;
    private Pipe tail;
    public int col=0;
    public int line=0;
    public Random rd=new Random();
    int cont=0;
    boolean simulate=true;

    public void addLast(Pipe pipe){
        if(head == null){
            head = pipe;
            tail = pipe;
            tail.setPrev(head);
            head.setNext(tail);
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
    private void changePipe(int line, int col, Pipe current, String type) {
        if(current==null){
            System.out.println("Invalid position");
            return;
        }
        if(current.getLine() == line && current.getColumn() == col){
            if(current.getTypePipe().equals("F") || current.getTypePipe().equals("D")){
                System.out.println("You can´t change the start or finish ");
            }else{
                if(current.getPrev().getTypePipe().equals("F") && current.getTypePipe().equals("=")){
                    current.setTypePipe(type);
                } else if (current.getNext().getTypePipe().equals("F") && current.getTypePipe().equals("=")) {
                    current.setTypePipe(type);
                }else{
                    current.setTypePipe(type);
                }

            }
        }else{
            changePipe(line,col,current.getNext(),type);
        }

    }
    public void changePipe1(int line, int col,String type){
        changePipe1(line,col,head,type);
    }
    private void changePipe1(int line, int col, Pipe current, String type) {
        if(current==null){
            System.out.println("Invalid position");
            return;
        }
    try {
        //Validacion de para no cambiar el inicio y el final
        if (current.getLine() == line && current.getColumn() == col) {
            if (current.getTypePipe().equals("F") || current.getTypePipe().equals("D")) {
                System.out.println("You can´t change the start or finish ");
                return;
            }
            //Validacion para poner una tuberia horizontal a la derecha de el inicio y para poner una tuberia horizontal a la derecha de otra
            if (current.getPrev().getTypePipe().equals("F") && type.equals("=") || current.getPrev().getTypePipe().equals("=") && type.equals("=")) {
                current.setTypePipe(type);
                current.setCorrectPosition(true);
                System.out.println(current.getLine() + ", " + current.getColumn());
                return;
            } else if (current.getNext().getTypePipe().equals("F") && type.equals("=") || current.getNext().getTypePipe().equals("=") && type.equals("=")) {
                current.setTypePipe(type);
                current.setCorrectPosition(true);
                System.out.println(current.getLine() + ", " + current.getColumn());
                System.out.println(current.getPrev().getLine() + ", " + current.getPrev().getColumn());
                return;
            } else if (current.getLine() == 0 && type.equals("||")) {
                System.out.println("The pipe must be connected to somenthing");
                return;

            } else if (current.getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getTypePipe().equals("F") && type.equals("||") || current.getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getTypePipe().equals("||") && type.equals("||")) {
                current.setTypePipe(type);
                current.setCorrectPosition(true);
                return;
            }else if(current.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getTypePipe().equals("F") && type.equals("||") || current.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getTypePipe().equals("||") && type.equals("||")){
                current.setTypePipe(type);
                current.setCorrectPosition(true);
                return;
            }else if(current.getPrev().getTypePipe().equals("=") && type.equals("o") || current.getPrev().getTypePipe().equals("o") && type.equals("=")){
                current.setTypePipe(type);
                current.setCorrectPosition(true);
                return;
            }else if(current.getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getTypePipe().equals("||") && type.equals("o")){
                current.setTypePipe(type);
                current.setCorrectPosition(true);
                return;
            }else if(current.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getTypePipe().equals("||") && type.equals("o")){
                current.setTypePipe(type);
                current.setCorrectPosition(true);
                return;
            }else if(current.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getTypePipe().equals("o") || current.getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getTypePipe().equals("o") || current.getNext().getTypePipe().equals("o") || current.getPrev().getTypePipe().equals("o") && type.equals("o")){
                current.setTypePipe(type);
                current.setCorrectPosition(false);
            }else{
                current.setTypePipe(type);
                current.setCorrectPosition(false);
                return;
            }
        }
        changePipe1(line,col,current.getNext(),type);

    }catch (NullPointerException e){
        e.printStackTrace();
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

    public void simulate(){
        simulate(head);

    }
    private void simulate(Pipe current){
        if(current==null){
            System.out.println("The simulation is good");
            return;
        }
        int i=0;
        if(current.getTypePipe().equals("F") || current.getTypePipe().equals("D")){
            if(current.getPrev().getTypePipe().equals("=") || current.getNext().getTypePipe().equals("=")){
                current.setCorrectPosition(true);
                simulate=true;

            }else if(current.getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getTypePipe().equals("||") || current.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getTypePipe().equals("||") ){
                current.setCorrectPosition(true);
                simulate=true;

            }else{
                current.setCorrectPosition(false);
                simulate=false;

            }
        }
        if(current.getTypePipe().equals("=") || current.getTypePipe().equals("||") || current.getTypePipe().equals("o")){
            if(current.isCorrectPosition()==true){
                simulate=true;
            }else{
                simulate=false;
            }
        }

        if(!simulate){
            System.out.println("The pipeline does not work, try again ");
            return;
        }
        //Termina el recorrido cuando encuentra el final de la pipe, despues de verificar esta misma
        if(current.getTypePipe().equals("D")){
            if(simulate){
                System.out.println("the pipeline works");
            }else{
                System.out.println("the pipeline does not work");
            }
            return;
        }

        simulate(current.getNext());
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
