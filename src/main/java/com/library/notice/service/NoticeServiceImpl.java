package com.library.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.notice.model.Notice;
import com.library.notice.model.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<Notice> findAll(){
		return noticeDAO.findAll();
	}

	@Override
	public Notice findByNum(Long num) {
		return noticeDAO.findByNum(num);
	}

	@Override
	public void write(Notice notice) {
		noticeDAO.save(notice);
	}	
	
	@Override
	public void update(Notice notice) {
		noticeDAO.update(notice);
	}

	@Override
	public void delete(Long num) {
		noticeDAO.delete(num);		
	}	
}