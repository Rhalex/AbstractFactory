package Logic;

public class OccidentalFactory implements ItemsFactory{

	@Override
	public Item MakeHouse() 
	{
		return new OccidentalHouse();
	}

	@Override
	public Item MakeTree() 
	{
		return new OccidentalTree();
	}

	@Override
	public Item MakeLamp() 
	{
		return new OccidentalLamp();
	}

}
