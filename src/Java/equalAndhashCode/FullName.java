package Java.equalAndhashCode;

import java.util.HashSet;
import java.util.Set;

public class FullName{
	private String first,last;
	public FullName(String first,String last){
		this.first=first;
		this.last=last;
	}


	// If not overridden it'll not do the job as
	// equals fairly compares to the `this` reference
	@Override
	public boolean equals(Object o){
		if(!(o instanceof FullName))
			return false;
		FullName fullName=(FullName)o;
		return first.equals(fullName.first) && last.equals(fullName.last);
	}

	@Override
	public int hashCode(){
		return 31*first.hashCode()*last.hashCode();
	}

	public static void main(String[] args){
		Set<FullName> s=new HashSet<>();
		s.add(new FullName("Bibhuti","Panda"));
		s.add(new FullName("Bibhuti","Panda"));
		System.out.println(s.contains(new FullName("Bibhuti","Panda")));
		System.out.println(s.size());
	}
}
