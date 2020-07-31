package com.gemstones.service.impl;

import com.gemstones.converter.BlogConverter;
import com.gemstones.dto.BlogDTO;
import com.gemstones.entity.BlogEntity;
import com.gemstones.repository.BlogRepository;
import com.gemstones.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogConverter blogConverter;

    @Override
    @Transactional
    public BlogDTO save(BlogDTO blogDTO) {
        BlogEntity entity;

        if (blogDTO.getTypeBlog() == null || blogDTO.getTypeBlog().equalsIgnoreCase("")) {
            blogDTO.setTypeBlog("Kiến thức nước hoa");
        }

        if (blogDTO.getId() != null) {
            BlogEntity oldEntity = blogRepository.findOne(blogDTO.getId());
            entity = blogConverter.toEntity(blogDTO, oldEntity);
        } else {
            entity = blogConverter.toEntity(blogDTO);
        }
        entity = blogRepository.save(entity);
        try {
            return blogConverter.toDTO(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getTotalItem() {
        return (int) blogRepository.count();
    }

    @Override
    public int getTotalItemByTypeBlog(String typeBlog) {
        return blogRepository.countDistinctByTypeBlog(typeBlog);
    }

 /*   @Override
    public List<BlogDTO> findAllByTitleAndOrderBy(String searchText, String orderBy) {
        List<BlogDTO> models = new ArrayList<>();
        List<BlogEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = blogRepository.findAllByTitleAndOrderByNameASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = blogRepository.findAllByTitleAndOrderByNameDESC(searchText);
        }

        for (BlogEntity item :
                entities) {
            BlogDTO dto = blogConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<BlogDTO> findAllByTitleAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<BlogDTO> models = new ArrayList<>();
        List<BlogEntity> entities = new ArrayList<>();
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = blogRepository.findAllByTitleAndOrderByNameASC(searchText, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = blogRepository.findAllByTitleAndOrderByNameDESC(searchText, limit, offset);
        } else {
            entities = blogRepository.findAllByTitleAndOrderByNameASC(searchText, limit, offset);
        }

        for (BlogEntity item :
                entities) {
            BlogDTO dto = blogConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

 /*   @Override
    public List<BlogDTO> findAllByTitleAndTypeBlogAndOrderBy(String searchText, String typeBlog, String orderBy) {
        List<BlogDTO> models = new ArrayList<>();
        List<BlogEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = blogRepository.findAllByTitleAndTypeBlogAndOrderByNameASC(searchText, typeBlog);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = blogRepository.findAllByTitleAndTypeBlogAndOrderByNameDESC(searchText, typeBlog);
        }

        for (BlogEntity item :
                entities) {
            BlogDTO dto = blogConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<BlogDTO> findAllByTitleAndTypeBlogAndOrderBy(Pageable pageable, String searchText, String typeBlog, String orderBy) {
        List<BlogDTO> models = new ArrayList<>();
        List<BlogEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = blogRepository.findAllByTitleAndTypeBlogAndOrderByNameASC(searchText, typeBlog, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = blogRepository.findAllByTitleAndTypeBlogAndOrderByNameDESC(searchText, typeBlog, limit, offset);
        } else {
            entities = blogRepository.findAllByTitleAndTypeBlogAndOrderByNameASC(searchText, typeBlog, limit, offset);
        }

        for (BlogEntity item :
                entities) {
            BlogDTO dto = blogConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<BlogDTO> findTop10ByTypeBlogAndOrOrderByModifiedDate(String typeBlog) {
        List<BlogDTO> models = new ArrayList<>();
        List<BlogEntity> entities = new ArrayList<>();

        entities = blogRepository.findAllByTypeBlogAndOrOrderByModifiedDate(typeBlog);

        for (BlogEntity item :
                entities) {
            BlogDTO dto = blogConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public BlogDTO findOneById(Long id) {
        return blogConverter.toDTO(blogRepository.findOne(id));
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            blogRepository.delete(id);
        }
    }
}
