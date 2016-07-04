Guavate
========

[![Build Status](https://travis-ci.org/steveash/guavate.svg?branch=master)](https://travis-ci.org/steveash/guavate)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.steveash.guavate/guavate/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.steveash.guavate/guavate)

This is a single jar dependency for Guavate written by Stephen Colebourne and included as part of 
[Strata](https://github.com/OpenGamma/Strata) under the Apache 2 License.  Guavate code is Copyright (C) 2014 - 
present by OpenGamma Inc. and the OpenGamma group of companies.

In order to be able to use Guavate simply from many of my projects without depending on Strata, I have released it
here as a simple tiny library (and added a few of my own additions).

### Getting Started

To use this library with some Maven compatible dependency management tool, use

```xml
<dependency>
    <groupId>com.github.steveash.guavate</groupId>
    <artifactId>guavate</artifactId>
    <version>1.0.0</version>
</dependency>
```

or in gradle `compile 'com.github.steveash.guavate:guavate:1.0.0'`

This depends on 
* Guava v19 (though 18 should work as well)
* Apache Commons Lang3 v3.4 (though any lang3 version will work; just for the Pair type)

### Example Usage
There are Collector implementations for each of the Immutable collections:

```java
List<String> inputs = Lists.newArrayList("a", "b", "c");
ImmutableSet<String> outputs = inputs.stream()
    .map(String::toUpperCase)
    .filter(it -> !it.startsWith("b"))
    .collect(Guavate.toImmutableSet());
// outputs is an immutable set of "a" and "c"
```

There are also some convenient methods for collecting to maps from 
Map.Entry (and Common-Lang3's Pair as it implements Entry):

```java
Map<String, Integer> inputs = ImmutableMap.of("bob", 1, "jon", 2, "mary", 3);
Map<String,Integer> outputs = inputs.entrySet().stream()
    .map(e -> Pair.of(e.getKey().toUpperCase(), e.getValue()))
    .collect(Guavate.entriesToMap());
// outputs is a map of BOB:1, JON:2, MARY:3
```

Converting an arbitrary iterable into a stream (which should've been in the JDK
to begin with):

```java
Iterable<String> values = // ...
Stream<String> streamVals = Guavate.stream(values);
```

and converting an Optional<T> into a stream of zero or one element:

```java
Optional<String> maybe = // ...
Stream<String> stream = Guavate.stream(maybe);
```
