package com.gemstones.dto;

public class DetailExportBillDTO extends AbstractDTO<DetailExportBillDTO>  {

    private Double price;
    private Double priceProductPresent;
    private Long quantity;
    private Long quantityProductPresent;
    private Long exportBillId;
    private ExportBillDTO exportBill;
    private Long productFullSizeId;
    private Product_ProductSizeDTO productFullSize;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceProductPresent() {
        return priceProductPresent;
    }

    public void setPriceProductPresent(Double priceProductPresent) {
        this.priceProductPresent = priceProductPresent;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantityProductPresent() {
        return quantityProductPresent;
    }

    public void setQuantityProductPresent(Long quantityProductPresent) {
        this.quantityProductPresent = quantityProductPresent;
    }

    public ExportBillDTO getExportBill() {
        return exportBill;
    }

    public void setExportBill(ExportBillDTO exportBill) {
        this.exportBill = exportBill;
    }

    public Product_ProductSizeDTO getProductFullSize() {
        return productFullSize;
    }

    public void setProductFullSize(Product_ProductSizeDTO productFullSize) {
        this.productFullSize = productFullSize;
    }

    public Long getExportBillId() {
        return exportBillId;
    }

    public void setExportBillId(Long exportBillId) {
        this.exportBillId = exportBillId;
    }

    public Long getProductFullSizeId() {
        return productFullSizeId;
    }

    public void setProductFullSizeId(Long productFullSizeId) {
        this.productFullSizeId = productFullSizeId;
    }
}
