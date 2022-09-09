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
            if(option==1){
                game.newBoard();
                game.print();
            }
            switch (option){
                case 1:
                    int option2=0;
                    while(option2 != 3) {
                        System.out.println("Enter your nickname");
                        String name = lector.nextLine();
                        System.out.println("...Let´s start the game...");
                        System.out.println("Choose an option");
                        System.out.println("1. Set a pipe");
                        System.out.println("2. Simulate");
                        System.out.println("3. Exit");
                         option2 = lector.nextInt();
                        lector.nextLine();
                        game.newPlayer(name);
                        addPipe(option2);
                    }
                    break ;
                case 2: boolean m= game.simulate();
                    System.out.println(m);
                    break ;
                case 3:
                     game.inorder();
                    break ;

            }

        }

    }
    public static void addPipe(int option) {
        switch (option){
            case 1:
                System.out.println("Enter the position of the pipe");
                System.out.println("Start entering the line: ");
                int line = lector.nextInt();
                lector.nextLine();
                System.out.println("Now enter the column");
                int column = lector.nextInt();
                System.out.println("Enter the type of the pipe: 1. =; 2.  ||; 3. o.");
                int typePipe = lector.nextInt();
                String pipe="";
                switch (typePipe){
                    case 1: pipe="=";
                        break;
                    case 2: pipe="||";
                        break;
                    case 3: pipe="o";
                        break;
                }
                game.changePipe(line,column,pipe);
                game.print();
                game.simulate();
                System.out.println("---------------------------------");
                break;
        }
    }
}