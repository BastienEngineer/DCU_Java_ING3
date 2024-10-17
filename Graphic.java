package Project;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Graphic extends Canvas implements MouseListener{

	private int x1, x2, y1, y2; // 4 values of the grid (plot the axis x and y)
	static int radius = 20; // the radius for the drone
	// a vector contains the name of the drone (because we have 2 drones)
	Vector<String> names = new Vector<String>(2);
	
	private Drone d1,d2; // 2 drones
	
	public Dimension getPreferredSize() {
		return new Dimension(600, 400); // the size of my application
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		// Drawing two lines for axis x and y 
		g.drawLine(x1-100, y1-100, x2, y2);
		g.drawLine(x1 * 0, y1 + 100, x2 * 2, y2 / 2);

		// Drawing the first drone (circle - oval)
		g.setColor(Color.cyan); // color
		g.drawOval(d1.current_position.x, d1.current_position.y, radius, radius); // circle
		String s1=Integer.toString(d1.current_position.x); // convert a int to string
		String s2=Integer.toString(d1.current_position.y);
		// Text for show the position of the drone 
		g.drawString("Position 1st drone: " + " " + s1 + " " + s2 + " " + "10",x1+100, 10);
		// Text for his height
		g.drawString("10",(d1.current_position.x+(radius/4)),(d1.current_position.y+(radius/2)));
		
		// Drawing the second drone 
		g.setColor(Color.magenta);
		g.drawOval(d2.current_position.x, d2.current_position.y, radius, radius);
		String s3=Integer.toString(d2.current_position.x);
		String s4=Integer.toString(d2.current_position.y);
		g.drawString("Position 2nd drone: " + " " + s3 + " " + s4 + " " + "10",x1+100, 20);	
		g.drawString("10",(d2.current_position.x+(radius/4)),(d2.current_position.y+(radius/2)));

	
		
		for(int i=0;i<names.size();i++)
		{
			String q = names.elementAt(i);
			
			if(q.equals("A")) // the name of the 1st drone
			{
				g.setColor(Color.cyan);
				// Shows its name and dimension
				g.drawString(q + " Dimension" + " 10*10",d1.current_position.x,(d1.current_position.y-10));
			}
			else if(q.equals("B")) // the name of the 2nd drone
			{
				g.setColor(Color.magenta);
				// Shows its name and dimension
				g.drawString(q + " Dimension" + " 10*10",d2.current_position.x,(d2.current_position.y-10));
			}
		}
		

	}

	// Constructor
	Graphic(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.addMouseListener(this);
		// Create 2 drones
		this.d1=new Drone("A",x1,y1,0,"cyan",10);
		this.d2=new Drone("B",250,250,0,"magenta",10);
		/*
		d1.setPosition(130,130);
		d1.setVelocity(10);
		d1.go();
		*/
		this.repaint();
	}
	
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) 
	{
			// When we are in the circle of the 1st drone (mouse pressed)
			// Add the name in the vector 
			if(e.getX() < (d1.current_position.x+radius) && e.getX() > (d1.current_position.x) && e.getY()< (d1.current_position.y+radius) && e.getY() > (d1.current_position.y))
			{
				names.addElement(new String(d1.name));
				this.repaint();

			}
			
			// Same for the 2nd drone 
			if(e.getX() < (d2.current_position.x+radius) && e.getX() > (d2.current_position.x) && e.getY()< (d2.current_position.y+radius) && e.getY() > (d2.current_position.y))
			{
				names.addElement(new String(d2.name));
				this.repaint();

			}
	}
	
	public void mouseReleased(MouseEvent e) 
	{
		if(!names.isEmpty())
		{
			// delete the first element in the vector of names
			names.removeElement(names.firstElement());
			this.repaint();
		}
		else
		{
			this.repaint();
		}
		
	}

}

