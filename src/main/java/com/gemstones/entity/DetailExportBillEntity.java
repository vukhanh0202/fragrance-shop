package com.gemstones.entity;

import javax.persistence.*;

@Entity
@Table(name = "DETAILEXPORTBILL")
public class DetailExportBillEntity extends BaseEntity {

    @Column
    private Long quantity;

    @Column
    private Double price;

    @Column(name = "quantityProductPresent")
    private Long quantityProductPresent;

    @Column(name = "priceProductPresent")
    private Double priceProductPresent;

    @ManyToOne
    @JoinColumn(name = "productSellFullSizeId")
    private Product_ProductSizeEntity productSellFullSize;

    @ManyToOne
    @JoinColumn(name = "exportBillId")
    private ExportBillEntity exportBill;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantityProductPresent() {
        return quantityProductPresent;
    }

    public void setQuantityProductPresent(Long quantityProductPresent) {
        this.quantityProductPresent = quantityProductPresent;
    }

    public Double getPriceProductPresent() {
        return priceProductPresent;
    }

    public void setPriceProductPresent(Double priceProductPresent) {
        this.priceProductPresent = priceProductPresent;
    }

    public Product_ProductSizeEntity getProductSellFullSize() {
        return productSellFullSize;
    }

    public void setProductSellFullSize(Product_ProductSizeEntity productSellFullSize) {
        this.productSellFullSize = productSellFullSize;
    }

    public ExportBillEntity getExportBill() {
        return exportBill;
    }

    public void setExportBill(ExportBillEntity exportBill) {
        this.exportBill = exportBill;
    }
}
