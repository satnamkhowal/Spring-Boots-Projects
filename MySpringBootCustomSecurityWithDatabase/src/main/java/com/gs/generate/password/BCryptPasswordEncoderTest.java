package com.gs.generate.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
		public static void main(String[] args) {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			System.out.println(encoder.encode("jai"));
			System.out.println(encoder.encode("veeru"));
		}
}
