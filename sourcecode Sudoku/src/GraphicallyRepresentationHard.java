import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GraphicallyRepresentationHard extends JFrame implements ActionListener{
	Container conhard;
	JButton b[][] = new JButton[16][16];
	TextField t[] = new TextField[256];
	JMenuBar mbarhard;
	JMenu file;
	JMenuItem submit, exit;
	Timer timer;
	
	int [][] cp = new int[16][16];
	int [][] ip = new int[16][16];
	
	GraphicallyRepresentationHard() {
		super("Sudoku! by OOP-Project");
		setSize(854, 480);
		
		conhard = getContentPane();
		conhard.setLayout(new GridLayout(16, 16));
		
		MylogicHard ob2 = new MylogicHard();
		ob2.complete_puzzle_hard();
		ob2.puzzle_hard();
		
		int c = 0;
		for(int i = 0; i < 16; i++) 
			for(int j = 0; j < 16; j++) {
				b[i][j] = new JButton("" + ip[i][j]);
				b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 14));
				b[i][j].setForeground(Color.red);
				if (ip[i][j] == 0) {
					b[i][j].setText("");
					b[i][j].setBackground(Color.white);
					b[i][j].addActionListener(this);
				}
				
				conhard.add(b[i][j]);
				
				if(i == 0 || i == 1 || i == 2 || i == 3) {
					if(j == 0 || j == 1 || j == 2 || j ==3) {
						b[i][j].setBackground(Color.white);
					} else if (j == 8 || j == 9 || j == 10 || j ==11) {
						b[i][j].setBackground(Color.white);
					} else {
						b[i][j].setBackground(Color.black);
					}
				} else if(i == 4 || i == 5 || i == 6 || i == 7) {
					if(j == 0 || j == 1 || j == 2 || j ==3) {
						b[i][j].setBackground(Color.black);
					} else if (j == 8 || j == 9 || j == 10 || j ==11) {
						b[i][j].setBackground(Color.black);
					} else {
						b[i][j].setBackground(Color.white);
					}
				} else if(i == 8 || i == 9 || i == 10 || i == 11) {
					if(j == 0 || j == 1 || j == 2 || j ==3) {
						b[i][j].setBackground(Color.white);
					} else if (j == 8 || j == 9 || j == 10 || j ==11) {
						b[i][j].setBackground(Color.white);
					} else {
						b[i][j].setBackground(Color.black);
					}
				} else if(i == 12 || i == 13 || i == 14 || i == 15) {
					if(j == 0 || j == 1 || j == 2 || j ==3) {
						b[i][j].setBackground(Color.black);
					} else if (j == 8 || j == 9 || j == 10 || j ==11) {
						b[i][j].setBackground(Color.black);
					} else {
						b[i][j].setBackground(Color.white);
					}
				}
			}
				
		mbarhard = new JMenuBar();
		setJMenuBar(mbarhard);
		
		file = new JMenu("File");
		
		//about = new JMenuItem("About");
		submit = new JMenuItem("Submit");
		exit = new JMenuItem("Exit");
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				int r = 0;
				
				for (int i = 0; i < 16; i++)
					for (int j = 0; j < 16; j++)
						if(cp[i][j] != Integer.parseInt(b[i][j].getText())) {
							r = 1;
							break;
						}
				
				for (int i = 0; i < 16; i++) {
					System.out.println();
					
					for (int j = 0; j < 16; j++) {
						System.out.print(cp[i][j]);
						System.out.print(Integer.parseInt(b[i][j].getText()) + "  ");
					}
				}
				
				System.out.print("\n" + r);
				
				if (r == 0) {
					JOptionPane.showMessageDialog(GraphicallyRepresentationHard.this, "You won the Game");
					timer.close();
					new Main().setName();;
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(GraphicallyRepresentationHard.this, "You lose the Game");
					timer.close();
					new Main().setName();;
					dispose();
					}
				}
			}
		);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
			}
		);
		
		//about.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(GraphicallyRepresentationHard.this, "58070058 Thanyathon project of java language", "How to play", JOptionPane.PLAIN_MESSAGE);
				//}
			//}
		//);
		
		file.add(submit);
		file.addSeparator();
		file.add(exit);
		mbarhard.add(file);
		//mbarhard.add(about);
		
		show();
		
		MyWindowAdapterHard mwa = new MyWindowAdapterHard();
		addWindowListener(mwa);
		}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	class MylogicHard extends LogicHard{
		void complete_puzzle_hard() {
			cp = save();
		}
		void puzzle_hard() {
			ip = hide();
		}
	}
	
	class MyWindowAdapterHard extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 16; i++)
			for(int j = 0; j < 16; j++) {
				if(e.getSource() == b[i][j]) {
					String s = JOptionPane.showInputDialog(null, "enter your number");
				
					if(s != null && s.length() >= 1) {
						int c1 = Integer.parseInt(s);
						if (0 < c1 && 17 > c1) {
							b[i][j].setText(s);
							b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 25));
							b[i][j].setForeground(Color.green);									//set answer color
						}						
					}
					
					break;
				}
			}
	}
	
	void recall() {
		GraphicallyRepresentationHard rs = new GraphicallyRepresentationHard();
	}
}
