
Using this program, I learned white-box testing, including coverage rate, loop testing, and mutation testing.

Gilded Rose 
=========== 
Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime 
location in a prominent city ran by a friendly innkeeper named Allison. We also buy 
and sell only the finest goods. Unfortunately, our goods are constantly degrading in 
quality as they approach their sell by date. We have a system in place that updates our 
inventory for us. It was developed by a no-nonsense type named Leeroy, who has 
moved on to new adventures. Your task is test to our system. 
First an introduction to our system: 
* All items have a SellIn value which denotes the number of days we have to sell the 
item 
* All items have a Quality value which denotes how valuable the item is 
* At the end of each day our system lowers both values for every item 
Pretty simple, right? Well this is where it gets interesting: 
* Once the sell by date has passed, Quality degrades twice as fast 
* The Quality of an item is never negative 
* "Aged Brie" actually increases in Quality the older it gets 
* The Quality of an item is never more than 50 
* "Sulfuras", being a legendary item, never has to be sold or decreases in Quality 
* "Backstage passes", like aged brie, increases in Quality as it's SellIn value 
approaches; 
Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days 
or 
less but Quality drops to 0 after the concert. 
Just for clarification, an item can never have its Quality increase above 50, however 
"Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.


