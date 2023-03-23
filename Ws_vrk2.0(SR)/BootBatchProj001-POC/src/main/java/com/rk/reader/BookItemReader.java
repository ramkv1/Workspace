package com.rk.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("biReader")
public class BookItemReader implements ItemReader<String> {
	private String[] booksInfo=new String[] {"CRJ","TIJ","EJ","HFJ","HFDP"};
	int counter=0;
	
	public BookItemReader() {
		System.out.println("BookItemReader::0-ParamConstructor");
	}
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	System.out.println("BookItemReader.read()");
	if(counter<booksInfo.length)
		return booksInfo[counter++];
	else
		
		return null;
	}

}
