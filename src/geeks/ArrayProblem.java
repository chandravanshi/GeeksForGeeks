package geeks;

public class ArrayProblem {

	public static void main(String [] args) {

	}

	public static void leftRotate(int [] array, int d) {
		for(int i=0; i<d; i++) {
			rotateByOne(array);
		}
	}

	public static void rotateByOne(int [] array) {
		int temp = array[0];
		for(int i= 0; i< array.length-1; i++) {
			array[i] = array[i-1];
		}
		array[array.length] = temp;
	}
}
