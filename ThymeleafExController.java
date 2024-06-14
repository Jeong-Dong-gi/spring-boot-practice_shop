package com.shop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.constant.itemSellStatus;
import com.shop.entity.Item;
import com.shop.itemdto.ItemDto;

//@Component - @Controller @Repository @Service
@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafExController {
	@GetMapping("/ex01")
	public String thymeleafExample01(Model model) {
		model.addAttribute("data", "타임리프 예제 입니다.");
		System.out.println("devtools test1");
		return "tlEx01";
	}
	
	@GetMapping("/ex02")
	public String thymeleafExample02(Model model) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("상품 상세 설명");
		itemDto.setItemNm("테스트 상품1");
		itemDto.setPrice(10000);
		itemDto.setRegTime(LocalDateTime.now());
		
		model.addAttribute("itemDto", itemDto);
		return "tl/tlEx02";
	}
	
	public void sayHello() {
		System.out.println("Hello world!");
	}
	
	@GetMapping("/ex03")
	public String tlEx03(Model model) {
		List<ItemDto> itemDtoList = new ArrayList<>();
		for(int i=1;i<=10;i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("테스트 상품 상세 설명" + i);
			itemDto.setItemNm("테스트 상품" + i);
			itemDto.setPrice(10000*i);
			itemDto.setRegTime(LocalDateTime.now());
			itemDtoList.add(itemDto);
		}
		model.addAttribute("itemDtoList", itemDtoList);
		return "tl/tlEx03";
	}
	
	@GetMapping("/ex04")
	public String tlEx04(Model model) {
		List<ItemDto> itemDtoList = new ArrayList<>();
		for(int i=1;i<=10;i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("테스트 상품 상세 설명" + i);
			itemDto.setItemNm("테스트 상품" + i);
			itemDto.setPrice(10000*i);
			itemDto.setRegTime(LocalDateTime.now());
			itemDtoList.add(itemDto);
		}
		model.addAttribute("itemDtoList", itemDtoList);
		return "tl/tlEx04";
	}
	
	@GetMapping("/ex05")
	public String tlEx05(Model model) {
		return "tl/tlEx05";
	}
	@GetMapping("/putdata")
	public String getData(Model model, String data) {
		model.addAttribute("data", data);
		System.out.println(data);
		
		return "tl/tlEx05";
	}
	
	@GetMapping("/ex06")
	public String tlEx06(Model model, String param1, String param2) {
		System.out.println(param1 + " " +param2);
		return "tl/tlEx05";
	}
}
