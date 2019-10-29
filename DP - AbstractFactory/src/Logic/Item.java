package Logic;

import javax.swing.ImageIcon;

public abstract class Item {
	
	public int price;
	public ImageIcon img;
		
	public int getPrice()
	{
		return this.price;
	}
	
	public ImageIcon getImg()
	{
		return this.img;
	}
	
	public String toString()
	{
		return "Price: " + this.price + "\tImg: " + this.img.getDescription();
	}
}
