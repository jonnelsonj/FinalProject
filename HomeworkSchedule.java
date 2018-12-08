import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class StatusPanel extends JPanel { 
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(message, 10, 20);
		
	}
	public StatusPanel() {
		setPreferredSize(new Dimension(300,100));
		
	}
}

public class HomeworkSchedule extends JFrame {
	StatusPanel span = new StatusPanel();
	private String year;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	private String month;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	private String day;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	private boolean Leap;
	public boolean isLeap() {
		return Leap;
	}
	public void setLeap(boolean leap) {
		Leap = leap;
	}
	public HomeworkSchedule() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,400,400);
		setTitle("Homework Schedule");
		span.setMessage("Please enter the month.");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		//panels
		JPanel panNorth = new JPanel();
		JPanel panCenter = new JPanel();
		JPanel panSouth = new JPanel();
		panCenter.setLayout(new GridLayout(5,7));
		//buttons
		JButton[] buttons = new JButton[36];
		for (int i = 0; i<31; i++) {
			buttons[i] = new JButton("" + (i+1));
			buttons[i].addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton btnClicked = (JButton)(e.getSource());
							setDay(btnClicked.getText());
							if (getMonth() != null && getDay() != null && getYear() != null) {
								span.setMessage(getDay() + "/" + getMonth() + "/" + getYear());
								repaint();
							}
						}
					});
		}
		JButton btnMonth = new JButton("Month");
		JButton btnYear = new JButton("Year");
		JButton btnPractice = new JButton("Check homework.");

		HomeworkSchedule hsch = this;
		//action listeners
		
		btnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogPanel2 dp2 = new DialogPanel2(hsch,true);
				dp2.setVisible(true);
				if (dp2.getNum() > 12 || dp2.getNum() < 0) {
					span.setMessage("Please enter a valid month.");
					repaint();
				} else {
					span.setMessage("Please enter the year.");
					repaint();
					btnMonth.setText(Month.of(dp2.getNum()).toString());
					setMonth("" + dp2.getNum());
					if (dp2.getNum() == 4 || dp2.getNum() == 6 || dp2.getNum() == 9 || dp2.getNum() == 11) {
						buttons[30].setEnabled(false);
					} else if (dp2.getNum() == 2) {
						for (int i = 29; i < 31; i++) {
							buttons[i].setEnabled(false);
						}
					} 
				}
				
			}
		});
		
		btnYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogPanel dp = new DialogPanel(hsch,true);
				dp.setVisible(true);
				//System.out.println("You entered " + dp.getNum());
				btnYear.setText("" + (dp.getNum()));
				setYear(btnYear.getText());
				span.setMessage("Please select the date.");
				repaint();
			}
		});
		
		
		btnPractice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeworkLog pg = new HomeworkLog(hsch, true);
				pg.setVisible(true);
			}
		});
		
		for (int k = 0; k<31; k++) {
			panCenter.add(buttons[k]);
		}
		
		panNorth.add(btnMonth);
		panNorth.add(btnYear);
		panSouth.add(btnPractice);
		panSouth.add(span);
		c.add(panCenter,BorderLayout.CENTER);
		c.add(panSouth,BorderLayout.SOUTH);
		c.add(panNorth,BorderLayout.NORTH);
	}
}
