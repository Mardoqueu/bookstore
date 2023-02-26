package com.mardoqueu.bookstore.dtos;

import java.io.Serializable;

import com.mardoqueu.bookstore.domain.Book;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String name_author;
	private String text;

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(Book obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
		this.name_author = obj.getName_author();
		this.text = obj.getText();
	}

    public BookDTO(int i, String clean_code, String robert_martin, String lorem_inpsum) {
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName_author() {
		return name_author;
	}

	public void setName_author(String name_author) {
		this.name_author = name_author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
