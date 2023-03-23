package com.rk.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rk.entity.MarriageSeeker;
import com.rk.service.IMarriagerSeekerMgmtService;

@Component
public class LOBsTestRunner1 implements CommandLineRunner {
	
	@Autowired
	private IMarriagerSeekerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
			
		try {
			MarriageSeeker ms=service.findMarriageSeekerById(1);
			if(ms!=null) {
				System.out.println(ms.getMsid()+" "+ms.getMsname()+" "+ms.getMsaddrs()+" "+ms.getDob()+" "+ms.getIndian());
				//read byte[] from ms Object and write to dest file
				byte[] photoContent=ms.getMsphoto();
				OutputStream os=new FileOutputStream("img646.jpeg");
				os.write(photoContent);
				os.flush();
				os.close();
				Writer writer=new FileWriter("biodata.txt");
				writer.flush();
				writer.close();
				
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
