package Logic;

public class OrientalFactory implements ItemsFactory {

	@Override
	public House MakeHouse() 
	{
		return new OrientalHouse();
	}

	@Override
	public Tree MakeTree() 
	{
		return new OrientalTree();
	}

	@Override
	public Lamp MakeLamp() 
	{
		return new OrientalLamp();
	}
}
