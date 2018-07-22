package cn.kkl.mall.fastdfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Admin
 * use fastDFS step :
 * 1. create a configuration file with tracker server address.file name is free
 * 2. load the configuration file with global object.get tracker server address.
 * 3. create tracker client object
 * 4. get tracker server by trackerClient object
 * 5. create a storageServer reference,maybe null
 * 6. create a storageClient parameters are trackerServer and storageServer
 * 7. upload file with storageClient object
 *
 */
public class ImageServerTest {
	@Before
	public void init() {
		try {
			ClientGlobal.init("D:"+File.separator+"E-commerce"+File.separator+"supermarket"+File.separator+"E3"+File.separator+"e3-manager-web"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"server-configuration"+File.separator+"tracker-server.conf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUploadImage() {
		
		TrackerClient trackerClient=new TrackerClient();
		TrackerServer trackerServer;
		try {
			trackerServer = trackerClient.getConnection();
			StorageServer storageServer = null;
			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			String[] strings = storageClient.upload_file("D:\\temp\\meizu2.jpg","jpg", null);
		
			for (String string : strings) {
				System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	

}
