package com.jhb0430.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.spring.ex.jpa.domain.Student;

//														<entity클래스,해당하는 클래스의 프라이머리 키 타입>
public interface StudentRepository extends JpaRepository<Student,Integer>{

	
}
