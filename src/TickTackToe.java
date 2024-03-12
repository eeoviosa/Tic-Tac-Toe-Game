
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class TickTackToe implements ActionListener {

	JFrame frame = new JFrame();
	JPanel title_Panel = new JPanel();
	JPanel button_Panel = new JPanel();
	JButton button[] = new JButton[9];
	Random random = new Random();
    JLabel textField = new JLabel();
    JButton replay = new JButton();
    JPanel replay_Panel = new JPanel();
    boolean player1_turn;
	TickTackToe()
	{
		replay.setText("Replay");
		replay.setFocusable(false);
	//eplay.setBounds(0,0,30,60);
		//play.setSize(30,60);
		replay.setBackground(Color.red);
		
		
		
		replay.addActionListener(this);
		
		replay_Panel.setBackground(Color.BLUE);
		replay_Panel.add(replay);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setTitle("TicktacToe");
		frame.setVisible(true);
		
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("TickTackToe");
		textField.setOpaque(true);
		
		title_Panel.setLayout(new BorderLayout());
		title_Panel.setBounds(0,0,800,100);
		
		
		replay_Panel.setBounds(0,0,50,100);
		
		
		
		
		button_Panel.setLayout(new GridLayout(3,3));
		button_Panel.setBackground(new Color(150,150,150));
		
		for(int i = 0; i < 9; i++)
		{
			button[i] = new JButton();
			button_Panel.add(button[i]);
			button[i].setFont(new Font("MV BOLI", Font.BOLD, 120));
			button[i].addActionListener(this);
			button[i].setFocusable(false);
			
		}
		
		title_Panel.add(textField);
		frame.add(button_Panel);
		frame.add(title_Panel, BorderLayout.NORTH);
frame.add(replay_Panel,BorderLayout.WEST);
		//ame.add(replay_Panel,BorderLayout.WEST);
		
		Firstturn();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 9; i++)
		{
			if(e.getSource() == button[i])
			{
				if(player1_turn)
				{
					if(button[i].getText() == "")
					{
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("X");
						player1_turn = false;
						textField.setText("O turn");
						check();
						
					}
				}
				else {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("O");
						player1_turn = true;
						textField.setText("X turn");
						check();
					}
				}
			}
		
		if (e.getSource() == replay)
		{
			frame.dispose();
			TickTackToe game = new TickTackToe();
		}
		}
		
	
	
	public void Firstturn()
	{
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2) == 0)
		{
			player1_turn = true;
			textField.setText("X turn");
		}
		
		else
			{
			player1_turn = false;
			textField.setText("O turn");
			}
			
	}
	
	public void check()
	{
		if(button[0].getText() == "X" && 
			button[1].getText() == "X" &&
			button[2].getText() == "X"
			)
		{
			xWins(0,1,2);
		}
		
		if(button[3].getText() == "X" && 
				button[4].getText() == "X" &&
				button[5].getText() == "X"
				)
			{
				xWins(3,4,5);
			}
		
		if(button[6].getText() == "X" && 
				button[7].getText() == "X" &&
				button[8].getText() == "X"
				)
			{
				xWins(6,7,8);
			}
		
		if(button[0].getText() == "X" && 
				button[3].getText() == "X" &&
				button[6].getText() == "X"
				)
			{
				xWins(0,3,6);
			}
		if(button[1].getText() == "X" && 
				button[4].getText() == "X" &&
				button[7].getText() == "X"
				)
			{
				xWins(1,4,7);
			}
		if(button[2].getText() == "X" && 
				button[5].getText() == "X" &&
				button[8].getText() == "X"
				)
			{
				xWins(2,5,8);
			}
		if(button[0].getText() == "X" && 
				button[4].getText() == "X" &&
				button[8].getText() == "X"
				)
			{
				xWins(0,4,8);
			}
		if(button[2].getText() == "X" && 
				button[4].getText() == "X" &&
				button[6].getText() == "X"
				)
			{
				xWins(2,4,6);
			}
	


		if(button[0].getText() == "O" && 
			button[1].getText() == "O" &&
			button[2].getText() == "O"
			)
		{
			oWins(0,1,2);
		}
		
		if(button[3].getText() == "O" && 
				button[4].getText() == "O" &&
				button[5].getText() == "O"
				)
			{
				oWins(3,4,5);
			}
		
		if(button[6].getText() == "O" && 
				button[7].getText() == "O" &&
				button[8].getText() == "O"
				)
			{
				oWins(6,7,8);
			}
		
		if(button[0].getText() == "O" && 
				button[3].getText() == "O" &&
				button[6].getText() == "O"
				)
			{
				oWins(0,3,6);
			}
		if(button[1].getText() == "O" && 
				button[4].getText() == "O" &&
				button[7].getText() == "O"
				)
			{
				oWins(1,4,7);
			}
		if(button[2].getText() == "O" && 
				button[5].getText() == "O" &&
				button[8].getText() == "O"
				)
			{
				oWins(2,5,8);
			}
		if(button[0].getText() == "O" && 
				button[4].getText() == "O" &&
				button[8].getText() == "O"
				)
			{
				oWins(0,4,8);
			}
		if(button[2].getText() == "O" && 
				button[4].getText() == "O" &&
				button[6].getText() == "O"
				)
			{
				oWins(2,4,6);
			}
	}
	
	public void xWins(int a, int b, int c)
	{
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++)
		{
			button[i].setEnabled(false);
		}
		
		textField.setText("X Wins!");
	}

	public void draw()
	{
		for(int i = 0; i < 9; i++)
		{
			button[i].setEnabled(false);
		}
		textField.setText("Draw!");
	}
	
	public void oWins(int a, int b, int c)
	{
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++)
		{
			button[i].setEnabled(false);
		}
		
		textField.setText("O Wins!");
	}
	
	public void replay()
	{
		
	}
}
