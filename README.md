### Introduction
This application is built on spring boot and java 17. This project can be built using maven

``
mvn clean install
or
mvn clean package
``

### Execution
```
./cookiefinder.sh --file cookiefile.csv -date 2018-12-09
or
./cookiefinder.sh -f cookiefile.csv -d 2018-12-09
```

### Input/Output
Input Format:
```aidl
AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00 
SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00 
5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00 
AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00 
SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00 
4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00 
fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00 
4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00 
```

Output Format:
```aidl
AtY0laUfhglK3lC7 
```

### References
[Picoli](https://picocli.info/)

[Spring baeldung](https://www.baeldung.com/java-picocli-create-command-line-program)

