public abstract class Box {
	
	private double Length=0;
	private double Width=0;
	private double Height=0;
	
	public Box(double Length, double Width, double Height)
	{
		this.Length = Length;
		this.Width = Width;
		this.Height = Height;	
	}
	
	public double getLength(){return Length;}
	public void setLength(double Length){this.Length=Length;}
	
	public double getWidth(){return Width;}
	public void setWidth(double Width){this.Width = Width;}
	
	public double getHeight(){return Height;}
	public void setHeight(double Height){this.Height = Height;}

}