package com.ytn.elemonitoring.project.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytn.elemonitoring.project.service.FirstDataService;
import com.ytn.elemonitoring.project.vo.PageingVo;

import lombok.extern.slf4j.Slf4j;

/**
 * Data Rest Controller
 * @author mattmk
 *
 */
@Slf4j
@RestController
@RequestMapping("/ytn/researchInstutute/elections/data/")
public class DataRestController {
	
	private final FirstDataService firstDataService;
	
	public DataRestController(FirstDataService firstDataService) {
		this.firstDataService = firstDataService;
	}
	
	/**
	 * 첫데이터 rest api
	 * 
	 * @author mattmk
	 * @param PathVariable String
	 * @param HttpServletRequest request
	 * @return String
	 */
	@PostMapping("{id}/firstData/getList")
	public String getList(@PathVariable String id, HttpServletRequest request) {
		log.info("DataRestController.class [id] ====> {}", id);
		log.info("DataRestController.class [request] ====> {}", request);
		
		String jsonList="";
		Integer pageCnt = Integer.parseInt(request.getParameter("iDisplayStart"));
		Integer pageLen = Integer.parseInt(request.getParameter("iDisplayLength"));
        String sCol = request.getParameter("iSortCol_0");
        String sdir = request.getParameter("sSortDir_0");
        
        log.info("DataRestController.class [pageCnt] ====> {}", pageCnt);
        log.info("DataRestController.class [pageLen] ====> {}", pageLen);
        log.info("DataRestController.class [sCol] ====> {}", sCol);
        log.info("DataRestController.class [sdir] ====> {}", sdir);
        
        Integer page = pageCnt/pageLen +1;
        
        log.info("DataRestController.class [page] ====> {}", page);
        log.info("DataRestController.class [pageLen] ====> {}", pageLen);
        
        PageingVo pageingVo = new PageingVo();
        pageingVo.setStartPageIdx(pageCnt+1);
        pageingVo.setEndPageIdx(page*pageLen);
        pageingVo.setOrder(sdir);
        pageingVo.setSCol(sCol);
        pageingVo.setPageCnt(pageCnt);
		
        jsonList = firstDataService.getFirstDataJson(pageingVo);
		
		return jsonList;
	}
}
