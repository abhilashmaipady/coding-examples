package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Element {
       int value;
       int oldPosition;
       int actualPosition;
       boolean visited;
}

class SortElement implements Comparator<Element> {

	@Override
	public int compare(Element e1, Element e2) {
		// TODO Auto-generated method stub
		return e1.value - e2.value;
	}
	
}

public class MinimumSwap {

	static int minimumSwaps(int[] arr) {
		int noOfSwap = 0;
		List<Element> elementList = constructArray(arr);
		for(Element e: elementList) {
			if(e.visited) continue;
			noOfSwap += findCycle(elementList, e);
		}
		return noOfSwap;
    }
	
	private static int findCycle(List<Element> arr, Element e) {
		Element item = e;
		List<Element> cycle = new ArrayList<Element>();
		while(true) {
			item = arr.get(item.oldPosition);
			item.visited = true;
			cycle.add(item);
			if(item.value == e.value) {
				return cycle.size() - 1;
			}
		}
	}
	
	private static List<Element> constructArray(int[] arr) {
		List<Element> eleList = new ArrayList<Element>();
			for(int i=0;i < arr.length; i++) {
		    	Element ele = new Element();
		        ele.value = arr[i];
		        ele.oldPosition = i;
		        ele.visited = false;
		        eleList.add(ele);
			}
		    Collections.sort(eleList, new SortElement());
		    int index = 0;
		    for(Element e:eleList) {
		    	e.actualPosition = index++;
		    }
		    return eleList;
	}
	
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] {3, 7, 6, 9, 1, 8, 10, 4, 2, 5};
        System.out.println(minimumSwaps(arr));
    }

}
