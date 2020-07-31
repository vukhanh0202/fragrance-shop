package com.gemstones.service;

import com.gemstones.dto.BlogDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    BlogDTO save(BlogDTO blogDTO);
    int getTotalItem();
    int getTotalItemByTypeBlog(String typeBlog);
    //List<BlogDTO> findAllByTitleAndOrderBy(String searchText, String orderBy);
    List<BlogDTO> findAllByTitleAndOrderBy(Pageable pageable, String searchText, String orderBy);
    //List<BlogDTO> findAllByTitleAndTypeBlogAndOrderBy(String searchText, String typeBlog, String orderBy);
    List<BlogDTO> findAllByTitleAndTypeBlogAndOrderBy(Pageable pageable, String searchText, String typeBlog, String orderBy);
    List<BlogDTO> findTop10ByTypeBlogAndOrOrderByModifiedDate(String typeBlog);
    BlogDTO findOneById(Long id);
    void delete(Long[] ids);
}
