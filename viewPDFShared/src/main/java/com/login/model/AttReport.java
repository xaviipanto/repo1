package com.login.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class AttReport implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2314181245048365759L;
	
	
	private LinkedHashMap<String, String> mapAtt;
	

	public AttReport() {
		mapAtt = new LinkedHashMap<String, String>(0);
		mapAtt.put("parameter1", "<p align='center'><font face='verdana' size='16'>Titulo Reporte</font></p>");
		mapAtt.put("parameter2", "<p><font face='verdana' size='6'>Inicio</font></p>");
		mapAtt.put("parameter3", "<p><font face='verdana' size='6'>Fin</font></p>");
		mapAtt.put("parameter4", "<b>valor4</b>");
		mapAtt.put("parameter5", "<b>valor5</b>");
		mapAtt.put("parameter6", "<b>valor6</b>");
		mapAtt.put("parameter7", "<b>valor7</b>");
		mapAtt.put("parameter8", "<b>valor8</b>");
		mapAtt.put("parameter9", "<b>valor9</b>");
		mapAtt.put("parameter10", "<b>valor10</b>");
		mapAtt.put("parameter11", "<b>valor11</b>");
	}
	
	public LinkedHashMap<String, String> getMapAtt() {
		return mapAtt;
	}
	
	public void setMapAtt(LinkedHashMap<String, String> mapAtt) {
		this.mapAtt = mapAtt;
	}
}