/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyphpk00628_asm_gd2;

import frm.frmDangNhap;
import frm.frmTrangChu;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author huy
 */
public class HUYPHPK00628_ASM_GD2 {
  public static  frm.frmTrangChu frmTC=new frmTrangChu();
     public static database.clsConnectDB connection = new  database.clsConnectDB ();

    public static void main(String[] args) {
       frm.frmDangNhap frmDN= new   frm.frmDangNhap();
  
       frmDN.show();
    }
   
    
}
