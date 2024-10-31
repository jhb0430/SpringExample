package com.jhb0430.spring.ex.lifecycle;

public class Person {

	// 이름, 나이 
	
	private String name;
	private int age;
	
	// 생성자를 통해 멤버변수 값을 채우도록 구성해주기
	public Person(String name, int age) {
		this.name= name;
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "이름 : " + name + "나이 : " + age;
	}
	
	// 변수가 private 라 이대로는 못쓴다!! getter 만들어줘야함 
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
}
