package cn.sh.life.etc.vo;

import java.util.List;

public class ShowConsumeDetailListVoPage {

	private Integer currentPage;
	private Integer totalPage;
	private List<ShowConsumeDetailListVo> list;
	private boolean hasNext;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<ShowConsumeDetailListVo> getList() {
		return list;
	}

	public void setList(List<ShowConsumeDetailListVo> list) {
		this.list = list;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

}
