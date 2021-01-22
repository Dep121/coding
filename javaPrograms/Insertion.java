class Insertion{
	static void insertionSort(int a[]){
		for(int i=1; i<a.length; i++){
			int key = a[i];
			int j;
			for(j=i-1; j>-1; j--){
				if(a[j] > key)
					a[j+1] = a[j];
				else
					break;
			}
			a[j+1] = key;
		}
	}

	public static void main(String args[]){
		int a[] = {3,5,7,8,2,4};

		insertionSort(a);
		for(int i:a)
			System.out.print(i+", ");
		System.out.println();
	}
}
