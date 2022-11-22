import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Gui program.
 */
public class GUIProgram implements ActionListener
{
  /**
   * The Number of buttons.
   */
  static final int NUMBER_OF_BUTTONS = 4;
  // Number buttons
  JButton[] boardButtons = new JButton[NUMBER_OF_BUTTONS];
  JButton nowPlaying;
  JButton mediaGuide;
  JButton library;
  JButton helpAndInfo;
  JButton okButton;
  JLabel infoLabel;
  JFrame applicationWindow;
  JTextArea textSection;
  
  /**
   * Instantiates a new Gui program.
   * @param title the title of the frame
   */
  public GUIProgram(String title)
  {
    int fontSize = 20;
    String fontTypes = "SansSerif";
    applicationWindow = new JFrame(title); // creating a JFrame window with the title
    nowPlaying = new JButton("Now Playing");
    nowPlaying.setFont(new Font(fontTypes, Font.PLAIN, 16));
    nowPlaying.addActionListener(this);
    mediaGuide = new JButton("Media Guide");
    mediaGuide.setFont(new Font(fontTypes, Font.PLAIN, 16));
    mediaGuide.addActionListener(this);
    library = new JButton("Library");
    library.setFont(new Font(fontTypes, Font.PLAIN, 16));
    library.addActionListener(this);
    helpAndInfo = new JButton("Help & Info");
    helpAndInfo.setFont(new Font(fontTypes, Font.PLAIN, 16));
    helpAndInfo.addActionListener(this);
    
    // Left side panel
    JPanel leftButtonPanel = new JPanel();
    leftButtonPanel.setLayout(new GridLayout(4, 1));
    leftButtonPanel.add(nowPlaying, BorderLayout.NORTH);
    leftButtonPanel.add(mediaGuide, BorderLayout.NORTH);
    leftButtonPanel.add(library, BorderLayout.NORTH);
    leftButtonPanel.add(helpAndInfo, BorderLayout.NORTH);
  
    // Text Panel
    textSection = new JTextArea(35, 30);
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new FlowLayout());
    centerPanel.add(textSection, BorderLayout.CENTER);
    
    // Number button
    JPanel NumberButtonPanel = new JPanel();
    NumberButtonPanel.setLayout(new GridLayout(2, 2));
    for (int index = 0; index < NUMBER_OF_BUTTONS; index++)
    {
      boardButtons[index] = new JButton();
      boardButtons[index].setText(Integer.toString(index));
      boardButtons[index].setFont(new Font(fontTypes, Font.PLAIN, fontSize));
      boardButtons[index].addActionListener(this);
      NumberButtonPanel.add(boardButtons[index], BorderLayout.EAST); // adding the button to the Panel
    }
    
    // OK Button
    JPanel OKButtonPanel = new JPanel();
    OKButtonPanel.setLayout(new FlowLayout());
    okButton = new JButton("OK");
    okButton.setFont(new Font(fontTypes, Font.PLAIN, 16));
    okButton.setPreferredSize(new Dimension(160, 280));
    okButton.addActionListener(this);
    OKButtonPanel.add(okButton, BorderLayout.SOUTH);
  
    // Button on the right side
    JPanel rightButtonPanel = new JPanel();
    rightButtonPanel.setLayout(new GridLayout(2,1));
    rightButtonPanel.add(NumberButtonPanel,BorderLayout.NORTH);
    rightButtonPanel.add(OKButtonPanel, BorderLayout.SOUTH);
    
    
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new FlowLayout());
    contentPanel.add(leftButtonPanel, BorderLayout.NORTH);
    contentPanel.add(centerPanel, BorderLayout.CENTER);
    contentPanel.add(rightButtonPanel, BorderLayout.NORTH);
    
    // Text information panel
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new GridLayout(2, 8));
    infoLabel = new JLabel("                                       Movies   Music   Videos   DVD   Web Pages");
    infoLabel.setFont(new Font(fontTypes, Font.PLAIN, 16));
    infoLabel.setPreferredSize(new Dimension(100, 40));
    infoPanel.add(infoLabel, BorderLayout.CENTER);
    
    
    // adding all the panels to the main window
    applicationWindow.setLayout(new BorderLayout());
    applicationWindow.add(contentPanel, BorderLayout.NORTH);
    applicationWindow.add(infoPanel, BorderLayout.SOUTH);
  
    applicationWindow.setSize(750, 690);
    applicationWindow.setVisible(true);
    applicationWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  
  /**
   * The entry point of application.
   * @param args the input arguments
   */
  public static void main (String[] args)
  {
    GUIProgram window = new GUIProgram("Movie on Thursday");
  }
  
  // Event when button clicked
  public void actionPerformed (ActionEvent event)
  {
    if(event.getSource().equals(nowPlaying))
    {
      this.textSection.append("Now Playing \n");
    }
    else if (event.getSource().equals(library))
    {
      this.textSection.append("Library \n");
    }
    else if (event.getSource().equals(mediaGuide))
    {
      this.textSection.append("Media Guide \n");
    }
    else if (event.getSource().equals(helpAndInfo))
    {
      this.textSection.append("Help & Info \n");
    }
    else if (event.getSource().equals(boardButtons[0]))
    {
      this.textSection.append("0 \n");
    }
    else if (event.getSource().equals(boardButtons[1]))
    {
      this.textSection.append("1 \n");
    }
    else if (event.getSource().equals(boardButtons[2]))
    {
      this.textSection.append("2 \n");
    }
    else if (event.getSource().equals(boardButtons[3]))
    {
      this.textSection.append("3 \n");
    }
    else
    {
      this.textSection.append("OK \n");
    }
  }
}
