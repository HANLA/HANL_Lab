package com.test;

public class View implements Output
{    
    private int callCount = 0;
    private Menu currentPage = Menu.MainMenu;
    
    @Override
    public void ShowMenu()
    {
        switch(this.currentPage)
        {
            case MainMenu : 
            {
                System.out.print( "==Menu==\n1.Login\n2.Join\n3.Find ID/PW\n4.Quit\nSelect : ");
            }
            break;

            case LoginMenu:
            {
                switch(this.callCount)
                {
                    case 0:
                    {
                        System.out.print("ID : ");
                        this.callCount++;
                    }
                    break;

                    case 1:
                    {
                        System.out.print("Pass Word : ");
                        this.callCount++;
                    }
                    break;                    

                    case 2:
                    {
                        System.out.print("Login Success\n");
                        this.callCount = 0;
                    }
                }
            }
            break;

            case JoinMenu:
            {
                switch(this.callCount)
                {
                    case 0:
                    {
                        System.out.print("ID : ");
                        this.callCount++;
                    }
                    break;

                    case 1:
                    {
                        System.out.print("Pass Word : ");
                        this.callCount++;
                    }
                    break;      
                    
                    case 2:
                    {
                        System.out.print("Regist Success\n");
                        this.callCount = 0;
                    }
                }
            }
            break;

            case FindMenu:
            {
                switch(this.callCount)
                {
                    case 0:
                    {
                        System.out.print("ID : ");
                        this.callCount++;
                    }
                    break;

                    case 1:
                    {
                        System.out.print("New Pass Word : ");
                        this.callCount = 0;
                    }
                    break;      
                }
            }
            break;            
        }
    }

	@Override
	public void ShowErrorMessage(ErrorCode _errorCode, String... _arge)
	{
		switch(_errorCode)
        {
            case EmptyInput:
            {
                if(_arge.length > 0)
                {
                    System.out.println(_arge[0] +  "must Filled");
                }
                else
                {
                    System.out.println("Empty Input");
                }
            }
            break;

            case IDNotExist:
            {
                if(_arge.length > 0)
                {
                    System.out.println(_arge[0]  + "is not exist.");
                }
                else
                {
                    System.out.println("Not Exist");
                    
                }
            }
            break;

            case WrongInput:
            {
                System.out.println("Wrong Input!");                
            }
            break;

            case WrongPassWord:
            {
                System.out.println("Invalid Password!");
            }
            break;

            case IDAlreadyExist:
            {
                if(_arge.length > 0)
                {
                    System.out.println("ID " + _arge[0] +" already Exist");
                }
                else
                {
                    System.out.println("ID already Exist");
                }
            }
            break;
        }

        this.callCount = 0;		
    }
    
    @Override
    public void SwapPage(Menu _Page)
    {
        this.currentPage = _Page;
        this.callCount = 0;
    }
}
