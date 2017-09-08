package com.cursocuencajava.app.model;

public class StatusResult implements IJson {
	
	public static final int OK = 1;
	public static final int ERROR = -1;
	public static final int NOT_ALLOWED = -2;
	
	private int r;
	private IJson v;
	public StatusResult(int r, IJson v) {
		super();
		this.r = r;
		this.v = v;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public IJson getV() {
		return v;
	}
	public void setV(IJson v) {
		this.v = v;
	}
	@Override
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"r\":");
		sb.append(r);
		if(v!=null) {
			sb.append(",\"v\":");
			sb.append(v.toJson());
		}
		sb.append("}");
		return sb.toString();
	}
	
}
