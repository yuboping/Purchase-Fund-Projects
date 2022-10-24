package com.qiandai.util.config;

/**
 * 
 * <p>Title:Global</p>
 * <p>Description:全局路径配置</p>
 * <p>Company:北京钱袋宝公司南京分公司</p>
 * @author wanghaitao01@new4g.cn
 * @date 2016年5月4日下午2:16:38
 */
public class Global {
	public static final String BASIC_PATH = "/b";
	/**
	 * 设置管理端访问路径（ADMIN_PATH或FRONT_PATH可允许一个为空） 1. 修改本类 ADMIN_PATH 常量 2. 修改
	 * application.properties 中的 adminPath 属性值 3. 如果指定了 FRONT_PATH 为主页，需要修改
	 * application.properties 文件中 web.view.index 属性值
	 */
	public static final String ADMIN_PATH = "/a";
	
	/**
	 * 设置网站前端路径（ADMIN_PATH或FRONT_PATH可允许一个为空） 1. 修改本类 FRONT_PATH 常量 2. 如果指定了
	 * FRONT_PATH 为主页，需要修改 application.properties 文件中 web.view.index 属性值
	 */
	public static final String FRONT_PATH = "/";
	
	/**
	 * 设置网站前端路径（ADMIN_PATH或FRONT_PATH可允许一个为空） 1. 修改本类 FRONT_PATH 常量 2. 如果指定了
	 * FRONT_PATH 为主页，需要修改 application.properties 文件中 web.view.index 属性值
	 */
	public static final String WX_PATH = "/wx"; 
}
