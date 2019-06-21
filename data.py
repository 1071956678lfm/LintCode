import numpy as np

arr = [-0.8, 1.6, -0.5, 0.2, -1.6, 0.2, 1.6, 1, 0.8, 1, 1.7, 1.2, 1.9, 0, 0]
m = np.mean(arr)
val = sum([(m - x) ** 2 for x in arr])
print(val / (len(arr) - 1))
print(np.var(arr))
