# OOP-Project-Victoria-Hayk
# OOP-Project-Victoria-Hayk

This game is a text based monopoly game

Every player starts the game at the 0 location with $2000

If a player goes bankrupt, then he/she loses the game

There are 4 checkpoints, at location 0, 8, 16, 24
By stepping at 0 the player receives $200 as a reward
By stepping at 8 the player receives $50 as a charge
By stepping at 16 the player receives $100 as a reward
By stepping at 24 the player receives $50 as a charge

There are 24 properties
After buying one the player can upgrade it from level 0 up to 4
An upgrade costs the 40% of the property's price. An upgrade increases property's worth by 20%

There are 4 chance squares
First possibility: The player gets elected chairman of the city and pays the other player $50
Second possibility: The player has to make repairs on all of his/her properties, thus he/she pays $25 for every owned house
Third possibility: The player gets paid $50 by the Bank
Fourth possibility: The player's building and loan matures, in result he/she receives $150 

A player does not have to pay anything if he/she steps on his/her own property or an non-owned property

If a player steps on other player's property he/she must pay the rent which is 10% of the property's price at the moment

How to play:
Input 'm' to roll the dice and move the pawn
Input 'b' if you want to buy the property
Input 'u' 'LOCATION' if you want to upgrade one of your properties at the location 'LOCATION'

The feature this games lack:
GUI

Additional comments:
Property, checkpoint and chance are inherited from square. The only common thing they have is their name. During this game the name of a square is not used at all, however it is there as it may come in handy when GUI is added.



