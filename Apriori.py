from mlxtend.frequent_patterns import apriori, association_rules
import pandas as pd

n = int(input("Enter no. of transactions: "))
data = [input(f"T{i+1}: ").split(',') for i in range(n)]
minsup = float(input("Enter min support (0-1): "))

items = sorted({i for t in data for i in t})
df = pd.DataFrame([{i: (i in t) for i in items} for t in data])

freq = apriori(df, min_support=minsup, use_colnames=True)
rules = association_rules(freq, metric="support", min_threshold=minsup)

print("\nFrequent Itemsets:")
print(freq)
print("\nAssociation Rules:")
print(rules[['antecedents','consequents','support','confidence']])
