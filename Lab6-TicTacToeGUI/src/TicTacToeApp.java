import edu.truman.li.cs260.gui.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeApp implements ActionListener
{
  static final int NUMBER_OF_BUTTONS = 9;
  // Buttons to hold the selection values
  JButton[] boardButtons = new JButton[NUMBER_OF_BUTTONS];
  JButton restartGame;
  JButton quitGame;
  
  // to provide status message
  JLabel gameStatusLabel;
  JFrame gameWindow; // main window object
  
  boolean moveToggleFlag = false; // toggles computer/user move
  int gameMoveCount = 0; // counts the number of moves to determine draw
  
  // constructor
  public TicTacToeApp (String title)
  {
    int columnSize = 3;
    int rowSize = 3;
    int fontSize = 20;
    String fontTypes = "SansSerif";
    gameWindow = new JFrame(title); // creating a JFrame window with the title
    
    // The JPanel holds the buttons
    JPanel upperLayerPanel = new JPanel();
    upperLayerPanel.setLayout(new GridLayout(rowSize, columnSize));
    for (int index = 0; index < NUMBER_OF_BUTTONS; index++)
    {
      boardButtons[index] = new JButton();
      boardButtons[index].setText(Integer.toString(index + 1));
      boardButtons[index].setFont(new Font(fontTypes, Font.PLAIN, fontSize));
      boardButtons[index].addActionListener(this);
      upperLayerPanel.add(boardButtons[index]); // adding the button to the Panel
    }
    
    // Panel holding buttons at the south side
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new GridLayout(2, 1));
    
    restartGame = new JButton("Restart Game");
    restartGame.setFont(new Font(fontTypes, Font.PLAIN, 16));
    restartGame.addActionListener(this);
    
    quitGame = new JButton("Exit Game");
    quitGame.setFont(new Font(fontTypes, Font.PLAIN, 16));
    quitGame.addActionListener(this);
    
    
    gameStatusLabel = new JLabel("   Welcome. Your Turn. Select any button above to begin ..");
    gameStatusLabel.setFont(new Font(fontTypes, Font.PLAIN, 16));
    gameStatusLabel.setPreferredSize(new Dimension(100, 40));
    
    southPanel.add(gameStatusLabel, BorderLayout.CENTER);
    
    JPanel lowerButtonPanel = new JPanel();
    lowerButtonPanel.setLayout(new GridLayout(1, 2));
    lowerButtonPanel.add(restartGame, BorderLayout.WEST);
    lowerButtonPanel.add(quitGame, BorderLayout.EAST);
    southPanel.add(lowerButtonPanel);
    
    
    // adding all the panels to the main window
    gameWindow.setLayout(new BorderLayout());
    gameWindow.add(upperLayerPanel, BorderLayout.CENTER);
    gameWindow.add(southPanel, BorderLayout.SOUTH);
    
    
    gameWindow.setSize(500, 500);
    gameWindow.setVisible(true);
    gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  
  public static void main (String[] args)
  {
    TicTacToeApp gameWindow = new TicTacToeApp("TicTacToeGUI Game");
  }
  
  /**
   * This function is to reset the game
   */
  public void resetGame ()
  {
    for (int index = 0; index < NUMBER_OF_BUTTONS; index++)
    {
      boardButtons[index].setText(Integer.toString(index + 1));
      boardButtons[index].setForeground(Color.BLACK);
    }
    gameMoveCount = 0;
  }
  
  /**
   * This function is to perform the action of the chess movement
   * @param event is the status of the game
   */
  public void actionPerformed (ActionEvent event)
  {
    Board boardObject = new Board();
    // if the event source is the restart button then reset the title and the text
    if (event.getSource().equals(restartGame))
    {
      resetGame();
      this.gameStatusLabel.setText("   Game has restarted. Select any button above to begin ..");
      gameWindow.setTitle("TicTacToe [Your Turn]"); // this can be randomized
    }
    else
    { // determine which cell button triggered the action event
      for (int index = 0; index < NUMBER_OF_BUTTONS; index++)
      {
        if (event.getSource().equals(boardButtons[index]) && ((!boardButtons[index].getText().equals("H")) && (!boardButtons[index].getText().equals("C"))))
        {
          gameStatusLabel.setText("  You have selected cell No. " + (index + 1)); // this is the selected cell number
          if (moveToggleFlag)
          {
            // Computer move in here
            boardObject.ComputerSide();
            gameWindow.setTitle("TicTacToe [Your Turn]");
            boardButtons[index].setText("C");
            boardButtons[index].setForeground(Color.RED);
          }
          else
          {
            gameWindow.setTitle("TicTacToe [Computers Turn]");
            boardButtons[index].setText("H");
            boardButtons[index].setForeground(Color.BLUE);
          }
          moveToggleFlag = !moveToggleFlag;
          if (boardObject.JudgeWinner().equals("Human") || boardObject.JudgeWinner().equals("Computer"))
          {
            gameStatusLabel.setText("We have a winner! The winner is: " + boardObject.JudgeWinner());
            gameStatusLabel.setText("    The Game Over! Restart the game to continue ...");
            gameWindow.setTitle("TicTacToe [Game Over!]");
          }
          gameMoveCount++; // keep counting the moves
          
          if (gameMoveCount == NUMBER_OF_BUTTONS)
          { // if this is the last move
            gameStatusLabel.setText("There is no Winner! Tie Game");
            gameStatusLabel.setText("    The Game Over! Restart the game to continue ...");
            gameWindow.setTitle("TicTacToe [Game Over!]");
          }
        } // new move: if condition ends
      } // main if inside the loop ends
    } // for loop ends
  } // else block ends
} // actionPerformed function ends
