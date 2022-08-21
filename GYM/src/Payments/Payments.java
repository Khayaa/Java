/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payments;

/**
 *
 * @author Khaya
 */
public class Payments {
  private int cpayid;
  private String cpaydate;
  private int Amount;

    public Payments(int cpayid, String cpaydate, int Amount) {
        this.cpayid = cpayid;
        this.cpaydate = cpaydate;
        this.Amount = Amount;
    }

    public int getCpayid() {
        return cpayid;
    }

    public String getCpaydate() {
        return cpaydate;
    }

    public int getAmount() {
        return Amount;
    }
}
