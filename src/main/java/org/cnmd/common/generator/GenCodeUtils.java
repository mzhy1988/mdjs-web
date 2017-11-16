package org.cnmd.common.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.cnmd.common.utils.DateUtil;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;


public class GenCodeUtils {

	public static void generateFile(String fileName, String templateName, Map<Object, Object> map){
		Configuration config = new Configuration(Configuration.VERSION_2_3_23);
		config.setDefaultEncoding("UTF-8");
		config.setTemplateLoader(new ClassTemplateLoader(GenCodeUtils.class, "/"));
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		File file = new File(fileName);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.err.println(file.getAbsolutePath());
		try{
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			Template template = config.getTemplate("template" + File.separatorChar + templateName);
			for (Map.Entry<Object, Object> entry : map.entrySet()) {  
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
			} 
			template.process(map, out);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String getPackageDir(String paxkage){
		String separatorChar =  String.valueOf(File.separatorChar);
		String packageDir = separatorChar;
		String[] lst = paxkage.split("\\.");
		for (int i = 0; i < lst.length; i++) {
			packageDir = packageDir + lst[i]+separatorChar;
		}
		return packageDir;
	}
	public static void main(String[] args) throws Exception {
		// 1.创建目录
//		Params params = UtilXML.params;
		Properties prop = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("generator.properties");
		prop.load(in);
		String tablesFromProperies = prop.getProperty(Constants.TABLES);
		if(tablesFromProperies == null || tablesFromProperies.equals("")){
			System.out.println("表名为空");
			throw new Exception();
		}
		String[] tablesArray = tablesFromProperies.split(",");
		List<Tables> tables = new ArrayList<Tables>();
		for (int i = 0; i < tablesArray.length; i++) {
			Tables tb = new Tables();
			tb.setTableName(tablesArray[i].toLowerCase());
			tables.add(tb);
		}

		for (Tables table : tables) {
			String javaClassName = GenUtils.getClassName(table.getTableName());
			Map<Object, Object> map =GenDBUtils.getTableInfo(table.getTableName());
			map.put("author", "mazy");
			map.put("createTime", DateUtil.getToday());

			//map.put("project", params.getProject());
			map.put("className", GenUtils.getClassName(table.getTableName()));
			//map.put("voClassName", javaClassName);
			map.put("javapackage", prop.getProperty(Constants.PACKAGE));
			//1.po
			String poName = prop.getProperty(Constants.OSDIR) + getPackageDir(prop.getProperty(Constants.PACKAGE)) + "po" + File.separatorChar + javaClassName + "PO.java";
			generateFile(poName, "javapo.ftl", map);
			// 2.vo
			//String voName = params.getOsdir() + File.separatorChar + "vo" + File.separatorChar + javaClassName + "VO.java";
			//UtilFreemarker.generateFile(voName, "javavo.ftl", map);
			// 2.dao
//			String daoName = params.getOsdir() + UtilFile.getPackageDir(params) + "dao" + File.separatorChar + javaClassName + "Dao.java";
//			UtilFreemarker.generateFile(daoName, "JavaDao.ftl", map);
			// 2.daoimpl
//			String daoImplName = params.getOsdir() + UtilFile.getPackageDir(params) + "dao" + File.separatorChar + javaClassName + "DaoImpl.java";
//			UtilFreemarker.generateFile(daoImplName, "JavaDaoImpl.ftl", map);
			// 2.daoimpl
//			String mapName = params.getOsdir() + UtilFile.getPackageDir(params) + "bean" + File.separatorChar + javaClassName + "Map.xml";
//			UtilFreemarker.generateFile(mapName, "Map.ftl", map);

			// 2.daoimpl
//			String DBPOName = params.getOsdir() + UtilFile.getPackageDir(params) + "bean" + File.separatorChar + javaClassName + ".java";
//			UtilFreemarker.generateFile(DBPOName, "simple-framework-o.ftl", map);

			// 3.xml
			//String xmlName = params.getOsdir() + File.separatorChar + "xml" + File.separatorChar + javaClassName + ".xml";
			//UtilFreemarker.generateFile(xmlName, "xml.ftl", map);
		}
	}
}
