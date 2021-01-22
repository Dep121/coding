class Bubble{
	static void bubbleSort(int a[]){
		for(int i=0; i<a.length-1; i++){
			for(int j=1; j<a.length-i; j++){
				if(a[j-1]>a[j]){
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	public static void main(String args[]){
		int a[] = {5,7,2,9,4,1};
		for(int i : a){
			System.out.print(i+", ");
		}
		System.out.println();
		bubbleSort(a);
		for(int i : a){
			System.out.print(i+", ");
		}
		System.out.println();
	}
}
