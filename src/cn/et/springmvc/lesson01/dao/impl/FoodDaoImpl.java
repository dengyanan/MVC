package cn.et.springmvc.lesson01.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson01.dao.FoodDao;
@Repository
public class FoodDaoImpl implements FoodDao {

	@Autowired
	JdbcTemplate template;
   
   public List<Map<String, Object>> getTableListPager(String name) throws Exception{
       StringBuffer sb=new StringBuffer();
       String sql="select * from food t  where t.foodname like '%"+name+"%'";
       List<Map<String, Object>> result=template.queryForList(sql);
       return result;
   }
   
   
 
public void saveFood(String foodName,String price,String imagePath) throws Exception{
       String sql="insert into food values((select nvl(max(foodid),0)+1 from food),'"+foodName+"','"+price+"','"+imagePath+"')";
       template.execute(sql);
   }
    

public void updateFood(String foodid,String foodName,String price,String path) throws Exception{
       String sql="update food set foodname='"+foodName+"',price='"+price+"',imagepath='"+path+"' where foodid="+foodid;
       template.execute(sql);
   }
  
public void deleteFoodType(String foodid) throws Exception{
       String sql="delete from  food  where foodid="+foodid;
       template.execute(sql);
   }


public Map<String, Object> findById(String foodid) {
	 StringBuffer sb=new StringBuffer();
     String sql="select * from food t  where t.foodid = "+foodid;
     List<Map<String, Object>> result=template.queryForList(sql);
     return result.get(0);
}
}
