import os

cd = os.getcwd()
print(cd)

for filename in os.listdir(cd):
	if not filename.endswith(".py"):
		os.remove(filename)
