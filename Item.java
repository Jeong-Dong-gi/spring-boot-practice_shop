package com.shop.entity;

import java.time.LocalDateTime;

import com.shop.constant.itemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 상품 엔터티 설계하기
// 엔터티(Entity)란 데이터베이스의 테이블에 대응하는 클래스라고 생각하면 된다.
// @Entity가 붙은 클래스는 JPA에서 관리하며 엔터티라고 한다.
// @Entity어노테이션은 클래스의 상단에 입력하면 JPA에 엔터티 클래스라는 것을 알려준다.
@Entity
//@Table어노테이션을 통해 어떤 테이블과 매핑될지를 지정한다.
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
	// 상품코드
	// @Id 어노테이션을 이용하면 id멤버 변수를 상품 테이블의 기본키로 설정한다.
	@Id
	// @GeneratedValue 어노테이션을 통한 기본키를 생성하는 전략(방법)
	// Auto - JPA 구현체가 자동으로 생성 전략 결정
	// MySql 데이터베이스의 경우 auto_increment를 사용하여 기본키 생성
	@GeneratedValue(strategy=GenerationType.AUTO)
	// @Column 속성
	// 추가 속성 name - 필드와 매핑할 컬럼의 이름 설정, 기본값: 객체의 필드 이름
	@Column(name="item_id")
	private Long id;
	// 상품명
	// nullable - null값의 허용 여부 설정
	// length - String 타입의 문자 길이 제약조건 설정
	@Column(nullable=false,length=50)
	private String itemNm;
	// 가격
	@Column(name="price",nullable=false)
	private int price;
	// 재고 수량
	@Column(nullable=false)
	private int stockNumber;
	// 상품 상세 설명
	@Column(nullable=false)
	private String itemDetail;
	// 상품 판매 상태
	// enum타입을 엔터티 매핑에서 사용할 때 @Enumerated 어노테이션을 사용해야 한다.
	// EnumType.ORIGINAL - enum순서(숫자)값을 DB에 저장
	// EnumType.STRING - enum 이름 값을 DB에 저장
	@Enumerated(EnumType.STRING)
	private itemSellStatus itemSellStatus;
	// 등록 시간
	private LocalDateTime regTime;
	// 수정 시간
	private LocalDateTime updateTime;
}
