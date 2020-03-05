package com.practice.day6;

class Superclass
{
	int a;
	void m1()
	{
		System.out.println("superclass method variable a="+a);
	}
	{
		System.out.println("====superClass block====");
	}
}
class Subclass extends Superclass
{
	int b;
	void m2()
	{
		System.out.println("Subclass method varibale b="+b);
	}
	{
		System.out.println("====SubClass Block====");
	}
	
}
public class Inheritance {
	public static void main(String[] args) {
		Subclass obj = new Subclass();
		obj.a=12;
		obj.b=13;
		
		obj.m1();
		obj.m2();
		
	}
}
