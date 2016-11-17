package henu.dao.impl;

import henu.dao.bean.User;
import java.util.List;
import java.util.Map;
import henu.dao.IUserDao;
import henu.util.SqlDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dot
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public boolean signUp(Map uinfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean signIn(String uid, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean signOut(String uid, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int appendUser(User user) {

        String sql = "insert into user (uid, gender, utype, email, birthday, uwords, password, uname) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = SqlDB.executePreparedStatement(sql);

        int result = 0;
        try {
            ps.setInt(1, Integer.parseInt(user.getId()));
            ps.setString(2, user.getGender());
            ps.setString(3, user.getUtype());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getBrithday());
            ps.setString(6, user.getUwords());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getName());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int deleteUser(String uid) {
        String sql = "delete from user where uid=" + uid;

        int result = SqlDB.executeUpdate(sql);

        SqlDB.close();

        return result;
    }

    /**
     * @param user
     * @param uid
     * @return
     */
    @Override
    public int updateUserPassword(String uid, User user) {
        String sql = "update user set password=? where uid=?";
        PreparedStatement ps = SqlDB.executePreparedStatement(sql);
        int result = 0;

        try {
            ps.setString(1, user.getPassword());
            ps.setString(2, uid);
            result = ps.executeUpdate();
            System.out.println("result: " + result);
        } catch (Exception e) {
        }

        SqlDB.close();
        return result;
    }

    @Override
    public int updateUserBasicInfo(String uid, User user) {

        String sql = "update user set uname=?, gender=?, email=?, birthday=?, uwords=? where uid=?";
        PreparedStatement ps = SqlDB.executePreparedStatement(sql);

        int result = 0;
        try {
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getBrithday());
            ps.setString(5, user.getUwords());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int updateUserType(String uid, User user) {
        String sql = "update user set utype=? where uid=?";
        PreparedStatement ps = SqlDB.executePreparedStatement(sql);
        int result = 0;

        try {
            ps.setString(1, user.getUtype());
            ps.setString(2, uid);
            result = ps.executeUpdate();
            System.out.println("result: " + result);
        } catch (Exception e) {
        }

        SqlDB.close();
        return result;
    }

    @Override
    public User getUserInfo(String uid) {
        String sql = "select * from user where uid=" + uid;

        ResultSet rs = SqlDB.executeQuery(sql);
        User user = getUserInfoByRs(rs, false);

        SqlDB.close();

        return user;
    }

    @Override
    public User getItsInfo(String uid) {
        String sql = "select * from user where uid=" + uid;

        ResultSet rs = SqlDB.executeQuery(sql);
        User user = getUserInfoByRs(rs, true);

        SqlDB.close();

        return user;
    }

    @Override
    public List<User> getAllInfo() {
        String sql = "select * from user order by uid";
        List<User> list = new ArrayList<User>();

        ResultSet rs = SqlDB.executeQuery(sql);
        try {
            while (rs.next()) {
                User user = new User();
                user.setBrithday(rs.getString("birthday"));
                user.setUtype(rs.getString("utype"));
                user.setUwords(rs.getString("uwords"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setName(rs.getString("uname"));
                user.setPassword("***");
                user.setId(Integer.toString(rs.getInt("uid")));
                printUserInfo(user);
                list.add(user);
            }
        } catch (Exception e) {
        }

        SqlDB.close();
        return list;
    }

    private User getUserInfoByRs(ResultSet rs, Boolean isbasic) {
        User user = new User();
        try {
            if (isbasic == true) {
                if (rs.next()) {
                    user.setName(rs.getString("uname"));
                    user.setGender(rs.getString("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setUwords(rs.getString("uwords"));
                }
            } else {
                user.setBrithday(rs.getString("birthdy"));
                user.setUtype(rs.getString("utype"));
                user.setUwords(rs.getString("uwords"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setName(rs.getString("uname"));
                user.setPassword("***");
                user.setId(Integer.toString(rs.getInt("uid")));
            }
        } catch (Exception e) {
        }

        return user;
    }

    private int setUserInfoByRs(PreparedStatement ps, User user, String type) {
        int result = 0;
        try {
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getUtype());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getBrithday());
            ps.setString(6, user.getUwords());
            ps.setString(7, user.getPassword());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    private String printUserInfo(User u){
        String str = "name:" + u.getName() +
            "\n gender:" + u.getGender() +
            "\n uwords: " + u.getUwords()
            ; 
        return str;
    }
}
