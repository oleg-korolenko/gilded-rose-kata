# gilded-rose-kata
My take on [gilded-rose kata](https://github.com/emilybache/GildedRose-Refactoring-Kata) exercise 

## Approach
I took the most straightforward approach to model the hierarchy of different items with corresponding behaviours:
- simple sub-typing with case classes grouped in `com.gildedrose.domain` package
- with `ItemWithQuality` trait  to be implemented to expose the needed behaviour


Another one of which I was thinking is to strictly going to ADTs without any behaviours and Type class pattern to implement the ad-hoc polymorphism :
 
- `com.gildedrose.alternative.domain` package contains ADTs
- `com.gildedrose.alternative.behaviours` contains type classes 


In general I prefer to go for separation between data and behaviour but  I think it's a bit of an overkill in this case so I opted for the 1st approach.


## Testing
All reqs are covered in `GildeRosTest` 
