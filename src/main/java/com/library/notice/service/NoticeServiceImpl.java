package com.library.notice.service;


import com.library.notice.model.Notice;
import com.library.notice.model.NoticeDAO;
import com.library.notice.service.NoticeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
  @Autowired
  private NoticeDAO noticeDAO;
  
  public List<Notice> findAll() {
    return this.noticeDAO.findAll();
  }
  
  public Notice findByNum(Long num) {
    return this.noticeDAO.findByNum(num);
  }
  
  public void write(Notice notice) {
    this.noticeDAO.save(notice);
  }
  
  public void update(Notice notice) {
    this.noticeDAO.update(notice);
  }
  
  public void delete(Long num) {
    this.noticeDAO.delete(num);
  }
}