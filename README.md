# College-Classroom-Simulation
A software developer position in DME SYSTEM is set up to test your ability to clearly communicate technical concepts, maintain legacy software systems and build new systems.

Your acceptance task is to simulate the following:

There are four kinds of threads: students, visitors, monitor and a one Lecturer per classroom. students must wait to enter classroom if class is running, enter, and then sitDown. At some point, the Lecturer enters the classroom. When the Lecturer is in the classroom, no one may enter, and the students may not leave. visitors may leave. Once all students check in, the Lecturer can StartLecture. After some time, the Lecturer leaves and all students can leave.
To make these requirements more specific, let’s give the threads some functions to execute, and put constraints on those functions.
• students must invoke enter, sit Down, and leave.
• The Lecturer invokes enter, start Lecture and leave.
• visitors invoke enter, sitDown and leave.
• While the Lecturer is in the classroom, no one may enter and students may not leave.
• The Lecturer cannot startLecture until all students who have entered have also sitDown.
• At any point of time any classroom may have only one lecturer.
• Classroom capacity should not exceed limit. Visitors are always low in count (less than 5).
• Add a monitor thread to keep printing the status of each class as follows

Simulate a college with few classrooms

{W201 (capacity 60), W202(capacity 60), W101 (Capacity 20), JS101 Capacity (30)) and lecturers {Osama, Barry, Faheem, Alex, Aqeel, Waseem} that circulate between classes.

Hints: Lecturer can use a binary semaphore to access classroom so one lecturer in class at any time students and visitors can use counted semaphores to access classroom. You can use locks, barriers, semaphores.
