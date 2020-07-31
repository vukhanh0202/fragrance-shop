package com.gemstones.converter;

import com.gemstones.dto.BlogDTO;
import com.gemstones.entity.BlogEntity;
import org.springframework.stereotype.Component;

@Component
public class BlogConverter {

    public BlogDTO toDTO(BlogEntity entity) {
        BlogDTO dto = new BlogDTO();
        try {
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setShortDescription(entity.getShortDescription());
            dto.setContent(entity.getContent());
            dto.setTypeBlog(entity.getTypeBlog());
            dto.setThumbnailByte(entity.getThumbnail());
            dto.setThumbnail(new String(entity.getThumbnail(), "UTF-8").toString());

            dto.setCreatedBy(entity.getCreatedBy());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedBy(entity.getModifiedBy());
            dto.setModifiedDate(entity.getModifiedDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public BlogEntity toEntity(BlogDTO dto) {
        BlogEntity entity = new BlogEntity();

        try {
            entity.setContent(dto.getContent());
            entity.setShortDescription(dto.getShortDescription());
            entity.setTitle(dto.getTitle());
            entity.setTypeBlog(dto.getTypeBlog());
            if (dto.getThumbnailByte() == null) {
                dto.setThumbnailByte(dto.getThumbnail().getBytes());
            }
            entity.setThumbnail(dto.getThumbnailByte());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public BlogEntity toEntity(BlogDTO dto, BlogEntity entity) {

        try {
            entity.setContent(dto.getContent());
            entity.setShortDescription(dto.getShortDescription());
            entity.setTitle(dto.getTitle());
            entity.setTypeBlog(dto.getTypeBlog());
            if (dto.getThumbnailByte() == null && dto.getThumbnail()!=null) {
                dto.setThumbnailByte(dto.getThumbnail().getBytes());
            }
            if (dto.getThumbnailByte() !=null)
            {
                entity.setThumbnail(dto.getThumbnailByte());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
