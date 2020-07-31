package com.gemstones.dto;

import java.util.ArrayList;
import java.util.List;

public class Product_ProductSizeDTO extends AbstractDTO<Product_ProductSizeDTO> {

    private Double importPrice;
    private Double newPriceSale;
    private Double oldPriceSale;
    private Long inventory;
    private String status;
    private String images;
    private byte[] imagesByte;
    private ProductDTO product;
    private Long productId;
    private ProductSizeDTO productSize;
    private Long productSizeId;

    private List<Product_ProductSizeDTO> listResultAllProduct = new ArrayList<>();

    public List<Product_ProductSizeDTO> getListResultAllProduct() {
        return listResultAllProduct;
    }

    public void setListResultAllProduct(List<Product_ProductSizeDTO> listResultAllProduct) {
        this.listResultAllProduct = listResultAllProduct;
    }



    public Double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }

    public Double getNewPriceSale() {
        return newPriceSale;
    }

    public void setNewPriceSale(Double newPriceSale) {
        this.newPriceSale = newPriceSale;
    }

    public Double getOldPriceSale() {
        return oldPriceSale;
    }

    public void setOldPriceSale(Double oldPriceSale) {
        this.oldPriceSale = oldPriceSale;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public byte[] getImagesByte() {
        return imagesByte;
    }

    public void setImagesByte(byte[] imagesByte) {
        this.imagesByte = imagesByte;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public ProductSizeDTO getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSizeDTO productSize) {
        this.productSize = productSize;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(Long productSizeId) {
        this.productSizeId = productSizeId;
    }


}
