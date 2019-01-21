import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sort {
	Scanner console = new Scanner(System.in);
	String input;
	Scanner file;
	int[] inputArray;
	long startTime;

	public Sort() {
		System.out.println("Enter a number for the input file");
		System.out.println("1: input1.txt  2: input2.txt  3: input3.txt  4: input4.txt");
		input = console.nextLine();
		if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
			while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
				System.out.println("Enter 1, 2, 3 or 4");
				input = console.nextLine();
			}
		}
		try {
			file = new Scanner(new File("input" + input + ".txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			System.exit(0);
		}
		String fileLine = file.nextLine();
		String[] inputStringArray = fileLine.split(",");
		inputArray = new int[inputStringArray.length];
		for (int i = 0; i < inputStringArray.length; i++) {
			inputArray[i] = Integer.parseInt(inputStringArray[i]);
			// System.out.println(inputArray[i]);
		}
		System.out.println("Enter a number for the sort you want to use");
		System.out.println("1: Bubble   2: Selection  3: Table  4: Quick");
		input = console.nextLine();
		if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
			while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
				System.out.println("Enter 1, 2, 3 or 4");
				input = console.nextLine();
			}
		}
		startTime = System.currentTimeMillis();
		if (input.equals("1")) {
			inputArray = BubbleSort(inputArray);
		} else if (input.equals("2")) {
			inputArray = SelectionSort(inputArray);

		} else if (input.equals("3")) {
			inputArray = TableSort(inputArray);
		} else if (input.equals("4")) {
			int low = 0;
			int high = inputArray.length-1;
			inputArray = QuickSort(inputArray, low, high);
		}
		long total = System.currentTimeMillis() - startTime;
		System.out.println("Total time: " + total + " milliseconds");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(new File("output.txt")));
			String output = "";
			for (int i = 0; i < inputArray.length; i++) {
				output = output + inputArray[i] + ",";
				System.out.println(inputArray[i]);
			}
			output += "\nTotal Time: " + total;
			pw.write(output);
			pw.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	private int[] QuickSort(int[] array, int low, int high) {
		int middle = low + (high - low) /2;
		int pivot = array[middle];
		int i = low, j = high;
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
 
			while (array[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
 
		if (low < j) {
			QuickSort(array, low, j);
		}
		if (high > i) {
			QuickSort(array, i, high);
		}
		return array;
	}

		
	

	// counts how often number is seen, prints out how often
	private int[] TableSort(int[] array) {
		// TODO Auto-generated method stub
		int[] tally = new int[1001];
		for (int i = 0; i < array.length; i++) {
			tally[array[i]]++;
		}
		int count = 0;
		// i keeps track of number
		for (int i = 0; i < tally.length; i++) {
			// j keeps track of how many times we've seen the number
			for (int j = 0; j < tally[i]; j++) {
				array[count] = i;
				count++;
			}
		}

		return array;
	}

	// find smallest and move to the front
	public int[] SelectionSort(int[] array) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.length; i++) {
			int small = array[i];
			int smallIndex = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < small) {
					small = array[j];
					smallIndex = j;
				}
			}
			int temp = array[smallIndex];
			array[smallIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}

	// compare each pair of numbers and move the larger to the right
	public int[] BubbleSort(int[] array) {
		// TODO Auto-generated method stub
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length - 1; i++) {
				// if the one to the left is larger...
				if (array[i] > array[i + 1]) {
					// swap
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}

		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sort();
	}


}
