package com.assesment;

abstract class Window 
{
	public abstract void write();
	public abstract void read();
}

class PMWindow extends Window 
{ 

	@Override
	public void write() {
		System.out.println("I am writing in PMWindow");
		
	}

	@Override
	public void read() {
		System.out.println("I am reading in PMWindow");
		
	}
	
}

class MotifWindow extends Window 
{

	@Override
	public void write() {
		System.out.println("I am writing in MotifWindow");
		
	}

	@Override
	public void read() {
		System.out.println("I am reading in MotifWindow");
		
	}
}

abstract class ScrollBar 
{
	public abstract void scrollTop();
	public abstract void scrollBottom();
}

class PMScrollBar extends ScrollBar 
{ 

	@Override
	public void scrollTop() {
		System.out.println("I am scrolling top in PMScrollBar");
		
	}

	@Override
	public void scrollBottom() {
		System.out.println("I am scrolling bottom in PMScrollBar");
		
	}
}

class MotifScrollBar extends ScrollBar 
{

	@Override
	public void scrollTop() {
		System.out.println("I am scrolling top in MotifScrollBar");
		
	}

	@Override
	public void scrollBottom() {
		System.out.println("I am scrolling bottom in MotifScrollBar");
		
	}
}

abstract class WidgetFactory 
{
	abstract Window createWindow();
	abstract ScrollBar createScrollBar();
}

class PMWidgetFactory extends WidgetFactory 
{
	Window createWindow()
	{
		return new PMWindow();
	}
	ScrollBar createScrollBar()
	{
		return new PMScrollBar();
	}
}

class MotifWidgetFactory extends WidgetFactory 
{
	Window createWindow()
	{
		return new MotifWindow();
	}
	ScrollBar createScrollBar()
	{
		return new MotifScrollBar();
	}
}

class FactoryMaker 
{
	private static WidgetFactory pf=null;
	static WidgetFactory getFactory(String choice)
	{
		if(choice.equals("A"))
		{
			pf=new PMWidgetFactory();
		}
		else if(choice.equals("B"))
		{
			pf=new MotifWidgetFactory();
		} 
		return pf;
	}
}

public class Client
{
	public static void main(String args[])
	{
		WidgetFactory af = FactoryMaker.getFactory("A");
		Window window = af.createWindow();
		window.write();
	}
}