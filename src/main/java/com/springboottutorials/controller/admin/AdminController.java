package com.springboottutorials.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.springboottutorials.constant.SystemConstant;
import com.springboottutorials.entity.ProductEntity;
import com.springboottutorials.service.ICategoryService;
import com.springboottutorials.service.IProductService;
import com.springboottutorials.utils.UploadFileUtil;

@Controller
public class AdminController {

	@Autowired private IProductService productService;
	@Autowired private ICategoryService categoryService;
	
	@RequestMapping(value = {"/admin", "/admin/dashboard"})
	public String dashboard() {
		return "admin/bodys/dashboard";
	}
	
	@RequestMapping(value = {"/admin/products"})
	public String products(Model model, HttpServletRequest request) {
		return productsPagination(model, request, 1, "name", "asc", "");
	}
	
	@RequestMapping(value = {"/admin/products/page/{pageNumber}"})
	public String productsPagination(Model model, HttpServletRequest request,
			@PathVariable("pageNumber") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir,
			@Param("keyword") String keyword) {
		
		Page<ProductEntity> page = productService.findAll(currentPage, sortField, sortDir, keyword);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("totalPages", page.getTotalPages() < 1 ? 1 : page.getTotalPages());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.addAttribute("reverseSortDir", reverseSortDir);
		model.addAttribute(SystemConstant.PRODUCTS, page.getContent());
		model.addAttribute(SystemConstant.CATEGORIES, categoryService.findAll());
		//Xu ly sau (dung model)
		request.getSession().setAttribute("messageapi", SystemConstant.MESSAGE_API);
//		model.addAttribute("messageapi", SystemConstant.MESSAGE_API);
		return "admin/bodys/products";
	}
	
	@RequestMapping(value = {"/admin/api/product/{id}"}, method = RequestMethod.GET)
	public String detail(@PathVariable String id ,Model model) {
		model.addAttribute(SystemConstant.PRODUCT, productService.findOne(id));
		return "admin/bodys/product_detail";
	}
	
	@RequestMapping(value = {"/admin/api/product"}, method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public String save(@RequestPart("product") ProductEntity product, @RequestPart("file") MultipartFile file) throws IOException {
		product.setImage(file.getOriginalFilename());
		UploadFileUtil.saveFile("src/main/resources/static/img/product/", file.getOriginalFilename(), file);
		productService.save(product);
		return "redirect:/admin/products";
	}
	
	@RequestMapping(value = {"/admin/api/product"}, method = RequestMethod.PUT)
	public String update(@RequestPart("product") ProductEntity product, @RequestPart("file") MultipartFile file) throws IOException {
		product.setImage(file.getOriginalFilename());
		UploadFileUtil.saveFile("src/main/resources/static/img/product/", file.getOriginalFilename(), file);
		productService.update(product);
		return "redirect:/admin/products";
	}
	
	@RequestMapping(value = {"/admin/api/product"}, method = RequestMethod.DELETE)
	public String delete(@RequestPart("product") ProductEntity product) {
		productService.delete(product.getIds());
		return "redirect:/admin/products";
	}

}
