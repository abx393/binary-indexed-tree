import java.util.Arrays;

public class BIT {
	private int[] nums;
	private int[] BIT;
	private int n;
	
	public BIT(int[] nums) {
		this.nums = nums;
		this.n = nums.length;
		this.BIT = new int[n+1];
		for (int i = 0; i < n; i++) {
			update(i, nums[i]);
		}
	}

	public void update(int i, int amount) {
		i++;
		while (i <= n){
			BIT[i] += amount;
			i += (i&-i);
		}
	}

	public int getSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += BIT[i];
			i -= (i&-i);
		}
		return sum;
	}

	public int[] bit() {
		return BIT;
	}

	public static void main(String[] args) {
		/*
		int i = 5;
		for (int k=0; k<29; k++){
			System.out.print("0");
		}
		System.out.println(Integer.toBinaryString(i));

		System.out.println(Integer.toBinaryString(-i));
		System.out.println(i&-i);
		
		int j = 6;
		*/
		int[] test1 = {1, 2, 3, 4, 5, 6};
		BIT bit1 = new BIT(test1);
		System.out.println(Arrays.toString(bit1.bit()));
		System.out.println(bit1.getSum(5));
	}
}
