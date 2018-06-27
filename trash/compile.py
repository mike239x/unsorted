import os
import subprocess

cd = os.getcwd()
for name in ["HashString","Client","Store","Master"]:
	input("compile "+name)
	os.system("javac "+name+".java")

