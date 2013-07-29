package de.ytek.maklerpoint.beratungsprotokoll.daten;

public class StammDaten {

	private int _id;

    private String _firmenName;
    private String _zusatz;

    private String _firmenRechtsform;


    private String _steuerNummer;
    private String _ustNummer;
    
    private String _vermoegensHaftpflicht;

    private boolean _beteiligungenVU = false; // Beteiligungen an Versicherungsunternehmen
    private boolean _beteiligungenMAK = false; // Beteiligungen am Makler


    private String _beraterTyp; // Versicherungsberater, Versicherungsmakler, Mehrfirmenvertretter, Versicherungsvertretter für ein VU
    private String _ihkName;
    private String _ihkRegistriernummer;
    private String _ihkStatus;
    private String _ihkAbweichungen = "";

    private boolean _34c = false;
    private boolean _34d = false;

    private String _briefkopf;

    // Adress Daten

    private String _strasse;
    private String _plz;
    private String _ort;
    private String _land;

    // Kontaktdaten
    private String _telefon;
    private String _mobil;
    private String _fax;  
    private String _email;
    private String _website;

    private String _custom1;
    private String _custom2;
    private String _custom3;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_firmenName() {
		return _firmenName;
	}
	public void set_firmenName(String _firmenName) {
		this._firmenName = _firmenName;
	}
	public String get_zusatz() {
		return _zusatz;
	}
	public void set_zusatz(String _zusatz) {
		this._zusatz = _zusatz;
	}
	public String get_firmenRechtsform() {
		return _firmenRechtsform;
	}
	public void set_firmenRechtsform(String _firmenRechtsform) {
		this._firmenRechtsform = _firmenRechtsform;
	}
	public String get_steuerNummer() {
		return _steuerNummer;
	}
	public void set_steuerNummer(String _steuerNummer) {
		this._steuerNummer = _steuerNummer;
	}
	public String get_ustNummer() {
		return _ustNummer;
	}
	public void set_ustNummer(String _ustNummer) {
		this._ustNummer = _ustNummer;
	}
	public String get_vermoegensHaftpflicht() {
		return _vermoegensHaftpflicht;
	}
	public void set_vermoegensHaftpflicht(String _vermoegensHaftpflicht) {
		this._vermoegensHaftpflicht = _vermoegensHaftpflicht;
	}
	public boolean is_beteiligungenVU() {
		return _beteiligungenVU;
	}
	public void set_beteiligungenVU(boolean _beteiligungenVU) {
		this._beteiligungenVU = _beteiligungenVU;
	}
	public boolean is_beteiligungenMAK() {
		return _beteiligungenMAK;
	}
	public void set_beteiligungenMAK(boolean _beteiligungenMAK) {
		this._beteiligungenMAK = _beteiligungenMAK;
	}
	public String get_beraterTyp() {
		return _beraterTyp;
	}
	public void set_beraterTyp(String _beraterTyp) {
		this._beraterTyp = _beraterTyp;
	}
	public String get_ihkName() {
		return _ihkName;
	}
	public void set_ihkName(String _ihkName) {
		this._ihkName = _ihkName;
	}
	public String get_ihkRegistriernummer() {
		return _ihkRegistriernummer;
	}
	public void set_ihkRegistriernummer(String _ihkRegistriernummer) {
		this._ihkRegistriernummer = _ihkRegistriernummer;
	}
	public String get_ihkStatus() {
		return _ihkStatus;
	}
	public void set_ihkStatus(String _ihkStatus) {
		this._ihkStatus = _ihkStatus;
	}
	public String get_ihkAbweichungen() {
		return _ihkAbweichungen;
	}
	public void set_ihkAbweichungen(String _ihkAbweichungen) {
		this._ihkAbweichungen = _ihkAbweichungen;
	}
	public boolean is_34c() {
		return _34c;
	}
	public void set_34c(boolean _34c) {
		this._34c = _34c;
	}
	public boolean is_34d() {
		return _34d;
	}
	public void set_34d(boolean _34d) {
		this._34d = _34d;
	}
	public String get_briefkopf() {
		return _briefkopf;
	}
	public void set_briefkopf(String _briefkopf) {
		this._briefkopf = _briefkopf;
	}
	public String get_strasse() {
		return _strasse;
	}
	public void set_strasse(String _strasse) {
		this._strasse = _strasse;
	}
	public String get_plz() {
		return _plz;
	}
	public void set_plz(String _plz) {
		this._plz = _plz;
	}
	public String get_ort() {
		return _ort;
	}
	public void set_ort(String _ort) {
		this._ort = _ort;
	}
	public String get_land() {
		return _land;
	}
	public void set_land(String _land) {
		this._land = _land;
	}
	public String get_telefon() {
		return _telefon;
	}
	public void set_telefon(String _telefon) {
		this._telefon = _telefon;
	}
	public String get_mobil() {
		return _mobil;
	}
	public void set_mobil(String _mobil) {
		this._mobil = _mobil;
	}
	public String get_fax() {
		return _fax;
	}
	public void set_fax(String _fax) {
		this._fax = _fax;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}
	public String get_website() {
		return _website;
	}
	public void set_website(String _website) {
		this._website = _website;
	}
	public String get_custom1() {
		return _custom1;
	}
	public void set_custom1(String _custom1) {
		this._custom1 = _custom1;
	}
	public String get_custom2() {
		return _custom2;
	}
	public void set_custom2(String _custom2) {
		this._custom2 = _custom2;
	}
	public String get_custom3() {
		return _custom3;
	}
	public void set_custom3(String _custom3) {
		this._custom3 = _custom3;
	}

    
    
}
