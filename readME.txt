It assumes all the 10 digit India mobile numbers are of format 
1. xxxxxxxxxx (10 digit in one block)
2. +91xxxxxxxxxx
3. +91-xxxxxxxxxx
Where the firt two numbers are either 9 , 8 or 7

This code can search for the mobile number no matter where it may be placed in the text by using the regular exp-
(?<!\\w)(\\+91(-?))?[7-9]{1}[0-9]{9}(?!\\w)

Source: Wikipedia 
https://en.wikipedia.org/wiki/Mobile_telephone_numbering_in_India