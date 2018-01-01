package cn.et.springmvc.lesson01.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {

	/**
	 * 封装了get方法
	 * @return
	 * @throws Exception
	 */
	public abstract List<Map<String, Object>> getTableListPager(String name)
			throws Exception;

	public abstract void saveFood(String foodName, String price,
			String imagePath) throws Exception;

	public abstract void updateFood(String foodid, String foodName, String price,String path)
			throws Exception;

	public abstract void deleteFoodType(String foodid) throws Exception;

	public Map<String, Object> findById(String foodid);
}