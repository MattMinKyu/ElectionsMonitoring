package com.ytn.elemonitoring.project.vo;

import lombok.Data;

/**
 * Pageing Vo
 * 
 * @author mattmk
 *
 */
@Data
public class PageingVo {
	
	/**
	 * Pageing 시작 Idx
	 */
	private Integer startPageIdx;
	
	/**
	 * Pageing 종료 Idx
	 */
	private Integer endPageIdx;
	
	/**
	 * Sorting 기준 컬럼
	 */
	private String targetOrder;
	
	/**
	 * Sorting 순서
	 * ex) asc, desc
	 */
	private String order;
	
	/**
	 * 정렬 컬럼
	 */
	private String sCol;
	
	/**
	 * 기본 
	 */
	private Integer pageCnt;
}
