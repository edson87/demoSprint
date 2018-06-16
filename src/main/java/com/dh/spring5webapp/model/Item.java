package com.dh.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Item extends ModelBase{
    private String name;
    private String code;

    @OneToOne(optional = false)
    private SubCategory subCategory;

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
