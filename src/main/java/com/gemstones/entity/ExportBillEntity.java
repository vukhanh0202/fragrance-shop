package com.gemstones.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EXPORTBILL")
public class ExportBillEntity extends BaseEntity {

    @Column(name = "dateExport")
    private LocalDate dateExport;

    @Column(name = "totalQuantity")
    private Long totalQuantity;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "exportBill")
    private List<DetailExportBillEntity> detailExportBills = new ArrayList<>();

    public LocalDate getDateExport() {
        return dateExport;
    }

    public void setDateExport(LocalDate dateExport) {
        this.dateExport = dateExport;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<DetailExportBillEntity> getDetailExportBills() {
        return detailExportBills;
    }

    public void setDetailExportBills(List<DetailExportBillEntity> detailExportBills) {
        this.detailExportBills = detailExportBills;
    }
}
