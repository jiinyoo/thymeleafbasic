package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BoardDto;
import com.example.demo.mapper.BoardMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	BoardMapper mapper;
	
	@RequestMapping("/")
	public String home() {
		return "/write";
	}
	
	@RequestMapping("writeOk")
	public String writeOk(BoardDto bdto) {
		mapper.writeOk(bdto);
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String writeOk(Model model) {
		ArrayList<BoardDto> blist =mapper.list();
		System.out.println(blist.get(0).getName());
		model.addAttribute("blist",blist);
		return "/list";
	}
	
	@RequestMapping("/readnum")
	public String readnum(HttpServletRequest request) {
		String id=request.getParameter("id");
		
		mapper.readnum(id);
		return "redirect:/content?id="+id;
	}
	
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		BoardDto bdto=mapper.content(id);
		model.addAttribute("bdto",bdto);
		return "content";
	}
	
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		BoardDto bdto=mapper.content(id);
		model.addAttribute("bdto",bdto);
		return "update";
	}
	
	
	@RequestMapping("/updateOk")
	public String updateOk(BoardDto bdto) {
		int id=bdto.getId();
		mapper.update(bdto);
		
		return "redirect:/content?id="+id;
	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id=request.getParameter("id");
		mapper.delete(id);
		
		return "redirect:/list";
	}

}
