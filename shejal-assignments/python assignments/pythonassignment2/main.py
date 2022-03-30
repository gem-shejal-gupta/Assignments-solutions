import pandas as pd
import requests

# creating first dataframe from api
url = 'https://reqres.in/api/users'
r = requests.get(url)
json=r.json()
df = pd.DataFrame(json['data'])
df.drop('avatar',axis='columns', inplace=True)
print(df)

# creating second dataframe from api
url2 = 'https://reqres.in/api/users?page=2'
r2 = requests.get(url2)
json=r2.json()
df2 = pd.DataFrame(json['data'])
df2.drop('avatar',axis='columns', inplace=True)
print(df2)

# comparing both data frame
print(df.compare(df2,keep_equal=True))

#appending two dataframe and sorting
df3 = df.append(df2, ignore_index=True)
df4 = df3.sort_values('first_name')
print(df4)

# final database
df5 = (df4.tail(9))
print(df5.head(7))




