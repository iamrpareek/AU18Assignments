package com.au.Quest1;

public class Logger implements Util
{
	private volatile static Logger o;
	private Logger(){}
	public static Logger getInstance()
	{
		if(o == null)
		{
			synchronized (Logger.class)
			{
				if(o == null)
					o = new Logger();
			}
		}
		return o;
	}

	@Override
	public void Log(String s)
	{
		System.out.print("Logged ");
		System.out.print(s+"\n");	
	}

}
