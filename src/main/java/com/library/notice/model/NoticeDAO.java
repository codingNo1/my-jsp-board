package com.library.notice.model;

import java.util.List;

public interface NoticeDAO {
	List<Notice> findAll();
	Notice findByNum(Long num);
	void save(Notice notice);
	void update(Notice notice);
    void delete(Long num);     
}
