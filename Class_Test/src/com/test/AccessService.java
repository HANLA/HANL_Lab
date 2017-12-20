package com.test;

import com.cms.IDAlreadyExistException;
import com.cms.InvalidPasswordException;
import com.cms.NotFoundIDException;

public interface AccessService
{
	public void Join(String _ID, String _PW) throws NotFoundIDException, InvalidPasswordException, IDAlreadyExistException;
	public void Login(String _ID, String _PW) throws NotFoundIDException, InvalidPasswordException;
	
}
