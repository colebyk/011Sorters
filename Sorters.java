import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sorters {

	static String alpha = "abcdefghijklmnopqrstuvwxyz0123456789.,:;\"-?[]' ";
	static String[] alphaArray = new String[alpha.length()];
	static String[] tempAlphaArray = new String[alpha.length()];
	
	static int tempMergArr[] = new int[alpha.length()];
	static int frequency[] = new int[alpha.length()];

	public static void main(String[] args) {
		//int[] list = { 5, 8, 1, 6, 9, 2 };
		
		ArrayList<Integer> frequencyAL = new ArrayList<Integer>();

		System.out.println();
		String fileName = "/home/compsci/eclipse-workspace/textFiles/SampleTextFile_1000kb.txt";
		String line;
		int unknown = 0;
		ArrayList aList = new ArrayList();
		

		for (int i = 0; i < alpha.length(); i++) {
			alphaArray[i] = String.valueOf(alpha.charAt(i));
		}
		
		for (int i = 0; i < alpha.length(); i++) {
			tempAlphaArray[i] = String.valueOf(alpha.charAt(i));
		}

		// set all values in frequency array to 0

		for (int i = 0; i < alpha.length(); i++)
			frequency[i] = 0;

		// make new buffered reader for reading txt file
		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));

			if (!input.ready()) {
				input.close();
				throw new IOException();

			}
			int location;
			// while there's still something in the document
			while ((line = input.readLine()) != null) {
				line = line.toLowerCase();
				// add line to array list
				aList.add(line);
				// for each char in the line
				for (int i = 0; i < line.length(); i++) {
					// if the alphabet string contains the current char
					if (alpha.contains(String.valueOf(line.charAt(i)))) {
						// set location var to where the value of the char at i is in the alphabet
						location = alpha.indexOf(line.charAt(i));
						// change the corresponding value of the frequency array += 1
						frequency[location] += 1;
					} else {
						unknown += 1;
					}
				}
			}
			input.close();
		} catch (IOException e) {
			System.out.println("error: " + e);
		}
		int sz = aList.size();
		for (int i = 0; i < sz; i++) {
			// print every line of the kennedy cuba crisis speech
			System.out.println(aList.get(i).toString());
		}

		// begin sorting portion

		// add all values from frequency integer array to new array list

		for (int i = 0; i < frequency.length; i++) {
			frequencyAL.add(frequency[i]);
		}

		

		// perform bubble sort

		System.out.println("");
		System.out.println("Bubble Sort:");

		frequency = bubbleSort(frequency);
		for (int i = 0; i < alpha.length(); i++) {
			System.out.println(alphaArray[i] + ": " + frequency[i]);
		}
		
		// perform merge sort
		
		System.out.println("");
		System.out.println("Merge Sort: ");
		frequency = doMergeSort(0, alphaArray.length -1);
		for (int i = 0; i < alpha.length(); i++) {
			System.out.println(alphaArray[i] + ": " + frequency[i]);
		}

		// perform insertion sort with an array list

		System.out.println("");
		System.out.println("ArrayList Insertion Sort:");
		
		frequencyAL = insertionSort(frequencyAL);
		for (int i = 0; i < alpha.length(); i++) {
			System.out.println(alphaArray[i] + ": " + frequencyAL.get(i));
		}

		// perform insertion sort with an int array

		System.out.println("");
		System.out.println("Insertion Sort with int array:");

		frequency = insertionSort(frequency);
		for (int i = 0; i < alpha.length(); i++) {
			System.out.println(alphaArray[i] + ": " + frequency[i]);
		}
		
	} // end of main()

	private static int[] bubbleSort(int[] frequency) {

		int temp = 0;
		String tempStr;
		for (int i = 0; i < frequency.length - 1; i++) {
			for (int j = 0; j < frequency.length - 1 - i; j++) {
				if (frequency[j] < frequency[j + 1]) {
					temp = frequency[j];
					frequency[j] = frequency[j + 1];
					frequency[j + 1] = temp;
					tempStr = alphaArray[j];
					alphaArray[j] = alphaArray[j + 1];
					alphaArray[j + 1] = tempStr;
				}
			}
		}

		return frequency;
	} // end of bubbleSort

	private static int[] insertionSort(int[] frequency) {

		int temp, key, j;
		String tempStr;
		for (int i = 1; i < frequency.length; i++) {
			key = frequency[i];
			j = i - 1;
			while (j >= 0 && key > frequency[j]) {
				temp = frequency[j];
				frequency[j] = frequency[j + 1];
				frequency[j + 1] = temp;
				tempStr = alphaArray[j];
				alphaArray[j] = alphaArray[j + 1];
				alphaArray[j + 1] = tempStr;
				j--;
			}

		}
		return frequency;
	} // end of insertionSort

	private static ArrayList<Integer> insertionSort(ArrayList<Integer> frequencyAL) {

		int temp, key, j;
		for (int i = 1; i < frequencyAL.size(); i++) {
			key = frequencyAL.get(i);
			j = i - 1;
			while (j >= 0 && key > frequencyAL.get(j)) {
				temp = frequencyAL.get(j);
				frequencyAL.set(j, frequencyAL.get(j + 1));
				frequencyAL.set(j + 1, temp);
				j--;
			}

		}
		return frequencyAL;
	} // end of insertionSort

    private static int[] doMergeSort(int lowerIndex, int higherIndex) {
        
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
        return frequency;
    }
 
    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = frequency[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] >= tempMergArr[j]) {
                frequency[k] = tempMergArr[i];
                i++;
            } else {
                frequency[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            frequency[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }


} // end of class
