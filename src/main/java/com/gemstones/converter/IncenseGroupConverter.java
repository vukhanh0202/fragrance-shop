package com.gemstones.converter;

import com.gemstones.dto.IncenseGroupDTO;
import com.gemstones.dto.ProductDTO;
import com.gemstones.entity.IncenseGroupEntity;
import com.gemstones.entity.ProductEntity;
import org.springframework.stereotype.Component;


@Component
public class IncenseGroupConverter {

    public IncenseGroupDTO toDTO(IncenseGroupEntity incenseGroupEntity) {
        IncenseGroupDTO dto = new IncenseGroupDTO();
        try {
            dto.setId(incenseGroupEntity.getId());
            dto.setName(incenseGroupEntity.getName());
            dto.setCode(incenseGroupEntity.getCode());

            dto.setCreatedBy(incenseGroupEntity.getCreatedBy());
            dto.setCreatedDate(incenseGroupEntity.getCreatedDate());
            dto.setModifiedBy(incenseGroupEntity.getModifiedBy());
            dto.setModifiedDate(incenseGroupEntity.getModifiedDate());
            //dto.setImagesByte(productEntity.getImages());
            //dto.setImages(new String(productEntity.getImages(), "UTF-8").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public IncenseGroupEntity toEntity(IncenseGroupDTO incenseGroupDTO) {
        IncenseGroupEntity entity = new IncenseGroupEntity();
        try {
            entity.setName(incenseGroupDTO.getName());
            entity.setCode(incenseGroupDTO.getCode());

            //dto.setImagesByte(productEntity.getImages());
            //dto.setImages(new String(productEntity.getImages(), "UTF-8").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public IncenseGroupEntity toEntity(IncenseGroupDTO incenseGroupDTO, IncenseGroupEntity entity) {
        try {
            entity.setName(incenseGroupDTO.getName());
            entity.setCode(incenseGroupDTO.getCode());

            //dto.setImagesByte(productEntity.getImages());
            //dto.setImages(new String(productEntity.getImages(), "UTF-8").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
