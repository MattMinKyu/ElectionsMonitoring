package com.ytn.elemonitoring.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.ytn.elemonitoring.project.dto.FirstDataDto;
import com.ytn.elemonitoring.project.vo.PageingVo;


/**
 * 첫데이터 DAO
 * 
 * @author mattmk
 */

@Mapper
public interface FirstDataDao {
	
	// 총 갯수 조회
	int selectMemberInfoListCnt();
		
	// 조회
	List<FirstDataDto> selectMemberInfoList(@RequestParam("pageingVo")PageingVo pageingVo);
	
}
