import com.edu.truman.li.cs260.Board;

public class TicTacToeApp {
  public static void main(String[] args){
    Board chessBoardObject = new Board();

    //Show the board and the direction of the game
    chessBoardObject.Direction();
    //Game Begin
    chessBoardObject.HumanChangeBoard();
    chessBoardObject.DisplayBoard();
  }
}
