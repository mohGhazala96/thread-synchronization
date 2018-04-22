# Mini-project-3
## Player Thread
• A player has four main attributes: ID, waiting time, on-board flag, and a ride-complete flag. Both flags, on-board and ride-complete, are initially false.
• A Player thread is initially put to sleep according to its waiting time. Upon waking up, the player calls the operator to queue for the next ride.
## Wheel Thread
• Wheel has four main attributes: capacity, count of currently on-board play- ers, list of currently on-board players and the maximum waiting time of the wheel.
• The wheel is put to sleep for max wait time upon start.
• A method load players() adds a player thread to the list of on-board players.
• A method run ride() updates the state of on-board threads to ride-complete.
• A method end ride() empties the list of on-board players and puts the wheel to sleep until the next ride is run.
## Operator
• The operator is responsible for managing the simulation. It keeps an instance of the wheel. It loads the wheel until it reaches capacity, then runs the wheel and ends the ride.
• The operator creates, starts and keeps a list of player threads.
• The operator creates and starts the wheel thread.
• The operator terminates when all players have successfully completed their rides.
