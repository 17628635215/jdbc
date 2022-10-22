package service;

import domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public void save(User user) throws Exception;
    public void update(User user) throws SQLException;
    public void delete(Long id) throws SQLException;
    public List<User> selectALL() throws SQLException;
    public User selectById(Long id) throws SQLException;
}
