import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {
	
	private JFrame frame;
	private JPanel main, panel, btPanel, left, right, bottom;
	private JButton play, exit, tutorial, back;
	private JLabel name;
	private static String player;
	
	public Main() {
		frame = new JFrame("Sudoku! by OOP-Project");
		main = new JPanel(new BorderLayout());
		panel = new JPanel(new GridLayout(2, 1));
		btPanel = new JPanel(new GridLayout(3, 1, 10, 10));
		left = new JPanel();
		right = new JPanel();
		bottom = new JPanel();
		play = new JButton("Play");
		exit = new JButton("Exit");
		tutorial = new JButton("How to Play");
		
		name = new JLabel("Sudoku!");
		
		play.addActionListener(this);
		tutorial.addActionListener(this);
		exit.addActionListener(this);
		
		name.setFont(new Font("ARIALBD", Font.ITALIC | Font.BOLD, 56));
		name.setForeground(Color.black);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.setBackground(Color.pink);
		btPanel.setBackground(Color.pink);
		main.setBackground(Color.pink);
		left.setBackground(Color.pink);
		right.setBackground(Color.pink);
		bottom.setBackground(Color.pink);
		
		play.setFont(new Font("ARIALBD", Font.BOLD, 20));
		play.setForeground(Color.black);
		play.setBackground(Color.green);
		tutorial.setFont(new Font("ARIALBD", Font.BOLD, 20));
		tutorial.setForeground(Color.black);
		tutorial.setBackground(Color.yellow);
		exit.setFont(new Font("ARIALBD", Font.BOLD, 20));
		exit.setForeground(Color.black);
		exit.setBackground(Color.red);
		
		btPanel.add(play);
		btPanel.add(tutorial);
		btPanel.add(exit);
		
		panel.add(name);
		panel.add(btPanel);
		
		
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
	
	public static String getName() {
		return player;
	}
	
	public void setName() {
		while(true) {
			player = "";
			if(player.equals("")) {
				String inp = JOptionPane.showInputDialog(null, "enter your name");
				if(inp != null && inp.length() >= 1) {
					player = inp;
					break;
				}				
			}
		}
	}
	
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		if(cmd.equals("Play")) {
			new Level();
			frame.dispose();
			}
		else if(cmd.equals("How to Play")) {
			new HowtoPlay();
			frame.dispose();
		}
		else if(cmd.equals("Exit")) {
			System.exit(0);
			}
		}
	
	public static void main(String[] args) {
//		HowtoPlay gui = new HowtoPlay();
//		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gui.setVisible(true);
//		gui.pack();
//		gui.setTitle("How to Play!!!");
		
		new Main().setName();
	}
}
