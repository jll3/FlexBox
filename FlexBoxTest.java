import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

//import java libraries
public class FlexBoxTest {//declare all variables
	private JTextArea question;
	private JLabel label;
	private JButton exitButton, submitButton;
	private JTextField Leng,Wid,Hei,Quan;
	private JLabel L,W,H,G,C,RB,RC,ST,Q;
	private JComboBox GradeChoice,ColourChoice;
	private JRadioButton ReinforcedBYes,ReinforcedBNo,ReinforcedCYes,ReinforcedCNo,SealedTopYes,SealedTopNo;
	private ButtonGroup RBottom,RCorners,STOP;
    private int i = 0;    
    JFrame frame;
    
private  String  [] Colourr={"0", "1","2"};//create strings of answer choices on questions
private  String [] Gradee={"1","2","3","4","5"};
private  String  ReinforceBYes = "Yes";
private String  ReinforceBNo = "No";
private  String  ReinforceCYes = "Yes";
private String  ReinforceCNo = "No";
private  String  SealedtYes = "Yes";
private String  SealedtNo = "No";
    
    public void setUp(){
    	  
    	label = new JLabel ("Create a FlexBox!");//sets jlabel
    	frame = new JFrame();//creates new jframe
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();//creates main panel 
		Font bigFont = new Font("sanserif", Font.BOLD, 14);//sets font of text in main panel
		
		JPanel buttonPanel = new JPanel();//creates button panel where buttons will be located
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));//sets location of button panel
		
		JPanel southPanel = new JPanel();//creates new jpanel named south panel 
		
		question = new JTextArea(8, 60);// creates text area and sets size and column lines
		question.setFont(bigFont);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
					
		question.setLineWrap(true);//allow text to continue on new line if line is full
		question.setEditable(false);//not allow user to type in this area
		
		question.append("Follow The Instructions Carefully");
		question.append("Specify each variable of a FlexBox you want. \n");//display insructions on screen in jframe
		question.append("Make sure what you enter is a valid answer. \n");
		question.append("Only enter numbers into text boxes. NO LETTERS.\n");
		question.append("BEFORE ENTERING VALUE - Clear Text Box Of Spaces\n");
		question.append("Do this by selecting all spaces in empty box and deleting it \n");
		question.append("When complete press submit, the cost of your box will be displayed. \n");
		question.append("After you view value of your box, press exit. \n");
		question.append("You may begin to fill up the questions. \n");
		
		JScrollPane qScroller = new JScrollPane(question);//create scroller
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//allow vertical mouse scrolling
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//not allow horizontal mouse scrolling
		
		//create buttons, set colours, set names
		exitButton = new JButton("Exit");
		exitButton.setBackground(Color.RED);
		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.BLUE);

    	mainPanel.add(qScroller);//add scroller and buttons to jframe
		southPanel.add(submitButton);
		southPanel.add(exitButton);
		
		
		//create listeners
		exitButton.addActionListener(new ExitButtonListener());
		submitButton.addActionListener(new submitButtonListener());

		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);//create panels
		frame.getContentPane().add(BorderLayout.EAST, buttonPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
		frame.getContentPane().add(BorderLayout.NORTH, label);
		frame.setSize(640,500);//set size of frame
		frame.setVisible(true);//true to show the frame
		
		L = new JLabel("Enter Length:"); //creates label for each question field
 		Leng = new JTextField("              ");//creates space to enter text
 		L.add(Leng);	//adds textfield to the jlabel
 			
 		W = new JLabel("Enter Width:"); 
 		Wid = new JTextField("              ");	
 		W.add(Wid);
 			
 		H= new JLabel ("Enter Height:");
 		Hei = new JTextField("              ");
 		H.add(Hei);
 		
 		G= new JLabel("Grade Of Card:");
 		GradeChoice=new JComboBox(Gradee);//create drop down box where options for this field are shown
 		
 		C = new JLabel("Colour?");	
 		ColourChoice= new JComboBox(Colourr);
 		
   		RB = new JLabel("Reinforced Bottom?");
		RBottom = new ButtonGroup();//make button group where boxes can be selected to choose an answer
		//ReinforcedBYes= new JRadioButton("ReinforcementBottom:");
		ReinforcedBYes= new JRadioButton(ReinforceBYes);//create an answer yes and no
		ReinforcedBNo= new JRadioButton(ReinforceBNo);
		RB.add(ReinforcedBYes);//add answers next to label
		RB.add(ReinforcedBNo);
		
		RC = new JLabel("Reinforced Corners?");
		RCorners = new ButtonGroup();
		//ReinforcedC1 = new JRadioButton("ReinforcementCorners: ");
		ReinforcedCYes = new JRadioButton (ReinforceCYes);
		ReinforcedCNo = new JRadioButton (ReinforceCNo);
		RC.add(ReinforcedCYes);
		RC.add(ReinforcedCNo);
		
		ST = new JLabel("Sealed Top?");
		STOP = new ButtonGroup();
		SealedTopYes = new JRadioButton(SealedtYes);
		SealedTopNo = new JRadioButton(SealedtNo);
		ST.add(SealedTopYes);
		ST.add(SealedTopNo);
		
		Q= new JLabel("Enter Quantity of this box you want:");
 		Quan = new JTextField("              ");
 		Q.add(Quan);
	//	Quantity.addActionListener(this);
		
		mainPanel.add(H);//adding each field to the jframe , where the questions are shown
		mainPanel.add(Hei);
		mainPanel.add(W);
		mainPanel.add(Wid);
		mainPanel.add(L);
		mainPanel.add(Leng);
		mainPanel.add(G);
		mainPanel.add(GradeChoice);
		mainPanel.add(C);
		mainPanel.add(ColourChoice);
		mainPanel.add(RB);
		mainPanel.add(ReinforcedBYes);
		mainPanel.add(ReinforcedBNo);
		mainPanel.add(RC);
		mainPanel.add(ReinforcedCYes);
		mainPanel.add(ReinforcedCNo);
		mainPanel.add(ST);
		mainPanel.add(SealedTopYes);
		mainPanel.add(SealedTopNo);
		mainPanel.add(Q);
		mainPanel.add(Quan);
		frame.setVisible(true);
    }
    
    public void finish(){
    	 //submitButton.setEnabled(false);//set usability of buttons - turns button off after it is pressed

    double Length=0;//create new instance variables copies of the ones in flexbox to assign values
    double Height=0;
    double Width=0;	 
    int Grade=0;
	int Colour=0;
	boolean Reinforcedbottom=false;
	boolean Reinforcedcorners=false;
	boolean Sealedtop=false;
	int Quantity=0;
	double Price=0;
	double Pricetotal=0;
	
    FlexBox one = new FlexBox(Length, Width, Height, Grade, Colour, Reinforcedbottom, Reinforcedcorners, Sealedtop, Quantity, Price, Pricetotal);
    
     	    double L = Double.parseDouble(Leng.getText());//assign new variable to user input value
     	 	double W = Double.parseDouble(Wid.getText());
   	    	double H = Double.parseDouble(Hei.getText());
   	    	int G = GradeChoice.getSelectedIndex()+1;
   	    	int C = ColourChoice.getSelectedIndex()+1;
   	    	int Q = Integer.parseInt(Quan.getText());
   	        
   	        one.setLength(L);//set values to variables in instance of class FlexBox one using new variable value given above
   	        one.setWidth(W);
   	        one.setHeight(H);	      
   	        one.setGrade(G);
   	    	one.setQuantity(Q);
   	    	one.setColour(C);
		
 if (ReinforcedBYes.isSelected())//when option is chosen on application
  	 {
    	one.setReinforcedbottom(true);//set the variable to given answer
   	}   
   if (ReinforcedBNo.isSelected())
   {
   	one.setReinforcedbottom(false);
   }      
    if (ReinforcedCYes.isSelected())
    {
     one.setReinforcedcorners(true);
    }
    if (ReinforcedCNo.isSelected())
    {
     one.setReinforcedcorners(false);
    }
    
    if (SealedTopYes.isSelected())
    {
      one.setSealedtop(true);
    }    
    if (SealedTopNo.isSelected())
    {
      one.setSealedtop(false);
    }

		question.setText("The price of your Order is = £" + one.Pricetotal() + "\n" + one.chooseTypes());//display price and type of box chosen of users box 
	
    }
		
    
    public static void main(String[]args){
    	FlexBoxTest newFlexBox = new FlexBoxTest();//create instance of FlexBoxMaker
    	newFlexBox.setUp();//call setup method of FlexBoxMaker
    }
    

    public class submitButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent ev){

   	      finish();  //call finish method
    	}
    }
    
    public class ExitButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent ev){
    		System.exit(0);//Exit program when button is activated
    	}
    }
   }