package com.practice.day6;

class SuperClass1
{
	int a;
	void m1()
	{
		System.out.println("Super class variable a="+a);
	}
}
class SubClass1 extends SuperClass1
{
	
	int b;
	void m1()
	{
	System.out.println("sub class variable b="+b);
	}
}
public class InheritanceOverride {
	public static void main(String[] args) {
	SubClass1 obj = new SubClass1();
	obj.a=10;
	obj.b=20;
	
	obj.m1();
		
	}
}
