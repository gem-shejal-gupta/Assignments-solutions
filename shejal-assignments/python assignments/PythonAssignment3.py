#!/usr/bin/env python
# coding: utf-8

# In[1]:


import time
def Square(n):
    t1 = time.time()
    square = []
    for each in n:
        square.append(each**2)
        time.sleep(1)
    print(square) 
    t2 = time.time()
    print("Time taken for squares: ",t2-t1)

def Cube(n):
    t1 = time.time()
    cube = []
    for each in n:
        cube.append(each**3)
        time.sleep(1)
    print(cube) 
    t2 = time.time()
    print("Time taken for cubes: ",t2-t1)


# In[2]:


if __name__ == '__main__':
    Square([1,2,3,4,5,6,7])
    
    Cube([1,2,3,4,5,6,7])


# In[3]:


import threading 
if __name__ == '__main__':
    t3 = threading.Thread(target=Square,args=[[1,2,3,4,5,6,7]])
    t4 = threading.Thread(target=Cube, args=[[1,2,3,4,5,6,7]])
    t3.start()
    t4.start()
    t3.join()
    t4.join()


# In[4]:


import threading
l = [1,2,3,4,5,6,7]
def taskExecution(lock,s):
    if s == "squares":
        lock.acquire()
        Square(l)
        lock.release()
    elif s=='cubes':
        lock.acquire()
        Cube(l)
        lock.release()



if __name__ == '__main__':
    lock = threading.Lock()
    t3 = threading.Thread(target=taskExecution, args=[lock,'squares'])
    t4 = threading.Thread(target=taskExecution, args=[lock,'cubes'])
    t3.start()
    t4.start()
    t3.join()
    t4.join()


# In[5]:



import re
list1 = ["example (.in)", "w3resource", "github (.com)", "stackoverflow (.us1)"]
for each in list1:
    list1[list1.index(each)] = re.sub("[\(\[].*?[\])]","",each)
list1


# In[6]:


import requests
r = requests.get('https://restcountries.com/v3.1/alpha/pe')
dict1 = r.json()[0]
for key in dict1['languages']:
    print(key+"-"+dict1['languages'][key])
    
print("\nCapital is: ",dict1['capital'][0])
print("\nTotal area: ",dict1['area'])
print("\nTotal population: ",dict1['population'])


# In[ ]:




