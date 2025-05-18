class Solution(object):
    def maximumUnits(self, boxTypes, truckSize):
        """
        :type boxTypes: List[List[int]]
        :type truckSize: int
        :rtype: int
        """
       
        boxTypes.sort(key=lambda x: x[1], reverse=True)
        ans = 0
        for b, n in boxTypes:
            boxes = min(b, truckSize)
            ans += boxes * n
            truckSize -= boxes
            if truckSize == 0:
                break
        return ans
