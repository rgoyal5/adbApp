package com.verizon.jhd.model.composition;
import javax.persistence.*;
@Embeddable
public class Identification {

	private String photoFileNName;
	private String fingerPrintFileName;
	
	
	public Identification() {
		super();
	}

	public Identification(String photoFileNName, String fingerPrintFileName) {
		super();
		this.photoFileNName = photoFileNName;
		this.fingerPrintFileName = fingerPrintFileName;
	}

	public String getPhotoFileNName() {
		return photoFileNName;
	}

	public void setPhotoFileNName(String photoFileNName) {
		this.photoFileNName = photoFileNName;
	}

	public String getFingerPrintFileName() {
		return fingerPrintFileName;
	}

	public void setFingerPrintFileName(String fingerPrintFileName) {
		this.fingerPrintFileName = fingerPrintFileName;
	}
	
	
	
}
