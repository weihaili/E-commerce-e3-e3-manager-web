package cn.kkl.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kkl.mall.pojo.E3Result;
import cn.kkl.mall.search.service.SearchItemService;

@Controller
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;
	
	@RequestMapping(value="/index/item/import",method=RequestMethod.POST)
	@ResponseBody
	public E3Result importItemList() {
		E3Result result = searchItemService.importAllItem();
		return result;
	}

}
