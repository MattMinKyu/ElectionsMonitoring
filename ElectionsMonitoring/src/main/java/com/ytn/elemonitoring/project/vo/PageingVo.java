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
	 * Pageing ���� Idx
	 */
	private Integer startPageIdx;
	
	/**
	 * Pageing ���� Idx
	 */
	private Integer endPageIdx;
	
	/**
	 * Sorting ���� �÷�
	 */
	private String targetOrder;
	
	/**
	 * Sorting ����
	 * ex) asc, desc
	 */
	private String order;
	
	/**
	 * ���� �÷�
	 */
	private String sCol;
	
	/**
	 * �⺻ 
	 */
	private Integer pageCnt;
}
