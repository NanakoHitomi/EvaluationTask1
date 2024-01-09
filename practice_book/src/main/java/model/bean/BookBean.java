package model.bean;

import java.io.Serializable;

public class BookBean implements Serializable {
	
	//Date型のssueDate,createDatetime,updateDatetimeをDateで取得しようとしたところエラーが出たので試しにStringで取得しようとしていました
	//修正の時間がなくなってしまいましたが、また修正します
	
	private String janCd;
	private String isbnCd;
	private String bookNm;
	private String bookKana;
	private int price;
	private String issueDate;
	private String createDatetime;
	private String updateDatetime;
	
	public BookBean() {
		
	}

	public BookBean(String janCd, String isbnCd, String bookNm, String bookKana, int price, String issueDate,
			String createDatetime, String updateDatetime) {
		super();
		this.janCd = janCd;
		this.isbnCd = isbnCd;
		this.bookNm = bookNm;
		this.bookKana = bookKana;
		this.price = price;
		this.issueDate = issueDate;
		this.createDatetime = createDatetime;
		this.updateDatetime = updateDatetime;
	}


	public String getJanCd() {
		return janCd;
	}

	public void setJanCd(String janCd) {
		this.janCd = janCd;
	}

	public String getIsbnCd() {
		return isbnCd;
	}

	public void setIsbnCd(String isbnCd) {
		this.isbnCd = isbnCd;
	}

	public String getBookNm() {
		return bookNm;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	public String getBookKana() {
		return bookKana;
	}

	public void setBookKana(String bookKana) {
		this.bookKana = bookKana;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	
	
	

}
