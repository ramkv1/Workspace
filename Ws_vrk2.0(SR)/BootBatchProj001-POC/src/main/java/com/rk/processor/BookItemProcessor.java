package com.rk.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("biProcessor")
public class BookItemProcessor implements ItemProcessor<String, String> {
	
	public BookItemProcessor() {
		System.out.println("BookItemProcessor::0-ParamConstructor");
	}
	@Override
	public String process(String item) throws Exception {
		String BookWithTitle=null;
		if(item.equalsIgnoreCase("CRJ"))
			BookWithTitle=item+"By HS&&PN";
		else if(item.equalsIgnoreCase("TIJ"))
			BookWithTitle=item+"By BE";
		else if(item.equalsIgnoreCase("EJ"))
			BookWithTitle=item+"By JB";
		else if(item.equalsIgnoreCase("HFJ"))
			BookWithTitle=item+"BY KS";
		else if(item.equalsIgnoreCase("HFDP"))
			BookWithTitle=item+"By KS";
		
		return BookWithTitle;
	}

}
