package com.gemstones.converter;

import com.gemstones.dto.ProductSizeDTO;
import com.gemstones.entity.ProductSizeEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductSizeConverter {

    public ProductSizeDTO toDTO(ProductSizeEntity productSizeEntity) {
        ProductSizeDTO dto = new ProductSizeDTO();
        try {
            dto.setId(productSizeEntity.getId());
            dto.setSize(productSizeEntity.getSize());

            dto.setCreatedBy(productSizeEntity.getCreatedBy());
            dto.setCreatedDate(productSizeEntity.getCreatedDate());
            dto.setModifiedBy(productSizeEntity.getModifiedBy());
            dto.setModifiedDate(productSizeEntity.getModifiedDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public ProductSizeEntity toEntity(ProductSizeDTO productSizeDTO) {
        ProductSizeEntity entity = new ProductSizeEntity();
        try {
            entity.setSize(productSizeDTO.getSize());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public ProductSizeEntity toEntity(ProductSizeDTO productSizeDTO, ProductSizeEntity entity) {
        try {
            entity.setSize(productSizeDTO.getSize());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
