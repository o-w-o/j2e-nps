/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.dao;

import java.util.Map;

/**
 *
 * @author dot
 */
public interface UserDao {
        
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
     * 添加用户
     * @param uinfo
     * @return 成功返回 true,否则 false
     */
    public boolean addUser(Map uinfo);
    
    /**
     * 删除用户
     * @param uid
     * @return 成功返回 true,否则 false
     */
    public boolean deleteUser(String uid);
    
    /**
     * 更新用户信息
     * @param uid
     * @param uinfo
     * @return 成功返回 true,否则 false
     */
    
    public boolean updateUser(String uid, Map uinfo);
    
    /**
     * 获取某人详细信息
     * @param uid
     * @return 
     */
    public Map getUserInfo(String uid);

    /**
     * 获取某人简介
     *
     * @param fid
     * @return
     */
    public Map getItsInfo(String fid);
    
}
