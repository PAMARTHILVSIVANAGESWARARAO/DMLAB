from sklearn.cluster import KMeans
import numpy as np

data = np.array([(1,1),(2,1),(4,3),(5,4),(3,3),(6,5)])
k = 2
model = KMeans(n_clusters=k, init='k-means++', n_init=10, random_state=0)
labels = model.fit_predict(data)

print("Final Cluster Centers:")
for i, c in enumerate(model.cluster_centers_):
    print(f"Cluster {i+1}: {tuple(c)}")

print("\nCluster Assignments:")
for i in range(k):
    print(f"Cluster {i+1}: {data[labels==i].tolist()}")
