package com.gemstones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTSIZE")
public class ProductSizeEntity extends BaseEntity{

    @Column
    private String size;

    @OneToMany(mappedBy = "productSize")
    private List<Product_ProductSizeEntity> productFullSize = new ArrayList<>();

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
