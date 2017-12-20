package com.test;


public final class Core implements Playable
{
    private boolean endFlag = false;
    
    private Output view = new View();
    private AccessService service = new Service();  
    private Input input = new JavaInput();

    @Override
    public void Run()
    {
        String currentSelectIndex ="";
        Menu currentMenu = Menu.MainMenu;
        view.SwapPage(currentMenu);
    	
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
                    view.ShowMenu();
                    String id = input.GetStringLineFromMainStream();
                    view.ShowMenu();
                    String pw = input.GetStringLineFromMainStream();

                    int resultKey = service.Join(id,pw);

                    if(resultKey < 0)
                    {
                        view.ShowErrorMessage(ErrorCode.IDAlreadyExist , id);
                    }

                    currentMenu = Menu.MainMenu;                    
                    view.SwapPage(currentMenu);               
                    

                }
                break;

                case LoginMenu:
                {
                    view.ShowMenu();
                    String id = input.GetStringLineFromMainStream();
                    view.ShowMenu();
                    String pw = input.GetStringLineFromMainStream();

                    int resultKey = service.Login(id,pw);

                    switch(resultKey)
                    {
                        case -1:
                        {
                            view.ShowErrorMessage(ErrorCode.IDNotExist, id);
                        }
                        break;

                        case -2:
                        {
                            view.ShowErrorMessage(ErrorCode.WrongPassWord);
                        }
                        break;

                        case 1:
                        {
                            view .ShowMenu();
                        }
                        break;
                    }
                    currentMenu = Menu.MainMenu;
                    view.SwapPage(currentMenu);               
                    
                }
                break;

                case MainMenu:
                {
                    view.ShowMenu();
                    currentSelectIndex = input.GetStringLineFromMainStream();

                    Menu selectMenu = Menu.FromStringIndex(currentSelectIndex);

                    if(selectMenu != null)
                    {
                        currentMenu = selectMenu;         
                        view.SwapPage(currentMenu);               
                    }
                    else
                    {
                        view.ShowErrorMessage(ErrorCode.WrongInput);
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