package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void writeOk(BoardDto bdto);
	ArrayList<BoardDto> list();
	void readnum(String id);
	BoardDto content(String id);
	void update(BoardDto bdto);
	void delete(String id);


}
