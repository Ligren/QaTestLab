package Test;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Reader extends JFrame {
	JButton b1, b2;
	JLabel l1, l2, l3;
	JTextField t1, t2;
	int i;
	String a, b;
	eHandler handler = new eHandler();

	public Reader(String s) throws HeadlessException {
		super(s);
		setLayout(new FlowLayout());
		
		l1 = new JLabel("The maximum amount of figures : ");
		l2 = new JLabel("      Designed by Kostiuchenco Vladyslav      ");
		l3 = new JLabel("sadkoua@gmail.com");
		t1 = new JTextField(5);
		t1.setText("10");
		b1 = new JButton("Start");
		add(l1);
		add(t1);
		add(b1);
		add(l2);
		add(l3);
		b1.addActionListener(handler);
	}
	
	public class eHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == b1) {
				try {
				Start.maxAmountOfShapes = Integer.parseInt(t1.getText());
				ShapeDrawing.xLocation = 0;
				ShapeDrawing.yLocation = 0;
				Start.start();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "¬ведите в поле число");
					}

			}
		}
		
	}


}
