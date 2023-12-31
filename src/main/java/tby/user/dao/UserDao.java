package tby.user.dao;

import tby.com.ConnectionMaker;
import tby.com.NConnectionMaker;
import tby.user.domain.User;

import java.sql.*;

public  class UserDao {

    private ConnectionMaker connectionMaker;
    public UserDao(){
        connectionMaker = new NConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.getConnection();
        PreparedStatement ps = c.prepareStatement("insert into user(id, name, password)" +
                                                       "VALUES(?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2 ,user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws  ClassNotFoundException, SQLException{
        Connection c = simpleConnectionMaker.makeNewConnection();
        PreparedStatement ps = c.prepareStatement("select * from user where id = ? ");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

}
