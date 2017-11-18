package defaults;

import java.util.Arrays;
import java.util.List;

public class DefaultMethodsDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3,1,4,1,5,9);
        System.out.println(nums);

        // removeIf is a default method in Collection
        // returns true if any elements were removed
        boolean removed = nums.removeIf(n -> n <= 0 );
        System.out.println("Elements were " + (removed ? "" : "not ") + "removed.");
        System.out.println(nums);

        // Iterator has a default forEach method
        nums.forEach(System.out::println);
    }
}
