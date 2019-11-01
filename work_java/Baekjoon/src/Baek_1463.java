
import java.io.*;
import java.util.*;

//1로 만들기
public class Baek_1463 {
	static int N, min;
	//Map<n값, n에 맞는 cnt>
	static Map<Integer, Integer> map = new HashMap();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		div(N, 0); 
		bw.append(min + "\n");
		bw.flush();
		bw.close();
	}
	//n은 숫자, cnt는 깊이(현재 내가 오는데 걸린 비용)
	static void div(int n, int cnt) {
		//기저조건은 n이 1일때 끝남
		if (n == 1) {
			//min을 계속 작은 값으로 넣어주면서 업데이트 하기
			min = Math.min(min, cnt);
			return;
		}
		//3으로 나눈 값, 2로 나눈 값, 1을 뺀 값을 모두 map에 저장하면서 들어가기
		//이때 상태 공간 트리는 3가지로 뻗으면서 가게 됨
		//키 값(n)이 포함되어 있으면, 
		if (map.containsKey(n)) {
			//map.get(n) 이전에 도착한 녀석이 걸린 비용
			if (map.get(n) >= cnt) {
				//작으면 새로운 비용으로 업데이트.
				map.put(n, cnt);
			}else
				return;
		} else //이전에 있던 것이 없으면, 새로운 것 알았으니까 map에 넣어주기
			map.put(n, cnt);

		if (n % 3 == 0)
			div(n / 3, cnt + 1);
		if (n % 2 == 0)
			div(n / 2, cnt + 1);

		div(n - 1, cnt + 1);
	}
}

/*
int memo[1000001];

int min(int a, int b)
{
    return a > b ? b : a;
}

int main(int argc, char const *argv[])
{
    int N;
    cin >> N;

    memo[1] = 0;

    for (int i = 2; i <= N; i++)
    {
        memo[i] = memo[i - 1] + 1;
        if (i % 2 == 0)
        {
            memo[i] = min(memo[i], memo[i / 2] + 1);
        }
        if (i % 3 == 0)
        {
            memo[i] = min(memo[i], memo[i / 3] + 1);
        }
    }

    cout << memo[N] << endl;
    return 0;
}*/