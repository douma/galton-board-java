![](./static/java.png)

# Galton Board

![](./static/GaltonBoard_1000.gif)

> The bean machine, also known as the Galton Board or quincunx, is a device invented
by Sir Francis Galton to demonstrate the central limit theorem, in particular that the normal
distribution is approximate to the binomial distribution. Among its applications, it afforded
insight into regression to the mean or "regression to mediocrity".

## Cucumber

![](./static/cucumber.png)

Feature test is implemented using Cucumber.

## Explanation

The implementation of the`Galton Board` is proven te work by using a `test double`, which replaces the
unpredictable behavior of the dropping bullets, with a predefined path from which can be determined in which
tray the bullet will end.

## Result

Run `App.main`:

```
000
000000000
00000000000000000000000000
00000000000000000000000000000000000000000000000
0000000000000000000000000000000000000000000000000000000
00000000000000000000000000000000000000000000
00000000000
00000
```
