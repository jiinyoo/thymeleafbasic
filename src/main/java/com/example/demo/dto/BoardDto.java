package com.example.demo.dto;

import lombok.Data;

@Data
public class BoardDto {
	int id, readnum;
	String name,title,content,pwd,writeday;

}
