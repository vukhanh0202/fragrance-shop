package com.gemstones.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportBillDTO extends AbstractDTO<ExportBillDTO>{

    private LocalDate dateExport;
    private Double totalPrice;
    private Long totalQuantity;
    private String status;
    private CustomerDTO customer;
    private List<DetailExportBillDTO> listResultDetailProduct = new ArrayList<>();

    public List<DetailExportBillDTO> getListResultDetailProduct() {
        return listResultDetailProduct;
    }

    public void setListResultDetailProduct(List<DetailExportBillDTO> listResultDetailProduct) {
        this.listResultDetailProduct = listResultDetailProduct;
    }

    public LocalDate getDateExport() {
        return dateExport;
    }

    public void setDateExport(LocalDate dateExport) {
        this.dateExport = dateExport;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
