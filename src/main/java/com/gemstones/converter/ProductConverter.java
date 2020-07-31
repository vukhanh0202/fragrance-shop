package com.gemstones.converter;

import com.gemstones.dto.ProductDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.entity.IncenseGroupEntity;
import com.gemstones.entity.ProductEntity;
import com.gemstones.entity.Product_ProductSizeEntity;
import com.gemstones.repository.IncenseGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductConverter {

    @Autowired
    private IncenseGroupConverter incenseGroupConverter;

    @Autowired
    private IncenseGroupRepository incenseGroupRepository;
    @Autowired
    private Product_ProductSizeConverter product_productSizeConverter;

    public ProductDTO toDTO(ProductEntity productEntity) {
        ProductDTO dto = new ProductDTO();
        try {
            dto.setId(productEntity.getId());
            dto.setName(productEntity.getName());
            dto.setDescription(productEntity.getDescription());
            dto.setGender(productEntity.getGender());
            dto.setLongevity(productEntity.getLongevity());
            dto.setStyle(productEntity.getStyle());
            dto.setNewRelease(productEntity.isNewRelease());
            dto.setHotTrend(productEntity.isHotTrend());
            dto.setBestSeller(productEntity.isBestSeller());
            dto.setSeasonal(productEntity.isSeasonal());


            dto.setIncenseGroupId(productEntity.getIncenseGroup().getId());
            dto.setIncenseGroup(incenseGroupConverter.toDTO(productEntity.getIncenseGroup()));

            dto.setCreatedBy(productEntity.getCreatedBy());
            dto.setCreatedDate(productEntity.getCreatedDate());
            dto.setModifiedBy(productEntity.getModifiedBy());
            dto.setModifiedDate(productEntity.getModifiedDate());
            //dto.setImagesByte(productEntity.getImages());
            //dto.setImages(new String(productEntity.getImages(), "UTF-8").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();

        try {
            productEntity.setName(productDTO.getName());
            productEntity.setDescription(productDTO.getDescription());
            productEntity.setGender(productDTO.getGender());
            productEntity.setLongevity(productDTO.getLongevity());
            productEntity.setStyle(productDTO.getStyle());
            productEntity.setNewRelease(productDTO.isNewRelease());
            productEntity.setHotTrend(productDTO.isHotTrend());
            productEntity.setBestSeller(productDTO.isBestSeller());
            productEntity.setSeasonal(productDTO.isSeasonal());

            if(productDTO.getIncenseGroup().getId() != null){
                productEntity.setIncenseGroup(incenseGroupRepository.findOne(productDTO.getIncenseGroup().getId()));
            }else{
                productEntity.setIncenseGroup(incenseGroupConverter.toEntity(productDTO.getIncenseGroup()));
            }

            //productEntity.setSalePrice(productDTO.getSale_price());
            //productEntity.setPurchasePrice(productDTO.getPurchase_price());
            //productEntity.setImages(productDTO.getImagesByte());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productEntity;
    }

    public ProductEntity toEntity(ProductDTO productDTO, ProductEntity productEntity) {

        try {

            productEntity.setName(productDTO.getName());
            productEntity.setDescription(productDTO.getDescription());
            productEntity.setGender(productDTO.getGender());
            productEntity.setLongevity(productDTO.getLongevity());
            productEntity.setStyle(productDTO.getStyle());
            productEntity.setNewRelease(productDTO.isNewRelease());
            productEntity.setHotTrend(productDTO.isHotTrend());
            productEntity.setBestSeller(productDTO.isBestSeller());
            productEntity.setSeasonal(productDTO.isSeasonal());

            if(productDTO.getIncenseGroup().getId() != null){
                productEntity.setIncenseGroup(incenseGroupRepository.findOne(productDTO.getIncenseGroup().getId()));
            }else{
                productEntity.setIncenseGroup(incenseGroupConverter.toEntity(productDTO.getIncenseGroup()));
            }

            //productEntity.setName(productDTO.getName());
            //productEntity.setPurchasePrice(productDTO.getPurchase_price());
            //productEntity.setSalePrice(productDTO.getSale_price());
            //productEntity.setDescription(productDTO.getDescription());
            //productEntity.setImages(productDTO.getImagesByte());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productEntity;
    }
}
