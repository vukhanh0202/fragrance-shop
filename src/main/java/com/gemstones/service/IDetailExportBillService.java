package com.gemstones.service;

import com.gemstones.dto.DetailExportBillDTO;
import com.gemstones.dto.ExportBillDTO;
import com.gemstones.entity.ExportBillEntity;

import java.util.List;

public interface IDetailExportBillService {

    DetailExportBillDTO save(DetailExportBillDTO detailExportBillDTO);
    List<DetailExportBillDTO> findAllByExportBill(ExportBillEntity exportBill);
    List<DetailExportBillDTO> findAllByExportBillId(Long exportBillId);
    //List<DetailExportBillDTO> findAllByExportBill(ExportBillDTO exportBill);
    void delete(Long[] ids);
    void delete(List<DetailExportBillDTO> details);
}
