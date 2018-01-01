package cn.et.model;

import java.util.List;

/**
 * ��ҳ����
 */
public class pageTools {
	/**
	 * �������  
	 * @param curPage ҳ�洫��ĵ�ǰҳ
	 * @param totalCount ���ݿ��ѯ���ܼ�¼��
	 * @param pageCount ÿҳ��ʾ������
	 */
	public pageTools(Integer curPage,Integer totalCount,Integer pageCount){
		this.curPage=curPage;
		this.totalCount=totalCount;
		this.pageCount=pageCount==null?this.pageCount:pageCount;
		this.prePage=(curPage==1?1:curPage-1);
		this.totalPage=totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1;
		this.nextPage=(curPage==totalPage)?totalPage:(curPage+1);
		this.startIndex=(curPage-1)*this.pageCount+1;
		this.endIndex=curPage*this.pageCount;
	}
//��ǰҳ
	private Integer curPage;
//ÿһҳ��ʾ������
	private Integer pageCount=10;
//��һҳ
	private Integer prePage;
//��һҳ
	private Integer nextPage;
//��ҳ��
	private Integer totalPage;
//�ܼ�¼��
	private  Integer totalCount;
	//��ʼ����
	private Integer startIndex;
	//��������
	private Integer endIndex;
	//�洢���ղ�ѯ������
	private List data;
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	public static void main(String[] args) {
		int curPage=2;
		int totalCount=26;
		int pageCount=5;
		pageTools pt=new pageTools(curPage, totalCount, pageCount);
		System.out.println(pt.getNextPage());
		System.out.println(pt.getPrePage());
		System.out.println(pt.getTotalPage());
		System.out.println(pt.getStartIndex());
		System.out.println(pt.getEndIndex());
	}
}
