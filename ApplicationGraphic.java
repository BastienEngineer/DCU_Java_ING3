package Project;
import java.awt.*;

public class ApplicationGraphic extends Frame 
{
	private Graphic a; // an attribute of the class Graphic
	public ApplicationGraphic() 
	{
		super("Canva Application");
		// Create a graphic to display in GUI
		this.a = new Graphic(300, 100, 200, 400);
		this.add(a);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ApplicationGraphic();
	}
}