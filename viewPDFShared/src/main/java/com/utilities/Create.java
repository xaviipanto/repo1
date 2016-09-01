package com.utilities;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.login.customer.services.CustomerService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

public class Create {


	@SuppressWarnings("rawtypes")
	private static JasperPrint createJasperPrint(Map<String, Object> params, ArrayList dataList, String relativeWebPath) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"spring-customer.xml"});
		CustomerService cust = (CustomerService)appContext.getBean("customerService");
		Resource resource = cust.getResource(relativeWebPath);
		
		JRBeanCollectionDataSource collectionDS = new JRBeanCollectionDataSource(dataList);
		JasperReport report = (JasperReport) JRLoader.loadObject(resource.getFile());
		//JasperReport report = JasperCompileManager.compileReport(absoluteDiskPath);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, collectionDS);
		return jasperPrint;
	}

	/**
	 * 
	 * @throws JRException 
	 */
	@SuppressWarnings("rawtypes") 
	public static byte[] createByteArrayPdf(Map<String, Object> params, ArrayList dataList, String relativeWebPath) throws Exception{
		JasperPrint jasperPrint = createJasperPrint(params, dataList, relativeWebPath);
		byte[] byteArr = JasperExportManager.exportReportToPdf(jasperPrint);
		return byteArr;
	}

	@SuppressWarnings("rawtypes") 
	public static byte[] createByteArrayMSExcel(Map<String, Object> params, ArrayList dataList, String relativeWebPath) throws Exception{
		JasperPrint jasperPrint = createJasperPrint(params, dataList, relativeWebPath);
		ByteArrayOutputStream  xlsReport = new ByteArrayOutputStream();

		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));

		SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
		xlsReportConfiguration.setOnePagePerSheet(false);
		xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(false);
		xlsReportConfiguration.setDetectCellType(false);
		xlsReportConfiguration.setWhitePageBackground(false);

		exporter.setConfiguration(xlsReportConfiguration);

		exporter.exportReport();
		byte[] byteArr = xlsReport.toByteArray();
		return byteArr;
	}

}
