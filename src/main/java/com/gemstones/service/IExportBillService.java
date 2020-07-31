package com.gemstones.service;

import com.gemstones.dto.CustomerDTO;
import com.gemstones.dto.ExportBillDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExportBillService {

    ExportBillDTO addCart(Long id, ExportBillDTO oldCart);

    ExportBillDTO deleteCart(Long id, ExportBillDTO oldCart);

    ExportBillDTO editCart(Long id, ExportBillDTO oldCart, Long quantity);

    Long getTotalQuantity(ExportBillDTO cart);

    Double getTotalPrice(ExportBillDTO cart);

    ExportBillDTO save(ExportBillDTO exportBillDTO);

    List<ExportBillDTO> findAll(Pageable pageable);

    List<ExportBillDTO> findAll();

    List<ExportBillDTO> findAllByNameAndOrderBy(Pageable pageable, String searchText, String orderBy);


    List<ExportBillDTO> findAllByNameAndStatusAndOrderBy(Pageable pageable, String searchText, String status, String orderBy);

    ExportBillDTO findOneById(Long id);

    int getTotalItem();
    int getTotalItemByStatus(String status);

    double getSumTotalPrice();
    double getSumTotalPriceByMonthAndYear(int month, int year);

    void doneBill(Long[] ids);

    void delete(Long[] ids);
}
