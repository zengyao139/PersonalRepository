package com.zengyao.URL;

import java.io.File;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

public class copyURLToFile {
	public static void main(String[] args) throws Exception {
		/*URL url=new URL("https://www.baidu.com/img/baidu_jgylogo3.gif");
		File file=new File("baidu-image-copy.gif");*/
		
		Downloader downloader=new Downloader("baidu-image-copy-2.gif", "https://www.baidu.com/img/baidu_jgylogo3.gif");
		ExecutorService service=Executors.newFixedThreadPool(1);
		Future<Boolean> result=null;
		result=service.submit(downloader);
		System.out.println(result.get());
	}
}

class Downloader implements Callable<Boolean>{

	private  File file;
	
	private URL url;
	
	public Downloader(String filename,String url)throws Exception {
		// TODO Auto-generated constructor stub
		this.file=new File(filename);
		this.url=new URL(url);
	}
	
	@Override
	public Boolean call() throws Exception {
		FileUtils.copyURLToFile(url, file);
		return true;
	}
	
	
}





