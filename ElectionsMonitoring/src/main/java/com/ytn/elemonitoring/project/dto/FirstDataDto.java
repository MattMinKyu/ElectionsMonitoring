package com.ytn.elemonitoring.project.dto;

import lombok.Data;

/**
 * 첫 데이터 화면 vo
 * @author mattmk
 *
 */
@Data
public class FirstDataDto {
	
	/**
	 * rowIdx
	 */
	private Integer rowIdx;
	
	/**
	 * 지역
	 */
	private String area;
	
	/**
	 * sub_sg_id
	 */
	private Integer subSgId;
	
	/**
	 * sdid
	 */
	private Integer sdid;
	
	/**
	 * wiwid
	 */
	private Integer wiwid;
	
	/**
	 * sggid
	 */
	private Integer sggid;
	
	/**
	 * cnt
	 */
	private Integer cnt;
	
}
