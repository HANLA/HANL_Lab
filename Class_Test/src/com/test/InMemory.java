package com.test;

import java.util.LinkedList;
import java.util.List;


public final class InMemory implements AccessDB
{

	private InMemory()
	{

	}		

	private static final int MaxArrayCapacity = 100;
	
	private  List<Member> MemberList = new LinkedList<Member>();

	private static InMemory instance = null;

	public static InMemory GetInstnace()
	{
		if(instance == null)
		{
			instance= new InMemory();
		}

		return instance;
	}
	
	public  boolean IsIDExist(String _ID)
	{
		boolean result = false;

		for(Member item : this.MemberList)
		{
			result = item.ID.equals(_ID);

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

		for ( int i = 0 ; i < MemberList.size() ; i++ )
		{
			if (this.MemberList.get(i).ID.equals( _ID ) == true)
			{
				result = i;
				break;
			}
		}

		return result;
    }
    
    public  boolean IsPWMatched(int _index, String _PW)
    {
        boolean result = false;
        
        if(this.MemberList.size() > _index )
        {
            result = this.MemberList.get(_index).PW.equals(_PW);
        }

        return result;
    }

    public  boolean IsPWMatched(String _ID, String _PW)
    {
        boolean result = false;

        int index = GetIdIndex(_ID);
        
        if(index  != -1)
        {
            result = IsPWMatched(index, _PW);
        }

        return result;
	};
	
	public  Member GetMemberByID(String _ID)
	{
		for(Member item : this.MemberList)
		{
			if( item.ID.equals(_ID) )
			{
				return item;
			}			
		}	

		return null;
	}

	public int Insert(String _ID , String _PW)
	{
		Member member = new Member();
		member.ID = _ID;
		member.PW = _PW;

		return Insert(member);
	}

	//-1 id exist , -2 capacity fulled
	@Override
	public int Insert(Object obj)
	{
		Member target = (Member)obj;

		if(this.MemberList.size() == MaxArrayCapacity )
		{
			return -2;
		}

		if(this.IsIDExist(target.ID) == true)
		{
			return -1;
		}

	//	Member newItem = new Member();
	//	newItem.ID = target.ID;
	//	newItem.PW =  target.PW;

	    boolean result = this.MemberList.add(target);

		return result == true ? 1 : -2;
	}

	@Override
	public int Delete(Object obj)
	{
		Member target = (Member)obj;

		boolean result =  this.MemberList.remove(target);

		return result == true ? 1 : -1;
	}

	//?
	@Override
	public int Update(Object obj)
	{
		Member target = (Member)obj;

		Member item = this.GetMemberByID(target.ID);

		if(item == null)
		{
			return -1;
		}
		
		item.ID = target.ID;
		item.PW = target.PW;

		return 1;
	}


}
