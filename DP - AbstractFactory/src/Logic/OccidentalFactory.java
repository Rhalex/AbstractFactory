package Logic;

public class OccidentalFactory implements ItemsFactory{

	@Override
	public House MakeHouse() 
	{
		return new OccidentalHouse();
	}

	@Override
	public Tree MakeTree() 
	{
		return new OccidentalTree();
	}

	@Override
	public Lamp MakeLamp() 
	{
		return new OccidentalLamp();
	}

}
