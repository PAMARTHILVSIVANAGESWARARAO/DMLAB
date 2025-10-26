import matplotlib.pyplot as plt
import numpy as np

data = np.array([[2,3],[3,5],[5,8],[7,2]])
a1,a2 = data[:,0], data[:,1]
plt.figure(figsize=(10,8))

plt.subplot(2,2,1); plt.hist(a1,bins=5,color='skyblue',edgecolor='black'); plt.title('Histogram A1')
plt.subplot(2,2,2); plt.boxplot(a2); plt.title('Boxplot A2')
plt.subplot(2,2,3); plt.bar(['A1','A2'],[a1.mean(),a2.mean()],color=['orange','green']); plt.title('Mean of Attributes')
plt.subplot(2,2,4); plt.pie([a1.sum(),a2.sum()],labels=['A1','A2'],autopct='%1.1f%%',colors=['purple','cyan']); plt.title('Sum proportion')

plt.tight_layout(); plt.show()
