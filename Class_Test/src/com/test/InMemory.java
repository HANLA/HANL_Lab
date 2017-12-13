package com.test;

public class InMemory
{
	public Member[] MemberList = new Member[MaxArrayCapacity];

	public static final int MaxArrayCapacity = 100;

	public int LastIndex = -1;
}
