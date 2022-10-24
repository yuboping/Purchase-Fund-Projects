package com.qiandai.util.excel;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//import org.apache.commons.beanutils.BeanUtils;  

/**
 * ����Person����ΪBeanUtilTest���ڲ���ʱ���������<br>
 * java.lang.NoSuchMethodException: Property '**' has no setter method<br>
 * ���ʣ��ڲ��� �� �����ļ��е�������� <br>
 * BeanUtils.populate���������ƣ�<br>
 * The class must be public, and provide a public constructor that accepts no
 * arguments. <br>
 * This allows tools and applications to dynamically create new instances of
 * your bean, <br>
 * without necessarily knowing what Java class name will be used ahead of time
 */
public class BeanUtilTest {

	public static void main(String[] args) {

		PersonBean person = new PersonBean();
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("name", "Mike");
		mp.put("age", 25);
		mp.put("mN", "male");

		// ��mapת��Ϊbean
		transMap2Bean(mp, person);

		System.out.println("--- transMap2Bean Map Info: ");
		for (Map.Entry<String, Object> entry : mp.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println("--- Bean Info: ");
		System.out.println("name: " + person.getName());
		System.out.println("age: " + person.getAge());
		System.out.println("mN: " + person.getmN());

		// ��javaBean ת��Ϊmap
		Map<String, Object> map = transBean2Map(person);

		System.out.println("--- transBean2Map Map Info: ");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	}

	// Map --> Bean 2: ����org.apache.commons.beanutils ������ʵ�� Map --> Bean
	// public static void transMap2Bean2(Map<String, Object> map, Object obj) {
	// if (map == null || obj == null) {
	// return;
	// }
	// try {
	// BeanUtils.populate(obj, map);
	// } catch (Exception e) {
	// System.out.println("transMap2Bean2 Error " + e);
	// }
	// }

	// Map --> Bean 1: ����Introspector,PropertyDescriptorʵ�� Map --> Bean
	public static void transMap2Bean(Map<String, Object> map, Object obj) {

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (map.containsKey(key)) {
					Object value = map.get(key);
					// �õ�property��Ӧ��setter����
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}

			}

		} catch (Exception e) {
			System.out.println("transMap2Bean Error " + e);
		}

		return;

	}

	// Bean --> Map 1: ����Introspector��PropertyDescriptor ��Bean --> Map
	public static Map<String, Object> transBean2Map(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// ����class����
				if (!key.equals("class")) {
					// �õ�property��Ӧ��getter����
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}

			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}

		return map;

	}
}