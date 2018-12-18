import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level implements ActionListener {

	private JFrame frame;
	private JPanel main, panel, btPanel, left, right, bottom;
	private JButton easy, hard, back;
	private JLabel name;
	
	public Level() {
		frame = new JFrame("Sudoku! by OOP-Project");
		main = new JPanel(new BorderLayout());
		panel = new JPanel(new GridLayout(2, 1));
		btPanel = new JPanel(new GridLayout(3, 1, 10, 10));
		left = new JPanel();
		right = new JPanel();
		bottom = new JPanel();
		easy = new JButton("Easy");
		hard = new JButton("Hard");
		back = new JButton("Back");
		name = new JLabel("Select Level");
		
		panel.setBackground(Color.pink);
		btPanel.setBackground(Color.pink);
		main.setBackground(Color.pink);
		left.setBackground(Color.pink);
		right.setBackground(Color.pink);
		bottom.setBackground(Color.pink);
		
		name.setFont(new Font("ARIALBD", Font.ITALIC | Font.BOLD, 48));
		name.setForeground(Color.black);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		
		easy.setFont(new Font("ARIALBD", Font.BOLD, 20));
		easy.setForeground(Color.black);
		easy.setBackground(Color.green);
		hard.setFont(new Font("ARIALBD", Font.BOLD, 20));
		hard.setForeground(Color.black);
		hard.setBackground(Color.red);
		back.setForeground(Color.red);
		back.setBackground(Color.black);
		back.setFont(new Font("ARIALBD", Font.BOLD, 20));
		
		easy.addActionListener(this);
		hard.addActionListener(this);
		back.addActionListener(this);
		
		btPanel.add(easy);
		btPanel.add(hard);
		
		panel.add(name);
		panel.add(btPanel);
		
		left.add(back);
		
		left.setPreferredSize(new Dimension(200, 480));
		right.setPreferredSize(new Dimension(200, 480));
		bottom.setPreferredSize(new Dimension(854, 50));
		
		main.add(panel, BorderLayout.CENTER);
		main.add(left, BorderLayout.WEST);
		main.add(right, BorderLayout.EAST);
		main.add(bottom, BorderLayout.SOUTH);
		
		frame.add(main);
		frame.setSize(854, 480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		if(cmd.equals("Easy")) {
			new Easy();
			frame.dispose();
			}
		else if (cmd.equals("Hard")){
			new Hard();
			frame.dispose();
		}
		else if(cmd.equals("Back")) {
			new Main();
			frame.dispose();
		}
		}
	}
	

