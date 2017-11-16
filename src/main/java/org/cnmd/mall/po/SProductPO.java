package org.cnmd.mall.po;

/**
 * <p>SProduct</p>
 * 类名:SProduct<br>
 * 创建人:mazy<br>
 * 创建时间:20171113<br>
 */
import java.math.BigDecimal; 
import java.sql.Timestamp;
import org.cnmd.common.db.BasicPO;
public class SProductPO  extends BasicPO {


	public static final String TABLENAME = "s_product";
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return TABLENAME;
	}
	@Override
	public BigDecimal getPrimaryKeyValue() {
		return getSproductId();
	}
	
	@Override
	public void setPrimaryKeyValue(BigDecimal primaryKey) {
		setSproductId(primaryKey);
	}	
	
	@Override
	public String getPrimaryKeyName() {
		return "S_PRODUCT_ID";
	}
	
	private  final static String[] FIELD_NAMES = {
		  "adClientId",
		  "adOrgId",
		  "created",
		  "createdby",
		  "updated",
		  "updatedby",
		  "isactive",
		  "sproductId",
		  "sbrandId",
		  "sclassificationId",
		  "seokey",
		  "name",
		  "ishasimage",
		  "isshelved",
		  "statusupdateddate",
		  "isgroupproduct",
		  "saleprice",
		  "seqno",
		  "description",
		  "saleinit",
		  "storagetype",
		  "value",
		  "integral",
		  "productstyle",
		  "manufacturer",
		  "lbundleQty",
		  "uom",
		  "otctype",
		  "certificateno",
		  "productname",
		  "mbundleQty",
		  "sbundleQty",
		  "medicinename",
		  "isotc",
		  "productspec",
		  "productcode",
		  "eaiProductId",
		  "safetyqty",
		  "productarea",
		  "memberprice",
		  "businessscope",
		  "isinsurance",
		  "insurancetype",
		  "isbasicmedicine",
		  "lot",
		  "qtyonline",
		  "instruction",
		  "isneedsync",
		  "adServerId",
		  "retailuom",
		  "uomratio",
		  "sourceServerId",
		  "returnable",
	};
	private  final static String[] COLUMN_NAMES = {
		  "AD_CLIENT_ID",
		  "AD_ORG_ID",
		  "CREATED",
		  "CREATEDBY",
		  "UPDATED",
		  "UPDATEDBY",
		  "ISACTIVE",
		  "S_PRODUCT_ID",
		  "S_BRAND_ID",
		  "S_CLASSIFICATION_ID",
		  "SEOKEY",
		  "NAME",
		  "ISHASIMAGE",
		  "ISSHELVED",
		  "STATUSUPDATEDDATE",
		  "ISGROUPPRODUCT",
		  "SALEPRICE",
		  "SEQNO",
		  "DESCRIPTION",
		  "SALEINIT",
		  "STORAGETYPE",
		  "VALUE",
		  "INTEGRAL",
		  "PRODUCTSTYLE",
		  "MANUFACTURER",
		  "L_BUNDLE_QTY",
		  "UOM",
		  "OTCTYPE",
		  "CERTIFICATENO",
		  "PRODUCTNAME",
		  "M_BUNDLE_QTY",
		  "S_BUNDLE_QTY",
		  "MEDICINENAME",
		  "ISOTC",
		  "PRODUCTSPEC",
		  "PRODUCTCODE",
		  "EAI_PRODUCT_ID",
		  "SAFETYQTY",
		  "PRODUCTAREA",
		  "MEMBERPRICE",
		  "BUSINESSSCOPE",
		  "ISINSURANCE",
		  "INSURANCETYPE",
		  "ISBASICMEDICINE",
		  "LOT",
		  "QTYONLINE",
		  "INSTRUCTION",
		  "ISNEEDSYNC",
		  "AD_SERVER_ID",
		  "RETAILUOM",
		  "UOMRATIO",
		  "SOURCE_SERVER_ID",
		  "RETURNABLE",
	};
	
	@Override
	public String[] getColumns() {
		// TODO Auto-generated method stub
		return COLUMN_NAMES;
	}
	@Override
	public String[] getFields() {
		// TODO Auto-generated method stub
		return FIELD_NAMES;
	}


    
    private BigDecimal adClientId;
    
    private BigDecimal adOrgId;
    
    private Timestamp created;
    
    private BigDecimal createdby;
    
    private Timestamp updated;
    
    private BigDecimal updatedby;
    
    private String isactive;
    
    private BigDecimal sproductId;
    
    private BigDecimal sbrandId;
    
    private BigDecimal sclassificationId;
    
    private String seokey;
    
    private String name;
    
    private String ishasimage;
    
    private String isshelved;
    
    private Timestamp statusupdateddate;
    
    private String isgroupproduct;
    
    private BigDecimal saleprice;
    
    private BigDecimal seqno;
    
    private String description;
    
    private BigDecimal saleinit;
    
    private String storagetype;
    
    private String value;
    
    private BigDecimal integral;
    
    private String productstyle;
    
    private String manufacturer;
    
    private BigDecimal lbundleQty;
    
    private String uom;
    
    private String otctype;
    
    private String certificateno;
    
    private String productname;
    
    private BigDecimal mbundleQty;
    
    private BigDecimal sbundleQty;
    
    private String medicinename;
    
    private String isotc;
    
    private String productspec;
    
    private String productcode;
    
    private BigDecimal eaiProductId;
    
    private BigDecimal safetyqty;
    
    private String productarea;
    
    private BigDecimal memberprice;
    
    private String businessscope;
    
    private String isinsurance;
    
    private String insurancetype;
    
    private String isbasicmedicine;
    
    private String lot;
    
    private BigDecimal qtyonline;
    
    private byte[] instruction;
    
    private String isneedsync;
    
    private BigDecimal adServerId;
    
    private String retailuom;
    
    private BigDecimal uomratio;
    
    private BigDecimal sourceServerId;
    
    private String returnable;
	
    
    public BigDecimal getAdClientId() {
		return adClientId;
	}
	
	public void setAdClientId(BigDecimal adClientId) {
		this.adClientId = adClientId;
	}
    
    public BigDecimal getAdOrgId() {
		return adOrgId;
	}
	
	public void setAdOrgId(BigDecimal adOrgId) {
		this.adOrgId = adOrgId;
	}
    
    public Timestamp getCreated() {
		return created;
	}
	
	public void setCreated(Timestamp created) {
		this.created = created;
	}
    
    public BigDecimal getCreatedby() {
		return createdby;
	}
	
	public void setCreatedby(BigDecimal createdby) {
		this.createdby = createdby;
	}
    
    public Timestamp getUpdated() {
		return updated;
	}
	
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
    
    public BigDecimal getUpdatedby() {
		return updatedby;
	}
	
	public void setUpdatedby(BigDecimal updatedby) {
		this.updatedby = updatedby;
	}
    
    public String getIsactive() {
		return isactive;
	}
	
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
    
    public BigDecimal getSproductId() {
		return sproductId;
	}
	
	public void setSproductId(BigDecimal sproductId) {
		this.sproductId = sproductId;
	}
    
    public BigDecimal getSbrandId() {
		return sbrandId;
	}
	
	public void setSbrandId(BigDecimal sbrandId) {
		this.sbrandId = sbrandId;
	}
    
    public BigDecimal getSclassificationId() {
		return sclassificationId;
	}
	
	public void setSclassificationId(BigDecimal sclassificationId) {
		this.sclassificationId = sclassificationId;
	}
    
    public String getSeokey() {
		return seokey;
	}
	
	public void setSeokey(String seokey) {
		this.seokey = seokey;
	}
    
    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
    
    public String getIshasimage() {
		return ishasimage;
	}
	
	public void setIshasimage(String ishasimage) {
		this.ishasimage = ishasimage;
	}
    
    public String getIsshelved() {
		return isshelved;
	}
	
	public void setIsshelved(String isshelved) {
		this.isshelved = isshelved;
	}
    
    public Timestamp getStatusupdateddate() {
		return statusupdateddate;
	}
	
	public void setStatusupdateddate(Timestamp statusupdateddate) {
		this.statusupdateddate = statusupdateddate;
	}
    
    public String getIsgroupproduct() {
		return isgroupproduct;
	}
	
	public void setIsgroupproduct(String isgroupproduct) {
		this.isgroupproduct = isgroupproduct;
	}
    
    public BigDecimal getSaleprice() {
		return saleprice;
	}
	
	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
	}
    
    public BigDecimal getSeqno() {
		return seqno;
	}
	
	public void setSeqno(BigDecimal seqno) {
		this.seqno = seqno;
	}
    
    public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
    
    public BigDecimal getSaleinit() {
		return saleinit;
	}
	
	public void setSaleinit(BigDecimal saleinit) {
		this.saleinit = saleinit;
	}
    
    public String getStoragetype() {
		return storagetype;
	}
	
	public void setStoragetype(String storagetype) {
		this.storagetype = storagetype;
	}
    
    public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
    
    public BigDecimal getIntegral() {
		return integral;
	}
	
	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}
    
    public String getProductstyle() {
		return productstyle;
	}
	
	public void setProductstyle(String productstyle) {
		this.productstyle = productstyle;
	}
    
    public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
    
    public BigDecimal getLbundleQty() {
		return lbundleQty;
	}
	
	public void setLbundleQty(BigDecimal lbundleQty) {
		this.lbundleQty = lbundleQty;
	}
    
    public String getUom() {
		return uom;
	}
	
	public void setUom(String uom) {
		this.uom = uom;
	}
    
    public String getOtctype() {
		return otctype;
	}
	
	public void setOtctype(String otctype) {
		this.otctype = otctype;
	}
    
    public String getCertificateno() {
		return certificateno;
	}
	
	public void setCertificateno(String certificateno) {
		this.certificateno = certificateno;
	}
    
    public String getProductname() {
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname = productname;
	}
    
    public BigDecimal getMbundleQty() {
		return mbundleQty;
	}
	
	public void setMbundleQty(BigDecimal mbundleQty) {
		this.mbundleQty = mbundleQty;
	}
    
    public BigDecimal getSbundleQty() {
		return sbundleQty;
	}
	
	public void setSbundleQty(BigDecimal sbundleQty) {
		this.sbundleQty = sbundleQty;
	}
    
    public String getMedicinename() {
		return medicinename;
	}
	
	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}
    
    public String getIsotc() {
		return isotc;
	}
	
	public void setIsotc(String isotc) {
		this.isotc = isotc;
	}
    
    public String getProductspec() {
		return productspec;
	}
	
	public void setProductspec(String productspec) {
		this.productspec = productspec;
	}
    
    public String getProductcode() {
		return productcode;
	}
	
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
    
    public BigDecimal getEaiProductId() {
		return eaiProductId;
	}
	
	public void setEaiProductId(BigDecimal eaiProductId) {
		this.eaiProductId = eaiProductId;
	}
    
    public BigDecimal getSafetyqty() {
		return safetyqty;
	}
	
	public void setSafetyqty(BigDecimal safetyqty) {
		this.safetyqty = safetyqty;
	}
    
    public String getProductarea() {
		return productarea;
	}
	
	public void setProductarea(String productarea) {
		this.productarea = productarea;
	}
    
    public BigDecimal getMemberprice() {
		return memberprice;
	}
	
	public void setMemberprice(BigDecimal memberprice) {
		this.memberprice = memberprice;
	}
    
    public String getBusinessscope() {
		return businessscope;
	}
	
	public void setBusinessscope(String businessscope) {
		this.businessscope = businessscope;
	}
    
    public String getIsinsurance() {
		return isinsurance;
	}
	
	public void setIsinsurance(String isinsurance) {
		this.isinsurance = isinsurance;
	}
    
    public String getInsurancetype() {
		return insurancetype;
	}
	
	public void setInsurancetype(String insurancetype) {
		this.insurancetype = insurancetype;
	}
    
    public String getIsbasicmedicine() {
		return isbasicmedicine;
	}
	
	public void setIsbasicmedicine(String isbasicmedicine) {
		this.isbasicmedicine = isbasicmedicine;
	}
    
    public String getLot() {
		return lot;
	}
	
	public void setLot(String lot) {
		this.lot = lot;
	}
    
    public BigDecimal getQtyonline() {
		return qtyonline;
	}
	
	public void setQtyonline(BigDecimal qtyonline) {
		this.qtyonline = qtyonline;
	}
    
    public byte[] getInstruction() {
		return instruction;
	}
	
	public void setInstruction(byte[] instruction) {
		this.instruction = instruction;
	}
    
    public String getIsneedsync() {
		return isneedsync;
	}
	
	public void setIsneedsync(String isneedsync) {
		this.isneedsync = isneedsync;
	}
    
    public BigDecimal getAdServerId() {
		return adServerId;
	}
	
	public void setAdServerId(BigDecimal adServerId) {
		this.adServerId = adServerId;
	}
    
    public String getRetailuom() {
		return retailuom;
	}
	
	public void setRetailuom(String retailuom) {
		this.retailuom = retailuom;
	}
    
    public BigDecimal getUomratio() {
		return uomratio;
	}
	
	public void setUomratio(BigDecimal uomratio) {
		this.uomratio = uomratio;
	}
    
    public BigDecimal getSourceServerId() {
		return sourceServerId;
	}
	
	public void setSourceServerId(BigDecimal sourceServerId) {
		this.sourceServerId = sourceServerId;
	}
    
    public String getReturnable() {
		return returnable;
	}
	
	public void setReturnable(String returnable) {
		this.returnable = returnable;
	}

}