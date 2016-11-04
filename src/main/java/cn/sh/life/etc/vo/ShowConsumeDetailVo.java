package cn.sh.life.etc.vo;

import cn.sh.life.etc.entity.ConsumeDetail;

public class ShowConsumeDetailVo extends ConsumeDetail {

	private String type;
	private String payName;
	private String status;
	private String showDate;
	private String sharePeopleName;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getSharePeopleName() {
		return sharePeopleName;
	}

	public void setSharePeopleName(String sharePeopleName) {
		this.sharePeopleName = sharePeopleName;
	}

}
