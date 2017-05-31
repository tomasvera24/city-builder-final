
public class Sort {
	//sorting method code
	private int[] arr;
	
	public Sort(int[] arr) {
		this.arr = arr;
	}
	
	public void insertionSort() {
	   for (int i = 1; i < arr.length; i++) {
	      int index = arr[i]; int j = i;
	      while (j > 0 && arr[j-1] > index) {
	           arr[j] = arr[j-1];
	           j--;
	      }
	      arr[j] = index;
	   }
	}
}
