from scipy.stats import chisquare

o = list(map(int, input("Observed: ").split(',')))
e = list(map(int, input("Expected: ").split(',')))

chi, p = chisquare(o, e)
print(f"\nChi² = {chi:.3f},  p = {p:.3f}")
print("Reject H₀" if p < 0.05 else "Accept H₀")
