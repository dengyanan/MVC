package cn.et.springmvc.lesson01.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.springmvc.lesson01.dao.FoodDao;
import cn.et.springmvc.lesson01.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.et.springmvc.lesson01.dao.impl.FoodDao#getTableListPager(java.lang
	 * .String)
	 */
	public List<Map<String, Object>> getTableListPager(String name)
			throws Exception {
		if (name == null) {
			name = "";
		}
		return dao.getTableListPager(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#saveFood(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void saveFood(String foodName, String price, String imagePath)
			throws Exception {
		dao.saveFood(foodName, price, imagePath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.et.springmvc.lesson01.dao.impl.FoodDao#updateFood(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void updateFood(String foodid, String foodName, String price,String path)
			throws Exception {
		dao.updateFood(foodid, foodName, price,path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.et.springmvc.lesson01.dao.impl.FoodDao#deleteFoodType(java.lang.String
	 * )
	 */
	public void deleteFoodType(String foodid) throws Exception {
		dao.deleteFoodType(foodid);
	}

	public Map<String, Object> findById(String foodid) {
		return dao.findById(foodid);
	}
}
