package com.test;


public interface Output
{
    public void ShowErrorMessage(ErrorCode _errorCode, String..._arge);
    public void ShowMenu();
    public void SwapPage(Menu _Page);
}