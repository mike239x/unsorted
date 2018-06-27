import sys
from math import *

if __name__ == "__main__":
	arg = sys.argv
	try:
		a = int(arg[1])
		not_done = True
		while (not_done and a > 1):
			not_done = False
			for i in range(int(sqrt(a))):
				if a%(i+2) == 0:
					print(str(i+2)+" * ", end = "")
					a /= (i+2)
					not_done = True
					break
		print(str(int(a)))
	except ValueError as e:
		print("invalid number")
	except: #for some solid errors
		print("Unexpected error:", sys.exc_info()[0])
		raise
		

