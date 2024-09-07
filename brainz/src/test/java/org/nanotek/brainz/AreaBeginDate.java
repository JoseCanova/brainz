package org.nanotek.brainz;

public class AreaBeginDate {

	private String beginYear;
	
	private String beginMonth;
	
	private String beginDay;
	
	public AreaBeginDate() {
		super();
	}

	public AreaBeginDate(String beginYear, String beginMonth, String beginDay) {
		super();
		this.beginYear = beginYear;
		this.beginMonth = beginMonth;
		this.beginDay = beginDay;
	}



	public String getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(String beginYear) {
		this.beginYear = beginYear;
	}

	public String getBeginMonth() {
		return beginMonth;
	}

	public void setBeginMonth(String beginMonth) {
		this.beginMonth = beginMonth;
	}

	public String getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(String beginDay) {
		this.beginDay = beginDay;
	}
	
}
