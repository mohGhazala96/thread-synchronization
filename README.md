# thread-synchronization assignment 
## Introduction:
  This project is nothing but trying to synchronize threads in Java, by simulating a scenario of the fair wheel ride in Java, a full description can found [here](https://github.com/mohGhazala96/Mini-project-3/blob/master/Mini-Project-3-Description_26555.pdf)


## Player Thread
• A player has four main attributes: ID, waiting time, on-board flag, and a ride-complete flag. Both flags, on-board and ride-complete, are initially false.<br>
• A Player thread is initially put to sleep according to its waiting time. Upon waking up, the player calls the operator to queue for the next ride.<br>
## Wheel Thread
• Wheel has four main attributes: capacity, count of currently on-board play- ers, list of currently on-board players and the maximum waiting time of the wheel.<br>
• The wheel is put to sleep for max wait time upon start.<br>
• A method load players() adds a player thread to the list of on-board players.<br>
• A method run ride() updates the state of on-board threads to ride-complete.<br>
• A method end ride() empties the list of on-board players and puts the wheel to sleep until the next ride is run.<br>
## Operator
• The operator is responsible for managing the simulation. It keeps an instance of the wheel. It loads the wheel until it reaches capacity, then runs the wheel and ends the ride.<br>
• The operator creates, starts and keeps a list of player threads.<br>
• The operator creates and starts the wheel thread.<br>
• The operator terminates when all players have successfully completed their rides.<br>
