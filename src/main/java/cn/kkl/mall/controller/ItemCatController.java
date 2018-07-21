package cn.kkl.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kkl.mall.pojo.EasyUITreeNode;
import cn.kkl.mall.service.ItemCatService;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping(value="/item/cat/list",method=RequestMethod.POST)
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
		return list;
	}
}
