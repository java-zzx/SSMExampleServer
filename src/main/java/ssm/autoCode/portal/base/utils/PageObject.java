package ssm.autoCode.portal.base.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页支持类
 * 
 * @author 蜘蛛侠
 */
public class PageObject<T> implements Serializable {

	private static final long serialVersionUID = 4080712481057208044L;

	public static final int PAGE_SIZE_TINY = 5;
	public static final int PAGE_SIZE_SMALL = 10;
	public static final int PAGE_SIZE_NORMAL = 25;
	public static final int PAGE_SIZE_LARGE = 50;
	public static final int PAGE_SIZE_HUGE = 100;

	private int size = PAGE_SIZE_SMALL; // 每页数量
	private int total = 0; // 数据总数
	private int num = 1; // 当前页数

	private int count;

	private List<T> data;
	private T obj;

	public PageObject() {
	}

	public PageObject(int total, int pageNum) {
		this(PAGE_SIZE_SMALL, total, pageNum);
	}

	public PageObject(int size, int total, int num) {
		this.size = size;
		this.setTotal(total);
		this.setNum(num);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int paramTotal) {
		total = paramTotal;
		count = total / size;
		if (total % size != 0) {
			count += 1;
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int paramNum) {
		this.num = paramNum;
		if (num > count) {
			num = count;
		}
		if (num < 1) {
			num = 1;
		}
	}

	public int getCount() {
		return count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	/**
	 * 获取当前页的第一个数据在全部数据中的索引
	 * 
	 * @return
	 */
	public int getStartIndex() {
		return (num - 1) * size;
	}
}
