package cn.kkl.mall.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kkl.mall.pojo.E3Result;
import cn.kkl.mall.pojo.EasyUIDataGridResult;
import cn.kkl.mall.pojo.TbItem;
import cn.kkl.mall.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/item/{itemId}")
	@ResponseBody
	public TbItem getItemInfoById(@PathVariable Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	
	@RequestMapping(value="/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public E3Result addItemAndDesc(TbItem item,String desc) {
		try {
			E3Result result = itemService.addItem(item, desc);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return E3Result.build(500, "server busy,please try again later");
		}
	}
	
	@RequestMapping(value="/rest/page/item-edit")
	@ResponseBody
	public E3Result editItemInfo(String[] ids) {
		System.out.println(Arrays.toString(ids));
		TbItem item = itemService.getItemById(Long.parseLong(ids[0]));
		return E3Result.ok(item);
	}
	
}
