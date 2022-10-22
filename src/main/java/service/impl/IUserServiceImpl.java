package service.impl;

import dao.UserDao;
import domain.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class IUserServiceImpl implements UserService {
    @Override
    public void save(User user) throws Exception {
        UserDao dao = new UserDao();
        dao.save(user);
    }

    @Override
    public void update(User user) throws SQLException {
        UserDao dao = new UserDao();
        dao.update(user);
    }

    @Override
    public void delete(Long id) throws SQLException {
        UserDao dao = new UserDao();
        dao.delete(id);
    }

    @Override
    public List<User> selectALL() throws SQLException {
        UserDao dao = new UserDao();
        return dao.selectALl();
    }

    @Override
    public User selectById(Long id) throws SQLException {
        UserDao dao = new UserDao();
        return dao.selectById(id);
    }
}
