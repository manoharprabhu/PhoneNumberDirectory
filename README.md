[![Build Status](https://travis-ci.org/manoharprabhu/PhoneNumberDirectory.svg)](https://travis-ci.org/manoharprabhu/PhoneNumberDirectory)

An implementation of Phone directory using Trie.
Very efficient for searching phone numbers with name prefix.

```XML
	mvn clean compile test package
```

Usage:

Add a name,number pair using addEntry
```java
PhoneDirectory<String> directory = new PhoneDirectoryTrie<String>();
directory.addEntry("Manohar Prabhu","9182324432");
directory.addEntry("Rakesh Kumar","919923221234");
```

Remove a name,number pair using removeEntry
```java
directory.removeEntry("Manohar Prabhu");
```

Search all the entries beginning with a prefix using searchNameWithPrefix
```java
List<String> entries = directory.searchNameWithPrefix("Man");
```


List all entries in directory using listAllEntries
```java
List<PhoneEntry> entries = directory.listAllEntries();
```
