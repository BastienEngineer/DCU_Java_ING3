package Project;

import java.awt.*;
import java.awt.event.*;

public class Control extends Frame implements AdjustmentListener, ActionListener {
	
	private Button button1, button2, button3, button4; // 4 buttons
	private Scrollbar scrollbar; // a scrollbar
	private TextField status;
	private Drone d1;

	public Control() {
		super("GUI Application");
		this.setLayout(new GridLayout(3, 1));

		Panel topPanel = new Panel();
		Panel topPanel2 = new Panel();

		// add 4 buttons in GUI	
		this.button1 = new Button("LEFT");
		this.button2 = new Button("GO FORWARD");
		this.button3 = new Button("GO BACKWARD");
		this.button4 = new Button("RIGHT");
		this.button1.addActionListener(this);
		this.button2.addActionListener(this);
		this.button3.addActionListener(this);
		this.button4.addActionListener(this);
		topPanel2.add(button1);
		topPanel2.add(button2);
		topPanel2.add(button3);
		topPanel2.add(button4);

		// add scollbar in GUI
		this.status = new TextField(20);
		this.scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 110);
		this.scrollbar.addAdjustmentListener(this);
		topPanel.add(status);
		this.add(topPanel);
		this.add(scrollbar);
		this.add(topPanel2);

		this.updateText();
		this.pack();
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("LEFT"))
		{
			System.out.println("LEFT");
			//d1.left();
			
		}
		else if(e.getActionCommand().equals("RIGHT"))
		{
			System.out.println("RIGHT");
			//d1.right();
			
		}	
		else if(e.getActionCommand().equals("GO FORWARD"))
		{
			System.out.println("GO FORWARD");
			//d1.go();
			
		}
		else if(e.getActionCommand().equals("GO BACKWARD"))
		{
			System.out.println("GO BACKWARD");
			//d1.forward();
			
		}
		
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (e.getSource().equals(scrollbar)) {
			this.updateText();
		}
	}

	private void updateText() {
		status.setText("Speed: " + scrollbar.getValue());
	}

	public static void main(String[] args) {

		Control f = new Control();
		System.out.println("GUI Application");
	}

}
