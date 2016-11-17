/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.dao.factory;

import henu.dao.FriendDao;
import henu.dao.MsgDao;
import henu.dao.TableDao;
import henu.dao.impl.FriendDaoImpl;
import henu.dao.impl.MsgDaoImpl;
import henu.dao.impl.TableDaoImpl;
import henu.dao.impl.UserDaoImpl;
import henu.dao.IUserDao;

/**
 *
 * @author dot
 */
public class DaoFactory {
    
    public static IUserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
    
    public static FriendDao getFriendDaoInstance(){
        return new FriendDaoImpl();
    }
    
    public static TableDao getTableDaoInstance(){
        return new TableDaoImpl();
    }
    
    public static MsgDao getMsgDaoInstance(){
        return new MsgDaoImpl();
    }
    
}
