package cn.kkl.mall.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.kkl.mall.pojo.KindEditorUploadResult;
import cn.kkl.mall.utils.FastDFSClient;
import cn.kkl.mall.utils.JsonUtils;

/**
 * @author Admin
 * picture operation controller
 */
@Controller
public class PictureController {
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;

	@RequestMapping(value="/pic/upload",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile){
		KindEditorUploadResult result = new KindEditorUploadResult();
		String originalFilename = "";
		try {
			originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf('.')+1);
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:server-configuration/tracker-server.conf");
			String uploadFilePath = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			String url=IMAGE_SERVER_URL+uploadFilePath;
			result.setError(0);
			result.setUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
			result.setError(1);
			result.setMessage("upload "+originalFilename+" fail,please try again later");
		}
		return JsonUtils.objectToJson(result);
	}
}
