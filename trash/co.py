import sys
from math import *
import os

cd = os.getcwd()

if __name__ == "__main__"	:
	arg = sys.argv
	try:
		name = arg[1]
		if name in ["HashString","Client","Store","Master"]:
			lines = []
			with open(cd+"/../working trash/"+name+".java", 'r') as f:
				for line in f:
					lines.append(line)
			with open(name+".java", 'w') as f:
				for line in lines:
					f.write(line)
				os.system("javac "+name+".java")
	except: #for some solid errors
		print("Unexpected error:", sys.exc_info()[0])
		raise
		

