package com.jhb0430.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//
//@Builder //객체를 생성하는 또다른 방식. 빌더 패턴. 
//@AllArgsConstructor // 생성자 다 관리해준다 
//@Setter
//@Getter
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor // 생성자 다 관리해준다 
@Getter
@Table(name="`new_student`")
@Entity
public class Student {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="phoneNumber")
	private String phoneNumber;
	private String email;
	@Column(name="dreamJob")
	private String dreamJob;
	
	@Column(name="createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
