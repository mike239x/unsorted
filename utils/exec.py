import threading
import time
import subprocess


def hs():
	subprocess.run("java Master", shell=True, check=True)
	#os.system("javac "+name+".java")
t1 = threading.Thread(target=hs)
t1.start()
time.sleep(3)
def s1():
	subprocess.run("java Store", shell=True, check=True)
	#os.system("javac "+name+".java")
threading.Thread(target=s1).start()
def s2():
	subprocess.run("java Store", shell=True, check=True)
	#os.system("javac "+name+".java")
threading.Thread(target=s2).start()
time.sleep(3)



#def start(name):	
	#subprocess.run("javac "+name+".java", shell=True, check=True)
	#os.system("javac "+name+".java")


