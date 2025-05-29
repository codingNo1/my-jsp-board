package com.library.notice.model;

import com.library.notice.model.Notice;
import java.util.List;

public interface NoticeDAO {
  List<Notice> findAll();
  
  Notice findByNum(Long paramLong);
  
  void save(Notice paramNotice);
  
  void update(Notice paramNotice);
  
  void delete(Long paramLong);
}
