import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

class StatusPan extends JPanel { 
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
	public StatusPan() {
		setPreferredSize(new Dimension(300,100));
		
	}
}

class Homework {
	private String title;
	private String subject;
	private String due;
	private String description;
	private boolean complete;
	private boolean overdue;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDue() {
		return due;
	}
	public void setDue(String due) {
		this.due = due;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public boolean isOverdue() {
		return overdue;
	}
	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}
	
}
public class HomeworkLog extends JDialog {
	public void configureUI() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(200,200,500,500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		StatusPan statpan = new StatusPan();
		setTitle("Homework Log");
		statpan.setMessage("Happy Studying");
		
		JPanel panNorth = new JPanel();
		JPanel panCenter = new JPanel();
		JPanel panSouth = new JPanel();
		JPanel panWest = new JPanel();
		panWest.setLayout(new GridLayout(7,1));
		panSouth.setLayout(new FlowLayout());

		JButton btnAdd = new JButton("Add Assignment");
		JButton btnEdit = new JButton("Edit Assignment");
		JButton btnDelete = new JButton("Delete Assignment");
		JButton btnComplete = new JButton("Mark Complete");
		
		c.add(panCenter,BorderLayout.CENTER);
		c.add(panSouth,BorderLayout.SOUTH);
		c.add(panNorth,BorderLayout.NORTH);
		c.add(panWest,BorderLayout.WEST);
	}

	public HomeworkLog(JFrame owner, boolean modal) {
		super(owner,modal);
		configureUI();
	}
}