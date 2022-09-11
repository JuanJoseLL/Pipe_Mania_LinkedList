import java.util.Scanner;
public class Main {
    public static Scanner  lector = new Scanner(System.in) ;
    public static Game game=new Game();
    public static void main(String[] args) {
        boolean flag  = false ;
        while(!flag){
            System.out.println("WELCOME TO PIPE MANIA");
            System.out.println("Choose an option");
            System.out.println("1. Start new Game");
            System.out.println("2. See score");
            System.out.println("3. Exit");
            int option = lector.nextInt() ;
            lector.nextLine() ;
            switch (option){
                case 1: menuBoard();
                    break;
                case 2: showScore();
                    break;
                case 3: flag=true;
                    break;
            }

        }

    }
    public static void showScore(){
        game.inorder();
    }
    public static void menuBoard(){
                boolean cont=true;
                int option2=0;

                    System.out.println("Enter your nickname");
                    String name = lector.nextLine();
                     game.insert(name);
                     game.newBoard();
                     game.print();
                    while(cont){
                    System.out.println("...Let´s start the game...");
                    System.out.println("Choose an option");
                    System.out.println("1. Set a pipe");
                    System.out.println("2. Simulate");
                    System.out.println("3. Exit");
                    option2 = lector.nextInt();
                    lector.nextLine();

                    switch (option2) {
                        case 1:
                            addPipe();
                            break;
                        case 2:
                            game.simulate();

                            break;
                        case 3: cont=false;
                            break;
                    }


                }

    }
    public static void addPipe() {
                System.out.println("Enter the position of the pipe");
                System.out.println("Start entering the line: ");
                int line = lector.nextInt();
                lector.nextLine();
                System.out.println("Now enter the column");
                int column = lector.nextInt();
                lector.nextLine();
                System.out.println("Enter the type of the pipe: 1. =; 2.  ||; 3. o.");
                int typePipe = lector.nextInt();
                lector.nextLine();
                String pipe="";
                switch (typePipe){
                    case 1: pipe="=";
                        break;
                    case 2: pipe="||";
                        break;
                    case 3: pipe="o";
                        break;
                }
            System.out.println(pipe+"tipo "+line+" linea"+column+" columna");
                game.changePipe1(line,column,pipe);
                game.print();
                System.out.println("---------------------------------");

        }

}