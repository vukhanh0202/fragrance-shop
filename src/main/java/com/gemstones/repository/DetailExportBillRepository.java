package com.gemstones.repository;

import com.gemstones.dto.ExportBillDTO;
import com.gemstones.entity.DetailExportBillEntity;
import com.gemstones.entity.ExportBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailExportBillRepository extends JpaRepository<DetailExportBillEntity, Long> {

    List<DetailExportBillEntity> findByExportBill(ExportBillEntity exportBill);
}
