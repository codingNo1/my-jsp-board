package com.library.notice.model;


public class Notice {
  private Long num;
  
  private String title;
  
  private String content;
  
  private String regDate;
  
  private int viewCount;
  
  public Notice() {}
  
  public Notice(Long num, String title, String content, String regDate) {
    this.num = num;
    this.title = title;
    this.content = content;
    this.regDate = regDate;
  }
  
  public Long getNum() {
    return this.num;
  }
  
  public void setNum(Long num) {
    this.num = num;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getRegDate() {
    return this.regDate;
  }
  
  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }
  
  public int getViewCount() {
    return this.viewCount;
  }
  
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
}