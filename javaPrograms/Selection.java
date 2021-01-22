class Selection{
	static void selectionSort(int a[]){
		for(int i=0; i<a.length-1; i++){
			int index=i;
			for(int j=i+1; j<a.length; j++){
				if(a[j] < a[index]){
					index = j;
				}
			}

			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}
	}

	public static void main(String args[]){
		int a[] = {3,5,2,6,1,4};
		selectionSort(a);
		for(int i:a)
			System.out.print(i+", ");
		System.out.println();
	}
}
