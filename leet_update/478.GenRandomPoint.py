from typing import List
import math
from random import uniform, random


class Solution:

    def __init__(self, radius: float, x_center: float, y_center: float):
        self.radius = radius
        self.x_center = x_center
        self.y_center = y_center

    def distance(self, x, y):
        return math.sqrt((self.x_center - x) ** 2 + (self.y_center - y) ** 2)

    def randPoint(self) -> List[float]:
        a = uniform(0, 2 * math.pi)
        rr = (uniform(0, self.radius** 2)) ** (1 / 2)
        return [self.radius+ rr * math.cos(a), self.radius + rr * math.sin(a)]

# Your Solution object will be instantiated and called as such:
# obj = Solution(radius, x_center, y_center)
# param_1 = obj.randPoint()
