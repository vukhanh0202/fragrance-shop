package com.gemstones.service.impl;

import com.gemstones.converter.DetailExportBillConverter;
import com.gemstones.converter.ExportBillConverter;
import com.gemstones.dto.DetailExportBillDTO;
import com.gemstones.dto.ExportBillDTO;
import com.gemstones.entity.DetailExportBillEntity;
import com.gemstones.entity.ExportBillEntity;
import com.gemstones.repository.DetailExportBillRepository;
import com.gemstones.repository.ExportBillRepository;
import com.gemstones.service.IDetailExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailExportBillService implements IDetailExportBillService {

    @Autowired
    private DetailExportBillRepository detailExportBillRepository;

    @Autowired
    private DetailExportBillConverter detailExportBillConverter;

    @Autowired
    private ExportBillRepository exportBillRepository;

    @Autowired
    private ExportBillConverter exportBillConverter;

    @Override
    @Transactional
    public DetailExportBillDTO save(DetailExportBillDTO detailExportBillDTO) {
        DetailExportBillEntity entity;

        if (detailExportBillDTO.getId() != null) {
            DetailExportBillEntity oldEntity = detailExportBillRepository.findOne(detailExportBillDTO.getId());
            entity = detailExportBillConverter.toEntity(detailExportBillDTO, oldEntity);
        } else {
            entity = detailExportBillConverter.toEntity(detailExportBillDTO);
        }
        entity = detailExportBillRepository.save(entity);
        try{
            return detailExportBillConverter.toDTO(entity);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DetailExportBillDTO> findAllByExportBill(ExportBillEntity exportBill) {
        List<DetailExportBillDTO> models = new ArrayList<>();
        List<DetailExportBillEntity> entities = detailExportBillRepository.findByExportBill(exportBill);

        for (DetailExportBillEntity item :
                entities) {
            DetailExportBillDTO dto = detailExportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<DetailExportBillDTO> findAllByExportBillId(Long exportBillId) {
        List<DetailExportBillDTO> models = new ArrayList<>();
        List<DetailExportBillEntity> entities = detailExportBillRepository.findByExportBill(exportBillRepository.findOne(exportBillId));

        for (DetailExportBillEntity item :
                entities) {
            DetailExportBillDTO dto = detailExportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }


    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            detailExportBillRepository.delete(id);
        }
    }

    @Override
    public void delete(List<DetailExportBillDTO> details) {
        for (DetailExportBillDTO detail :
                details) {
            detailExportBillRepository.delete(detail.getId());
        }
    }
}
