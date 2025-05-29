package com.library.notice.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
  private String URL = "jdbc:mariadb://localhost:3307/testdb";
  
  private String USER = "tester";
  
  private String PASSWORD = "1234";
  
  public NoticeDAOImpl() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } 
  }
  
  private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
  }
  
  public List<Notice> findAll() {
    List<Notice> list = new ArrayList<>();
    String sql = "SELECT * FROM notice ORDER BY num DESC";
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return list;
  }
  
  public Notice findByNum(Long num) {
    String updateSql = "UPDATE notice SET view_count = view_count + 1 WHERE num = ?";
    String selectSql = "SELECT * FROM notice WHERE num=?";
    try {
      Exception exception1 = null, exception2 = null;
      try {
      
      } finally {
        exception2 = null;
        if (exception1 == null) {
          exception1 = exception2;
        } else if (exception1 != exception2) {
          exception1.addSuppressed(exception2);
        } 
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public void save(Notice notice) {
    String sql = "INSERT INTO notice (title, content, reg_date) VALUES (?, ?, NOW())";
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void update(Notice notice) {
    String sql = "UPDATE notice SET title=?, content=? WHERE num=?";
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void delete(Long num) {
    String sql = "DELETE FROM notice WHERE num=?";
    try {
      Exception exception2, exception1 = null;
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}