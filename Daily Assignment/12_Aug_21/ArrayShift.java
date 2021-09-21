import java.util.Scanner;

public class ArrayShift {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] arr=new int[]{1,2,3,4,5};
		System.out.println("Enter the right shift number ");
		int r=sc.nextInt();
		ArrayShift right=new ArrayShift();
		right.rightshift(arr, r, arr.length);
		right.printArray(arr, arr.length);
		}
	void rightshift(int arr[],int d,int n){
		while(d>n)
		{
			d=d-n;
		}
		int temp[]=new int[n-d];
		for (int i = 0; i < n - d; i++)
            temp[i] = arr[i];
        for (int i = n - d; i < n; i++) {
            arr[i - n + d] = arr[i];
        }
        for (int i = 0; i < n - d; i++) {
            arr[i + d] = temp[i];
        }
    }
    void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
		
	}


