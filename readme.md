[![Coverage Status](https://coveralls.io/repos/github/mierasmade/data-generator/badge.svg?branch=master)](https://coveralls.io/github/mierasmade/data-generator?branch=master)
[![Build Status](https://travis-ci.org/mierasmade/data-generator.svg?branch=master)](https://travis-ci.org/mierasmade/data-generator)

# Data Generator 0.0.1

## Current bug
* the amount of lines provided by the user does not match with the amount of lines with the output, this seems to be a threading issue with the future task implementation

## Introduction and use case

This application provides an easy way to generate fake data. There are some sites on the internet that provide free fake data, but whenever you need alot of fake data you either have to pay for it, or the same data is replicated alot and loses its uniqueness.

The application creates an .csv file that you can open in excel (the app prefixes the file with a file byte order mark).

## How to run

Download the executable jar [here](https://github.com/mierasmade/data-generator/raw/master/data-generator-0.0.1.jar) and just open the app!

## 0.0.2 Future Features

* the user will be able to add a header and/or a footer to the file
* alot more fake data types

## 0.0.3 Future Features
* status bar to inform the user of the progress of the generation
* ability to surround some of the columns with quotes

## 0.0.4 Future Features
* a more user friendly interface that enables drop down selection of the type of data from the overview
