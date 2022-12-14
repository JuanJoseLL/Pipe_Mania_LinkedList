package model;


public class Game {
    private Player root;
    private Board board;



    public void newBoard(){
        board=new Board();
        board.create();
        board.startAndFinal();
    }
    public void print(){
        board.print();
    }
    public void changePipe(int line,int col,String type){
        board.changePipe(line,col,type);
    }
    public void changePipe1(int line, int col, String type) {

        board.changePipe1(line,col,type);
    }
    public void simulate(){
         board.simulate();
    }

    public void insert(String name,double points){
        Player n=new Player(name,points);
        if(root==null){
            root=n;
        }else{
            insert(n,root);
        }
    }
    private void insert(Player input,Player current){
        if(input.getScore()< current.getScore()){
            //Left
            if(current.getLeft()!=null){
                insert(input,current.getLeft());
            }else{
                current.setLeft(input);
            }
        }
        else if(input.getScore()>current.getScore()){
            //Right
            if(current.getRight()!=null){
                insert(input,current.getRight());
            }else{
                current.setRight(input);
            }
        }else{
            //Equal
            Player aux = current.getLeft();
            current.setLeft(input);
            input.setLeft(aux);
            return;
        }
    }
    public void inorder(){

        inorder(root);

    }
    private void inorder(Player current){
        if(current==null){
            return;
        }
        inorder(current.getLeft());
        System.out.println(current.getUsername()+": "+current.getScore());
        inorder(current.getRight());
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getRoot() {
        return root;
    }

    public void setRoot(Player root) {
        this.root = root;
    }

}
