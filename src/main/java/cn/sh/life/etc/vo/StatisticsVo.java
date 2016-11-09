package cn.sh.life.etc.vo;

public class StatisticsVo {
	private Integer paied;
	private String name;
	private Double payMoney;
	private Double shareMoney;
	private String info;
	private Double resultMoney;

	public Integer getPaied() {
		return paied;
	}

	public void setPaied(Integer paied) {
		this.paied = paied;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public Double getShareMoney() {
		return shareMoney;
	}

	public void setShareMoney(Double shareMoney) {
		this.shareMoney = shareMoney;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Double getResultMoney() {
		return resultMoney;
	}

	public void setResultMoney(Double resultMoney) {
		this.resultMoney = resultMoney;
	}

	@Override
	public String toString() {
		return "StatisticsVo [paied=" + paied + ", name=" + name + ", payMoney=" + payMoney + ", shareMoney="
				+ shareMoney + ", info=" + info + ", resultMoney=" + resultMoney + "]";
	}

}
