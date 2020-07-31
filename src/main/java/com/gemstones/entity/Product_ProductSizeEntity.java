package com.gemstones.entity;

import javax.persistence.*;
import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT_PRODUCTSIZE")
public class Product_ProductSizeEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "productSizeId")
    private ProductSizeEntity productSize;

    @Column(name = "importPrice")
    private Double importPrice;

    @Column(name = "oldPriceSale")
    private Double oldPriceSale;

    @Column(name = "newPriceSale")
    private Double newPriceSale;

    @Column(name = "inventory")
    private Long inventory;

    @Column(name = "images")
    @Lob
    private byte[] images;

    @Column
    private String status;


    @OneToMany(mappedBy = "productSellFullSize")
    private List<DetailExportBillEntity> detailExportBills = new ArrayList<>();

    //.......

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public ProductSizeEntity getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSizeEntity productSize) {
        this.productSize = productSize;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }

    public Double getOldPriceSale() {
        return oldPriceSale;
    }

    public void setOldPriceSale(Double oldPriceSale) {
        this.oldPriceSale = oldPriceSale;
    }

    public Double getNewPriceSale() {
        return newPriceSale;
    }

    public void setNewPriceSale(Double newPriceSale) {
        this.newPriceSale = newPriceSale;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DetailExportBillEntity> getDetailExportBills() {
        return detailExportBills;
    }

    public void setDetailExportBills(List<DetailExportBillEntity> detailExportBills) {
        this.detailExportBills = detailExportBills;
    }
}
