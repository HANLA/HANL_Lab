package com.test;


public final class Core implements Playable
{
    private boolean endFlag = false;
    
    private Output output = new View();
    private AccessService service = new Service();  
    private Input input = new JavaInput();

    @Override
    public void Run()
    {
        String currentSelectIndex ="";
        Menu currentMenu = Menu.MainMenu;
        output.SwapPage(currentMenu);
    	
        while(endFlag != true)
        {
            switch(currentMenu)
            {
                case FindMenu:
                {
           
                }
                break;

                case JoinMenu:
                {
                    output.ShowMenu();
                    String id = input.GetStringLineFromMainStream();
                    output.ShowMenu();
                    String pw = input.GetStringLineFromMainStream();

                    int resultKey = service.Join(id,pw);

                    if(resultKey < 0)
                    {
                        output.ShowErrorMessage(ErrorCode.IDAlreadyExist , id);
                    }

                    currentMenu = Menu.MainMenu;                    
                    output.SwapPage(currentMenu);               
                    

                }
                break;

                case LoginMenu:
                {
                    output.ShowMenu();
                    String id = input.GetStringLineFromMainStream();
                    output.ShowMenu();
                    String pw = input.GetStringLineFromMainStream();

                    int resultKey = service.Login(id,pw);

                    switch(resultKey)
                    {
                        case -1:
                        {
                            output.ShowErrorMessage(ErrorCode.IDNotExist, id);
                        }
                        break;

                        case -2:
                        {
                            output.ShowErrorMessage(ErrorCode.WrongPassWord);
                        }
                        break;

                        case 1:
                        {
                            output .ShowMenu();
                        }
                        break;
                    }
                    currentMenu = Menu.MainMenu;
                    output.SwapPage(currentMenu);               
                    
                }
                break;

                case MainMenu:
                {
                    output.ShowMenu();
                    currentSelectIndex = input.GetStringLineFromMainStream();

                    Menu selectMenu = Menu.FromStringIndex(currentSelectIndex);

                    if(selectMenu != null)
                    {
                        currentMenu = selectMenu;         
                        output.SwapPage(currentMenu);               
                    }
                    else
                    {
                        output.ShowErrorMessage(ErrorCode.WrongInput);
                    }
                }
                break;

                case Quit:
                {
                    this.endFlag = true;
                }
                break;
            }
        }
    }  
}