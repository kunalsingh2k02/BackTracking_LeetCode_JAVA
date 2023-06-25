import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> currentPerm, List<List<Integer>> permutations) {
        if (currentPerm.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPerm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currentPerm.contains(nums[i])) {
                continue;
            }
            currentPerm.add(nums[i]);
            backtrack(nums, currentPerm, permutations);
            currentPerm.remove(currentPerm.size() - 1);
        }
    }
}
class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);

        // Print the permutations
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}






