package com.gemstones.dto;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO extends AbstractDTO<ProductDTO> {

    private String name;
    private String description;
    private String gender;
    private String longevity;
    private String style;
    private IncenseGroupDTO incenseGroup;
    private Long incenseGroupId;
    private List<Product_ProductSizeDTO> listResultAllProduct = new ArrayList<>();
    private int totalProductSize;


    private boolean isNewRelease;
    private boolean hotTrend;
    private boolean bestSeller;
    private boolean seasonal;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLongevity() {
        return longevity;
    }

    public void setLongevity(String longevity) {
        this.longevity = longevity;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public IncenseGroupDTO getIncenseGroup() {
        return incenseGroup;
    }

    public void setIncenseGroup(IncenseGroupDTO incenseGroup) {
        this.incenseGroup = incenseGroup;
    }

    public Long getIncenseGroupId() {
        return incenseGroupId;
    }

    public void setIncenseGroupId(Long incenseGroupId) {
        this.incenseGroupId = incenseGroupId;
    }

    public List<Product_ProductSizeDTO> getListResultAllProduct() {
        return listResultAllProduct;
    }

    public void setListResultAllProduct(List<Product_ProductSizeDTO> listResultAllProduct) {
        this.listResultAllProduct = listResultAllProduct;
    }

    public int getTotalProductSize() {
        return totalProductSize;
    }

    public void setTotalProductSize(int totalProductSize) {
        this.totalProductSize = totalProductSize;
    }

    public boolean isNewRelease() {
        return isNewRelease;
    }

    public void setNewRelease(boolean newRelease) {
        isNewRelease = newRelease;
    }

    public boolean isHotTrend() {
        return hotTrend;
    }

    public void setHotTrend(boolean hotTrend) {
        this.hotTrend = hotTrend;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public boolean isSeasonal() {
        return seasonal;
    }

    public void setSeasonal(boolean seasonal) {
        this.seasonal = seasonal;
    }

    //    public byte[] imagesByte;
//    private Long typeProductId;
//    private String typeProductName;
//
//    public String  getImages() {
//        if (this.images != null)
//        {
//            return this.images;
//        }
//        return null;
//    }
//    public String getImagesNotSplit(){
//        return this.images;
//    }
//
//    public void setImages(String  images) {
//        this.images = images;
//    }
//    public byte[] getImagesByte() {
//
//        if (this.imagesByte != null)
//        {
//            return this.imagesByte;
//            // return this.images.getClass().toString().split(",")[1].getBytes();
//        }
//        return this.getImages().split(",")[1].getBytes();
//    }
//
//    public void setImagesByte(byte[] imagesByte) {
//        this.imagesByte = imagesByte;
//    }

}
