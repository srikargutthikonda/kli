package com.posidex.prime.response;

public class Prime360ParamMap {

	 	private String insertTime;

	    private String EngineRequestIDBatchID;

	    private String psxCurrentTime;

	    private String startTime;

	    private String endTime;

	    private String processTime;

	    public void setInsertTime(String insertTime){
	        this.insertTime = insertTime;
	    }
	    public String getInsertTime(){
	        return this.insertTime;
	    }
	    public void setEngineRequestIDBatchID(String EngineRequestIDBatchID){
	        this.EngineRequestIDBatchID = EngineRequestIDBatchID;
	    }
	    public String getEngineRequestIDBatchID(){
	        return this.EngineRequestIDBatchID;
	    }
	    public void setPsxCurrentTime(String psxCurrentTime){
	        this.psxCurrentTime = psxCurrentTime;
	    }
	    public String getPsxCurrentTime(){
	        return this.psxCurrentTime;
	    }
	    public void setStartTime(String startTime){
	        this.startTime = startTime;
	    }
	    public String getStartTime(){
	        return this.startTime;
	    }
	    public void setEndTime(String endTime){
	        this.endTime = endTime;
	    }
	    public String getEndTime(){
	        return this.endTime;
	    }
	    public void setProcessTime(String processTime){
	        this.processTime = processTime;
	    }
	    public String getProcessTime(){
	        return this.processTime;
	    }
		@Override
		public String toString() {
			return "Prime360ParamMap [insertTime=" + insertTime + ", EngineRequestIDBatchID=" + EngineRequestIDBatchID
					+ ", psxCurrentTime=" + psxCurrentTime + ", startTime=" + startTime + ", endTime=" + endTime
					+ ", processTime=" + processTime + "]";
		}
	    
}
