package com.posidex.prime.response;

import java.util.List;

public class Prime360Results {
	
	private String sourceSystemName;

    private List<String> offline;

    private List<String> online;

    public void setSourceSystemName(String sourceSystemName){
        this.sourceSystemName = sourceSystemName;
    }
    public String getSourceSystemName(){
        return this.sourceSystemName;
    }
    public void setOffline(List<String> offline){
        this.offline = offline;
    }
    public List<String> getOffline(){
        return this.offline;
    }
    public void setOnline(List<String> online){
        this.online = online;
    }
    public List<String> getOnline(){
        return this.online;
    }
	@Override
	public String toString() {
		return "Prime360Results [sourceSystemName=" + sourceSystemName + ", offline=" + offline + ", online=" + online
				+ "]";
	}
    
}
