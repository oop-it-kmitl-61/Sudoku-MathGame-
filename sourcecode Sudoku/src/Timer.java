import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Timer extends JFrame{

	private JLabel time;
	private boolean stopFlag;
	private int sec, min, hour;
	
	public Timer() {
		setLayout(new BorderLayout());
		time = new JLabel("");
		time.setText("-----------------");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("ARIALBD", Font.ITALIC | Font.BOLD, 36));
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		add(time, BorderLayout.CENTER);

		setVisible(true);
		pack();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!stopFlag) {
					try {
						sec++;
						if(sec == 60) {
							sec = 0;
							min++;
						}else if(min == 60) {
							min = 0;
							hour++;
						}
						String format = String.format("%02d:%02d:%02d", hour, min, sec);
						time.setText(format);
						Thread.sleep(1000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
	
	public void stop() {
		stopFlag = true;
	}
	
	public void close() {
		try(FileWriter fw = new FileWriter("record.txt", true)){
			fw.write(Main.getName() + " " +  time.getText() + "\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispose();
	}
	
}
