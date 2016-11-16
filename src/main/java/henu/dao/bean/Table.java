/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.dao.bean;

/**
 *
 * @author dot
 */
public class Table {
    
    private int tid;
    private int[] fids;
    private boolean type;
    private String tname;
    private String tfile;

    /**
     * @return the tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(int tid) {
        this.tid = tid;
    }

    /**
     * @return the tname
     */
    public String getTname() {
        return tname;
    }

    /**
     * @param tname the tname to set
     */
    public void setTname(String tname) {
        this.tname = tname;
    }

    /**
     * @return the tfile
     */
    public String getTfile() {
        return tfile;
    }

    /**
     * @param tfile the tfile to set
     */
    public void setTfile(String tfile) {
        this.tfile = tfile;
    }

    /**
     * @return the type
     */
    public boolean isType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * @return the fids
     */
    public int[] getFids() {
        return fids;
    }

    /**
     * @param fids the fids to set
     */
    public void setFids(int[] fids) {
        this.fids = fids;
    }
    
    
}
