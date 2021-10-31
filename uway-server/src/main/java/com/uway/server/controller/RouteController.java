package com.uway.server.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
	
	@RequestMapping("/")
	public void index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getServletContext().getRequestDispatcher("/index.html").forward(req, res);
	}
	


}