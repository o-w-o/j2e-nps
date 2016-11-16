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
public interface FriendDao {
    
    /**
     * 发送好友请求
     *
     * @param uid
     * @param fid
     * @return 成功返回 true,否则 false
     */
    public boolean makeFriend(String uid, String fid);

    /**
     * 批准交友请求
     *
     * @param uid
     * @param fid
     * @return 成功返回 true,否则 false
     */
    public boolean approveFriend(String uid, String fid);

    /**
     * 删除好友
     *
     * @param uid
     * @param fid
     * @return 成功返回 true,否则 false
     */
    public boolean deleteFriend(String uid, String fid);

    /**
     * 获取好友列表
     *
     * @param uid
     * @return
     */
    public Map getFriendsList(String uid);
}
