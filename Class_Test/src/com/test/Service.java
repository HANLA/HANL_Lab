package com.test;

import com.cms.InvalidPasswordException;
import com.cms.NotFoundIDException;

public class Service implements AccessService
{    
    @Override
	// return -> index if -1 => error
	public void Join(String _ID, String _PW)
	{
		int result = -1;

		result =  InMemory.GetInstnace().Insert(_ID,_PW);

		return result;
    }    

    @Override
    //return -1 id not exist, -2 PW no match, 1 success
	public void Login(String _ID, String _PW) throws NotFoundIDException, InvalidPasswordException
	{


        if(InMemory.GetInstnace().IsIDExist(_ID) == false)
        {

            throw new NotFoundIDException();
        }
        else
        {
            if(InMemory.GetInstnace().IsPWMatched(_ID, _PW) == false)
            {
                result =  -2;
            }
        }

    }

}
