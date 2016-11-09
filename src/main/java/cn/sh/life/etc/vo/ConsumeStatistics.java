package cn.sh.life.etc.vo;

import java.util.List;

public class ConsumeStatistics {
	private Double sum;
	private Double avg;
	private List<StatisticsVo> list;

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public List<StatisticsVo> getList() {
		return list;
	}

	public void setList(List<StatisticsVo> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ConsumeStatistics [sum=" + sum + ", avg=" + avg + ", list=" + list + "]";
	}

}
