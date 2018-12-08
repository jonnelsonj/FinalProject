import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogPanel extends JDialog {
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void configureUI() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100,100,300,100);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel lblNum = new JLabel("Enter the year (YYYY): ");
		JTextField txtNum = new JTextField(3);
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNum(Integer.parseInt(txtNum.getText()));
				setVisible(false);
			}
		});
		c.add(lblNum);
		c.add(txtNum);
		c.add(btnOK);
	}
	public DialogPanel(JFrame owner, boolean modal) {
		super(owner,modal);
		configureUI();
	}
}