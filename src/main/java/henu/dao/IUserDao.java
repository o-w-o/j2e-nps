/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.dao;

import henu.dao.bean.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dot
 */
public interface IUserDao {
        
    /**
     * 用户注册
     * @param uinfo
     * @return 
     */
    public boolean signUp(Map uinfo);
    
    /**
     * 用户登录
     * @param uid
     * @param password
     * @return 成功返回 true,否则 false
     */
    public boolean signIn(String uid, String password);
    
    /**
     * 用户退出
     * @param uid
     * @param password
     * @return 成功返回 true,否则 false
     */
    public boolean signOut(String uid, String password);

    /**
     * 
     * @param u
     * @return 大于零0 成功,否则 失败
     */
    public int appendUser(User u);
    
    /**
     * 删除用户
     * @param uid
     * @return 大于零0 成功,否则 失败
     */
    public int deleteUser(String uid);
    
    /**
     * 更新用户信息
     * @param uid
     * @param user
     * @return 成功返回 true,否则 false
     */
    
    public int updateUserPassword(String uid, User user);
    
    public int updateUserBasicInfo(String uid, User user);
    
    public int updateUserType(String uid, User user);
    
    /**
     * 获取某人详细信息
     * @param uid
     * @return 
     */
    public User getUserInfo(String uid);

    /**
     * 获取某人简介
     *
     * @param uid
     * @return
     */
    public User getItsInfo(String uid);
    
    
    public List<User> getAllInfo();
    
}
