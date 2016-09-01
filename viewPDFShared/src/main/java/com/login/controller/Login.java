package com.login.controller;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.login.model.AttReport;
import com.utilities.Constants;
import com.utilities.Create;
import com.utilities.Download;
 
@Controller
public class Login {
 
	@RequestMapping(value = "loadDataAttReport", method = RequestMethod.GET)
	public ModelAndView loadDataAttReport(){
		return new ModelAndView("attReportEditor" , "attReport", new AttReport());
	}
	
	@RequestMapping(value = "/createReport", method = RequestMethod.GET)
	public void createReport(@ModelAttribute("contactForm") AttReport attReport,
			 Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*System.out.println("Inside of dosomething handler method");
		
		System.out.println("--- Model data ---");
		Map<String, Object> modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}
		
		System.out.println("=== Request data ===");
		Enumeration<String> reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			System.out.println(s + "==" + request.getAttribute(s));
		}*/
		
		Map<String, Object> params = new HashMap<String, Object>(0);
		@SuppressWarnings("rawtypes")
		ArrayList listExp = new ArrayList(0);
		
		for (int a=0; a < 10; a++  ) {
			Map<String, Object> hm = new HashMap<String, Object>(0);
			hm.put("uid", "uid2345678" + a);
			hm.put("tipoTarjeta", "");
			hm.put("noOperacion", new Long(a));
			hm.put("importe", 3.4);
			hm.put("importeIvaORegalo", 10.8);
			hm.put("importeTotal", 7804.34);
			hm.put("fechaHoraFormat", "fecha hora");
			
			listExp.add(hm);
		}

		Map<String, String> att = attReport.getMapAtt();
		params.putAll(att);
		
		params.put("inicio", "dd_MM_yyyy");
		params.put("fin", "dd_MM_yyyy");
		params.put("puntoVenta", "TODOS");
		params.put("asesor", "TODOS");
		params.put("region", "region");
		params.put("fechaCorte", new Date().toString());
		params.put("compania", "compania");
		params.put("claseServicio", "claseServicio");
		params.put("turno", "turno");
		params.put("marca", "marca");
		params.put("movimientos", "");
		
		String relativeWebPath = "classpath:com/login/jrxml/reportDetalle.jasper";
		byte[] byteArr = Create.createByteArrayPdf(params, listExp, relativeWebPath);
		Download.download(response, "reportDetalle", byteArr, Constants.EXPORT_TYPE_PDF);
		
	}
	
	
	/*@RequestMapping("/doLogin")
	public String doLogin(@ModelAttribute Usuario usuario, Model model, HttpServletRequest request) {
		System.out.println("Inside of dosomething handler method");

		System.out.println("--- Model data ---");
		Map<String, Object> modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}

		System.out.println("=== Request data ===");
		Enumeration<String> reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			System.out.println(s + "==" + request.getAttribute(s));
		}
		
		model.addAttribute("tel", "telefono");
		model.addAttribute("ema", "email");
		model.addAttribute("chrono", "chronqwer5t6y7u8ioo");
		
	System.out.println(" usuario " + usuario.getNickname());
	System.out.println(" pass " + usuario.getPass());

		return "demo-2";
	}*/
}