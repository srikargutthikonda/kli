package com.posidex.bean;

import java.util.List;

public class ListOfCheckBox {
	
	private List<GetCheckBoxData> chckData;

	public List<GetCheckBoxData> getChckData() {
		return chckData;
	}

	public void setChckData(List<GetCheckBoxData> chckData) {
		this.chckData = chckData;
	}

	@Override
	public String toString() {
		return "ListOfCheckBox [chckData=" + chckData + "]";
	}
	

}
