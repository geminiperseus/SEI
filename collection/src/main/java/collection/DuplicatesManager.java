package collection;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class DuplicatesManager {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DuplicatesManager.class);
	
	/*
	 * Removing duplicates form Integer list using LinkedHashSet 
	 * LinkedHashSet will keep the order in which the list is passed in and will not allow duplicates by default.
	 * Takes advantage of Collections framework.
	 * To me this is the efficient way of doing it because its less code to go over less complexity and no latency for doing computations on the list
	 * 
	 * */
	public static int[] removeDuplicatesUsingSet(List<Integer> randomIntegers) {
		LOGGER.info("Input array to removeDuplicatesUsingSet method is :" + Arrays.toString(Ints.toArray(randomIntegers)));
		Set<Integer> result = new LinkedHashSet<Integer>();
		result.addAll(randomIntegers);
		LOGGER.info("Output array from removeDuplicatesUsingSet method is :" + Arrays.toString(Ints.toArray(result)));
		return Ints.toArray(result);
	}
	
	/*
	 * Removing duplicates form Integer list using List 
	 * Less effective as we are using a for loop to go over all the elements of the array. In case of large arrays it will become slow.
	 * Takes advantage of Collections framework.
	 * Not sorting the list to keep the original order
	 * 
	 * */
	public static int[] removeDuplicatesUsingIterations(List<Integer> randomIntegers) {
		LOGGER.info("Input array to removeDuplicatesUsingIterations method is :" + Arrays.toString(Ints.toArray(randomIntegers)));
		List<Integer> resultList = Lists.newArrayList();
		resultList.add(randomIntegers.get(0));
		for (int i = 0; i < randomIntegers.size(); i++) {	
			if(!resultList.contains(randomIntegers.get(i))) {
				resultList.add(randomIntegers.get(i));
			}
		}
		LOGGER.info("Output array from removeDuplicatesUsingIterations method is :" + Arrays.toString(Ints.toArray(resultList)));
		return Ints.toArray(resultList);
	}
	
	/*
	 * Removing duplicates form int array 
	 * Less effective as we are using couple of for loop to go over all the elements of the array. In case of large arrays it will become slow.
	 * Also using if condition which make it a little hard to understand code.
	 * Not taking any advantage of Collections.
	 * Not sorting the list to keep the original order
	 * 
	 * */
	public static int[] removeDuplicatesWithoutCollection(int[] randomInts) {
		LOGGER.info("Input array to removeDuplicatesWithoutCollection method is :" + Arrays.toString(randomInts));
	    int[] result = new int[randomInts.length];
	    int j = 0;
	    int count = 0;
	    for (int i : randomInts) {
	        if (!doesExist(result, i)) {
	            result[j++] = i;
	            count++;
	        }
	    }
	    LOGGER.info("Output array from removeDuplicatesWithoutCollection method is :" + Arrays.toString(Arrays.copyOf(result, count)));
	    return Arrays.copyOf(result, count);
	}

	private static boolean doesExist(int[] result, int i) {
	    for (int j : result) {
	        if (j == i) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/*
	 * I am not using any Java8 feature here. With the power of lambdas and the distinct key words its easier to do this in java8.
	 * Also not doing any Exception handling because I don't see any use of it in this class.
	 * 
	 * */
}
