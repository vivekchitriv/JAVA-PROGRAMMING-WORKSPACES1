package com.test;
import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class TransLog implements Serializable{
	private final double tId;
	private final long bAccNo;
	private final int amt;
	private final java.util.Date d;
	public TransLog(double tId,long bAccNo,int amt,java.util.Date d)
	{
		this.tId = tId;
		this.bAccNo = bAccNo;
		this.amt = amt;
		this.d = d;
	}
	@Override
	public final String toString() {
		return "tId:"+tId+"\nbAccNo:"+bAccNo+"\namt"+amt+"\nDate and time"+d;
	}
	
	
}
