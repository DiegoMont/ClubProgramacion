anio = int(input())
nextWindow = 2018
month = 4
while(anio > nextWindow):
  nextWindow+=2
  month+=2
  if month > 12:
    month = 2
    nextWindow+=1
print("yes" if anio == nextWindow else "no")