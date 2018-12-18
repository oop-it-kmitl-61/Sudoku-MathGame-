import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HowtoPlay extends JFrame{
	private ImageIcon image1, image2;
	private JLabel label1;
	private JButton back;
	
	HowtoPlay(){
		setTitle("How to play");
		
		setLayout(new BorderLayout());
		
		image1 = new ImageIcon(getClass().getResource("how2.png"));
		label1 = new JLabel(image1);
		add(label1, BorderLayout.CENTER);
		
		back = new JButton("Back");
		back.setFont(new Font("ARIALBD", Font.BOLD, 20));
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Main();
				dispose();
				
			}
		});
		
		add(back, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}