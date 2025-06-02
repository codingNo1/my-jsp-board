package com.library.notice.service;

import java.util.List;

import com.library.notice.model.Notice;

public interface NoticeService {

	List<Notice> findAll();
	Notice findByNum(Long num);
	void write(Notice notice);
	void update(Notice notice);
	void delete(Long num);

}