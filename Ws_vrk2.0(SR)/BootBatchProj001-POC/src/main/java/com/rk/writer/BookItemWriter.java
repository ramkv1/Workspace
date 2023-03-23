package com.rk.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("biWriter")
public class BookItemWriter implements ItemWriter<String>{
	public BookItemWriter() {
		System.out.println("BookItemWriter::0-paramConstructor");
	}
	
	@Override
	public void write(List<? extends String> items) throws Exception{
		System.out.println("BookItemWriter.write()");
		System.out.println("The processed Book are::"+items);
	}

}
