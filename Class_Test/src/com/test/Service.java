package com.test;

public class Service
{
	private InMemory DB = new InMemory();

	public boolean IsIDExist(String _ID)
	{
		boolean result = false;

		for ( int i = 0 ; i < this.DB.MemberList.length ; i++ )
		{
			result = this.DB.MemberList[i].ID.equals( _ID );

			if (result == true)
			{
				break;
			}
		}

		return result;
	}

	public int GetIdIndex(String _ID)
	{
		int result = -1;

		for ( int i = 0 ; i < this.DB.MemberList.length ; i++ )
		{
			if (this.DB.MemberList[i].ID.equals( _ID ) == true)
			{
				result = i;
				break;
			}
		}

		return result;
    }
    
    public boolean IsPWMatched(int _index, String _PW)
    {
        boolean result = false;
        
        if(this.DB.LastIndex >= _index )
        {
            result = this.DB.MemberList[_index].PW.equals(_PW);
        }

        return result;
    }

    public boolean IsPWMatched(String _ID, String _PW)
    {
        boolean result = false;

        int index = GetIdIndex(_ID);
        
        if(index  != -1)
        {
            result = IsPWMatched(index, _PW);
        }

        return result;
    }

	// return -> index if -1 => error
	public int Join(String _ID, String _PW)
	{
		int result = -1;

		boolean iDExistChecker = false;

		iDExistChecker = this.IsIDExist( _ID );

		if (iDExistChecker == false)
		{
			Member mb = new Member();
			mb.ID = _ID;
			mb.PW = _PW;

			this.DB.LastIndex++;

			this.DB.MemberList[this.DB.LastIndex] = mb;

			result = this.DB.LastIndex;
		} else
		{
			result = -1;
		}

		return result;
    }
    

    //return -1 id not exist, -2 pw no match, 1 success
	public int Login(String _ID, String _PW)
	{
        int result = -1;

        if(this.IsIDExist(_ID) == false)
        {
            result = -1;
        }
        else
        {
            if(this.IsPWMatched(_ID, _PW) == false)
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
