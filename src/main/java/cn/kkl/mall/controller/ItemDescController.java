package cn.kkl.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kkl.mall.pojo.E3Result;
import cn.kkl.mall.pojo.TbItemDesc;
import cn.kkl.mall.service.ItemDescService;

/**
 * @author Admin
 * item description manage controller
 */
@Controller
public class ItemDescController {
	
	@Autowired
	private ItemDescService itemDescService;

	@RequestMapping(value="/rest/item/param/item/query/{id}")
	@ResponseBody
	public E3Result getItemDescInfo(@PathVariable Long id) {
		System.out.println(id);
		TbItemDesc itemDesc = itemDescService.getItemDescById(id);
		return E3Result.ok(itemDesc);
	}
}
