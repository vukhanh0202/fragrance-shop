package com.gemstones.converter;

import com.gemstones.dto.DetailExportBillDTO;
import com.gemstones.dto.ExportBillDTO;
import com.gemstones.entity.DetailExportBillEntity;
import com.gemstones.entity.ExportBillEntity;
import com.gemstones.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExportBillConverter {

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private DetailExportBillConverter detailExportBillConverter;


    public ExportBillDTO toDTO(ExportBillEntity entity) {
        ExportBillDTO dto = new ExportBillDTO();
        try {
            dto.setId(entity.getId());
            dto.setDateExport(entity.getDateExport());
            dto.setTotalPrice(entity.getTotalPrice());
            dto.setTotalQuantity(entity.getTotalQuantity());
            dto.setStatus(entity.getStatus());
            dto.setCustomer(customerConverter.toDTO(customerRepository.findOne(entity.getCustomer().getId())));
            if (entity.getDetailExportBills() != null){
                dto.setListResultDetailProduct(detailExportBillConverter.toDTO(entity.getDetailExportBills()));
            }

            dto.setCreatedBy(entity.getCreatedBy());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedBy(entity.getModifiedBy());
            dto.setModifiedDate(entity.getModifiedDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public ExportBillEntity toEntity(ExportBillDTO dto) {
        ExportBillEntity entity = new ExportBillEntity();

        try {
            entity.setDateExport(dto.getDateExport());
            entity.setTotalPrice(dto.getTotalPrice());
            entity.setTotalQuantity(dto.getTotalQuantity());
            entity.setStatus(dto.getStatus());
            entity.setCustomer(customerRepository.findOne(dto.getCustomer().getId()));
            if (dto.getListResultDetailProduct() != null)
            {
                entity.setDetailExportBills(detailExportBillConverter.toEntity(dto.getListResultDetailProduct()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public ExportBillEntity toEntity(ExportBillDTO dto, ExportBillEntity entity) {

        try {
            entity.setDateExport(dto.getDateExport());
            entity.setTotalPrice(dto.getTotalPrice());
            entity.setTotalQuantity(dto.getTotalQuantity());
            entity.setStatus(dto.getStatus());
            entity.setCustomer(customerRepository.findOne(dto.getCustomer().getId()));
            if (dto.getListResultDetailProduct() != null)
            {
                entity.setDetailExportBills(detailExportBillConverter.toEntity(dto.getListResultDetailProduct()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
