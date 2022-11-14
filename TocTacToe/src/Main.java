import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{' ' ,' ' ,' '},
                          {' ' ,' ' ,' '},
                          {' ' ,' ' ,' '}};
        Scanner scanner = new Scanner(System.in);
        while(true){
            playerTurn(board,scanner);
            if (isGameFinished(board,'X')){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if (isGameFinished(board,'O')){
                break;
            }
            printBoard(board);
        }
    }

    private static void playerTurn(char[][] board,Scanner scanner) {
        String userInput;
        while(true){
            System.out.println("where would you like to play 1-9");
            userInput = scanner.nextLine();
            if(isValid(board,userInput)){
                break;
            }else {
                System.out.println(userInput + " is not valid");
            }
        }
        placeMove(board, userInput,'X');
    }

    private  static  boolean isValid(char[][] board,String position){
        switch (position){
            case "1":
                return (board[0][0] ==' ');
            case "2":
                return (board[0][1] ==' ');
            case "3":
                return (board[0][2] ==' ');
            case "4":
                return (board[1][0] ==' ');
            case "5":
                return (board[1][1] ==' ');
            case "6":
                return (board[1][2] ==' ');
            case "7":
                return (board[2][0] ==' ');
            case "8":
                return (board[2][1] ==' ');
            case "9":
                return (board[2][2] ==' ');
            default:
                return false;


        }
    }
    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerPlay;
        while(true){
            computerPlay= random.nextInt(9)+1;
            if(isValid(board, Integer.toString(computerPlay))){
                break;
            }
        }
        System.out.println("computer Play in "+ computerPlay);
        placeMove(board,Integer.toString(computerPlay),'O');
    }

    private static void placeMove(char[][] board, String position,char symbol) {
        switch (position){
            case "1":
                board[0][0] =symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;

            default:
                System.out.println("invalid...");


        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1]+"|" + board[0][2]);
        System.out.println("-----");
        System.out.println(board[1][0] + "|" + board[1][1]+"|" + board[1][2]);
        System.out.println("-----");
        System.out.println(board[2][0] + "|" + board[2][1]+"|" + board[2][2]);
    }

    private static boolean isGameFinished(char[][] board,char symbol){
        if(symbol == 'X'){
            if( isWinner(board,symbol)){
                printBoard(board);
                System.out.println("Player wins !");
                return true;
            }
        }else {
            if( isWinner(board,symbol)){
                printBoard(board);
                System.out.println("Computer wins !");
                return true;
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("the game is in a tie");
        return true;
    }

    private static boolean isWinner(char[][] board, char symbol) {
        if(     (board[0][0]== symbol && board[0][1]== symbol && board[0][2]== symbol)||
                (board[1][0]== symbol && board[1][1]== symbol && board[1][2]== symbol)||
                (board[2][0]== symbol && board[2][1]== symbol && board[2][2]== symbol)||

                (board[0][0]==symbol && board[1][0]==symbol && board[2][0]== symbol)||
                (board[0][1]==symbol && board[1][1]==symbol && board[2][1]== symbol)||
                (board[0][2]==symbol && board[1][2]==symbol && board[2][2]== symbol)||

                (board[0][0]== symbol && board[1][1]== symbol && board[2][2]== symbol)||
                (board[0][2]== symbol && board[1][1]== symbol && board[2][0]== symbol)){

            return true;
        }else{
            return false;
        }
    }
}