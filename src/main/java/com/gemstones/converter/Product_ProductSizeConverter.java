package com.gemstones.converter;

import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.entity.Product_ProductSizeEntity;
import com.gemstones.repository.ProductRepository;
import com.gemstones.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Product_ProductSizeConverter {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private ProductSizeConverter productSizeConverter;

    public Product_ProductSizeDTO toDTO(Product_ProductSizeEntity entity) {
        Product_ProductSizeDTO dto = new Product_ProductSizeDTO();
        try {
            dto.setId(entity.getId());
            dto.setImportPrice(entity.getImportPrice());
            dto.setInventory(entity.getInventory());
            dto.setNewPriceSale(entity.getNewPriceSale());
            dto.setOldPriceSale(entity.getOldPriceSale());
            dto.setStatus(entity.getStatus());
            dto.setImagesByte(entity.getImages());
            dto.setImages(new String(entity.getImages(), "UTF-8").toString());

            dto.setProductId(entity.getProduct().getId());
            dto.setProduct(productConverter.toDTO(entity.getProduct()));

            dto.setProductSizeId(entity.getProductSize().getId());
            dto.setProductSize(productSizeConverter.toDTO(entity.getProductSize()));

            dto.setCreatedBy(entity.getCreatedBy());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedBy(entity.getModifiedBy());
            dto.setModifiedDate(entity.getModifiedDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public Product_ProductSizeEntity toEntity(Product_ProductSizeDTO dto) {
        Product_ProductSizeEntity entity = new Product_ProductSizeEntity();
        try {
            entity.setImportPrice(dto.getImportPrice());
            if (dto.getInventory() == null)
            {
                entity.setInventory(0L);
            }else{
                entity.setInventory(dto.getInventory());
            }
            entity.setNewPriceSale(dto.getNewPriceSale());
            entity.setOldPriceSale(dto.getOldPriceSale());
            entity.setStatus(dto.getStatus());
            if (dto.getImagesByte() == null) {
                dto.setImagesByte(dto.getImages().getBytes());
            }
            entity.setImages(dto.getImagesByte());

            if (dto.getProduct().getId() !=null){
                entity.setProduct(productRepository.findOne(dto.getProduct().getId()));
            }else{
                entity.setProduct(productConverter.toEntity(dto.getProduct()));
            }

            if (dto.getProductSize().getId() != null){
                entity.setProductSize(productSizeRepository.findOne(dto.getProductSize().getId()));
            }else{
                entity.setProductSize(productSizeConverter.toEntity(dto.getProductSize()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public Product_ProductSizeEntity toEntity(Product_ProductSizeDTO dto, Product_ProductSizeEntity entity) {
        try {
            entity.setImportPrice(dto.getImportPrice());
            if (dto.getInventory() == null)
            {
                entity.setInventory(0L);
            }else{
                entity.setInventory(dto.getInventory());
            }
            entity.setNewPriceSale(dto.getNewPriceSale());
            entity.setOldPriceSale(dto.getOldPriceSale());
            entity.setStatus(dto.getStatus());
            if (dto.getImagesByte() == null && dto.getImages()!=null) {
                dto.setImagesByte(dto.getImages().getBytes());
            }
            if (dto.getImagesByte() !=null)
            {
                entity.setImages(dto.getImagesByte());
            }

            if (dto.getProduct().getId() != null){
                entity.setProduct(productRepository.findOne(dto.getProduct().getId()));
            }else{
                entity.setProduct(productConverter.toEntity(dto.getProduct()));
            }

            if (dto.getProductSize().getId() != null){
                entity.setProductSize(productSizeRepository.findOne(dto.getProductSize().getId()));
            }else{
                entity.setProductSize(productSizeConverter.toEntity(dto.getProductSize()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
