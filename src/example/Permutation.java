package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
	
	public List<List<Integer>> permute(int[] nums) {
		return permuteItems(getList(nums));
    }

	private List<List<Integer>> permuteItems(List<Integer> inputList) {
		if(inputList.isEmpty())
		{
			List<List<Integer>> resultList = new ArrayList<List<Integer>>();
			resultList.add(new ArrayList<>());
			return resultList;
		}
		List<List<Integer>> resultList = new ArrayList<>();
		for(int i = 0; i < inputList.size(); i++) {
			Integer firstItem = inputList.remove(i);
			List<List<Integer>> permutedList = permuteItems(inputList);
			permutedList.stream()
						.forEach(listArr -> listArr.add(0, firstItem));
			resultList.addAll(permutedList);
			inputList.add(i, firstItem);
		}
		
		return resultList;
	}

	private List<Integer> getList(int[] nums) {
		return Arrays.stream(nums)
        			.boxed()
        			.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		

		Permutation p = new Permutation();
		int[] inputArr = new int[] {1,2,3,4};
		System.out.println(inputArr);
		System.out.println(p.permute(inputArr));
		
		
	}

}
