# jsoup: Java HTML Parser

**jsoup** is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods.


**jsoup** implements the [WHATWG HTML5](http://whatwg.org/html) specification, and parses HTML to the same DOM as modern browsers do.

* scrape and [parse](https://jsoup.org/cookbook/input/parse-document-from-string) HTML from a URL, file, or string
* find and [extract data](https://jsoup.org/cookbook/extracting-data/selector-syntax), using DOM traversal or CSS selectors
* manipulate the [HTML elements](https://jsoup.org/cookbook/modifying-data/set-html), attributes, and text
* [clean](https://jsoup.org/cookbook/cleaning-html/whitelist-sanitizer) user-submitted content against a safe white-list, to prevent XSS attacks
* output tidy HTML

jsoup is designed to deal with all varieties of HTML found in the wild; from pristine and validating, to invalid tag-soup; jsoup will create a sensible parse tree.

See [**jsoup.org**](https://jsoup.org/) for downloads and the full [API documentation](https://jsoup.org/apidocs/).

[![Build Status](https://travis-ci.org/jhy/jsoup.svg?branch=master)](https://travis-ci.org/jhy/jsoup)
