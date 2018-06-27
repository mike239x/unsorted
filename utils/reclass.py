import os

cd = os.getcwd()
print(cd)

for filename in os.listdir(cd):
	if filename.endswith(".class"):
		print(filename)
		os.remove(filename)
