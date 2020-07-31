package com.gemstones.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity {

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String longevity;

    @Column
    private String gender;

    @Column(columnDefinition = "TEXT")
    private String style;

    @Column(name = "newRelease")
    private boolean newRelease;

    @Column(name = "hotTrend")
    private boolean hotTrend;

    @Column(name = "bestSeller")
    private boolean bestSeller;

    @Column(name = "seasonal")
    private boolean seasonal;

    @ManyToOne
    @JoinColumn(name = "incenseGroupId")
    private IncenseGroupEntity incenseGroup;

    @OneToMany(mappedBy = "product")
    private List<Product_ProductSizeEntity> productFullSize = new ArrayList<>();

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

    public String getLongevity() {
        return longevity;
    }

    public void setLongevity(String longevity) {
        this.longevity = longevity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public IncenseGroupEntity getIncenseGroup() {
        return incenseGroup;
    }

    public void setIncenseGroup(IncenseGroupEntity incenseGroup) {
        this.incenseGroup = incenseGroup;
    }

    public boolean isNewRelease() {
        return newRelease;
    }

    public void setNewRelease(boolean newRelease) {
        this.newRelease = newRelease;
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

    public List<Product_ProductSizeEntity> getProductFullSize() {
        return productFullSize;
    }

    public void setProductFullSize(List<Product_ProductSizeEntity> productFullSize) {
        this.productFullSize = productFullSize;
    }
}
