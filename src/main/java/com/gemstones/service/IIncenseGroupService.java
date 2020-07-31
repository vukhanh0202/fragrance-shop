package com.gemstones.service;

import com.gemstones.dto.IncenseGroupDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IIncenseGroupService {

    List<IncenseGroupDTO> findAll();
    List<IncenseGroupDTO> findAll(Pageable pageable);
    //List<IncenseGroupDTO> findAllByNameAndOrderBy(String searchText, String orderBy);
    List<IncenseGroupDTO> findAllByNameAndOrderBy(Pageable pageable, String searchText, String orderBy);
    int getTotalItem();
    IncenseGroupDTO findOneById(Long id);
    IncenseGroupDTO save(IncenseGroupDTO productDTO);
    void delete(Long[] ids);
}
