package com.gemstones.service.impl;

import com.gemstones.converter.IncenseGroupConverter;
import com.gemstones.dto.IncenseGroupDTO;
import com.gemstones.entity.IncenseGroupEntity;
import com.gemstones.repository.IncenseGroupRepository;
import com.gemstones.service.IIncenseGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncenseGroupService implements IIncenseGroupService {


    @Autowired
    private IncenseGroupRepository incenseGroupRepository;

    @Autowired
    private IncenseGroupConverter incenseGroupConverter;

    @Override
    public List<IncenseGroupDTO> findAll() {
        List<IncenseGroupDTO> models = new ArrayList<>();
        List<IncenseGroupEntity> entities = incenseGroupRepository.findAll();

        for (IncenseGroupEntity item :
                entities) {
            IncenseGroupDTO dto = incenseGroupConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<IncenseGroupDTO> findAll(Pageable pageable) {
        List<IncenseGroupDTO> models = new ArrayList<>();
        List<IncenseGroupEntity> entities = incenseGroupRepository.findAll(pageable).getContent();

        for (IncenseGroupEntity item :
                entities) {
            IncenseGroupDTO dto = incenseGroupConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

  /*  @Override
    public List<IncenseGroupDTO> findAllByNameAndOrderBy(String searchText, String orderBy) {
        List<IncenseGroupDTO> models = new ArrayList<>();
        List<IncenseGroupEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = incenseGroupRepository.findAllByNameAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = incenseGroupRepository.findAllByNameAndOrderByDESC(searchText);
        }

        for (IncenseGroupEntity item :
                entities) {
            IncenseGroupDTO dto = incenseGroupConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }
*/
    @Override
    public List<IncenseGroupDTO> findAllByNameAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<IncenseGroupDTO> models = new ArrayList<>();
        List<IncenseGroupEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = incenseGroupRepository.findAllByNameAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = incenseGroupRepository.findAllByNameAndOrderByDESC(searchText, limit, offset);
        }


        for (IncenseGroupEntity item :
                entities) {
            IncenseGroupDTO dto = incenseGroupConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) incenseGroupRepository.count();
    }

    @Override
    public IncenseGroupDTO findOneById(Long id) {
        return incenseGroupConverter.toDTO(incenseGroupRepository.findOne(id));
    }

    @Override
    @Transactional
    public IncenseGroupDTO save(IncenseGroupDTO dto) {
        IncenseGroupEntity entity;

        if (dto.getId() != null) {
            IncenseGroupEntity oldEntity = incenseGroupRepository.findOne(dto.getId());
            entity = incenseGroupConverter.toEntity(dto, oldEntity);
        } else {
            entity = incenseGroupConverter.toEntity(dto);
        }
        entity = incenseGroupRepository.save(entity);
        try {
            return incenseGroupConverter.toDTO(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            incenseGroupRepository.delete(id);
        }
    }
}
