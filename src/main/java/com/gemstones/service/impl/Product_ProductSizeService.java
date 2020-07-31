package com.gemstones.service.impl;

import com.gemstones.converter.ProductConverter;
import com.gemstones.converter.ProductSizeConverter;
import com.gemstones.converter.Product_ProductSizeConverter;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.entity.Product_ProductSizeEntity;
import com.gemstones.repository.ProductRepository;
import com.gemstones.repository.ProductSizeRepository;
import com.gemstones.repository.Product_ProductSizeRepository;
import com.gemstones.service.IProduct_ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class Product_ProductSizeService implements IProduct_ProductSizeService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Autowired
    private ProductSizeConverter productSizeConverter;

    @Autowired
    private Product_ProductSizeRepository product_productSizeRepository;

    @Autowired
    private Product_ProductSizeConverter product_productSizeConverter;

    /*@Override
    public List<Product_ProductSizeDTO> findAllByGender(Pageable pageable, int condition) {
        // Nam condition= 1;
        // Nữ condtion =0;
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeDTO> entities = this.findAllByGenders(condition);

        int page = pageable.getPageNumber(); // page
        int limit = pageable.getPageSize(); // limit
        int count = page * limit;
        int max;
        if (entities.size() < (page + 1) * limit) {
            max = entities.size();
        } else {
            max = (page + 1) * limit;
        }
        for (int i = count; i < max; i++) {
            models.add(entities.get(i));
        }
        return models;
    }

    @Override
    public List<Product_ProductSizeDTO> findAllByGenders(int condition) {
        // Nam condition= 1;
        // Nữ condtion =0;
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAll();

        // Nếu lấy ra ds Nam
        if (condition == 1) {
            for (Product_ProductSizeEntity item :
                    entities) {
                if (item.getProduct().getGender().equals("Nam")) {
                    Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
                    models.add(dto);

                } else {
                    continue;
                }
            }
        } else if (condition == 0) {
            for (Product_ProductSizeEntity item :
                    entities) {
                if (!item.getProduct().getGender().equals("Nam")) {
                    Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
                    models.add(dto);
                } else {
                    continue;
                }
            }
        }
        return models;
    }
*/
    @Override
    public List<Product_ProductSizeDTO> findAll(Pageable pageable) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAll(pageable).getContent();

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<Product_ProductSizeDTO> findAll() {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAllActive();

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<Product_ProductSizeDTO> findAllByProductIdAndStatus(Long id, int status) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = new ArrayList<>();
        if (status == 1) {
            entities = product_productSizeRepository.findByProductIdAndStatus(id, "Đang hoạt động");
        } else if (status == 0) {
            entities = product_productSizeRepository.findByProductIdAndStatus(id, "Ngừng hoạt động");
        } else {
            entities = product_productSizeRepository.findByProductIdAndStatus(id, "Đang hoạt động");
        }

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        models.sort(new Comparator<Product_ProductSizeDTO>() {
            @Override
            public int compare(Product_ProductSizeDTO o1, Product_ProductSizeDTO o2) {
                if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                    return 1;
                } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                    return -1;
                }
                return 0;
            }
        });
        return models;
    }

    /*@Override
    public List<Product_ProductSizeDTO> findAllMiniSizeForMale() {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAllMiniSizeForMale();

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<Product_ProductSizeDTO> findAllMiniSizeByProductId(Long productId) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAllMiniSizeByProductId(productId);

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<Product_ProductSizeDTO> find4GreaterPrice(Double price) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.find4ByNewPriceSaleIsGreaterThan(price);

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<Product_ProductSizeDTO> find4LessPrice(Double price) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.find4ByNewPriceSaleIsLessThan(price);

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

   /* @Override
    public List<Product_ProductSizeDTO> findAllByProductNameAndOrderBy(String searchText, String orderBy) {

        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = product_productSizeRepository.findAllByProductNameAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = product_productSizeRepository.findAllByProductNameAndOrderByDESC(searchText);
        } else if (orderBy.equalsIgnoreCase("size-asc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("size-desc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndOrderByDESC(searchText);
        }
        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }
*/
    @Override
    public List<Product_ProductSizeDTO> findAllByProductNameAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = product_productSizeRepository.findAllByProductNameAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = product_productSizeRepository.findAllByProductNameAndOrderByDESC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("size-asc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equalsIgnoreCase("size-desc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndOrderByDESC(searchText, limit, offset);
        }

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

   /* @Override
    public List<Product_ProductSizeDTO> findAllByProductNameAndGenderAndOrderBy(String searchText, String gender, String orderBy) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = product_productSizeRepository.findAllByProductNameAndGenderAndOrderByASC(searchText, gender);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = product_productSizeRepository.findAllByProductNameAndGenderAndOrderByDESC(searchText, gender);
        } else if (orderBy.equalsIgnoreCase("size-asc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndGenderAndOrderByASC(searchText, gender);
        } else if (orderBy.equalsIgnoreCase("size-desc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndGenderAndOrderByDESC(searchText, gender);
        }
        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<Product_ProductSizeDTO> findAllByProductNameAndGenderAndOrderBy(Pageable pageable, String searchText, String gender, String orderBy) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = product_productSizeRepository.findAllByProductNameAndGenderAndOrderByASC(searchText, gender, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = product_productSizeRepository.findAllByProductNameAndGenderAndOrderByDESC(searchText, gender, limit, offset);
        } else if (orderBy.equalsIgnoreCase("size-asc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndGenderAndOrderByASC(searchText, gender, limit, offset);
        } else if (orderBy.equalsIgnoreCase("size-desc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndGenderAndOrderByDESC(searchText, gender, limit, offset);
        }

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

   /* @Override
    public List<Product_ProductSizeDTO> findAllByProductNameAndStatusAndOrderBy(String searchText, String status, String orderBy) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = product_productSizeRepository.findAllByProductNameAndStatusAndOrderByASC(searchText, status);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = product_productSizeRepository.findAllByProductNameAndStatusAndOrderByDESC(searchText, status);
        } else if (orderBy.equalsIgnoreCase("size-asc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndStatusAndOrderByASC(searchText, status);
        } else if (orderBy.equalsIgnoreCase("size-desc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndStatusAndOrderByDESC(searchText, status);
        }
        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<Product_ProductSizeDTO> findAllByProductNameAndStatusAndOrderBy(Pageable pageable, String searchText, String status, String orderBy) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        List<Product_ProductSizeEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equalsIgnoreCase("asc")) {
            entities = product_productSizeRepository.findAllByProductNameAndStatusAndOrderByASC(searchText, status, limit, offset);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = product_productSizeRepository.findAllByProductNameAndStatusAndOrderByDESC(searchText, status, limit, offset);
        } else if (orderBy.equalsIgnoreCase("size-asc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndStatusAndOrderByASC(searchText, status, limit, offset);
        } else if (orderBy.equalsIgnoreCase("size-desc")) {
            entities = product_productSizeRepository.findAllByProductSizeAndStatusAndOrderByDESC(searchText, status, limit, offset);
        }

        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) product_productSizeRepository.count();
    }

    @Override
    public int getTotalItemByGender(String gender) {
        return product_productSizeRepository.countDistinctByGender(gender);
    }

    @Override
    public int getTotalItemByStatus(String status) {
        return product_productSizeRepository.countDistinctByStatus(status);
    }


    @Override
    public Product_ProductSizeDTO findOneById(Long id) {
        return product_productSizeConverter.toDTO(product_productSizeRepository.findOne(id));
    }

    @Override
    @Transactional
    public Product_ProductSizeDTO save(Product_ProductSizeDTO dto) {
        Product_ProductSizeEntity entity;

        if (dto.getStatus() == null || dto.getStatus().equalsIgnoreCase("")) {
            dto.setStatus("Đang hoạt động");
        }
        dto.setProduct(productConverter.toDTO(productRepository.findOne(dto.getProductId())));
        dto.setProductSize(productSizeConverter.toDTO(productSizeRepository.findOne(dto.getProductSizeId())));

        if (dto.getId() != null) {
            Product_ProductSizeEntity oldProduct = product_productSizeRepository.findOne(dto.getId());
            entity = product_productSizeConverter.toEntity(dto, oldProduct);
        } else {
            entity = product_productSizeConverter.toEntity(dto);
        }
        entity = product_productSizeRepository.save(entity);
        try {
            return product_productSizeConverter.toDTO(entity);
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
            try {
                product_productSizeRepository.delete(id);
            } catch (Exception e) {
                Product_ProductSizeEntity oldProduct = product_productSizeRepository.findOne(id);
                oldProduct.setStatus("Ngừng hoạt động");
                product_productSizeRepository.save(oldProduct);
            }
        }
    }

   /* @Override
    public List<Product_ProductSizeDTO> findTop10ByOrderByLevelDesc(String sortBy) {
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, sortBy);
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAll(sort);

        int count = 0;
        for (Product_ProductSizeEntity item :
                entities) {
            Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
            models.add(dto);
            if (count >= 10)
                break;
            count++;
        }
        return models;
    }

    @Override
    public List<Product_ProductSizeDTO> findTop10ByOrderByLevelDescAndGender(String sortBy, int condition) {
        // Nam condition= 1;
        // Nữ condtion =0;
        List<Product_ProductSizeDTO> models = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, sortBy);
        List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAll(sort);

        int count = 0;
        // Nếu lấy ra ds Nam
        if (condition == 1) {
            for (Product_ProductSizeEntity item :
                    entities) {
                if (item.getProduct().getGender().equals("Nam")) {
                    Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
                    models.add(dto);
                    if (count >= 10)
                        break;
                    count++;
                } else {
                    continue;
                }
            }
        } else if (condition == 0) {
            for (Product_ProductSizeEntity item :
                    entities) {
                if (!item.getProduct().getGender().equals("Nam")) {
                    Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(item);
                    models.add(dto);
                    if (count >= 10)
                        break;
                    count++;
                } else {
                    continue;
                }
            }
        }
        return models;
    }*/

    @Override
    public int getTotalListResult(List<Product_ProductSizeDTO> list) {
        if (list.toArray().length > 0) {
            return list.toArray().length;
        }
        return 0;
    }
}
