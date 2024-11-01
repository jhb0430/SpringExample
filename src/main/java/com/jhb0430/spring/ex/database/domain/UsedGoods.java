package com.jhb0430.spring.ex.database.domain;

import java.time.LocalDateTime;

// Domain
// Entity Class
// 대상 테이블의 컬럼 이름과 정확히 일치하는 멤버 변수를 가진 클래스
// 한 행의 정보를 모두 저장하는 객체를 만들기 위한 목적 
public class UsedGoods {

	private int id;
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String image;
	// createdAt updatedAt
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	
	
	// 객체를 생성하고 저장하거나 가져다ㅆ느느 경우 프레임워크나 라이브러리를 쓰느 ㄴ경우가 많음
	// 사용 용이하도록 게터쎄터 만들어두는게 좋음
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
