import os

cd = os.getcwd()
for filename in os.listdir(cd):
	if filename.endswith(".java"):
		lines = []
		with open(filename, 'r') as f:
			for line in f:
				if not line.strip().startswith("package "):
					lines.append(line)
		with open(filename, 'w') as f:
			for line in lines:
				f.write(line)

