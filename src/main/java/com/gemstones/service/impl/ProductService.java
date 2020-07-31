package com.gemstones.service.impl;

import com.gemstones.converter.IncenseGroupConverter;
import com.gemstones.converter.ProductConverter;
import com.gemstones.converter.Product_ProductSizeConverter;
import com.gemstones.dto.ProductDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.entity.ProductEntity;
import com.gemstones.entity.ProductSizeEntity;
import com.gemstones.entity.Product_ProductSizeEntity;
import com.gemstones.repository.IncenseGroupRepository;
import com.gemstones.repository.ProductRepository;
import com.gemstones.repository.Product_ProductSizeRepository;
import com.gemstones.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private IncenseGroupRepository incenseGroupRepository;

    @Autowired
    private IncenseGroupConverter incenseGroupConverter;

    @Autowired
    private Product_ProductSizeRepository product_productSizeRepository;

    @Autowired
    private Product_ProductSizeConverter product_productSizeConverter;


   /* @Override
    public List<ProductDTO> findAllBySearchText(String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities =new ArrayList<>();

        for (ProductEntity item :
                entities) {
            if (product_productSizeRepository.findByProductIdAndStatus(item.getId(), "Đang hoạt động").size() > 0) {
                ProductDTO dto = productConverter.toDTO(item);
                models.add(dto);
            }
        }

        if (orderBy.equals("asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) {
                        return 1;
                    } else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) {
                        return -1;
                    } else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("price-asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    List<Product_ProductSizeEntity> listo1 = product_productSizeRepository.findByProductIdAndStatus(o1.getId(), "Đang hoạt động");
                    listo1.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o1Price = listo1.get(0).getNewPriceSale();

                    List<Product_ProductSizeEntity> listo2 = product_productSizeRepository.findByProductIdAndStatus(o2.getId(), "Đang hoạt động");
                    listo2.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o2Price = listo2.get(0).getNewPriceSale();

                    if (o1Price > o2Price) {
                        return 1;
                    } else if (o1Price < o2Price) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("price-desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    List<Product_ProductSizeEntity> listo1 = product_productSizeRepository.findByProductIdAndStatus(o1.getId(), "Đang hoạt động");
                    listo1.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o1Price = listo1.get(0).getNewPriceSale();

                    List<Product_ProductSizeEntity> listo2 = product_productSizeRepository.findByProductIdAndStatus(o2.getId(), "Đang hoạt động");
                    listo2.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o2Price = listo2.get(0).getNewPriceSale();

                    if (o1Price > o2Price) {
                        return -1;
                    } else if (o1Price < o2Price) {
                        return 1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("date-asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) > 0) {
                        return 1;
                    } else if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("date-desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) < 0) {
                        return 1;
                    } else if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) > 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
        return models;
    }*/

    @Override
    public List<ProductDTO> findAllBySearchText(Pageable pageable, String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findByNameContainingIgnoreCaseAndOrderByNameAsc(searchText, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findByNameContainingIgnoreCaseAndOrderByNameDesc(searchText, limit, offset);
        } else {
            entities = productRepository.findByNameContainingIgnoreCaseAndOrderByNameAsc(searchText, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<ProductDTO> findAllByGender(Pageable pageable, int condition, String orderBy) {

        // Nam condition= 1;
        // Nữ condtion =0;
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();
        String gender = "Nam";
        if (condition == 1) {
            gender = "Nam";
        } else if (condition == 0) {
            gender = "Nữ";
        }
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByPageableAndGenderAndOrderByNameASC(gender, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByPageableAndGenderAndOrderByNameDESC(gender, limit, offset);
        } else {
            entities = productRepository.findAllByPageableAndGenderAndOrderByNameDESC(gender, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }

        return models;
    }

   /* @Override
    public List<ProductDTO> findAllByGenders(int condition, String orderBy) {

        // Nam condition= 1;
        // Nữ condtion =0;
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll();

        // Nếu lấy ra ds Nam
        if (condition == 1) {
            for (ProductEntity item :
                    entities) {
                if (product_productSizeRepository.findByProductIdAndStatus(item.getId(), "Đang hoạt động").size() > 0) {
                    if (item.getGender().equals("Nam")) {
                        ProductDTO dto = productConverter.toDTO(item);
                        models.add(dto);
                    } else {
                        continue;
                    }
                }
            }
        } else if (condition == 0) {
            for (ProductEntity item :
                    entities) {

                if (product_productSizeRepository.findByProductIdAndStatus(item.getId(), "Đang hoạt động").size() > 0) {
                    if (!item.getGender().equals("Nam")) {
                        ProductDTO dto = productConverter.toDTO(item);
                        models.add(dto);
                    } else {
                        continue;
                    }
                }

            }
        }


        if (orderBy.equals("asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) {
                        return 1;
                    } else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) {
                        return -1;
                    } else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("price-asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    List<Product_ProductSizeEntity> listo1 = product_productSizeRepository.findByProductIdAndStatus(o1.getId(), "Đang hoạt động");
                    listo1.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o1Price = listo1.get(0).getNewPriceSale();

                    List<Product_ProductSizeEntity> listo2 = product_productSizeRepository.findByProductIdAndStatus(o2.getId(), "Đang hoạt động");
                    listo2.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o2Price = listo2.get(0).getNewPriceSale();

                    if (o1Price > o2Price) {
                        return 1;
                    } else if (o1Price < o2Price) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("price-desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    List<Product_ProductSizeEntity> listo1 = product_productSizeRepository.findByProductIdAndStatus(o1.getId(), "Đang hoạt động");
                    listo1.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o1Price = listo1.get(0).getNewPriceSale();

                    List<Product_ProductSizeEntity> listo2 = product_productSizeRepository.findByProductIdAndStatus(o2.getId(), "Đang hoạt động");
                    listo2.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o2Price = listo2.get(0).getNewPriceSale();

                    if (o1Price > o2Price) {
                        return -1;
                    } else if (o1Price < o2Price) {
                        return 1;
                    }
                    return 0;
                }
            });
        }
        return models;
    }*/

    @Override
    public List<ProductDTO> findAllByNewRelease() {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAllByNewRelease();


        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<ProductDTO> findAllByBestSeller() {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAllByBestSeller();


        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<ProductDTO> findAllByHotTrend() {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAllByHotTrend();


        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    @Override
    public List<ProductDTO> findAllBySeasonal() {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAllBySeasonal();


        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    /*Đã chỉnh*/
    @Override
    public List<ProductDTO> findAll(Pageable pageable, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByPageableAndOrderByNameASC(limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByPageableAndOrderByNameDESC(limit, offset);
        } else {
            entities = productRepository.findAllByPageableAndOrderByNameASC(limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }

        return models;
    }

  /*  @Override
    public List<ProductDTO> findAll(String orderBy) {

        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll();

        for (ProductEntity item :
                entities) {
            if (product_productSizeRepository.findByProductIdAndStatus(item.getId(), "Đang hoạt động").size() > 0) {
                ProductDTO dto = productConverter.toDTO(item);
                models.add(dto);
            }
        }

        if (orderBy.equals("asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) {
                        return 1;
                    } else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) {
                        return -1;
                    } else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("price-asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    List<Product_ProductSizeEntity> listo1 = product_productSizeRepository.findByProductIdAndStatus(o1.getId(), "Đang hoạt động");
                    listo1.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o1Price = listo1.get(0).getNewPriceSale();

                    List<Product_ProductSizeEntity> listo2 = product_productSizeRepository.findByProductIdAndStatus(o2.getId(), "Đang hoạt động");
                    listo2.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o2Price = listo2.get(0).getNewPriceSale();

                    if (o1Price > o2Price) {
                        return 1;
                    } else if (o1Price < o2Price) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("price-desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    List<Product_ProductSizeEntity> listo1 = product_productSizeRepository.findByProductIdAndStatus(o1.getId(), "Đang hoạt động");
                    listo1.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o1Price = listo1.get(0).getNewPriceSale();

                    List<Product_ProductSizeEntity> listo2 = product_productSizeRepository.findByProductIdAndStatus(o2.getId(), "Đang hoạt động");
                    listo2.sort(new Comparator<Product_ProductSizeEntity>() {
                        @Override
                        public int compare(Product_ProductSizeEntity o1, Product_ProductSizeEntity o2) {
                            if (o1.getNewPriceSale() > o2.getNewPriceSale()) {
                                return 1;
                            } else if (o1.getNewPriceSale() < o2.getNewPriceSale()) {
                                return -1;
                            }
                            return 0;
                        }
                    });
                    Double o2Price = listo2.get(0).getNewPriceSale();

                    if (o1Price > o2Price) {
                        return -1;
                    } else if (o1Price < o2Price) {
                        return 1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("date-asc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) > 0) {
                        return 1;
                    } else if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (orderBy.equals("date-desc")) {
            models.sort(new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO o1, ProductDTO o2) {
                    if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) < 0) {
                        return 1;
                    } else if (o1.getModifiedDate().compareTo(o2.getModifiedDate()) > 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
        return models;
    }*/

   /* @Override
    public List<ProductDTO> findAll(Pageable pageable) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll(pageable).getContent();

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }

        return models;
    }*/

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll();


        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    /* @Override
     public List<ProductDTO> findAllMiniSize(String orderBy) {
         List<ProductDTO> listProduct = this.findAll(orderBy);
         List<ProductDTO> arrRemove = new ArrayList<>();
         for (ProductDTO item :
                 listProduct) {
             List<Product_ProductSizeDTO> models = new ArrayList<>();
             List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAllMiniSizeByProductId(item.getId());

             for (Product_ProductSizeEntity itemEntity :
                     entities) {
                 Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(itemEntity);
                 models.add(dto);
             }
             if (entities.size() == 0) {
                 arrRemove.add(item);
             } else {
                 item.setListResultAllProduct(models);
             }
         }
         for (ProductDTO item :
                 arrRemove) {
             listProduct.remove(item);
         }
         return listProduct;
     }
 */
    @Override
    public List<ProductDTO> findAllMiniSize(Pageable pageable, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllMiniByPageableAndOrderByNameASC(limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllMiniByPageableAndOrderByNameDESC(limit, offset);
        } else {
            entities = productRepository.findAllMiniByPageableAndOrderByNameASC(limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

    /*@Override
    public List<ProductDTO> findAllMiniSizeByGender(int gender, String orderBy) {
        List<ProductDTO> listProduct = this.findAllByGenders(gender, orderBy);
        List<ProductDTO> arrRemove = new ArrayList<>();
        for (ProductDTO item :
                listProduct) {
            List<Product_ProductSizeDTO> models = new ArrayList<>();
            List<Product_ProductSizeEntity> entities = product_productSizeRepository.findAllMiniSizeByProductId(item.getId());

            for (Product_ProductSizeEntity itemEntity :
                    entities) {
                Product_ProductSizeDTO dto = product_productSizeConverter.toDTO(itemEntity);
                models.add(dto);
            }
            if (entities.size() == 0) {
                arrRemove.add(item);
            } else {
                item.setListResultAllProduct(models);
            }
        }
        for (ProductDTO item :
                arrRemove) {
            listProduct.remove(item);
        }
        return listProduct;
    }*/

    @Override
    public List<ProductDTO> findAllMiniSizeByGender(Pageable pageable, int gender, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        String genders = "Nam";
        if (gender == 1) {
            genders = "Nam";
        } else if (gender == 0) {
            genders = "Nữ";
        }
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllMiniByPageableAndGenderAndOrderByNameASC(genders, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllMiniByPageableAndGenderAndOrderByNameDESC(genders, limit, offset);
        } else {
            entities = productRepository.findAllMiniByPageableAndGenderAndOrderByNameASC(genders, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }

  /*  @Override
    public List<ProductDTO> findAllByProductNameAndOrderBy(String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = productRepository.findAllByProductNameAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = productRepository.findAllByProductNameAndOrderByDESC(searchText);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ProductDTO> findAllByProductNameAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByProductNameAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByProductNameAndOrderByDESC(searchText, limit, offset);
        } else {
            entities = productRepository.findAllByProductNameAndOrderByASC(searchText, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            dto.setTotalProductSize(productRepository.countTotalProductSize(dto.getId()));
            models.add(dto);
        }
        return models;
    }

   /* @Override
    public List<ProductDTO> findAllByProductNameAndGenderAndOrderBy(String searchText, String gender, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = productRepository.findAllByProductNameAndGenderAndOrderByASC(searchText, gender);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = productRepository.findAllByProductNameAndGenderAndOrderByDESC(searchText, gender);
        }
        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ProductDTO> findAllByProductNameAndGenderAndOrderBy(Pageable pageable, String searchText, String gender, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByProductNameAndGenderAndOrderByASC(searchText, gender, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByProductNameAndGenderAndOrderByDESC(searchText, gender, limit, offset);
        } else {
            entities = productRepository.findAllByProductNameAndGenderAndOrderByASC(searchText, gender, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            dto.setTotalProductSize(productRepository.countTotalProductSize(dto.getId()));
            models.add(dto);
        }
        return models;
    }

  /*  @Override
    public List<ProductDTO> findAllByProductNameAndBestSellerAndOrderBy(String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = productRepository.findAllByProductNameAndBestSellerAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = productRepository.findAllByProductNameAndBestSellerAndOrderByDESC(searchText);
        }
        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ProductDTO> findAllByProductNameAndBestSellerAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByProductNameAndBestSellerAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByProductNameAndBestSellerAndOrderByDESC(searchText, limit, offset);
        } else {
            entities = productRepository.findAllByProductNameAndBestSellerAndOrderByASC(searchText, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            dto.setTotalProductSize(productRepository.countTotalProductSize(dto.getId()));
            models.add(dto);
        }
        return models;
    }

    /* @Override
     public List<ProductDTO> findAllByProductNameAndHotTrendAndOrderBy(String searchText, String orderBy) {
         List<ProductDTO> models = new ArrayList<>();
         List<ProductEntity> entities = new ArrayList<>();

         if (orderBy.equalsIgnoreCase("asc")) {
             entities = productRepository.findAllByProductNameAndHotTrendAndOrderByASC(searchText);
         } else if (orderBy.equalsIgnoreCase("desc")) {
             entities = productRepository.findAllByProductNameAndHotTrendAndOrderByDESC(searchText);
         }
         for (ProductEntity item :
                 entities) {
             ProductDTO dto = productConverter.toDTO(item);
             models.add(dto);
         }
         return models;
     }
 */
    @Override
    public List<ProductDTO> findAllByProductNameAndHotTrendAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByProductNameAndHotTrendAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByProductNameAndHotTrendAndOrderByDESC(searchText, limit, offset);
        } else {
            entities = productRepository.findAllByProductNameAndHotTrendAndOrderByASC(searchText, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            dto.setTotalProductSize(productRepository.countTotalProductSize(dto.getId()));
            models.add(dto);
        }
        return models;
    }

  /*  @Override
    public List<ProductDTO> findAllByProductNameAndSeasonalAndOrderBy(String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = productRepository.findAllByProductNameAndSeasonalAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = productRepository.findAllByProductNameAndSeasonalAndOrderByDESC(searchText);
        }
        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ProductDTO> findAllByProductNameAndSeasonalAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByProductNameAndSeasonalAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByProductNameAndSeasonalAndOrderByDESC(searchText, limit, offset);
        } else {
            entities = productRepository.findAllByProductNameAndSeasonalAndOrderByASC(searchText, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            dto.setTotalProductSize(productRepository.countTotalProductSize(dto.getId()));
            models.add(dto);
        }
        return models;
    }

   /* @Override
    public List<ProductDTO> findAllByProductNameAndNewReleaseAndOrderBy(String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        if (orderBy.equalsIgnoreCase("asc")) {
            entities = productRepository.findAllByProductNameAndNewReleaseAndOrderByASC(searchText);
        } else if (orderBy.equalsIgnoreCase("desc")) {
            entities = productRepository.findAllByProductNameAndNewReleaseAndOrderByDESC(searchText);
        }
        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            models.add(dto);
        }
        return models;
    }*/

    @Override
    public List<ProductDTO> findAllByProductNameAndNewReleaseAndOrderBy(Pageable pageable, String searchText, String orderBy) {
        List<ProductDTO> models = new ArrayList<>();
        List<ProductEntity> entities = new ArrayList<>();

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        if (orderBy.equals("asc")) {
            entities = productRepository.findAllByProductNameAndNewReleaseAndOrderByASC(searchText, limit, offset);
        } else if (orderBy.equals("desc")) {
            entities = productRepository.findAllByProductNameAndNewReleaseAndOrderByDESC(searchText, limit, offset);
        } else {
            entities = productRepository.findAllByProductNameAndNewReleaseAndOrderByASC(searchText, limit, offset);
        }

        for (ProductEntity item :
                entities) {
            ProductDTO dto = productConverter.toDTO(item);
            dto.setTotalProductSize(productRepository.countTotalProductSize(dto.getId()));
            models.add(dto);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) productRepository.count();
    }

    @Override
    public int getTotalItemActive() {
        return (int) productRepository.countProductActive();
    }

    @Override
    public int getTotalItemByGender(String gender) {
        return productRepository.countDistinctByGender(gender);
    }

    @Override
    public int getTotalItemMini() {
        return productRepository.countAllMiniSize();
    }

    @Override
    public int getTotalItemMiniByGender(String gender) {
        return productRepository.countAllMiniSizeByGender(gender);
    }

    @Override
    public int getTotalItemBySearch(String searchText) {
        return productRepository.countTotalItemBySearch(searchText);
    }

    @Override
    public int getTotalItemByBestSeller() {
        return productRepository.countDistinctByBestSeller();
    }

    @Override
    public int getTotalItemByHotTrend() {
        return productRepository.countDistinctByHotTrend();
    }

    @Override
    public int getTotalItemByNewRelease() {
        return productRepository.countDistinctByNewRelease();
    }

    @Override
    public int getTotalItemBySeasonal() {
        return productRepository.countDistinctBySeasonal();
    }

    @Override
    public ProductDTO findOneById(Long id) {
        return productConverter.toDTO(productRepository.findOne(id));
    }

    @Override
    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity;

        productDTO.setIncenseGroup(incenseGroupConverter.toDTO(incenseGroupRepository.findOne(productDTO.getIncenseGroupId())));

        if (productDTO.getId() != null) {
            ProductEntity oldProduct = productRepository.findOne(productDTO.getId());
            productEntity = productConverter.toEntity(productDTO, oldProduct);
        } else {
            productEntity = productConverter.toEntity(productDTO);
        }
        productEntity = productRepository.save(productEntity);
        try {
            return productConverter.toDTO(productEntity);
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
            productRepository.delete(id);
        }
    }
}
