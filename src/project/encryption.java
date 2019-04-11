
package project;


import java.io.*;



public class encryption {
	private int key;
	public encryption(int key)
	{
		this.key=key;
	}
	public void encrypt(InputStream inStr,OutputStream outStr) throws Exception
	{
		boolean done =false;
		while(!done)
		{
			int next=inStr.read();
			if(next==-1)
				done=true;
			else
			{
				byte b=(byte)next;
				byte c=(byte)(b+key);
				outStr.write(c);
			}
		}
	}
}
