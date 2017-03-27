package ssm.autoCode.portal.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtils implements ApplicationContextAware {

	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 *
	 * @param applicationContext Spring的上下文环境
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtils.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取对象 这里重写了bean方法，起主要作用
	 *
	 * @param name
	 * @return Object 一个以所给名字注册的bean的实例
	 * @throws org.springframework.beans.BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
		return applicationContext.getBean(name, clazz);
	}

	public static Object getBeanByClass(Class<?> clazz) throws BeansException, ClassNotFoundException {
		return applicationContext.getBean(clazz);
	}

	public static Object getBeanByClassName(String name) throws BeansException, ClassNotFoundException {
		return applicationContext.getBean(Class.forName(name));
	}

	public static Object getBeanWithArgs(String name, Object... args) {
		return applicationContext.getBean(name, args);
	}
}
