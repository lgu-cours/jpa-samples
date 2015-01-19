package org.demo.primarykey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "BOOK_ID", nullable = false)
    private int  bookId ;

    @Column(name = "CUSTOMER_CODE", nullable = false)
    private String customerCode ;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
    
    
}
