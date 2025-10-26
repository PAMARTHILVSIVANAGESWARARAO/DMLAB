from sklearn.datasets import fetch_openml
from sklearn.naive_bayes import CategoricalNB
import pandas as pd

df = fetch_openml('titanic', version=1, as_frame=True).frame[['sex','pclass','embarked','age','survived']].dropna()
X = df[['sex','pclass','embarked','age']].astype({'sex':'category','pclass':'category','embarked':'category'})
for c in ['sex','pclass','embarked']: X[c] = X[c].cat.codes
y = df['survived'].astype('category').cat.codes

model = CategoricalNB()
model.fit(X, y)

user = pd.DataFrame([[input("sex:"), input("class:"), input("embarked:"), float(input("age:"))]], columns=X.columns)
for c in ['sex','pclass','embarked']: user[c] = user[c].astype('category').cat.codes
print("Predicted Survival:", "Yes" if model.predict(user)[0]==1 else "No")
