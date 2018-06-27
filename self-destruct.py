import os
import sys

if __name__ == "__main__":
	m = sys.modules[__name__]
	os.remove(m.__file__)
