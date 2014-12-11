/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cattsoft.tm.struts;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.sm.vo.SysUserExtendedMVO;
import com.cattsoft.tm.delegate.WoQueryDelegate;
import com.cattsoft.tm.vo.AdvQueryMVO;
import com.cattsoft.webpub.util.ReqUtil;


/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: <br>
 * Date: 2007-6-13 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class WoQueryAction extends DispatchAction {
	private static final Logger log = Logger.getLogger(WoQueryAction.class);

	
	/**
	 * �õ������б�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SysException
	 * @throws AppException
	 * @throws IOException 
	 */
	public ActionForward queryBySoNbr4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SysException, AppException, IOException {
		String infoJsonString = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject infoJsonObject = com.alibaba.fastjson.JSONObject.parseObject(infoJsonString);
		String soNum = infoJsonObject.getString("soNum");
		String localNetId = infoJsonObject.getString("localNetId");
		com.alibaba.fastjson.JSONObject userInfoJson = (com.alibaba.fastjson.JSONObject) infoJsonObject.get("userInfo");
		SysUserExtendedMVO suve = com.alibaba.fastjson.JSON.parseObject(userInfoJson.toString(), SysUserExtendedMVO.class);
		AdvQueryMVO queryVo = new AdvQueryMVO();
		queryVo.setQryFlag("cur");
		queryVo.setChbSoNbr("1");
		queryVo.setSoNbr(soNum);
		queryVo.setPageFlag("WoQuery");
		queryVo.setChbLocalNetId("1");
		queryVo.setLocalNetId(localNetId);
		String sysUserId = suve.getSysUserSVO().getSysUserId();
		queryVo.setSysUserId(sysUserId);
		String queryVoString = com.alibaba.fastjson.JSONObject.toJSONString(queryVo);
		String woList = WoQueryDelegate.getDelegate().getWoListBySoNbr4MOS(queryVoString);
		//���������б��ַ���ת����json�ַ������͵�ǰ̨
		JSONArray jsonArray = JSONArray.fromObject(woList);//���õ����ַ���ת��JSONArray
//		System.out.println("JSON========"+jsonArray);
		if (jsonArray!=null) {
			ReqUtil.write(response, jsonArray.toString());
		} 
		return null;
		
	}
	/**
	 * ��ôӿͻ��˴����json�ַ���
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJSON(HttpServletRequest request) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		return sb.toString();
	}

	
}