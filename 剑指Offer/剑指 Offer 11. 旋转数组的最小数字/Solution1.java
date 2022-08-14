// 因为数组由两个递增数列构成，可以用二分法
// 时间复杂度O(log n)，若数组中元素全部相同，算法会退化成O(n)
// 空间复杂度O(1)

class Solution {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int resultIndex = 0;
        int left = 0, right = n - 1;
        while (numbers[left] >= numbers[right]) {
            if (left + 1 == right) {
                resultIndex = right;
                break;
            }
            int mid = (left + right) / 2;
            // 三个指针对应数字完全相同的情况，无法判断该取哪部分，故采用顺序查找
            if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                return sequence(numbers, left, right);
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[resultIndex];
    }

    int sequence(int[] numbers, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }
}