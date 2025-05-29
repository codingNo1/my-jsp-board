package com.library.notice.service;


import com.library.notice.model.Notice;
import java.util.List;

public interface NoticeService {
  List<Notice> findAll();
  
  Notice findByNum(Long paramLong);
  
  void write(Notice paramNotice);
  
  void update(Notice paramNotice);
  
  void delete(Long paramLong);
}
