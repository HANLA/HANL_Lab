package com.test;

public class Service
{    
    
	// return -> index if -1 => error
	public int Join(String _ID, String _PW)
	{
		int result = -1;

		result =  InMemory.GetInstnace().Insert(_ID,_PW);

		return result;
    }    

    //return -1 id not exist, -2 pw no match, 1 success
	public int Login(String _ID, String _PW)
	{
        int result = -1;

        if(InMemory.GetInstnace().IsIDExist(_ID) == false)
        {
            result = -1;
        }
        else
        {
            if(InMemory.GetInstnace().IsPWMatched(_ID, _PW) == false)
            {
                result =  -2;
            }
            else
            {
                result =  1;
            }
        }

        return result;
    }

}
