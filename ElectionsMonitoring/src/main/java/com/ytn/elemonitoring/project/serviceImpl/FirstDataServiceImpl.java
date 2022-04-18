package com.ytn.elemonitoring.project.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ytn.elemonitoring.project.dao.FirstDataDao;
import com.ytn.elemonitoring.project.dto.FirstDataDto;
import com.ytn.elemonitoring.project.dto.WrapperDto;
import com.ytn.elemonitoring.project.service.FirstDataService;
import com.ytn.elemonitoring.project.vo.PageingVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FirstDataServiceImpl implements FirstDataService{
	
	private FirstDataDao firstDataDao;
	
	public FirstDataServiceImpl(FirstDataDao firstDataDao) {
		this.firstDataDao = firstDataDao;
	}
	
	@Override
	public String getFirstDataJson(PageingVo pageingVo) {
		String returnData="";
		
		if(pageingVo == null) {
			return returnData;
		}
		String targetOrder;
        
		/*
		 * 기준컬럼값 재셋팅.
		 */
        switch (pageingVo.getSCol()) {
        	case "1" : 
        		targetOrder = "area";
        		break;
        	case "2" : 
        		targetOrder = "subSgId";
        		break;
        	case "3" : 
        		targetOrder = "sdid";
        		break;
        	case "4" : 
        		targetOrder = "wiwid";
        		break;
        	case "5" : 
        		targetOrder = "sggid";
        		break;
        	case "6" : 
        		targetOrder = "cnt";
        		break;
        	default:
        		targetOrder = "area";
        		break;
        }
        
        pageingVo.setTargetOrder(targetOrder);
		
        int recordsCnt;
		ObjectMapper mapper = new ObjectMapper();
		List<FirstDataDto> firstDataList = new ArrayList<FirstDataDto>();
		
		recordsCnt = firstDataDao.selectMemberInfoListCnt();
		
		firstDataList = firstDataDao.selectMemberInfoList(pageingVo);	
		
		for(int idx=0;idx<firstDataList.size();idx++) {
			firstDataList.get(idx).setRowIdx(pageingVo.getPageCnt()+(idx+1));
		}

		/*
		// @TestData
			recordsCnt = 0;
		*/
		//클라이언트로 값 전송을 위해 WrapperDto로 감싸기
		WrapperDto wrapperDto = new WrapperDto();
		wrapperDto.setAaData(firstDataList);
		//실제 전체 데이터
		wrapperDto.setITotalRecords(recordsCnt);
		//필터링 된 전체 데이터 - 필터링 기능 사용하지 않기 때문에 실제 전체 데이터와 동일하다.
		wrapperDto.setITotalDisplayRecords(recordsCnt);
		
		try {
			returnData = mapper.writeValueAsString(wrapperDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("FirstDataServiceImpl.class [returnData] ====> {}", returnData);
		
		
		return returnData;
	}
}
