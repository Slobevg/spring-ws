package ru.slobevg;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}
