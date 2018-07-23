package cn.kkl.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kkl.mall.content.service.ContentCategoryService;
import cn.kkl.mall.pojo.E3Result;
import cn.kkl.mall.pojo.EasyUITreeNode;

@Controller
public class ContentCategoryController {
	 
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(name="id",defaultValue="0")Long parentId){
		List<EasyUITreeNode> contentCategoryList = contentCategoryService.getContentCategoryList(parentId);
		return contentCategoryList;
	}
	
	@RequestMapping(value="/content/category/create",method=RequestMethod.POST)
	@ResponseBody
	public E3Result addContentCategory(Long parentId,String name) {
		E3Result result = contentCategoryService.addContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping(value="/content/category/update",method=RequestMethod.POST)
	@ResponseBody
	public E3Result updateContentCategory(Long id,String name) {
		E3Result result = contentCategoryService.updateContentCategory(id,name);
		return result;
	}
	
	@RequestMapping(value="/content/category/delete/",method=RequestMethod.POST)
	@ResponseBody
	public E3Result deleteContentCategoryById(Long id) {
		E3Result result=contentCategoryService.deleteContentCategoryById(id);
		return result;
	}
}
