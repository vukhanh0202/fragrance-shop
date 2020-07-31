package com.gemstones.service.impl;

import com.gemstones.converter.ExportBillConverter;
import com.gemstones.converter.Product_ProductSizeConverter;
import com.gemstones.dto.CustomerDTO;
import com.gemstones.dto.DetailExportBillDTO;
import com.gemstones.dto.ExportBillDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.entity.ExportBillEntity;
import com.gemstones.repository.ExportBillRepository;
import com.gemstones.repository.Product_ProductSizeRepository;
import com.gemstones.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExportBillService implements IExportBillService {

    @Autowired
    private Product_ProductSizeRepository product_productSizeRepository;

    @Autowired
    private Product_ProductSizeConverter product_productSizeConverter;

    @Autowired
    private ExportBillRepository exportBillRepository;

    @Autowired
    private ExportBillConverter exportBillConverter;

    @Override
    public ExportBillDTO addCart(Long id, ExportBillDTO oldCart) {
        DetailExportBillDTO detail = null;

        Product_ProductSizeDTO product = product_productSizeConverter.toDTO(product_productSizeRepository.findOne(id));
        List<DetailExportBillDTO> oldList = oldCart.getListResultDetailProduct();
        for (DetailExportBillDTO item :
                oldList) {
            if (item.getProductFullSize().getId() == id) {
                detail = item;
            }
        }
        if (product != null && detail != null) {
            detail.setQuantity(detail.getQuantity() + 1);
            detail.setPrice(detail.getQuantity() * detail.getProductFullSize().getNewPriceSale());
        } else {
            detail = new DetailExportBillDTO();
            detail.setProductFullSize(product);
            detail.setProductFullSizeId(product.getId());
            detail.setQuantity(1L);
            detail.setExportBill(oldCart);
            detail.setExportBillId(oldCart.getId());
            detail.setPrice(product.getNewPriceSale());

            oldList.add(detail);
            oldCart.setListResultDetailProduct(oldList);
        }
        return oldCart;
    }

    @Override
    public ExportBillDTO deleteCart(Long id, ExportBillDTO oldCart) {
        DetailExportBillDTO detail = null;

        List<DetailExportBillDTO> oldList = oldCart.getListResultDetailProduct();
        for (DetailExportBillDTO item :
                oldList) {
            if (item.getProductFullSize().getId() == id) {
                detail = item;
            }
        }
        if (detail != null) {
            oldList.remove(detail);
            oldCart.setListResultDetailProduct(oldList);
        }

        return oldCart;
    }

    @Override
    public ExportBillDTO editCart(Long id, ExportBillDTO oldCart, Long quantity) {
        DetailExportBillDTO detail = null;

        Product_ProductSizeDTO product = product_productSizeConverter.toDTO(product_productSizeRepository.findOne(id));
        List<DetailExportBillDTO> oldList = oldCart.getListResultDetailProduct();
        for (DetailExportBillDTO item :
                oldList) {
            if (item.getProductFullSize().getId() == id) {
                detail = item;
            }
        }
        if (product != null && detail != null) {
            detail.setQuantity(quantity);
            detail.setPrice(detail.getQuantity() * detail.getProductFullSize().getNewPriceSale());
        }
        return oldCart;
    }

    @Override
    public Long getTotalQuantity(ExportBillDTO cart) {
        Long count = 0L;
        for (DetailExportBillDTO item :
                cart.getListResultDetailProduct()) {
            count += item.getQuantity();
        }

        return count;
    }

    @Override
    public Double getTotalPrice(ExportBillDTO cart) {
        Double total = 0d;
        for (DetailExportBillDTO item :
                cart.getListResultDetailProduct()) {
            total += item.getPrice();
        }

        return total;
    }

    @Override
    @Transactional
    public ExportBillDTO save(ExportBillDTO exportBillDTO) {
        ExportBillEntity entity;

        if (exportBillDTO.getId() != null) {
            ExportBillEntity oldEntity = exportBillRepository.findOne(exportBillDTO.getId());
            entity = exportBillConverter.toEntity(exportBillDTO, oldEntity);
        } else {
            entity = exportBillConverter.toEntity(exportBillDTO);
        }
        entity = exportBillRepository.save(entity);
        try {
            return exportBillConverter.toDTO(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ExportBillDTO> findAll(Pageable pageable) {
        List<ExportBillDTO> models = new ArrayList<>();
        List<ExportBillEntity> entities = exportBillRepository.findAll(pageable).getContent();

        for (ExportBillEntity item :
                entities) {
            ExportBillDTO dto = exportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<ExportBillDTO> findAll() {
        List<ExportBillDTO> models = new ArrayList<>();
        List<ExportBillEntity> entities = exportBillRepository.findAll();

        for (ExportBillEntity item :
                entities) {
            ExportBillDTO dto = exportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

 /*   @Override
    public List<ExportBillDTO> findAllByNameAndOrderBy(String searchText, String orderBy) {
        List<ExportBillDTO> models = new ArrayList<>();
        List<ExportBillEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = exportBillRepository.findAllByNameAndOrderByNameASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = exportBillRepository.findAllByNameAndOrderByNameDESC(searchText);
        } else if (orderBy.equalsIgnoreCase("price-asc")) {
            entities = exportBillRepository.findAllByNameAndOrderByPriceASC(searchText);
        } else if (orderBy.equalsIgnoreCase("price-desc")) {
            entities = exportBillRepository.findAllByNameAndOrderByPriceDESC(searchText);
        }

        for (ExportBillEntity item :
                entities) {
            ExportBillDTO dto = exportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ExportBillDTO> findAllByNameAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<ExportBillDTO> models = new ArrayList<>();
        List<ExportBillEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = exportBillRepository.findAllByNameAndOrderByNameASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = exportBillRepository.findAllByNameAndOrderByNameDESC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("price-asc")) {
            entities = exportBillRepository.findAllByNameAndOrderByPriceASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("price-desc")) {
            entities = exportBillRepository.findAllByNameAndOrderByPriceDESC(searchText, limit, offset);
        }

        for (ExportBillEntity item :
                entities) {
            ExportBillDTO dto = exportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

 /*   @Override
    public List<ExportBillDTO> findAllByNameAndStatusAndOrderBy(String searchText, String status, String orderBy) {
        List<ExportBillDTO> models = new ArrayList<>();
        List<ExportBillEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByNameASC(searchText, status);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByNameDESC(searchText, status);
        } else if (orderBy.equalsIgnoreCase("price-asc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByPriceASC(searchText, status);
        } else if (orderBy.equalsIgnoreCase("price-desc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByPriceDESC(searchText, status);
        }

        for (ExportBillEntity item :
                entities) {
            ExportBillDTO dto = exportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ExportBillDTO> findAllByNameAndStatusAndOrderBy(Pageable pageable, String searchText, String status, String orderBy) {
        List<ExportBillDTO> models = new ArrayList<>();
        List<ExportBillEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByNameASC(searchText, status, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByNameDESC(searchText, status, limit, offset);
        } else if (orderBy.equalsIgnoreCase("price-asc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByPriceASC(searchText, status, limit, offset);
        } else if (orderBy.equalsIgnoreCase("price-desc")) {
            entities = exportBillRepository.findAllByNameAndStatusAndOrderByPriceDESC(searchText, status, limit, offset);
        }

        for (ExportBillEntity item :
                entities) {
            ExportBillDTO dto = exportBillConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public ExportBillDTO findOneById(Long id) {
        return exportBillConverter.toDTO(exportBillRepository.findOne(id));
    }

    @Override
    public int getTotalItem() {
        return (int) exportBillRepository.count();
    }

    @Override
    public int getTotalItemByStatus(String status) {
        return exportBillRepository.countDistinctByStatus(status);
    }

    @Override
    public double getSumTotalPrice() {
        return (double) exportBillRepository.getSumTotalPrice();
    }

    @Override
    public double getSumTotalPriceByMonthAndYear(int month, int year) {
        return (double) exportBillRepository.getSumTotalPriceByMonthAndYear(month, year);
    }

    @Override
    @Transactional
    public void doneBill(Long[] ids) {
        for (Long id :
                ids) {
            exportBillRepository.findOne(id).setStatus("Hoàn thành");
        }
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id :
                ids) {
            exportBillRepository.delete(id);
        }
    }
}
