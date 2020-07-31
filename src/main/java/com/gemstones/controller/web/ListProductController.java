package com.gemstones.controller.web;

import com.gemstones.dto.ProductDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.service.IProductService;
import com.gemstones.service.IProduct_ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "listProductControllerOfWeb")
public class ListProductController extends BaseController {

    @Autowired
    private IProduct_ProductSizeService product_productSizeService;

    @Autowired
    private IProductService productService;


    @RequestMapping(value = "/tat-ca", method = RequestMethod.GET)
    public ModelAndView listProduct(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                    @RequestParam(value = "orderby", required = false) String orderby, HttpServletRequest req) {
        if (orderby == null) {
            orderby = "default";
        }
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);

        String title = "Nước hoa Pháp";
        String titleTab = "Nước hoa Pháp - 4S Perfume";
        Pageable pageable = new PageRequest(page - 1, limit);

        List<ProductDTO> listTemp = productService.findAll(pageable, orderby);
        List<ProductDTO> listRemove = new ArrayList<>();

        for (ProductDTO item :
                listTemp) {
            List<Product_ProductSizeDTO> arr = product_productSizeService.findAllByProductIdAndStatus(item.getId(),1);
            if (arr.size() == 0) {
                listRemove.add(item);
            } else {
                item.setListResultAllProduct(arr);
            }
        }

        for (ProductDTO item :
                listRemove) {
            listTemp.remove(item);
        }

        model.setListResult(listTemp);
        model.setTotalItem(productService.getTotalItemActive());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

        model.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getId(),1));
        model.setOrderBy(orderby);

        mav.setViewName("web/listProduct");

        mav.addObject("title", title);
        mav.addObject("titleTab", titleTab);
        mav.addObject("model", model);

        return mav;
    }

    @RequestMapping(value = "/nuoc-hoa-nam", method = RequestMethod.GET)
    public ModelAndView listMaleProduct(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                        @RequestParam(value = "orderby", required = false) String orderby, HttpServletRequest req) {
        if (orderby == null) {
            orderby = "default";
        }
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);

        String title = "Nước hoa Nam";
        String titleTab = "Nước hoa Nam - 4S Perfume";
        Pageable pageable = new PageRequest(page - 1, limit);


        List<ProductDTO> listTemp = productService.findAllByGender(pageable, 1, orderby);
        List<ProductDTO> listRemove = new ArrayList<>();

        for (ProductDTO item :
                listTemp) {
            List<Product_ProductSizeDTO> arr = product_productSizeService.findAllByProductIdAndStatus(item.getId(),1);
            if (arr.size() == 0) {
                listRemove.add(item);
            } else {
                item.setListResultAllProduct(arr);
            }

        }

        for (ProductDTO item :
                listRemove) {
            listTemp.remove(item);
        }

        model.setListResult(listTemp);
        model.setTotalItem(productService.getTotalItemByGender("Nam"));
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

        model.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getId(),1));
        model.setOrderBy(orderby);

        mav.setViewName("web/listProduct");

        mav.addObject("title", title);
        mav.addObject("titleTab", titleTab);
        mav.addObject("model", model);

        return mav;
    }

    @RequestMapping(value = "/nuoc-hoa-nu", method = RequestMethod.GET)
    public ModelAndView listFemaleProduct(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                          @RequestParam(value = "orderby", required = false) String orderby, HttpServletRequest req) {

        if (orderby == null) {
            orderby = "default";
        }
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);

        String title = "Nước hoa Nữ";
        String titleTab = "Nước hoa Nữ - 4S Perfume";
        Pageable pageable = new PageRequest(page - 1, limit);


        List<ProductDTO> listTemp = productService.findAllByGender(pageable, 0, orderby);
        List<ProductDTO> listRemove = new ArrayList<>();

        for (ProductDTO item :
                listTemp) {
            List<Product_ProductSizeDTO> arr = product_productSizeService.findAllByProductIdAndStatus(item.getId(),1);
            if (arr.size() == 0) {
                listRemove.add(item);
            } else {
                item.setListResultAllProduct(arr);
            }

        }

        for (ProductDTO item :
                listRemove) {
            listTemp.remove(item);
        }

        model.setListResult(listTemp);
        model.setTotalItem(productService.getTotalItemByGender("Nữ"));
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

        model.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getId(),1));
        model.setOrderBy(orderby);

        mav.setViewName("web/listProduct");

        mav.addObject("title", title);
        mav.addObject("titleTab", titleTab);
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/nuoc-hoa-mini", method = RequestMethod.GET)
    public ModelAndView listMiniProduct(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                        @RequestParam(value = "orderby", required = false) String orderby, HttpServletRequest req) {

        if (orderby == null) {
            orderby = "default";
        }
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);

        String title = "Nước hoa Mini";
        String titleTab = "Nước hoa Mini - 4S Perfume";
        Pageable pageable = new PageRequest(page - 1, limit);

        List<ProductDTO> listProduct = productService.findAllMiniSize(pageable, orderby);
        List<ProductDTO> arrRemove = new ArrayList<>();
        for (ProductDTO item :
                listProduct) {
            List<Product_ProductSizeDTO> listProductMini = product_productSizeService.findAllMiniSizeByProductId(item.getId());
            if (listProductMini.size() == 0) {
                arrRemove.add(item);
            } else {
                item.setListResultAllProduct(listProductMini);
            }
        }
        for (ProductDTO item :
                arrRemove) {
            listProduct.remove(item);
        }

        model.setListResult(listProduct);
        model.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getId(),1));
        model.setOrderBy(orderby);

        model.setTotalItem(productService.getTotalItemMini());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        mav.setViewName("web/listProduct");

        mav.addObject("title", title);
        mav.addObject("titleTab", titleTab);
        mav.addObject("model", model);

        return mav;
    }

    @RequestMapping(value = "/nuoc-hoa-mini-nam", method = RequestMethod.GET)
    public ModelAndView listMiniMaleProduct(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                            @RequestParam(value = "orderby", required = false) String orderby, HttpServletRequest req) {

        if (orderby == null) {
            orderby = "default";
        }
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);

        String title = "Nước hoa Mini Nam";
        String titleTab = "Nước hoa Mini Nam - 4S Perfume";
        Pageable pageable = new PageRequest(page - 1, limit);

        List<ProductDTO> listProduct = productService.findAllMiniSizeByGender(pageable, 1, orderby);
        List<ProductDTO> arrRemove = new ArrayList<>();
        for (ProductDTO item :
                listProduct) {
            List<Product_ProductSizeDTO> listProductMini = product_productSizeService.findAllMiniSizeByProductId(item.getId());
            if (listProductMini.size() == 0) {
                arrRemove.add(item);
            } else {
                item.setListResultAllProduct(listProductMini);
            }
        }
        for (ProductDTO item :
                arrRemove) {
            listProduct.remove(item);
        }

        model.setListResult(listProduct);
        model.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getId(),1));
        model.setOrderBy(orderby);

        model.setTotalItem(productService.getTotalItemMiniByGender("Nam"));
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        mav.setViewName("web/listProduct");

        mav.addObject("title", title);
        mav.addObject("titleTab", titleTab);
        mav.addObject("model", model);

        return mav;
    }

    @RequestMapping(value = "/nuoc-hoa-mini-nu", method = RequestMethod.GET)
    public ModelAndView listMiniFemaleProduct(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                              @RequestParam(value = "orderby", required = false) String orderby, HttpServletRequest req) {

        if (orderby == null) {
            orderby = "default";
        }
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);

        String title = "Nước hoa Mini Nữ";
        String titleTab = "Nước hoa Mini Nữ - 4S Perfume";
        Pageable pageable = new PageRequest(page - 1, limit);

        List<ProductDTO> listProduct = productService.findAllMiniSizeByGender(pageable, 0, orderby);
        List<ProductDTO> arrRemove = new ArrayList<>();
        for (ProductDTO item :
                listProduct) {
            List<Product_ProductSizeDTO> listProductMini = product_productSizeService.findAllMiniSizeByProductId(item.getId());
            if (listProductMini.size() == 0) {
                arrRemove.add(item);
            } else {
                item.setListResultAllProduct(listProductMini);
            }
        }
        for (ProductDTO item :
                arrRemove) {
            listProduct.remove(item);
        }

        model.setListResult(listProduct);
        model.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getId(),1));
        model.setOrderBy(orderby);

        model.setTotalItem(productService.getTotalItemMiniByGender("Nữ"));
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        mav.setViewName("web/listProduct");

        mav.addObject("title", title);
        mav.addObject("titleTab", titleTab);
        mav.addObject("model", model);

        return mav;
    }

    @RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
    public ModelAndView listSearchProduct(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                          @RequestParam(value = "tim-kiem", required = false) String searckText,
                                          @RequestParam(value = "orderby", required = false) String orderby, HttpServletRequest req) {

        if (orderby == null) {
            orderby = "default";
        }
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);

        Pageable pageable = new PageRequest(page - 1, limit);

        model.setListResult(productService.findAllBySearchText(pageable, searckText, orderby));

        model.setTotalItem(productService.getTotalItemBySearch(searckText));
        String title;
        if (model.getListResult().size() > 0) {
            title = "Kết quả tìm kiếm cho <strong>" + searckText + "</strong>";
        } else {
            title = "Không tìm thấy kết quả nào";
        }
        String titleTab = "Kết quả tìm kiếm - 4S Perfume";
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        for (int i = 0; i < model.getListResult().size(); i++) {
            model.getListResult().get(i).setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getListResult().get(i).getId(),1));
        }
        model.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(model.getId(),1));
        model.setOrderBy(orderby);

        //ModelAndView mav = new ModelAndView("web/listProduct");
        mav.setViewName("web/listProduct");

        mav.addObject("title", title);
        mav.addObject("titleTab",titleTab);
        mav.addObject("model", model);
        return mav;
    }
}
