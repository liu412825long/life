package cn.sh.life.etc.type;

public enum ConsumeStatus {
	NOCHECKOUT((byte) 0, "未结账"), CHECKOUT((byte) 1, "已结账");
	private byte id;
	private String name;

	private ConsumeStatus(byte id, String name) {
		this.id = id;
		this.name = name;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 普通方法
	public static ConsumeStatus getEnumById(byte id) {
		for (ConsumeStatus c : ConsumeStatus.values()) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	public static ConsumeStatus getEnumByName(String name) {
		for (ConsumeStatus c : ConsumeStatus.values()) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

}
