import java.util.*;
import java.lang.*;

public class Main {

	static void dfs(int num, Set<Integer> res, int tmp) {
		if(tmp > num)
			return;
		if(!res.add(tmp))
			return;
		if( tmp%10 == 0) {
			dfs(num, res, tmp * 10 + 1);
		}else if(tmp%10 == 9) {
			dfs(num, res, tmp * 10 + 8);
		}else {
			dfs(num, res, tmp * 10 + tmp%10 - 1);
			dfs(num, res, tmp * 10 + tmp%10 + 1);
		}
	}
	
	public static void main (String[] args) throws InterruptedException {
		int num = 104;
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<10;i++) {
			dfs(num, set, i);
		}
		List<Integer> res = new ArrayList<>(set);
		Collections.sort(res);
		System.out.println(res);
	}
}

