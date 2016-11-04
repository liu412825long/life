package cn.sh.life.etc.type;

public enum ConsumeType {
	FOOD((byte) 1, "餐饮费"), WORTER((byte) 2, "水电费"), ELECTRICITY((byte) 3, "电费"), GAS((byte) 4, "煤气费");

	private byte id;
	private String name;

	private ConsumeType(byte id, String name) {
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
	public static ConsumeType getEnumById(byte id) {
		for (ConsumeType c : ConsumeType.values()) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	public static ConsumeType getEnumByName(String name) {
		for (ConsumeType c : ConsumeType.values()) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

}
