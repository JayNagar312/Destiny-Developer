package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Form;
import com.entity.User;
import com.repo.FormRepo;
import com.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo urepo;
	@Autowired
	private FormRepo frepo;
	
	public User saveUser(User user) {
		return urepo.save(user);
	}

	public User findUser(String mail) {
		return urepo.findByMail(mail);
	}

	public Form saveForm(Form frm) {
		return frepo.save(frm);
	}
}
