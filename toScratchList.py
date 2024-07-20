fileName="Collins Scrabble Words (2019).txt"
output=''
file=open(fileName,"r")
#file.readline()
#file.readline()
for i in file:
    if len(i)>=5: output+=i.strip()+"."
file.close()

out=open("scratchOutput.txt","w")
out.write(output)
out.close()
