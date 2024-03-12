import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class TickTackToe implements ActionListener {

	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton[] buttons = new JButton[9];
	Random random = new Random();
	JLabel textField = new JLabel();
	JButton replayButton = new JButton();
	JPanel replayPanel = new JPanel();
	boolean player1Turn;

	TickTackToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Tic Tac Toe");
		frame.setVisible(true);

		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);

		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);

		replayButton.setText("Replay");
		replayButton.setFocusable(false);
		replayButton.setBackground(Color.RED);
		replayButton.addActionListener(this);

		replayPanel.setBackground(Color.BLUE);
		replayPanel.add(replayButton);

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].addActionListener(this);
			buttons[i].setFocusable(false);
		}

		titlePanel.add(textField);
		frame.add(buttonPanel);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(replayPanel, BorderLayout.WEST);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1Turn) {
					if (buttons[i].getText().equals("")) {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1Turn = false;
						textField.setText("O turn");
						check();
					}
				} else {
					if (buttons[i].getText().equals("")) {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						player1Turn = true;
						textField.setText("X turn");
						check();
					}
				}
			}
		}

		if (e.getSource() == replayButton) {
			resetGame();
		}
	}

	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (random.nextInt(2) == 0) {
			player1Turn = true;
			textField.setText("X turn");
		} else {
			player1Turn = false;
			textField.setText("O turn");
		}
	}

	public void check() {
		int[][] winConditions = {
				{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
				{0, 3, 6}, {1, 4, 7}, {2, 5, 8},
				{0, 4, 8}, {2, 4, 6}
		};

		for (int[] winCondition : winConditions) {
			if (checkWinCondition(winCondition)) {
				return;
			}
		}
		checkForDraw();
	}

	public boolean checkWinCondition(int[] winCondition) {
		if (!buttons[winCondition[0]].getText().equals("") &&
				buttons[winCondition[0]].getText().equals(buttons[winCondition[1]].getText()) &&
				buttons[winCondition[1]].getText().equals(buttons[winCondition[2]].getText())) {

			if (buttons[winCondition[0]].getText().equals("X")) {
				xWins(winCondition[0], winCondition[1], winCondition[2]);
			} else {
				oWins(winCondition[0], winCondition[1], winCondition[2]);
			}
			return true;
		}
		return false;
	}

	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (JButton button : buttons) {
			button.setEnabled(false);
		}
		textField.setText("X Wins!");
	}

	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (JButton button : buttons) {
			button.setEnabled(false);
		}
		textField.setText("O Wins!");
	}

	public void checkForDraw() {
		boolean allFilled = true;
		for (JButton button : buttons) {
			if (button.getText().equals("")) {
				allFilled = false;
				break;
			}
		}
		if (allFilled) {
			draw();
		}
	}

	public void draw() {
		for (JButton button : buttons) {
			button.setEnabled(false);
		}
		textField.setText("Draw!");
	}

	public void resetGame() {
		for (JButton button : buttons) {
			button.setText("");
			button.setEnabled(true);
			button.setBackground(new JButton().getBackground());
		}
		firstTurn();
	}
}
//