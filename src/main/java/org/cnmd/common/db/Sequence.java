package org.cnmd.common.db;

import java.math.BigDecimal;

public class Sequence {
	
	private String tablename;
	private BigDecimal incrementno;
	private BigDecimal startno;
	private BigDecimal currentnext;
	private String isaudited;
	private String istableid;	
	private String prefix;	
	private String suffix;	
	private String startnewyear;

	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public BigDecimal getIncrementno() {
		return incrementno;
	}
	public void setIncrementno(BigDecimal incrementno) {
		this.incrementno = incrementno;
	}
	public BigDecimal getStartno() {
		return startno;
	}
	public void setStartno(BigDecimal startno) {
		this.startno = startno;
	}
	public BigDecimal getCurrentnext() {
		return currentnext;
	}
	public void setCurrentnext(BigDecimal currentnext) {
		this.currentnext = currentnext;
	}
	public String getIsaudited() {
		return isaudited;
	}
	public void setIsaudited(String isaudited) {
		this.isaudited = isaudited;
	}
	public String getIstableid() {
		return istableid;
	}
	public void setIstableid(String istableid) {
		this.istableid = istableid;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getStartnewyear() {
		return startnewyear;
	}
	public void setStartnewyear(String startnewyear) {
		this.startnewyear = startnewyear;
	}	

}
