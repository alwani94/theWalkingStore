package com.alwani.enterprise.theWalkingStore.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Partner {
	
	@Id
	@GeneratedValue
	private int ID;
	
	private String G_User_Name;
	
	private String G_User_EmailId;
	
	private String Mobile_No;
	
	private String P_Category;
	
	private String P_Type;
	
	private String P_Name;
	
	private boolean Is_Verified;
	
	private boolean SS_Verified;
	
	private boolean Is_Active;

	
	
	@Override
	public String toString() {
		return "Partner [ID=" + ID + ", G_User_Name=" + G_User_Name + ", G_User_EmailId=" + G_User_EmailId
				+ ", Mobile_No=" + Mobile_No + ", P_Category=" + P_Category + ", P_Type=" + P_Type + ", P_Name="
				+ P_Name + ", Is_Verified=" + Is_Verified + ", SS_Verified=" + SS_Verified + ", Is_Active=" + Is_Active
				+ "]";
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String getG_User_Name() {
		return G_User_Name;
	}



	public void setG_User_Name(String g_User_Name) {
		G_User_Name = g_User_Name;
	}



	public String getG_User_EmailId() {
		return G_User_EmailId;
	}



	public void setG_User_EmailId(String g_User_EmailId) {
		G_User_EmailId = g_User_EmailId;
	}



	public String getMobile_No() {
		return Mobile_No;
	}



	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	}



	public String getP_Category() {
		return P_Category;
	}



	public void setP_Category(String p_Category) {
		P_Category = p_Category;
	}



	public String getP_Type() {
		return P_Type;
	}



	public void setP_Type(String p_Type) {
		P_Type = p_Type;
	}



	public String getP_Name() {
		return P_Name;
	}



	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}



	public boolean isIs_Verified() {
		return Is_Verified;
	}



	public void setIs_Verified(boolean is_Verified) {
		Is_Verified = is_Verified;
	}



	public boolean isSS_Verified() {
		return SS_Verified;
	}



	public void setSS_Verified(boolean sS_Verified) {
		SS_Verified = sS_Verified;
	}



	public boolean isIs_Active() {
		return Is_Active;
	}



	public void setIs_Active(boolean is_Active) {
		Is_Active = is_Active;
	}







	
	

}
