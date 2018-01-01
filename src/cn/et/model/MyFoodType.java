package cn.et.model;

import java.util.List;
import java.util.Map;

public class MyFoodType {
	public Integer getTableListCount(String name) throws Exception {
		if (name == null) {
			name = " ";
		}
		String sql = "select count(rowid) as cr from foodtype where typename like '%" + name + "%' ";
		List<Map> result = Dbutil.query(sql);
		return Integer.parseInt(result.get(0).get("CR").toString());
	}
	public pageTools getTableListPager(String name, Integer curPage) throws Exception {
		if (name == null) {
			name = "";
		}
		Integer totalCount = getTableListCount(name);
		pageTools pt = new pageTools(curPage, totalCount, null);
		String sql = "select * from (select t.*,rownum rn from foodtype t where t.typename like '%" + name + "%') "
				+ "where rn>=" + pt.getStartIndex() + " and rn<=" + pt.getEndIndex();
		List<Map> result = Dbutil.query(sql);
		pt.setData(result);
		return pt;
	
}
}
