import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                board[i][j] = ' ';
            }
        }

        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        System.out.println("Name of player with sign 'X' : ");
        player1.player_Name = sc.nextLine();
        player1.playerID = 'X';
        System.out.println("Name of player with sign 'O' : ");
        player2.player_Name = sc.nextLine();
        player2.playerID = 'O';
        char player = 'X';
        boolean gameOver = false;

        while(!gameOver){
            printBoard(board);
            if (player == player1.playerID) {
                System.out.println(player1.player_Name+ "'s move :");
            }
            else{
                System.out.println(player2.player_Name+ "'s move :");
            }
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board[row][col]==' '){
                board[row][col] = player;
                gameOver = hasWon(board,player);
                boolean isTie = tie(board,gameOver);
                if(gameOver){
                    if (player == player1.playerID) {
                        System.out.println(player1.player_Name+ " wins!");
                        break;
                    }
                    else{
                        System.out.println(player2.player_Name+ " wins!");
                        break;
                    }

                }
                else if (isTie) {
                    System.out.println("It's a tie baby :p");
                    break;
                }
                player = (player == 'X') ? 'O':'X';
            }else {
                System.out.println("Invalid move! Try again!");
            }

        }
        printBoard(board);
    }

    private static boolean hasWon(char[][] board, char player) {
        for (int i = 0; i <3 ; i++) {
            if (board[i][0]==player && board[i][1]==player && board[i][2]==player) {
                return true;
            } else if (board[0][i]==player && board[1][i]==player && board[2][i]==player) {
                return true;
            }
            else if (board[0][0]==player && board[1][1]==player && board[2][2]==player) {
                return true;
            }
            else if (board[0][2]==player && board[1][1]==player && board[2][0]==player) {
                return true;
            }

        }
        return false;
    }

    public static  boolean tie(char[][] board,boolean gameOver){
        if (!gameOver) {
            for (int i = 0; i <3 ; i++) {
                for (int j = 0; j <3; j++) {
                    if (board[i][j]==' ') {
                        return false;
                    }
                }
            }
            gameOver = true;
            return true;
        }
        else {
            return false;
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.print(board[i][j] + " |");
            }
            System.out.println();
        }
    }
}