package edu.keval;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Tags extends SimpleTagSupport {
	public Tags()
	{
		super();
	}
	String numbers;
	public void setNumbers(String numbers)
	{
		this.numbers = numbers;
	}
	public void doTag() throws JspException, IOException {
		JspWriter print = getJspContext().getOut();
		StringTokenizer token = new StringTokenizer(numbers,",");
		int[] data = new int[token.countTokens()];
		for (int i = 0; i < data.length; i++) 
		{
			data[i]=Integer.parseInt(token.nextToken());
		}
		Arrays.sort(data);
		print.println("Sorted Numbers");
		for (int i = 0; i < data.length; i++) {
			print.println(data[i]);
		}
		//print.println("Hello Tags!");
	}
}
