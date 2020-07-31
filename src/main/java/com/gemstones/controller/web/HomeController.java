package com.gemstones.controller.web;

import com.gemstones.dto.ProductDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.entity.UserEntity;
import com.gemstones.service.IProductService;
import com.gemstones.service.IProduct_ProductSizeService;
import com.gemstones.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "homeControllerOfWeb")
public class HomeController extends BaseController{

    @Autowired
    private IProduct_ProductSizeService product_productSizeService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, HttpServletRequest req) {

        // Danh sách sản phẩm new release
        ProductDTO newRelease = new ProductDTO();
        List<ProductDTO> arrAddNewRelease = new ArrayList<>();
        List<ProductDTO> arrRemoveNewRelease = new ArrayList<>();

        arrAddNewRelease = productService.findAllByNewRelease();
        for (ProductDTO item:
                arrAddNewRelease) {
            List<Product_ProductSizeDTO> arr = product_productSizeService.findAllByProductIdAndStatus(item.getId(), 1);
            if (arr.size() == 0){
                arrRemoveNewRelease.add(item);
            }else{
                item.setListResultAllProduct(arr);
            }
        }

        for (ProductDTO item:
                arrRemoveNewRelease) {
            arrAddNewRelease.remove(item);
        }
        newRelease.setListResult(arrAddNewRelease);
        newRelease.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(newRelease.getId(),1));

        // Kết thúc sản phẩm new release

        // Danh sách sản phẩm hot trend
        ProductDTO hotTrend = new ProductDTO();
        List<ProductDTO> arrAddHotTrend = new ArrayList<>();
        List<ProductDTO> arrRemoveHotTrend = new ArrayList<>();
        arrAddHotTrend = productService.findAllByHotTrend();
        for (ProductDTO item:
                arrAddHotTrend) {
            List<Product_ProductSizeDTO> arr = product_productSizeService.findAllByProductIdAndStatus(item.getId(),1);
            if (arr.size() == 0){
                arrRemoveHotTrend.add(item);
            }else{
                item.setListResultAllProduct(arr);
            }
        }

        for (ProductDTO item:
                arrRemoveHotTrend) {
            arrAddHotTrend.remove(item);
        }
        hotTrend.setListResult(arrAddHotTrend);
        hotTrend.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(hotTrend.getId(),1));
        // Kết thúc sản phẩm hot trend

        // Danh sách sản phẩm best seller
        ProductDTO bestSeller = new ProductDTO();
        List<ProductDTO> arrAddBestSeller = new ArrayList<>();
        List<ProductDTO> arrRemoveBestSeller = new ArrayList<>();
        arrAddBestSeller = productService.findAllByBestSeller();
        for (ProductDTO item:
                arrAddBestSeller) {
            List<Product_ProductSizeDTO> arr = product_productSizeService.findAllByProductIdAndStatus(item.getId(),1);
            if (arr.size() == 0){
                arrRemoveBestSeller.add(item);
            }else{
                item.setListResultAllProduct(arr);
            }
        }

        for (ProductDTO item:
                arrRemoveBestSeller) {
            arrAddBestSeller.remove(item);
        }
        bestSeller.setListResult(arrAddBestSeller);
        bestSeller.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(bestSeller.getId(),1));
        // Kết thúc sản phẩm best seller

        // Danh sách sản phẩm seasonal
        ProductDTO seasonal = new ProductDTO();
        List<ProductDTO> arrAddSeasonal = new ArrayList<>();
        List<ProductDTO> arrRemoveSeasonal = new ArrayList<>();
        arrAddSeasonal = productService.findAllBySeasonal();
        for (ProductDTO item:
                arrAddSeasonal) {
            List<Product_ProductSizeDTO> arr = product_productSizeService.findAllByProductIdAndStatus(item.getId(),1);
            if (arr.size() == 0){
                arrRemoveSeasonal.add(item);
            }else{
                item.setListResultAllProduct(arr);
            }
        }

        for (ProductDTO item:
                arrRemoveSeasonal) {
            arrAddSeasonal.remove(item);
        }
        seasonal.setListResult(arrAddSeasonal);
        seasonal.setListResultAllProduct(product_productSizeService.findAllByProductIdAndStatus(seasonal.getId(),1));
        // Kết thúc sản phẩm seasonal


        mav.setViewName("web/home");
        mav.addObject("newRelease",newRelease);
        mav.addObject("hotTrend",hotTrend);
        mav.addObject("bestSeller",bestSeller);
        mav.addObject("seasonal",seasonal);

        return mav;
    }

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        //ModelAndView mav = new ModelAndView("login");
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        //ModelAndView mav = new ModelAndView("register");
        mav.setViewName("register");

        mav.addObject("user", new UserEntity());
        return mav;
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public ModelAndView createAccount(@ModelAttribute("user") UserEntity user) {
        String status = userService.save(user);
        //ModelAndView mav = new ModelAndView();
        if (status.equals("Thành công"))
        {
            mav.setViewName("login");
            mav.addObject("status",status);
        }else {
            mav.setViewName("register");
            mav.addObject("status",status);
        }

        return mav;
    }

    @RequestMapping(value = "/thoat", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/trang-chu");
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("redirect:/dang-nhap?accessDenied");
    }
   /* @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public String homePage1() {
        return "redirect:homePage?page=1&limit=9";
    }*/
}