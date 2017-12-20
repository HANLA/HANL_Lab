package com.test;

public enum Menu
{
	MainMenu, 
	LoginMenu, 
	JoinMenu, 
    FindMenu,
    Quit ;
	
	public static Menu FromInteger(int x)
	{
        switch(x) 
        {
        case 0:
            return Menu.MainMenu;
        case 1:
            return Menu.LoginMenu;
        case 2:
            return Menu.JoinMenu;
        case 3:
            return Menu.FindMenu;
        case 4:
            return Menu.Quit;
        }
        return null;
    }

    public static Menu FromStringIndex(String _index)
    {
        try
        {        
            int index =  Integer.parseInt(_index);
            return Menu.FromInteger(index);            
        }
        catch(NumberFormatException e)
        {
            return null;
        }
    }    
}
