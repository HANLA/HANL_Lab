package com.test;


public class View implements Output
{    
    private int callCount = 0;
    
    @Override
    public void ShowErrorMessage(ErrorCode _errorCode, String..._arge)
    {
        // => print error message 
        
        switch(_errorCode)
        {
            case EmptyInput:
            {
                System.out.println(_arge[0] +  "must Filled");
            }
            break;

            case IDNotExist:
            {
                System.out.println(_arge[0]  + "is not exist.");
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
        }

        this.callCount = 0;
    }

    @Override
    public void ShowMenu(Menu _page)
    {
        switch(_page)
        {
            case MeinMenu : 
            {
                System.out.print( "==Menu==\n1.Login\n2.Join\n3.Find ID/PW\nSelect : ");
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
}
