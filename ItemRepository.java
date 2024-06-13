package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Item;

// JpaRepository를 상속받는 ItemRepository를 작성한다.
// JpaRepository는 2개의 제네릭 타입을 사용하는데 첫 번째에는 엔터티 타입 클래스를 넣어 주고, 두 번째는 기본키 타입을 넣어 준다.
// JpaRepository는 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정의되어 있다.
public interface ItemRepository extends JpaRepository<Item, Long>{
	// JpaRepository에서 지원하는 메소드 예시
	// 메소드 / 기능
	// save() - 엔터티 저장 및 수정
	// delete() - 엔터티 삭제
	// count() - 엔터티 총 개수 반환
	// findAll() - 모든 엔터티 조회
	
	// Repository 인터페이스에 간단한 네이밍 룰을 이용하여 메소드를 작성하면 원하는 쿼리를 실행할 수 있다.
	// 데이터 조회하는 메소드를 이용할 때 가장 많이 사용하는 문법으로 find를 사용
	// find+(엔터티이름)+By+(변수이름)
	
	// 상품의 이름을 이용하여 데이터를 조회하는 예제를 살펴본다.
	// 엔터티명은 생략이 가능
	// 매개변수로 검색할 때 사용할 상품명 변수를 넘겨준다.
	List<Item> findByItemNm(String itemNm);
	// 상품을 상품명과 상품 상세 설명을 OR조건을 이용하여 조회하는 쿼리 메소드
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
}
