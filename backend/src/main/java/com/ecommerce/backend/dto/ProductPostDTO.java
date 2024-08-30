package com.ecommerce.backend.dto;

import javax.validation.constraints.NotBlank;

public class ProductPostDTO {

	String title;
	
    public ProductPostDTO(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
