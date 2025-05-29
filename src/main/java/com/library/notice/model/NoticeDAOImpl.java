package com.library.notice.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO{

	private String URL ="jdbc:mariadb://localhost:3307/testdb";
	private String USER ="tester";
	private String PASSWORD ="1234";

	  public NoticeDAOImpl() {
	        try {
	            Class.forName("org.mariadb.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

	    @Override
	    public List<Notice> findAll() {
	        List<Notice> list = new ArrayList<>();
	        String sql = "SELECT * FROM notice ORDER BY num DESC";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Notice n = new Notice();
	                n.setNum(rs.getLong("num"));
	                n.setTitle(rs.getString("title"));
	                n.setContent(rs.getString("content"));
	                n.setRegDate(rs.getString("reg_date"));
	                n.setViewCount(rs.getInt("view_count"));
	                list.add(n);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    @Override	    
	    public Notice findByNum(Long num) {
	        String updateSql = "UPDATE notice SET view_count = view_count + 1 WHERE num = ?";
	        String selectSql = "SELECT * FROM notice WHERE num=?";

	        try (Connection conn = getConnection()) {
	            // 조회수 증가
	            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
	                updateStmt.setLong(1, num);
	                updateStmt.executeUpdate();
	            }

	            // 게시글 조회
	            try (PreparedStatement stmt = conn.prepareStatement(selectSql)) {
	                stmt.setLong(1, num);
	                try (ResultSet rs = stmt.executeQuery()) {
	                    if (rs.next()) {
	                        Notice n = new Notice();
	                        n.setNum(rs.getLong("num"));
	                        n.setTitle(rs.getString("title"));
	                        n.setContent(rs.getString("content"));
	                        n.setRegDate(rs.getString("reg_date"));
	                        n.setViewCount(rs.getInt("view_count"));
	                        return n;
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public void save(Notice notice) {
	        String sql = "INSERT INTO notice (title, content, reg_date) VALUES (?, ?, NOW())";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, notice.getTitle());
	            stmt.setString(2, notice.getContent());
	            stmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void update(Notice notice) {
	    	String sql = "UPDATE notice SET title=?, content=? WHERE num=?";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, notice.getTitle());
	            stmt.setString(2, notice.getContent());
	            stmt.setLong(3,notice.getNum());
	            stmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void delete(Long num) {
	    	String sql = "DELETE FROM notice WHERE num=?";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setLong(1, num);
	            stmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

