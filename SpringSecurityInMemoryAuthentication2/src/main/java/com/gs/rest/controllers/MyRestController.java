package com.gs.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {
			@RequestMapping("/admin")
			public String admin() {
				return "I am admin";
			}
			@RequestMapping("/admin/main")
			public String main() {
				return "I am main in admin";
			}
			@RequestMapping("/user")
			public String user() {
				return "I am user";
			}
			@RequestMapping("/user/ticket")
			public String ticket() {
				return "I am modual in user";
			}
			
}
