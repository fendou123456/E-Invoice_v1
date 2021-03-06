package com.rongzer.efapiao.service;

import com.rongzer.rdp.common.context.RDPContext;
import com.rongzer.rdp.common.util.StringUtil;
import com.wabacus.config.component.application.report.AbsReportDataPojo;
import com.wabacus.config.component.application.report.ColBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.abstractreport.configbean.AbsListReportRowGroupSubDisplayRowBean;
import com.wabacus.system.dataset.select.report.value.AbsReportDataSetValueProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 已开发票查询优化
 * @author qrl
 *
 */
public class InvoiceExceptionInfoDataSet extends AbsReportDataSetValueProvider {

	@Override
	public List<String> getColFilterDataSet(ReportRequest arg0, ColBean arg1,
			boolean arg2, int arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 按照查询条件查询数据
	 */
	@Override
	public List<Map<String, Object>> getDataSet(ReportRequest rrequest,
			List<AbsReportDataPojo> lstReportData, int startRownum,
			int endRownum) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("TRANSACTION_NUMBER", rrequest.getAttribute("TRANSACTION_NUMBER"));
		params.put("INVOICE_STATUS", rrequest.getAttribute("INVOICE_STATUS"));
		params.put("STORE_NO", rrequest.getAttribute("STORE_NO"));
		params.put("TAXPAYER_IDENTIFY_NO", rrequest.getAttribute("TAXPAYER_IDENTIFY_NO"));
		params.put("TAXPAYER_NAME_CN", rrequest.getAttribute("TAXPAYER_NAME_CN"));
		params.put("INVOICE_TYPE", rrequest.getAttribute("INVOICE_TYPE"));
		params.put("IS_MANUAL", rrequest.getAttribute("IS_MANUAL"));
		params.put("UPDATE_TIME_START", rrequest.getAttribute("UPDATE_TIME_START"));
		params.put("UPDATE_TIME_END", rrequest.getAttribute("UPDATE_TIME_END"));
		String taxpayerQx = StringUtil.toStringWithEmpty(rrequest.getAttribute("TAXPAYER_QX"));
		taxpayerQx = StringUtil.isEmpty(taxpayerQx)?"''":taxpayerQx;
		params.put("TAXPAYER_QX", taxpayerQx);
		params.put("startRowNum", startRownum);
		params.put("endRowNum", endRownum);
		InvoiceInfoService invoiceInfoService = (InvoiceInfoService) RDPContext.getContext().getBean("invoiceInfoService");
		resultList = invoiceInfoService.getInvoiceExceptionInfo(params);
		return resultList;
	}


	/**
	 * 按照查询条件查询数据行
	 */
	@Override
	public int getRecordcount(ReportRequest rrequest) {
		int recordCount = 0;
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("TRANSACTION_NUMBER", rrequest.getAttribute("TRANSACTION_NUMBER"));
			params.put("INVOICE_STATUS", rrequest.getAttribute("INVOICE_STATUS"));
			params.put("STORE_NO", rrequest.getAttribute("STORE_NO"));
			params.put("TAXPAYER_IDENTIFY_NO", rrequest.getAttribute("TAXPAYER_IDENTIFY_NO"));
			params.put("TAXPAYER_NAME_CN", rrequest.getAttribute("TAXPAYER_NAME_CN"));
			params.put("INVOICE_TYPE", rrequest.getAttribute("INVOICE_TYPE"));
			params.put("IS_MANUAL", rrequest.getAttribute("IS_MANUAL"));
			params.put("UPDATE_TIME_START", rrequest.getAttribute("UPDATE_TIME_START"));
			params.put("UPDATE_TIME_END", rrequest.getAttribute("UPDATE_TIME_END"));
			String taxpayerQx = StringUtil.toStringWithEmpty(rrequest.getAttribute("TAXPAYER_QX"));
			taxpayerQx = StringUtil.isEmpty(taxpayerQx)?"''":taxpayerQx;
			params.put("TAXPAYER_QX", taxpayerQx);
			InvoiceInfoService invoiceInfoService = (InvoiceInfoService) RDPContext.getContext().getBean("invoiceInfoService");
			recordCount = invoiceInfoService.getInvoiceExceptionInfoCount(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return recordCount;
	}

	@Override
	public Map<String, Object> getStatisticDataSet(ReportRequest arg0,
			AbsListReportRowGroupSubDisplayRowBean arg1,
			Map<String, String> arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
