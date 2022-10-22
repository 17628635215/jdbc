package dao;

import domain.User;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void save(User user) throws SQLException {
        Connection conn = JdbcUtil.getConn();
        String sql = "insert into user (name,sex,age,tel,email) values (?,?,?,?,?);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSex());
        stmt.setInt(3, user.getAge());
        stmt.setLong(4, user.getTel());
        stmt.setString(5, user.getEmail());
        stmt.executeUpdate();
        JdbcUtil.close(null,stmt,conn);
    }

    public void update(User user) throws SQLException{
        Connection conn = JdbcUtil.getConn();
        String sql = "update user set name=?, sex=?, age=?, tel=?, email=? where id=?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSex());
        stmt.setInt(3, user.getAge());
        stmt.setLong(4, user.getTel());
        stmt.setString(5, user.getEmail());
        stmt.setLong(6, user.getId());
        stmt.executeUpdate();
        JdbcUtil.close(null,stmt,conn);
    }

    public void delete(Long id) throws SQLException{
        Connection conn = JdbcUtil.getConn();
        Statement stmt = conn.createStatement();
        String sql = "delete from user where id="+id;
        stmt.executeUpdate(sql);
        JdbcUtil.close(null,stmt,conn);
    }

    public User selectById(Long id) throws SQLException{
        Connection conn = JdbcUtil.getConn();
        Statement stmt = conn.createStatement();
        String sql = "select * from user where id="+id;
        ResultSet rs = stmt.executeQuery(sql);
        User user = new User();
        while (rs.next()){
             user.setId(rs.getLong("id"));
             user.setName( rs.getString("name"));
             user.setAge(rs.getInt("age"));
             user.setSex(rs.getString("sex"));
             user.setTel(rs.getLong("tel"));
             user.setEmail(rs.getString("email"));
        }
        JdbcUtil.close(null,stmt,conn);
        return user;
    }

    public List<User> selectALl() throws SQLException{
        Connection conn = JdbcUtil.getConn();
        Statement stmt = conn.createStatement();
        String sql = "select * from user";
        ResultSet rs = stmt.executeQuery(sql);
        List<User> users = new ArrayList<>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName( rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setSex(rs.getString("sex"));
            user.setTel(rs.getLong("tel"));
            user.setEmail(rs.getString("email"));
            users.add(user);
        }
        JdbcUtil.close(null,stmt,conn);
        return users;
    }
}
