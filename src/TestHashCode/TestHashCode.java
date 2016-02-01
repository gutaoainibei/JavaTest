package TestHashCode;

public class TestHashCode {
    String id;
    String name;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestHashCode other = (TestHashCode) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    public static void main(String[] args) {
    	 TestHashCode testHashCode  = new TestHashCode();
    	 testHashCode.setId("1");
    	 TestHashCode testHashCode2 = new TestHashCode();
    	 testHashCode2.setId("1");
    	 System.out.println(testHashCode.equals(testHashCode2));
	}
}
