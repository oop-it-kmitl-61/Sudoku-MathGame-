import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class GraphicallyRepresentation extends JFrame implements ActionListener {
	Container con;
	JButton b[][] = new JButton[9][9];
	TextField t[] = new TextField[61];
	JMenuBar mbar;
	JMenu file;
	JMenuItem submit, exit;
	Timer timer;

	int[][] cp = new int[9][9];
	int[][] ip = new int[9][9];


	GraphicallyRepresentation() {
		super("Sudoku! by OOP-Project");
		setSize(854, 480);
		// setresizeable(false);

		con = getContentPane();
		con.setLayout(new GridLayout(9, 9));

		Mylogic ob1 = new Mylogic();
		ob1.complete_puzzle();
		ob1.puzzle();

		int c = 0;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				b[i][j] = new JButton("" + ip[i][j]);
				b[i][j].setFont(new Font("ARIALBD", Font.BOLD, 20));
				b[i][j].setForeground(Color.red); 							//ramdom number color
				if (ip[i][j] == 0) {
					// b[i][j]=new JButton("");
					b[i][j].setText("");
					b[i][j].setBackground(Color.white);
					b[i][j].addActionListener(this);

				}

				con.add(b[i][j]);

				if (i == 3 || i == 4 || i == 5 || j == 3 || j == 4 || j == 5) {
					if (2 < i && i < 6 && 2 < j && j < 6) {
						b[i][j].setBackground(Color.white); 				//center square
						continue;
					}
					b[i][j].setBackground(Color.black); 					//2 4 6 8 square

				}

				else
					b[i][j].setBackground(Color.white); 					// 1 3 7 9 color
			}

		mbar = new JMenuBar();												//set function bar
		setJMenuBar(mbar);

		file = new JMenu("File");											//set name function
		
		submit = new JMenuItem("Submit");
		exit = new JMenuItem("Exit");

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				int r = 0;
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++)
						if (cp[i][j] != Integer.parseInt(b[i][j].getText())) {
							r = 1;
							break;
						}
				for (int i = 0; i < 9; i++) {
					System.out.println();
					for (int j = 0; j < 9; j++) {
						System.out.print(cp[i][j]);
						System.out.print(Integer.parseInt(b[i][j].getText()) + "  ");
					}
				}
				System.out.print("\n" + r);									//result game
				if (r == 0) {
					JOptionPane.showMessageDialog(GraphicallyRepresentation.this, "You won the Game");
					// System.out.println("You won the Game");
					timer.close();
					new Main().setName();
					dispose();
				}
				else {
					// System.out.println("You lose the Game");
					JOptionPane.showMessageDialog(GraphicallyRepresentation.this, "You lose the Game");
					timer.close();
					new Main().setName();
					dispose();
				}
				}
			}
		);
		exit.addActionListener(new ActionListener() {						//set exit function
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
			}
		);

		//about.addActionListener(new ActionListener() {						//set about function
			//public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(GraphicallyRepresentation.this,
					//"58070058 Thanyathon project of java language",
					//"How to play", JOptionPane.PLAIN_MESSAGE);
				//}
			//}
		//);

		file.add(submit);
		file.addSeparator();
		file.add(exit);
		mbar.add(file);
		//mbar.add(about);

		show();

		// ob1.complet_puzzle();

		MyWindowAdapter mwa = new MyWindowAdapter();
		addWindowListener(mwa);

	}
	
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	class Mylogic extends Logic {
		void complete_puzzle() {
			cp = save();

		}


		void puzzle() {
			ip = hide();

		}

	}

	class MyWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}


	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (e.getSource() == b[i][j]) {
					String s = JOptionPane.showInputDialog(null, "enter your number");			//set pop up answer window
					if(s != null && s.length() >= 1) {
						int c = Integer.parseInt(s);
						if (0 < c && 10 > c) {
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
		GraphicallyRepresentation rs = new GraphicallyRepresentation();
	}
}