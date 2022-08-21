/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Members;

/**
 *
 * @author khaya
 */
public class Members {
    private String cname;
    private String cdob;
    private String csurname;
    private String cpaydate;
    private int cmemberid;
    private int cid; 
    private int ccontatct;
    private String cmembertype;

    public Members(int cmemberid ,String cname, String csurname, String cdob,  int cid, int ccontatct, String cpaydate ,   String cmembertype) {
        this.cname = cname;
        this.cdob = cdob;
        this.csurname = csurname;
        this.cpaydate = cpaydate;
        this.cmemberid = cmemberid;
        this.cid = cid;
        this.ccontatct = ccontatct;
        this.cmembertype = cmembertype;
    }

    public String getCname() {
        return cname;
    }

    public String getCdob() {
        return cdob;
    }

    public String getCsurname() {
        return csurname;
    }

    public String getCpaydate() {
        return cpaydate;
    }

    public int getCmemberid() {
        return cmemberid;
    }

    public int getCid() {
        return cid;
    }

    public int getCcontatct() {
        return ccontatct;
    }

    public String getCmembertype() {
        return cmembertype;
    }
     
    
    
     
}
