package com.proyecto.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.apachecommons.CommonsLog;

public class DecoderPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "sonia2022";
		String encodedPassword = "$2a$10$zKbda8yGsebOZlN4zQDMgOHPPlpX0MheQqtj9Prp4gzcCBpqUdtya";
		
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		
	}
}
