class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        curmin, curmax = 1,1

        for num in nums:
            tmp = curmax *num
            curmax = max(curmax * num, num * curmin, num)
            curmin = min(tmp, num * curmin, num)
            res = max(res, curmax)
        return res