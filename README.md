# Red Jsoup

This is a basic JRuby extension example.
The example uses [jsoup](https://jsoup.org/) HTML parser.
When HTML is given as a string, the application parses the string and prints node names.
The node names are listed as post-order traversal manner.


## How to Use

### Prerequisite
- Java version 21 and above
- JRuby version 10.0.1.0 and above

### Steps
1. Compile Java classes if it needs.
```bash
$ rake
```
2. Run sample ruby code.
```bash
$ ruby sample/basic_sample.rb
```
