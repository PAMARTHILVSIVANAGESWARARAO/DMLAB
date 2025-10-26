import math

data = [[1,2],[2,3],[3,5],[6,8]]
n = len(data)
matrix = [[round(math.sqrt((data[i][0]-data[j][0])**2 + (data[i][1]-data[j][1])**2),2)
           for j in range(n)] for i in range(n)]

print("Dissimilarity Matrix:")
for row in matrix: print(row)
