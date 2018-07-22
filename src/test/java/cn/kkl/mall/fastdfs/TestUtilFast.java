package cn.kkl.mall.fastdfs;


import org.junit.Test;

import cn.kkl.mall.utils.FastDFSClient;

public class TestUtilFast {
	
	private String conf="D:\\E-commerce\\supermarket\\E3\\e3-manager-web\\src\\main\\resources\\server-configuration\\tracker-server.conf";
	
	@Test
	public void test() {
		try {
			FastDFSClient fastDFSClient = new FastDFSClient(conf);
			String string = fastDFSClient.uploadFile("D:\\temp\\meizu2.jpg","jpg");
			System.out.println(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
