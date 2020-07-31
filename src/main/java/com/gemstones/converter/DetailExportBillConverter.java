package com.gemstones.converter;

import com.gemstones.dto.DetailExportBillDTO;
import com.gemstones.entity.DetailExportBillEntity;
import com.gemstones.repository.ExportBillRepository;
import com.gemstones.repository.Product_ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailExportBillConverter {

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private ExportBillConverter exportBillConverter;

    @Autowired
    private Product_ProductSizeRepository product_productSizeRepository;

    @Autowired
    private ExportBillRepository exportBillRepository;

    @Autowired
    private Product_ProductSizeConverter product_productSizeConverter;

    public DetailExportBillDTO toDTO(DetailExportBillEntity entity) {
        DetailExportBillDTO dto = new DetailExportBillDTO();
        try {
            dto.setId(entity.getId());
            dto.setPrice(entity.getPrice());
            dto.setPriceProductPresent(entity.getPrice());
            dto.setQuantity(entity.getQuantity());
            dto.setQuantityProductPresent(entity.getQuantity());
            dto.setExportBillId(entity.getExportBill().getId());
            //dto.setExportBill(exportBillConverter.toDTO(entity.getExportBill()));

            dto.setProductFullSizeId(entity.getProductSellFullSize().getId());
            dto.setProductFullSize(product_productSizeConverter.toDTO(entity.getProductSellFullSize()));

            dto.setCreatedBy(entity.getCreatedBy());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedBy(entity.getModifiedBy());
            dto.setModifiedDate(entity.getModifiedDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
    public List<DetailExportBillDTO> toDTO(List<DetailExportBillEntity> listEntity) {
        List<DetailExportBillDTO> list = new ArrayList<>();
        try {
            for (DetailExportBillEntity item:
                    listEntity) {
                list.add(this.toDTO(item));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public DetailExportBillEntity toEntity(DetailExportBillDTO dto) {
        DetailExportBillEntity entity = new DetailExportBillEntity();

        try {
            entity.setPrice(dto.getPrice());
            entity.setPriceProductPresent(dto.getPrice()/dto.getQuantity());
            entity.setQuantityProductPresent(dto.getQuantity());
            entity.setQuantity(dto.getQuantity());

            entity.setExportBill(exportBillRepository.findOne(dto.getExportBill().getId()));
            entity.setProductSellFullSize(product_productSizeRepository.findOne(dto.getProductFullSize().getId()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public DetailExportBillEntity toEntity(DetailExportBillDTO dto, DetailExportBillEntity entity) {

        try {
            entity.setPrice(dto.getPrice());
            entity.setPriceProductPresent(dto.getPriceProductPresent());
            entity.setQuantityProductPresent(dto.getQuantityProductPresent());
            entity.setQuantity(dto.getQuantity());

            entity.setExportBill(exportBillRepository.findOne(dto.getExportBill().getId()));
            entity.setProductSellFullSize(product_productSizeRepository.findOne(dto.getProductFullSize().getId()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
    public List<DetailExportBillEntity> toEntity(List<DetailExportBillDTO> listDTO) {
        List<DetailExportBillEntity> list = new ArrayList<>();
        try {
            for (DetailExportBillDTO item:
                    listDTO) {
                list.add(this.toEntity(item));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
