fileName="Collins Scrabble Words (2019).txt"
output=''
file=open(fileName,"r")
#file.readline()
#file.readline()
for i in file:
    if len(i)>=4: output+=i
file.close()

out=open("wordhuntWords.txt","w")
out.write(output)
out.close()