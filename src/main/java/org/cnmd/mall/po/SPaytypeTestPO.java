package org.cnmd.mall.po;

/**
 * <p>SPaytypeTest</p>
 * 类名:SPaytypeTest<br>
 * 创建人:mazy<br>
 * 创建时间:20171113<br>
 */
import java.math.BigDecimal; 
import java.sql.Timestamp;
import org.cnmd.common.db.BasicPO;
public class SPaytypeTestPO  extends BasicPO {


	public static final String TABLENAME = "s_paytype_test";
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return TABLENAME;
	}
	@Override
	public BigDecimal getPrimaryKeyValue() {
		return getSpaytypeId();
	}
	
	@Override
	public void setPrimaryKeyValue(BigDecimal primaryKey) {
		setSpaytypeId(primaryKey);
	}	
	
	@Override
	public String getPrimaryKeyName() {
		return "S_PAYTYPE_ID";
	}
	
	private  final static String[] FIELD_NAMES = {
		  "spaytypeId",
		  "name",
		  "accountno",
		  "useabled",
		  "sortseq",
		  "adClientId",
		  "adOrgId",
		  "created",
		  "createdby",
		  "updated",
		  "updatedby",
		  "isactive",
		  "key",
		  "url",
		  "url2",
		  "paytypecode",
		  "sourcesys",
		  "config",
	};
	private  final static String[] COLUMN_NAMES = {
		  "S_PAYTYPE_ID",
		  "NAME",
		  "ACCOUNTNO",
		  "USEABLED",
		  "SORTSEQ",
		  "AD_CLIENT_ID",
		  "AD_ORG_ID",
		  "CREATED",
		  "CREATEDBY",
		  "UPDATED",
		  "UPDATEDBY",
		  "ISACTIVE",
		  "KEY",
		  "URL",
		  "URL2",
		  "PAYTYPECODE",
		  "SOURCESYS",
		  "CONFIG",
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


    
    private BigDecimal spaytypeId;
    
    private String name;
    
    private String accountno;
    
    private String useabled;
    
    private BigDecimal sortseq;
    
    private BigDecimal adClientId;
    
    private BigDecimal adOrgId;
    
    private Timestamp created;
    
    private BigDecimal createdby;
    
    private Timestamp updated;
    
    private BigDecimal updatedby;
    
    private String isactive;
    
    private String key;
    
    private String url;
    
    private String url2;
    
    private Integer paytypecode;
    
    private String sourcesys;
    
    private String config;
	
    
    public BigDecimal getSpaytypeId() {
		return spaytypeId;
	}
	
	public void setSpaytypeId(BigDecimal spaytypeId) {
		this.spaytypeId = spaytypeId;
	}
    
    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
    
    public String getAccountno() {
		return accountno;
	}
	
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
    
    public String getUseabled() {
		return useabled;
	}
	
	public void setUseabled(String useabled) {
		this.useabled = useabled;
	}
    
    public BigDecimal getSortseq() {
		return sortseq;
	}
	
	public void setSortseq(BigDecimal sortseq) {
		this.sortseq = sortseq;
	}
    
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
    
    public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
    
    public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
    
    public String getUrl2() {
		return url2;
	}
	
	public void setUrl2(String url2) {
		this.url2 = url2;
	}
    
    public Integer getPaytypecode() {
		return paytypecode;
	}
	
	public void setPaytypecode(Integer paytypecode) {
		this.paytypecode = paytypecode;
	}
    
    public String getSourcesys() {
		return sourcesys;
	}
	
	public void setSourcesys(String sourcesys) {
		this.sourcesys = sourcesys;
	}
    
    public String getConfig() {
		return config;
	}
	
	public void setConfig(String config) {
		this.config = config;
	}

}