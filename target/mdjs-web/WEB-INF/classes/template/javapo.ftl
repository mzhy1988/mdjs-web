package ${javapackage}.po;

/**
 * <p>${title}</p>
 * 类名:${className}<br>
 * 创建人:${author}<br>
 * 创建时间:${createTime}<br>
 */
import java.math.BigDecimal; 
import java.sql.Timestamp;
import org.cnmd.common.db.BasicPO;
public class ${className}PO  extends BasicPO {


	public static final String TABLENAME = "${tableName}";
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return TABLENAME;
	}
	@Override
	public BigDecimal getPrimaryKeyValue() {
		return get${fieldPrimaryKey?cap_first}();
	}
	
	@Override
	public void setPrimaryKeyValue(BigDecimal primaryKey) {
		set${fieldPrimaryKey?cap_first}(primaryKey);
	}	
	
	@Override
	public String getPrimaryKeyName() {
		return "${primaryKey}";
	}
	
	private  final static String[] FIELD_NAMES = {
		<#list feilds as propertyName>
		  "${propertyName}",
		</#list>
	};
	private  final static String[] COLUMN_NAMES = {
		<#list columns as propertyName>
		  "${propertyName}",
		</#list>
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


	<#list feilds as propertyName>
    
    private ${feildTypes[propertyName_index]} ${propertyName};
    </#list>
	
    <#list feilds as propertyName>
    
    public ${feildTypes[propertyName_index]} get${propertyName?cap_first}() {
		return ${propertyName};
	}
	
	public void set${propertyName?cap_first}(${feildTypes[propertyName_index]} ${propertyName}) {
		this.${propertyName} = ${propertyName};
	}
    </#list>

}