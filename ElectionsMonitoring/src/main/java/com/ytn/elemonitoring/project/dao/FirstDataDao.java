package com.ytn.elemonitoring.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.ytn.elemonitoring.project.dto.FirstDataDto;
import com.ytn.elemonitoring.project.vo.PageingVo;


/**
 * ù������ DAO
 * 
 * @author mattmk
 */

@Mapper
public interface FirstDataDao {
	
	// �� ���� ��ȸ
	int selectMemberInfoListCnt();
		
	// ��ȸ
	List<FirstDataDto> selectMemberInfoList(@RequestParam("pageingVo")PageingVo pageingVo);
	
}
