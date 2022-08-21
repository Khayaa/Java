/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

/**
 *
 * @author khaya
 * 
 */
public class Display {
    private int cid;
    private String cname;
    private String csurname;
    private String cdob;
    private int cage;
    private int camountdue;
    private int camountpaid;
    private int cbalance;

    public Display(int cid, String cname, String csurname, String cdob, int cage, int camountdue, int camountpaid, int cbalance) {
        this.cid = cid;
        this.cname = cname;
        this.csurname = csurname;
        this.cdob = cdob;
        this.cage = cage;
        this.camountdue = camountdue;
        this.camountpaid = camountpaid;
        this.cbalance = cbalance;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getCsurname() {
        return csurname;
    }

    public String getCdob() {
        return cdob;
    }

    public int getCage() {
        return cage;
    }

    public int getCamountdue() {
        return camountdue;
    }

    public int getCamountpaid() {
        return camountpaid;
    }

    public int getCbalance() {
        return cbalance;
    }
    
    
}
