fileName="cleanWords.txt"
output1=''
file=open(fileName,"r")
output2=''
l=0
for i in file:
    l+=1
    if len(i)>=3:
        if l<=200000:
            output1+=i
        else:
            output2+=i
file.close()
out=open("scratchOutput1.txt","w")
out.write(output1)
out.close()
out=open("scratchOutput2.txt","w")
out.write(output2)
out.close()
