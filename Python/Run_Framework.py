import os

def Compile_Framework_Code():
		cwd=os.getcwd()
		os.chdir('../Java/')
		os.system('rm -rf Classes/sootOutput')
		os.system('javac -d Classes -cp "../Jar_Libs/*" BAnalysisApp.java')
		os.chdir(cwd)

Compile_Framework_Code()