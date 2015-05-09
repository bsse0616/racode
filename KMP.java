package rayhanVai;

import java.util.Scanner;
import java.util.ArrayList;

public class KMP
{
	String pattern;
	int pre;
	int firstElementPosition;
	
	ArrayList <Integer> lps = new ArrayList <Integer> ();
	
	public KMP(String pattern)
	{
		this.pattern = pattern;
		pre = 0;
		firstElementPosition = 0;
	}


	public ArrayList <Integer> failureFunction()
	{
		lps.add(0);
		
		for(int i = 1; i < pattern.length(); )
		{
			if(pre != 0)
			{
				for(int patternIterator = 1; patternIterator < pattern.length(); )
				{
					if(pattern.charAt(firstElementPosition + patternIterator) == pattern.charAt(i))
					{
						lps.add(++pre);
						i++;
						patternIterator++;
		
		
					}
					else
					{
						pre = 0;
						lps.add(pre);
						i++;
						break;
					}
		
				}
		
			}
			else
			{
				if(pattern.charAt(i) == pattern.charAt(firstElementPosition))
				{
					lps.add(++pre);
					i++;
				}
				else
				{
					lps.add(pre);
					i++;
				}
		
			}
		}
		
		return lps;
	}
		
	
}
