package com.qiandai.util.config;

/**
 * 
 * <p>Title:Global</p>
 * <p>Description:ȫ��·������</p>
 * <p>Company:����Ǯ������˾�Ͼ��ֹ�˾</p>
 * @author wanghaitao01@new4g.cn
 * @date 2016��5��4������2:16:38
 */
public class Global {
	public static final String BASIC_PATH = "/b";
	/**
	 * ���ù���˷���·����ADMIN_PATH��FRONT_PATH������һ��Ϊ�գ� 1. �޸ı��� ADMIN_PATH ���� 2. �޸�
	 * application.properties �е� adminPath ����ֵ 3. ���ָ���� FRONT_PATH Ϊ��ҳ����Ҫ�޸�
	 * application.properties �ļ��� web.view.index ����ֵ
	 */
	public static final String ADMIN_PATH = "/a";
	
	/**
	 * ������վǰ��·����ADMIN_PATH��FRONT_PATH������һ��Ϊ�գ� 1. �޸ı��� FRONT_PATH ���� 2. ���ָ����
	 * FRONT_PATH Ϊ��ҳ����Ҫ�޸� application.properties �ļ��� web.view.index ����ֵ
	 */
	public static final String FRONT_PATH = "/";
	
	/**
	 * ������վǰ��·����ADMIN_PATH��FRONT_PATH������һ��Ϊ�գ� 1. �޸ı��� FRONT_PATH ���� 2. ���ָ����
	 * FRONT_PATH Ϊ��ҳ����Ҫ�޸� application.properties �ļ��� web.view.index ����ֵ
	 */
	public static final String WX_PATH = "/wx"; 
}
