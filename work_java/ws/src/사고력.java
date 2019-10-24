
import java.io.*;
import java.util.*;

public class 사고력 {

	public static void main(String[] args) {
		int res = dfs(1000);
		System.out.println(res);
	}

	public static int dfs(int x) {
		if (x == 1) {
			return 1;
		}
		return 3 * dfs(x - 1) + 6;
	}

}
