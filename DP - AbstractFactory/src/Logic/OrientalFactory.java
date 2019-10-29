package Logic;

public class OrientalFactory implements ItemsFactory {

	@Override
	public Item MakeHouse() 
	{
		return new OrientalHouse();
	}

	@Override
	public Item MakeTree() 
	{
		return new OrientalTree();
	}

	@Override
	public Item MakeLamp() 
	{
		return new OrientalLamp();
	}
	
	/*public void s()
	{
		System.out.println("s");
	}*/
}
