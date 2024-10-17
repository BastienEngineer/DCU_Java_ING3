package Project;
import java.awt.Point;
import java.io.*;    

// class Drone
public class Drone implements Serializable{
	
	public String name; // a name
	public Point current_position; // a position
	private int velocity; // a speed
	private String color; // a color
	private int time; // a time of update
	
	// Constructor
	Drone(String name,int p1,int p2,int velocity,String color,int time)
	{
		this.color=color;
		this.name=name;
		this.current_position=new Point(p1,p2);
		this.velocity=velocity;
		this.time=time;
	}
	
	// Change the position of the drone
	public void setPosition(int a,int b)
	{
		current_position.x=a;
		current_position.y=b;
	}
	
	// Modify the velocity (speed)
	public void setVelocity(int v)
	{
		velocity=v;
	}
	
	// Go right (necessary for the buttons in Control.java)
	public void right()
	{
		// Final position is equal to the speed plus the initial position
		// We calculate for x and y
		current_position.x=velocity+current_position.x;
		current_position.y=-velocity-current_position.y;
	}
	
	// Go left
	public void left()
	{
		current_position.x=-velocity-current_position.x;
		current_position.y=velocity+current_position.y;
	}
	
	// Go to
	public void go()
	{
		current_position.x=velocity+current_position.x;
		current_position.y=velocity+current_position.y;
	}
	
	// Go forward
	public void forward()
	{
		current_position.x=-velocity-current_position.x;
		current_position.y=-velocity-current_position.y;
	}
	
	// Display the drone with the attributes
	public void display()
	{
		System.out.println(name + " " + velocity + " " + current_position.x + " " + current_position.y + " " + color + " " + time);
	}
	
	public static void main(String[] args) 
	{
		// Create a drone 
		Drone d=new Drone("A",100,100,0,"cyan",10);
		// Testing phase (for the drone)
		d.display(); 
		d.setPosition(200,200);
		d.setVelocity(10);
		d.display();
		d.go();
		d.display();
	}

}
