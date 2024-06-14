package com.shop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.constant.itemSellStatus;
import com.shop.entity.Item;

@SpringBootTest
public class ItemRepositoryTest3 {

	@Autowired
	ItemRepository itemRepository;
	
	// 상품 10개 등록하기
		public void createItemList() {
			for(int i=1;i<=10;i++) {
				Item item = new Item();
				item.setItemNm("테스트 상품" + i);
				item.setPrice(10000+i);
				item.setStockNumber(100);
				item.setItemDetail("테스트 상품 상세 설명" + i);
				item.setItemSellStatus(itemSellStatus.SELL);
				item.setRegTime(LocalDateTime.now());
				item.setUpdateTime(LocalDateTime.now());
				Item savedItem=itemRepository.save(item);
			}
		}
	
//	@Test
//	@DisplayName("@Query를 이용한 상품 조회 테스트")
//	void findByItemDetailTest() {
//		this.createItemList();
//		List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");
//		for(Item item : itemList)
//			System.out.println(item);
//	}
	
	
	@Test
	@DisplayName("nativeQuery 속성을 이용한 상품 조회 테스트")
	public void findByItemDetailByNative() {
		this.createItemList();
		List<Item> itemList = itemRepository.findByItemDetailByNative();
		for(Item item : itemList)
			System.out.println(item);
	}
}
