package cn.sh.life.etc.vo;

import java.util.List;

import cn.sh.life.etc.entity.ConsumeDetail;

public class AddConsumeDetailVo extends ConsumeDetail {
	private String payPeople;
	private List<SharePeopleVo> share;
	private List<String> shareIds;
	private Integer type;
	private Integer messageId;

	public String getPayPeople() {
		return payPeople;
	}

	public void setPayPeople(String payPeople) {
		this.payPeople = payPeople;
	}

	public List<SharePeopleVo> getShare() {
		return share;
	}

	public void setShare(List<SharePeopleVo> share) {
		this.share = share;
	}

	public List<String> getShareIds() {
		return shareIds;
	}

	public void setShareIds(List<String> shareIds) {
		this.shareIds = shareIds;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

}
