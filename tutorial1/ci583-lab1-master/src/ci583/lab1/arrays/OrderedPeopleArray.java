package ci583.lab1.arrays;

public class OrderedPeopleArray extends PeopleArray {
	
	public OrderedPeopleArray(int max) {
		super(max);
	}

	/**
	 * Insert a new person maintaining the order of the data.
	 * Return false if arr is full.
	 * @param first
	 * @param last
	 * @param age
	 */
	public boolean insert(String first, String last, int age) {
		if(nElems == arr.length) return false; //list is full
		Person p = new Person(first, last, age);
		for (int i=0;i<nElems;i++) { //looping through the entire list
			Person iP = arr[i];
			int comp = iP.getLastName().compareTo(last); //comparing current person to new person
			if (comp >= 0) { //if its the right place
				for(int j=nElems;j>i;j--) {
					arr[j] = arr[j-1]; //move every element over by 1 (right)
				}
				arr[i] = p; //add new person in the correct position
				nElems++; //increase number of elements
				return true;
			}
		}
		arr[nElems] = p; //if it has no place then it's added onto the end
		nElems++;
		return true;
	}

	/**
	 * Return the Person with lastName, or null. Use BinarySearch to to do the finding.
	 * @param lastName
	 * @return
	 */
	public Person find(String lastName) {
		int start = 0; //start at first array item initially
		int end = nElems-1; //end is the last element
		while(start <= end) { //so there are still multiple elements
			int check = start + ((end-start)/2); //finding mid point
			if (arr[check].getLastName().compareTo(lastName) < 0) { //compare mid point to new
				start = check + 1; //remove first half
			} else if (arr[check].getLastName().compareTo(lastName) > 0) {
				end = check - 1; //remove second half
			} else {
				return arr[check]; //found the right element
			}
		}
		return null;//it doesn't exist
	}
}



