package com.gemstones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity extends BaseEntity {

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String city;

    @OneToMany(mappedBy = "customer")
    private List<ExportBillEntity> exportBill = new ArrayList<>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ExportBillEntity> getExportBill() {
        return exportBill;
    }

    public void setExportBill(List<ExportBillEntity> exportBill) {
        this.exportBill = exportBill;
    }
}
