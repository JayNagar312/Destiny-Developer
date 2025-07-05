package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Form;

public interface FormRepo extends JpaRepository<Form, Long>{

	public Form save(Form frm);
}
