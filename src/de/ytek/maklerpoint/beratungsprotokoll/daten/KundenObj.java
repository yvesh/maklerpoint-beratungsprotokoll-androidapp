package de.ytek.maklerpoint.beratungsprotokoll.daten;

import de.ytek.maklerpoint.beratungsprotokoll.defines.CommunicationTypes;

public class KundenObj {

	private int id; 
    private int betreuerId; 
    private String kundenNr; 
    private String anrede; 
    private String titel; 
    private String firma; 
    private String vorname; 
    private String nachname; 
    private String zusatz; 
    private String strasse; 
    private String plz; 
    private String ort; 
    private String land; 
    private String geburtsdatum; 
    private String communication1; 
    private String communication2; 
    private String communication3; 
    private String communication4; 
    private int communiction1_typ = CommunicationTypes.TELEFON; 
    private int communiction2_typ = CommunicationTypes.FAX; 
    private int communiction3_typ = CommunicationTypes.MOBIL; 
    private int communiction4_typ = CommunicationTypes.EMAIL; 
    private String custom1; 
    private String custom2; 
    private String custom3; 
    private int status = 0; 

    // getter and setter
	public void setId(int id ) {
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setBetreuerId(int betreuerId ) {
		this.betreuerId = betreuerId;
	}

	public int getBetreuerId() {
		return betreuerId;
	}


	public void setKundenNr(String kundenNr ) {
		this.kundenNr = kundenNr;
	}

	public String getKundenNr() {
		return kundenNr;
	}


	public void setAnrede(String anrede ) {
		this.anrede = anrede;
	}

	public String getAnrede() {
		return anrede;
	}


	public void setTitel(String titel ) {
		this.titel = titel;
	}

	public String getTitel() {
		return titel;
	}


	public void setFirma(String firma ) {
		this.firma = firma;
	}

	public String getFirma() {
		return firma;
	}


	public void setVorname(String vorname ) {
		this.vorname = vorname;
	}

	public String getVorname() {
		return vorname;
	}


	public void setNachname(String nachname ) {
		this.nachname = nachname;
	}

	public String getNachname() {
		return nachname;
	}


	public void setZusatz(String zusatz ) {
		this.zusatz = zusatz;
	}

	public String getZusatz() {
		return zusatz;
	}


	public void setStrasse(String strasse ) {
		this.strasse = strasse;
	}

	public String getStrasse() {
		return strasse;
	}


	public void setPlz(String plz ) {
		this.plz = plz;
	}

	public String getPlz() {
		return plz;
	}


	public void setOrt(String ort ) {
		this.ort = ort;
	}

	public String getOrt() {
		return ort;
	}


	public void setLand(String land ) {
		this.land = land;
	}

	public String getLand() {
		return land;
	}


	public void setGeburtsdatum(String geburtsdatum ) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}


	public void setCommunication1(String communication1 ) {
		this.communication1 = communication1;
	}

	public String getCommunication1() {
		return communication1;
	}


	public void setCommunication2(String communication2 ) {
		this.communication2 = communication2;
	}

	public String getCommunication2() {
		return communication2;
	}


	public void setCommunication3(String communication3 ) {
		this.communication3 = communication3;
	}

	public String getCommunication3() {
		return communication3;
	}


	public void setCommunication4(String communication4 ) {
		this.communication4 = communication4;
	}

	public String getCommunication4() {
		return communication4;
	}


	public void setCommuniction1_typ(int communiction1_typ ) {
		this.communiction1_typ = communiction1_typ;
	}

	public int getCommuniction1_typ() {
		return communiction1_typ;
	}


	public void setCommuniction2_typ(int communiction2_typ ) {
		this.communiction2_typ = communiction2_typ;
	}

	public int getCommuniction2_typ() {
		return communiction2_typ;
	}


	public void setCommuniction3_typ(int communiction3_typ ) {
		this.communiction3_typ = communiction3_typ;
	}

	public int getCommuniction3_typ() {
		return communiction3_typ;
	}


	public void setCommuniction4_typ(int communiction4_typ ) {
		this.communiction4_typ = communiction4_typ;
	}

	public int getCommuniction4_typ() {
		return communiction4_typ;
	}


	public void setCustom1(String custom1 ) {
		this.custom1 = custom1;
	}

	public String getCustom1() {
		return custom1;
	}


	public void setCustom2(String custom2 ) {
		this.custom2 = custom2;
	}

	public String getCustom2() {
		return custom2;
	}


	public void setCustom3(String custom3 ) {
		this.custom3 = custom3;
	}

	public String getCustom3() {
		return custom3;
	}


	public void setStatus(int status ) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
}
