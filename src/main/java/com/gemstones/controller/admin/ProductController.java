package com.gemstones.controller.admin;

import com.gemstones.dto.ProductDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.service.IIncenseGroupService;
import com.gemstones.service.IProductService;
import com.gemstones.service.IProductSizeService;
import com.gemstones.service.IProduct_ProductSizeService;
import com.gemstones.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "productsControllerAdmin")
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductSizeService productSizeService;

    @Autowired
    private IIncenseGroupService incenseGroupService;

    @Autowired
    private IProduct_ProductSizeService product_productSizeService;



    @RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
    public ModelAndView showListProduct(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req,
                                        @RequestParam(value = "tim-kiem", required = false) String searckText,
                                        @RequestParam(value = "orderby", required = false) String orderby) {
        if (orderby == null) {
            orderby = "asc";
        }
        if (searckText == null) {
            searckText = "";
        }

        /*Full*/
        ProductDTO model = new ProductDTO();

        model.setPage(page);
        model.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(productService.findAllByProductNameAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(productService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        model.setOrderBy(orderby);
        /*End Full*/

        /*Male*/
        ProductDTO modelMale = new ProductDTO();

        modelMale.setPage(page);
        modelMale.setLimit(limit);
        modelMale.setListResult(productService.findAllByProductNameAndGenderAndOrderBy(pageable, searckText,"Nam", orderby));
        modelMale.setTotalItem(productService.getTotalItemByGender("Nam"));
        modelMale.setTotalPage((int) Math.ceil((double) modelMale.getTotalItem() / modelMale.getLimit()));
        modelMale.setOrderBy(orderby);
        /*End Male*/

        /*Female*/
        ProductDTO modelFemale = new ProductDTO();

        modelFemale.setPage(page);
        modelFemale.setLimit(limit);
        modelFemale.setListResult(productService.findAllByProductNameAndGenderAndOrderBy(pageable, searckText,"Nữ", orderby));
        modelFemale.setTotalItem(productService.getTotalItemByGender("Nữ"));
        modelFemale.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelFemale.setOrderBy(orderby);
        /*End Female*/

        /*BestSeller*/
        ProductDTO modelBestSeller = new ProductDTO();

        modelBestSeller.setPage(page);
        modelBestSeller.setLimit(limit);
        modelBestSeller.setListResult(productService.findAllByProductNameAndBestSellerAndOrderBy(pageable, searckText, orderby));
        modelBestSeller.setTotalItem(productService.getTotalItemByBestSeller());
        modelBestSeller.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelBestSeller.setOrderBy(orderby);
        /*End BestSeller*/

        /*HotTrend*/
        ProductDTO modelHotTrend = new ProductDTO();

        modelHotTrend.setPage(page);
        modelHotTrend.setLimit(limit);
        modelHotTrend.setListResult(productService.findAllByProductNameAndHotTrendAndOrderBy(pageable, searckText, orderby));
        modelHotTrend.setTotalItem(productService.getTotalItemByHotTrend());
        modelHotTrend.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelHotTrend.setOrderBy(orderby);
        /*End HotTrend*/

        /*NewRelease*/
        ProductDTO modelNewRelease = new ProductDTO();

        modelNewRelease.setPage(page);
        modelNewRelease.setLimit(limit);
        modelNewRelease.setListResult(productService.findAllByProductNameAndNewReleaseAndOrderBy(pageable, searckText, orderby));
        modelNewRelease.setTotalItem(productService.getTotalItemByNewRelease());
        modelNewRelease.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelNewRelease.setOrderBy(orderby);
        /*End NewRelease*/

        /*Seasonal*/
        ProductDTO modelSeasonal = new ProductDTO();

        modelSeasonal.setPage(page);
        modelSeasonal.setLimit(limit);
        modelSeasonal.setListResult(productService.findAllByProductNameAndSeasonalAndOrderBy(pageable, searckText, orderby));
        modelSeasonal.setTotalItem(productService.getTotalItemBySeasonal());
        modelSeasonal.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelSeasonal.setOrderBy(orderby);
        /*End Seasonal*/

        mav.setViewName("admin/products/listProduct");
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        mav.addObject("modelMale", modelMale);
        mav.addObject("modelFemale", modelFemale);
        mav.addObject("modelBestSeller", modelBestSeller);
        mav.addObject("modelHotTrend", modelHotTrend);
        mav.addObject("modelNewRelease", modelNewRelease);
        mav.addObject("modelSeasonal", modelSeasonal);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/san-pham/chinh-sua-san-pham", method = RequestMethod.GET)
    public ModelAndView editProduct(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("admin/products/editProduct");
        ProductDTO model = new ProductDTO();
        if (id != null) {
            model = productService.findOneById(id);
            model.setIncenseGroupId(model.getIncenseGroup().getId());
        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("listIncenseGroup", incenseGroupService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
