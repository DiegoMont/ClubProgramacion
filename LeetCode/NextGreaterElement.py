from queue import PriorityQueue
from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        self.match_nums2_greater_elements(nums2)
        result = []
        for num in nums1:
            greatest_element = self.greater_elements[num]
            result.append(greatest_element)
        return result

    def match_nums2_greater_elements(self, nums2: List[int]):
        self.greater_elements = {}
        unmatched_numbers = PriorityQueue()
        for num in nums2:
            self.greater_elements[num] = -1
            while not unmatched_numbers.empty() and num > unmatched_numbers.queue[0]:
                unmatched_value = unmatched_numbers.get()
                self.greater_elements[unmatched_value] = num
            unmatched_numbers.put(num)